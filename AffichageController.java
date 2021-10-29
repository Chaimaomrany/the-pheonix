/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Produit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import service.serviceproduit;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AffichageController implements Initializable {
    @FXML
    private TableView<Produit> tableProduit;
    @FXML
    private TableColumn<Produit, String> colnom;
    @FXML
    private TableColumn<Produit, String> colprix;
    @FXML
    private TableColumn<Produit, String> colcategorie;
 
    
    private Connection cnx;
    
   
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private AnchorPane pane;
    @FXML
    private TableColumn<Produit, Integer> colid;
    @FXML
    private ImageView imageView;
    @FXML
    private Button buttonPDF;

    /**
     * Initializes the controller class.
     */
    public AffichageController (){
       cnx = MyDB.getInstance().getConnection();
    }
    public static int w;

    /**
     * Initializes the controller class.
     */
     private void imageView(ActionEvent event) {       
    Image image = new Image("R.jpg");
        imageView = setImage(image);
     }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AfficheProduit();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
   
         
         private void AfficheProduit() throws SQLException{
       serviceproduit sp = new serviceproduit();
       List produit=sp.AfficheProduit();
       ObservableList et=FXCollections.observableArrayList(produit);
       tableProduit.setItems(et);
            
            
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            colcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            colid.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
           
            
           
            
          
            
            
        }

   
         
         
         
    @FXML
    private void ajouter(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        pane.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("produit.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         Produit p = (Produit)tableProduit.getSelectionModel().getSelectedItem();
        w= p.getId_produit();
        System.out.println(w);
          FXMLLoader loader = new FXMLLoader();
        pane.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("modifierproduit.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
         serviceproduit cs = new serviceproduit();
         Produit p = (Produit)tableProduit.getSelectionModel().getSelectedItem();
        if(p== null){
            JOptionPane.showMessageDialog(null, "choisir produit");
                   
        }else{
             try {
                 cs.delete(p.getId_produit());
                
                AfficheProduit();
                 JOptionPane.showMessageDialog(null, "produit supprimé avec succés");
               
                 p=null;
             } catch (SQLException ex) {
                 Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    }

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
          @FXML
    void PDF (ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        try {
Connection connection = MyDB.getInstance().getConnection();

        ResultSet rs;
        rs = connection.createStatement().executeQuery("SELECT * FROM produit");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Liste Produit.pdf"));
                    my_pdf_report.open();
                    //we have four columns in our table
                    PdfPTable my_report_table = new PdfPTable(4);
                    //create a cell object
                    PdfPCell table_cell;

                    while (rs.next()) {
                                

                                    String dept_name=rs.getString("id_produit");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);

                                    String manager_id=rs.getString("nom");
                                    table_cell=new PdfPCell(new Phrase(manager_id));
                                    my_report_table.addCell(table_cell);

                                    String dated=rs.getString("prix");
                                    table_cell=new PdfPCell(new Phrase(dated));
                                    my_report_table.addCell(table_cell);

                                    String datef=rs.getString("categorie");
                                    table_cell=new PdfPCell(new Phrase(datef));
                                    my_report_table.addCell(table_cell);

                                    
                                    }
                    /* Attach report table to PDF */
                    my_pdf_report.add(my_report_table);
                    my_pdf_report.close();

                    /* Close all DB related objects */
                    rs.close();





    } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    } catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();

    }
         String title = "Succes! ";
        String message = "Le fichier PDF est generé";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5));

    }
    

    
         
         
         
 
    
}
