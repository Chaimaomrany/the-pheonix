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
import java.sql.SQLException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.serviceordonnance;
import utils.myDB;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class AfficherordonnanceController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TableColumn<ordonnance, Integer> ref_ordonnance;
    @FXML
    private TableColumn<ordonnance, String> medicament;
    @FXML
    private TableColumn<ordonnance, String> Date;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button retour;
        private int index;
    private int a;
    private String b,c;
    @FXML
    private TableView<ordonnance> tableau;

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
            ref_ordonnance.setCellValueFactory(new PropertyValueFactory<>("ref_ordonnance"));
            medicament.setCellValueFactory(new PropertyValueFactory<>("medicament"));
            Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
           tableau.setItems(listt);
}
 private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/acc.jpg");
        ImageView imageView = setImage(image);
    }
 public AfficherordonnanceController ()
{
        Connection cnx = myDB.getInstance().getConnection();
}
 
 
    @FXML
    private void ajouter(ActionEvent event)throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("ordonnance.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        
       serviceordonnance rs = new serviceordonnance();
       a=ref_ordonnance.getCellData(index);
        rs.delete(a);
        Affiche();
    }
    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  

    @FXML
    private void retour(ActionEvent event) throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("facture.fxml"));
        anchorpane.getChildren().setAll(page);
    }
    @FXML
    private void clicked(MouseEvent event) {
        index = tableau.getSelectionModel().getSelectedIndex();
        if (index<= -1)
            return;
        a=ref_ordonnance.getCellData(index);
        b=medicament.getCellData(index);
        c=Date.getCellData(index);
        System.out.println(a);
    }
    
}
