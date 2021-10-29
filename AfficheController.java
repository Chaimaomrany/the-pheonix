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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class AfficheController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Pane Gr;
    @FXML
    private Pane pane;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Pane Pr;
    @FXML
    private TableView<?> tableau;
    @FXML
    private TableColumn<?, ?> hd;
    @FXML
    private TableColumn<?, ?> Hf;
    @FXML
    private TableColumn<?, ?> cd;
    @FXML
    private TableColumn<?, ?> id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event)throws IOException {
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("ajouter_rdv.fxml"));
        pane.getChildren().setAll(page);
    }
        
    

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }
    
}
