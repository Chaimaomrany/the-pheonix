/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.servicecategorie;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CategorieController implements Initializable {

    @FXML
    private TableView<Categorie> tableCategorie;
    @FXML
    private TableColumn<Categorie, Integer> colid;
    @FXML
    private TableColumn<Categorie, String> colnom;
    @FXML
    private TableColumn<Categorie,  String> coldescription;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnsupprimer;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
     public CategorieController (){
        Connection cnx = MyDB.getInstance().getConnection();
    }
    public static int w;
    @Override
       public void initialize(URL url, ResourceBundle rb) {
        try {
            AfficheCategorie();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
        private void AfficheCategorie() throws SQLException{
       servicecategorie sc = new servicecategorie();
       List categorie=sc.AfficheCategorie();
       ObservableList et=FXCollections.observableArrayList(categorie);
       tableCategorie.setItems(et);
            
            
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colid.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
           
            
           
            
          
            
            
        }

    @FXML
    private void ajouter(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader();
          pane.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("ajoutercategorie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    private void modifier(ActionEvent event) throws IOException {
        Categorie c = (Categorie)tableCategorie.getSelectionModel().getSelectedItem();
        w= c.getId_categorie();
        System.out.println(w);
          FXMLLoader loader = new FXMLLoader();
        pane.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("modifiercategorie.fxml"));
        Parent root;
        root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
                servicecategorie cs = new servicecategorie();
         Categorie c = (Categorie)tableCategorie.getSelectionModel().getSelectedItem();
        if(c== null){
            JOptionPane.showMessageDialog(null, "choisir categorie");
                   
        }else{
             try {
                 cs.delete(c.getId_categorie());
                
                AfficheCategorie();
                 JOptionPane.showMessageDialog(null, "categorie supprimé avec succés");
               
                 c=null;
             } catch (SQLException ex) {
                 Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    }
    
}
