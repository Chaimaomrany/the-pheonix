/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.rendez_vous_medecin;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import services.servicerendezvous;
import utils.myDB;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class AccueilController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TableView<rendez_vous_medecin> tableau;
    @FXML
    private TableColumn<rendez_vous_medecin, String> hd;
      @FXML
    private TableColumn<rendez_vous_medecin, Integer> rf;
    @FXML
    private TableColumn<rendez_vous_medecin, String> dt;
   
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button retour;
    private int index;
    private int a;
    private String b,c;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Affiche();

    }
        // TODO

    private void Affiche()  {
    servicerendezvous sr = new servicerendezvous();
    ObservableList<rendez_vous_medecin> listt= sr.findAll();
            hd.setCellValueFactory(new PropertyValueFactory<>("h_debut"));
            dt.setCellValueFactory(new PropertyValueFactory<>("date"));
            rf.setCellValueFactory(new PropertyValueFactory<>("ref_rdv_med"));
           tableau.setItems(sr.findAll());
          

    }    
    private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/acc.jpg");
        ImageView imageView = setImage(image);
    }
public AccueilController ()
{
        Connection cnx = myDB.getInstance().getConnection();
}
    @FXML
    private void ajouter(ActionEvent event)throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("ajouter_rdv.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    @FXML
    private void modifier(ActionEvent event)throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("modifier_rdv.fxml"));
        anchorpane.getChildren().setAll(page);
    } 
    

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        
       servicerendezvous rs = new servicerendezvous();
        rs.delete(a);
        Affiche();
    }
    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  

    @FXML
    private void retour(ActionEvent event)throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("Medecin.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    @FXML
    private void clicked(MouseEvent event) {
        index = tableau.getSelectionModel().getSelectedIndex();
        if (index<= -1)
            return;
        a=rf.getCellData(index);
        b=hd.getCellData(index);
        c=dt.getCellData(index);
        System.out.println(a);
    }

  
    
           
            
           
            
          
            
            
        }

