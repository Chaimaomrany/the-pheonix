/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.rendez_vous_medecin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import services.servicerendezvous;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class Ajouter_rdvController implements Initializable {

    @FXML
    private Pane HR;
    @FXML
    private TextField hhr;
    @FXML
    private Pane dtt;
    @FXML
    private TextField dt;
    @FXML
    private Button confirmer;
    @FXML
    private Button retour;
    
    @FXML
    private ImageView imageView;
private servicerendezvous sr;
    @FXML
    private AnchorPane pane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         sr=new servicerendezvous();
    } 
    private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/doc.jpg");
        imageView = setImage(image);
    }
    

    @FXML
    private void confirmer(ActionEvent event) {
              rendez_vous_medecin r = new rendez_vous_medecin();
        r.setDate(dt.getText());
        r.setH_debut(hhr.getText());
        
        
     try {
        
         
        sr.Ajouterrdv(r);
     }catch(Exception e){
         System.out.println("erreur");
     }
    }

    @FXML
    private void retour(ActionEvent event)throws IOException {
       
 
         AnchorPane page=FXMLLoader.load(getClass().getResource("Affiche.fxml"));
        pane.getChildren().setAll(page);
    }
    
   private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
