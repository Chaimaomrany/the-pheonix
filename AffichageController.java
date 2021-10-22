/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.serviceproduit;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AffichageController implements Initializable {
    @FXML
    private TableView<Produit> tableProduit;
    @FXML
    private TableColumn<Produit, String> colnom;
    @FXML
    private TableColumn<Produit, String> colprix;
    @FXML
    private TableColumn<Produit, String> colcategorie;
 
    
    private Connection cnx;
    
   
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private AnchorPane pane;
    @FXML
    private TableColumn<Produit, Integer> colid;

    /**
     * Initializes the controller class.
     */
    public AffichageController (){
       cnx = MyDB.getInstance().getConnection();
    }
    public static int w;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AfficheProduit();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
   
         
         private void AfficheProduit() throws SQLException{
       serviceproduit sp = new serviceproduit();
       List produit=sp.AfficheProduit();
       ObservableList et=FXCollections.observableArrayList(produit);
       tableProduit.setItems(et);
            
            
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            colcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            colid.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
           
            
           
            
          
            
            
        }

   
         
         
         
    @FXML
    private void ajouter(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        pane.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("produit.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         Produit p = (Produit)tableProduit.getSelectionModel().getSelectedItem();
        w= p.getId_produit();
        System.out.println(w);
          FXMLLoader loader = new FXMLLoader();
        pane.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("modifierproduit.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
         serviceproduit cs = new serviceproduit();
         Produit p = (Produit)tableProduit.getSelectionModel().getSelectedItem();
        if(p== null){
            JOptionPane.showMessageDialog(null, "choisir produit");
                   
        }else{
             try {
                 cs.delete(p.getId_produit());
                
                AfficheProduit();
                 JOptionPane.showMessageDialog(null, "produit supprimé avec succés");
               
                 p=null;
             } catch (SQLException ex) {
                 Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    }
         
         
         
 
    
}
