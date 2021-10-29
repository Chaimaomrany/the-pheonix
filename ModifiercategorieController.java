/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.servicecategorie;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModifiercategorieController implements Initializable {

    @FXML
    private ImageView btnok;
    @FXML
    private Button retour;
    @FXML
    private TextField nommodifie;
    @FXML
    private TextField descriptionmodifie;
     public static int id ;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("categorie.fxml"));
            Parent root = loader.load();
            CategorieController ac = loader.getController();
            id = ac.w;
        } catch (IOException ex) {
            Logger.getLogger(ModifierproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        // TODO
    }    

    @FXML
    private void okmodifie(ActionEvent event) throws NoSuchAlgorithmException {
        
Categorie c = new Categorie();
        c.setNom(nommodifie.getText());
        c.setDescription(descriptionmodifie.getText());

        
       
        
  
        servicecategorie sc = new servicecategorie();
        sc.ModifierCategorie(c, id);
 


    }
    

    @FXML
    private void retourcategorie(ActionEvent event) throws IOException{
      FXMLLoader loader = new FXMLLoader();
        retour.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("categorie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    @FXML
    private void okmodifie(MouseEvent event) {
    }
    
}
