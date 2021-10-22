/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Produit;
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
import service.serviceproduit;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ProduitControllerjava implements Initializable {

    @FXML
    private TextField nomproduit;
    @FXML
    private TextField prixproduit;
    @FXML
    private TextField categorie;
    private AnchorPane pane;
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
    private void ajouterproduit(ActionEvent event) {
         serviceproduit sp =new serviceproduit ();
        Produit p=new Produit(nomproduit.getText(),prixproduit.getText(),categorie.getText());
      
        sp.Ajouterproduit(p);
//          String title = "Succes! ";
//        String message = "Le formateur est ajouté avec succés";
//
//        TrayNotification tray = new TrayNotification();
//        tray.setTitle(title);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(javafx.util.Duration.seconds(5));
//          AnchorPane page=FXMLLoader.load(getClass().getResource("Afficherformateur.fxml"));
//        pane.getChildren().setAll(page);
    }

    @FXML
    private void retouraffichage(ActionEvent event) throws IOException {
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
    

