/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.facture;
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
import services.servicefacture;
import utils.myDB;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class AfficheFactController implements Initializable {

    @FXML
    private TableView<facture> tableau;
    @FXML
    private TableColumn<?, ?> rf;
    @FXML
    private TableColumn<?, ?> pu;
    @FXML
    private TableColumn<?, ?> q;
    @FXML
    private TableColumn<?, ?> s;
    @FXML
    private TableColumn<?, ?> d;
    @FXML
    private TableColumn<?, ?> ma;
    @FXML
    private Button retour;
    @FXML
    private AnchorPane anchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Affiche();
        // TODO
    }    
    private void Affiche()  {
   servicefacture sr = new servicefacture();
    ObservableList<facture> listt= sr.findAll();
            rf.setCellValueFactory(new PropertyValueFactory<>("reference_facture"));
            pu.setCellValueFactory(new PropertyValueFactory<>("Prix_unitaire"));
            q.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
            s.setCellValueFactory(new PropertyValueFactory<>("Somme_prix"));
            d.setCellValueFactory(new PropertyValueFactory<>("Date"));
            ma.setCellValueFactory(new PropertyValueFactory<>("mail"));
           tableau.setItems(sr.findAll());
    }
    

    
private void imageView(ActionEvent event)
    { Image image = new Image ("/icons/facture.jpg");
        ImageView imageView = setImage(image);
    }
public AfficheFactController ()
{
        Connection cnx = myDB.getInstance().getConnection();

} 
@FXML
    private void retour(ActionEvent event)  throws IOException {
   
    
        
    
         AnchorPane page=FXMLLoader.load(getClass().getResource("Patient.fxml"));
        anchorpane.getChildren().setAll(page);
    }

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   



