/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.servicecategorie;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutercategorieController implements Initializable {

    @FXML
    private TextField nomcategorie;
    @FXML
    private TextField descriptioncategorie;
    @FXML
    private Button retour;
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutercategorie(ActionEvent event) {
         servicecategorie sc =new servicecategorie ();
         Categorie c=new Categorie(nomcategorie.getText(),descriptioncategorie.getText());
           if((nomcategorie.getText().length()==0) || (descriptioncategorie.getText().length()==0) )
      { JOptionPane.showMessageDialog(null, "Champ Vide ");}
        else{
          
          JOptionPane.showMessageDialog(null, " Categorie Ajouté ");
        sc.Ajoutercategorie(c);;
      }
        
//          String title = "Succes! ";
//        String message = "la categorie est ajouté avec succés";
//
//        TrayNotification tray = new TrayNotification();
//        tray.setTitle(title);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(javafx.util.Duration.seconds(5));
    }

    @FXML
    private void retourcategorie(ActionEvent event) throws IOException {
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
    
}
