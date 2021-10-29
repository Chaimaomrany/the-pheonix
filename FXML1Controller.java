/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
////////////////////////////////////////////////////////////////////////////////
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

////////////////////////////////////////////////////////////////////////////////
import Entities.service;
import Services.CentresMedicauxService;
import com.mysql.cj.util.DnsSrv;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import utils.database;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class FXML1Controller implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView imageView;
//    private TableView<service> table;
//    private TableColumn<service,Integer> ref;
//    private TableColumn<service, String> prixService;
//    private TableColumn<service, String> nomService;

     private Connection cnx;
    @FXML
    private Button retouur;
    @FXML
    private TableView<service> table11;
    @FXML
    private TableColumn<service,Integer> ref1;
    @FXML
    private TableColumn<service, String> prixService1;
    @FXML
    private TableColumn<service, String> nomService1;
    @FXML
    private Button PDF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cnx = database.getInstance().getConnection();

             Afficherservice();
    }    

    @FXML
    private void onClick(MouseEvent event) {
    }


private void Afficherservice(){
       CentresMedicauxService sp = new CentresMedicauxService();       
            
            ref1.setCellValueFactory(new PropertyValueFactory<>("ref_s_med"));
            prixService1.setCellValueFactory(new PropertyValueFactory<>("prix_s_med"));
            nomService1.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
           
             table11.setItems(sp.afficherService());    
        }

    @FXML
    private void retouur(ActionEvent event) throws IOException {
         Pane page=FXMLLoader.load(getClass().getResource("client.fxml"));
        pane.getChildren().setAll(page);
    }

      @FXML
    void PDF (ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        try {
Connection connection = database.getInstance().getConnection();

        ResultSet rs;
        rs = connection.createStatement().executeQuery("SELECT * FROM service_medicaux");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Liste Service.pdf"));
                    my_pdf_report.open();
                    //we have four columns in our table
                    PdfPTable my_report_table = new PdfPTable(5);
                    //create a cell object
                    PdfPCell table_cell;

                    while (rs.next()) {
                                

                                    String dept_name=rs.getString("ref_s_med");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);

                                    String manager_id=rs.getString("prix_s_med");
                                    table_cell=new PdfPCell(new Phrase(manager_id));
                                    my_report_table.addCell(table_cell);

                                    String dated=rs.getString("nom_med");
                                    table_cell=new PdfPCell(new Phrase(dated));
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
