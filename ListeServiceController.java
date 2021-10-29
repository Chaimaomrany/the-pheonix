/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.service;
import Services.CentresMedicauxService;
import Services.Service;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import utils.database;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author oussama
 */
public class ListeServiceController implements Initializable {

     private CentresMedicauxService l;
    @FXML
    private TableView<service> table;
    @FXML
    private Button interaj;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private AnchorPane pane;
     @FXML
    private ImageView imageView;
    private Connection cnx;
    @FXML
    private TableColumn<service,Integer> ref;
    @FXML
    private TableColumn<service, String> prixService;
    @FXML
    private TableColumn<service, String> nomService;

    private int index;
    private int a;
    private String b,c;
    @FXML
    private Button ret;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          cnx = database.getInstance().getConnection();

             Afficherservice();
       
    }    

    @FXML
    private void interaj(ActionEvent event)throws IOException  {
 
     Pane page=FXMLLoader.load(getClass().getResource("AjouterServicefxml.fxml"));
        pane.getChildren().setAll(page);
    
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException  {
 Pane page=FXMLLoader.load(getClass().getResource("ModifierService.fxml"));
        pane.getChildren().setAll(page);
    
    }

    @FXML
    private void supprimer(ActionEvent event)throws SQLException{

        CentresMedicauxService cs = new CentresMedicauxService();
        cs.Supprimer(a);
        table.refresh();
        table.setItems(cs.afficherService());
        

    }

    
    
private void Afficherservice(){
       CentresMedicauxService sp = new CentresMedicauxService();       
            
            ref.setCellValueFactory(new PropertyValueFactory<>("ref_s_med"));
            prixService.setCellValueFactory(new PropertyValueFactory<>("prix_s_med"));
            nomService.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
           
             table.setItems(sp.afficherService());
            
           
            
          
            
            
        }
    
    

     private void imageView(ActionEvent event) {       
    Image img = new Image("/icons/ecole-europeenne-de-bien-etre-.jpg");
          imageView =setImage(img);
        }

    private ImageView setImage(Image img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void onClick(MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index<= -1)
            return;
        a=ref.getCellData(index);
        b=prixService.getCellData(index);
        c=nomService.getCellData(index);
        System.out.println(a);
    }

    @FXML
    private void ret(ActionEvent event) throws IOException {
     Pane page=FXMLLoader.load(getClass().getResource("Admin.fxml"));
        pane.getChildren().setAll(page);
    }

   
    
    

    
}
