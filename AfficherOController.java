/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.ordonnance;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;
import services.serviceordonnance;
import utils.myDB;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class AfficherOController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TableView<ordonnance> table;
    @FXML
    private TableColumn<ordonnance, Integer> refa;
    @FXML
    private TableColumn<ordonnance,String> medica;
    @FXML
    private TableColumn<ordonnance, String> date;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Affiche();
        // TODO
    } 
     private void Affiche()  {
   serviceordonnance sr = new serviceordonnance();
    ObservableList<ordonnance> listt= sr.findAll();
            refa.setCellValueFactory(new PropertyValueFactory<>("ref_ordonnance"));
            medica.setCellValueFactory(new PropertyValueFactory<>("medicament"));
            date.setCellValueFactory(new PropertyValueFactory<>("Date"));
           
           table.setItems(sr.findAll());
    }
     private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/facture.jpg");
        ImageView imageView = setImage(image);
    }
public AfficherOController()
{
        Connection cnx = myDB.getInstance().getConnection();

} 

    @FXML
    private void retour(ActionEvent event) throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("Patient.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    

