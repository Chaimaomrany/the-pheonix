/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.user;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author doues
 */
public class AccueilController implements Initializable {
    
    
      @FXML
    private AnchorPane pane_accueil;

    @FXML
    private AnchorPane pane_menu;

    @FXML
    private Button btn_medecin;

    @FXML
    private Button btn_centre;

    @FXML
    private Button btn_clinique;

    @FXML
    private Button btn_coach;

    @FXML
    private Button btn_admin;

    @FXML
    private Button btn_boutique;

    @FXML
    private ImageView accueil_image;
    
    @FXML
    private Label labe_2;
    
    @FXML
    private Label label_1;

    @FXML
    private Button btn_patient;
    
    
    /* public void VersAdmin() throws IOException{
        Pane page=FXMLLoader.load(getClass().getResource("/pi.user.Admin.fxml"));
       pane_accueil.getChildren().setAll(page);
        
    }*/

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void VersAdmin(ActionEvent event) {
        

    Parent root;
          try {
              root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                      Scene scene = new Scene (root);
            Stage mainStage = new Stage();
            mainStage.setScene(scene);
            
            mainStage.show();
          } catch (IOException ex) {
              Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
          }
   
    
    }
   
    
}
