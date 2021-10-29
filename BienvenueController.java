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
public class BienvenueController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Button espaceM;
    @FXML
    private Button espaceP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void espaceM(ActionEvent event) throws IOException {
       
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("Medecin.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    @FXML
    private void espaceP(ActionEvent event)throws IOException {
       
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("Patient.fxml"));
        anchorpane.getChildren().setAll(page);
    }
    }
    

