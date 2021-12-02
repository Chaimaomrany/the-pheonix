/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.serviceproduit;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FrontController implements Initializable {

    @FXML
    private TableView<?> tableProduit;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colnom;
    @FXML
    private TableColumn<?, ?> colprix;
    @FXML
    private TableColumn<?, ?> colcategorie;
      @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
       private void imageView(ActionEvent event) {       
    Image image = new Image("R.jpg");
        imageView = setImage(image);
     }
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

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
