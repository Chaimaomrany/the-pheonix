/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//////////////////////////////////////////////////////////////////////////////
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.myDB;
/////////////////////////////////////////////////////////////////////////////

import entities.facture;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.servicefacture;
import utils.Mailfacture;
import utils.myDB;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class FactureController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<facture> tableau;
    @FXML
    private TableColumn<facture,Integer> Ref;
    @FXML
    private TableColumn<facture, String> prix_un;
    @FXML
    private TableColumn<facture, String> quantite;
    @FXML
    private TableColumn<facture, String> somme;
    @FXML
    private TableColumn<facture, String> date;
    @FXML
    private TableColumn<facture, String> mail;
    @FXML
    private Button supprimer;
    private int index;
    private int a;
    private String b,c,d,e,f;
    @FXML
    private Button retour;
    @FXML
    private Button pdf;
    @FXML
    private Button ordo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Affiche();
        // TODO
    }
private void Affiche()  {
    servicefacture sf = new servicefacture();
    ObservableList<facture> listt= sf.findAll();
            Ref.setCellValueFactory(new PropertyValueFactory<>("Reference_facture"));
            prix_un.setCellValueFactory(new PropertyValueFactory<>("Prix_unitaire"));
            quantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
            somme.setCellValueFactory(new PropertyValueFactory<>("Somme_prix"));
            date.setCellValueFactory(new PropertyValueFactory<>("Date"));
            mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
           tableau.setItems(sf.findAll());
          

    }    
private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/facture.jpg");
        ImageView imageView = setImage(image);
    }
public FactureController ()
{
        Connection cnx = myDB.getInstance().getConnection();
}

    @FXML
    private void ajouter(ActionEvent event)throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("ajouter_fac.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void supprimer(ActionEvent event)throws SQLException {
        servicefacture rs = new servicefacture();
        a=Ref.getCellData(index);
        rs.delete(a);
        Affiche();
    }
     private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  

    @FXML
    private void clicked(MouseEvent event) {
        index = tableau.getSelectionModel().getSelectedIndex();
        if (index<= -1)
            return;
        a=Ref.getCellData(index);
        b=prix_un.getCellData(index);
        c=quantite.getCellData(index);
        d=somme.getCellData(index);
        e=date.getCellData(index);
        f=mail.getCellData(index);
        
         System.out.println(a);
    }

  
   

    @FXML
    private void retour(ActionEvent event)throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("Affiche.fxml"));
        pane.getChildren().setAll(page);

    }

    

  @FXML
    void pdf (ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        try {
Connection connection = myDB.getInstance().getConnection();

        ResultSet rs;
        rs = connection.createStatement().executeQuery("SELECT * FROM facture");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("facture.pdf"));
                    my_pdf_report.open();
                    //we have four columns in our table
                    PdfPTable my_report_table = new PdfPTable(6);
                    //create a cell object
                    PdfPCell table_cell;

                    while (rs.next()) {
                                

                                    String dept_name=rs.getString("Reference_facture");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);

                                    String manager_id=rs.getString("Prix_unitaire");
                                    table_cell=new PdfPCell(new Phrase(manager_id));
                                    my_report_table.addCell(table_cell);

                                    String dated=rs.getString("Quantite");
                                    table_cell=new PdfPCell(new Phrase(dated));
                                    my_report_table.addCell(table_cell);

                                    String datef=rs.getString("Somme_prix");
                                    table_cell=new PdfPCell(new Phrase(datef));
                                    my_report_table.addCell(table_cell);

                                    String location_id=rs.getString("Date");
                                    table_cell=new PdfPCell(new Phrase(location_id));
                                    my_report_table.addCell(table_cell);
                                    //String location_id=rs.getString("mail");
                                    //table_cell=new PdfPCell(new Phrase(location_id));
                                    //my_report_table.addCell(table_cell);
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

    @FXML
    private void ordo(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("afficherordonnance.fxml"));
        pane.getChildren().setAll(page);
    }
    

    }
        
        
    
    

