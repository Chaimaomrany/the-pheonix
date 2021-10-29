/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class MedecinController implements Initializable {

    @FXML
    private Button rendezvous;
    @FXML
    private Button facture;
    @FXML
    private Button ordonnance;
@FXML
    private AnchorPane anchorpane;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rendezvous(ActionEvent event) throws IOException {
       
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("Affiche.fxml"));
        anchorpane.getChildren().setAll(page);
    }
    

    @FXML
    private void facture(ActionEvent event) throws IOException {
       
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("facture.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    @FXML
    private void ordonnance(ActionEvent event) throws IOException {
       
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("ordonnance.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
       
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("bienvenue.fxml"));
        anchorpane.getChildren().setAll(page);
    }
    
}
