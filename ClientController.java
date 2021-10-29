/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class ClientController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView imageView;
    @FXML
    private Button clientcm;
    @FXML
    private Button clientcl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clientcm(ActionEvent event) throws IOException {
   Pane page=FXMLLoader.load(getClass().getResource("fxml1.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void clientcl(ActionEvent event) throws IOException {
         Pane page=FXMLLoader.load(getClass().getResource("listerdv.fxml"));
        pane.getChildren().setAll(page);
    }
    
}
