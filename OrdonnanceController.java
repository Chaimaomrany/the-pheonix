/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.ordonnance;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.serviceordonnance;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class OrdonnanceController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextArea med;
    @FXML
    private TextField date;
    @FXML
    private Button envoyer;
    @FXML
    private Button retour;
    private serviceordonnance so;
    private ImageView imageView;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    so=new serviceordonnance();
        // TODO
    }   
    private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/medica.jpg");
       imageView  = setImage(image);
    }
   
    @FXML
    private void envoyer(ActionEvent event) {
        
        ordonnance r = new ordonnance();
        r.setMedicament(med.getText());
        r.setDate(date.getText());
        
        
     try {
        
         
       so.Ajouterord(r);
     }catch(Exception e){
         System.out.println("erreur");
     }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
       
 
         AnchorPane page=FXMLLoader.load(getClass().getResource("facture.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    }

 


   
    