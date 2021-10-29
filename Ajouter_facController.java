/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.facture;
import java.io.IOException;
import java.net.URL;
import java.sql.Ref;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.servicefacture;
import utils.Mailfacture;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class Ajouter_facController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField D2;
    @FXML
    private TextField D3;
    @FXML
    private TextField D4;
    @FXML
    private TextField D5;
    @FXML
    private Button confirmer;
    @FXML
    private Button retour;
    private servicefacture sf;
    private ImageView imageView;
    @FXML
    private TextField D6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sf=new servicefacture();
        // TODO
    }    
 private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/facture.jpg");
        ImageView imageView = setImage(image);
    }
 
    @FXML
    private void confirmer(ActionEvent event) {
        facture r = new facture();
       
        r.setPrix_unitaire(D2.getText());
        r.setQuantite(D3.getText());
        r.setSomme_prix(D4.getText());
        r.setDate(D5.getText());
        r.setMail(D6.getText());
        
        
     try {
        
         
        sf.Ajouterfac(r);
     }catch(Exception e){
         System.out.println("erreur");
     }
     Mailfacture mailer = new Mailfacture();
        mailer.SendMail(confirmer.getText());
        System.out.println("facture confirmée");
    
    }
    
    

    @FXML
    private void retour(ActionEvent event)throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("facture.fxml"));
        anchorpane.getChildren().setAll(page);
    }
     private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
