/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Produit;
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
import javafx.stage.Stage;
import service.serviceproduit;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModifierproduitController implements Initializable {

    @FXML
    private TextField nommodifie;
    @FXML
    private TextField prixmodifie;
    @FXML
    private TextField categoriemodifie;
    @FXML
    private Button btnok;
    @FXML
    private Button retour;
    
    public static int id ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("affichage.fxml"));
            Parent root = loader.load();
            AffichageController ac = loader.getController();
            id = ac.w;
        } catch (IOException ex) {
            Logger.getLogger(ModifierproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        // TODO
    }    

    @FXML
    private void okmodifie(ActionEvent event) throws NoSuchAlgorithmException {

Produit u = new Produit();
        u.setNom(nommodifie.getText());
        u.setPrix(prixmodifie.getText());
                u.setCategorie(categoriemodifie.getText());

        
       
        
  
        serviceproduit sp = new serviceproduit();
        sp.ModifierProduit(u, id);
 


    }

    @FXML
    private void retourproduit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        retour.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("affichage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }
    
}
