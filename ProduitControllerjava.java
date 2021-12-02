/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.servicecategorie;
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
    private ComboBox<Categorie> categorie;
    private AnchorPane pane;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         servicecategorie sc =new servicecategorie ();

        try {
            categorie.setItems( sc.AfficheCategorie());
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControllerjava.class.getName()).log(Level.SEVERE, null, ex);
        }
             categorie.getSelectionModel().selectFirst();
    }    

    @FXML
    private void ajouterproduit(ActionEvent event) throws SQLException, IOException{
         serviceproduit sp =new serviceproduit ();
       Produit p=new Produit(nomproduit.getText(),categorie.getId(),prixproduit.getText());
//      if(nomproduit.getText().length()==0){
//                     JOptionPane.showMessageDialog(null, "ecrire nomproduit");}
//        else{
//          sp.Ajouterproduit(p);
//          JOptionPane.showMessageDialog(null, " Produit Ajouté ");
//        sp.Ajouterproduit(p);
      
      if((prixproduit.getText().length()==0) || (nomproduit.getText().length()==0)|| (nomproduit.getId().length()==0) )
      { JOptionPane.showMessageDialog(null, "Champ Vide ");}
        else{
          sp.Ajouterproduit(p);
          JOptionPane.showMessageDialog(null, " Produit Ajouté ");
  
      }
    }

    @FXML
    private void retouraffichage(ActionEvent event) throws IOException ,SQLException {
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

    
    

