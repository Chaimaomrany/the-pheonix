/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entities.rendezVous;

import Services.rendezVousC;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import utils.database;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class ListerdvController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<rendezVous> table1;
    @FXML
    private TableColumn<rendezVous, Integer> rf;
    @FXML
    private TableColumn<rendezVous, String> hd;
    @FXML
    private TableColumn<rendezVous, String> hf;
    @FXML
    private TableColumn<rendezVous, String> date;
    @FXML
    private Button ajouterrdv;
    @FXML
    private Button modifierrdv;
    @FXML
    private Button supprimerrdv;
private rendezVousC l;
private Connection cnx;
private int index;
    private int a;
    private String b,c,d,e;
    @FXML
    private Button re;
    @FXML
    private TableColumn<rendezVous,String> mail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  cnx = database.getInstance().getConnection();

             Afficherrdv();
    }    

    @FXML
    private void onClick(MouseEvent event) {
       index = table1.getSelectionModel().getSelectedIndex();
        if (index<= -1)
            return;
        a=rf.getCellData(index);
        b=hd.getCellData(index);
        c=hf.getCellData(index);
        d=date.getCellData(index);
        e=mail.getCellData(index);
        System.out.println(a);
    }

    @FXML
    private void ajouterrdv(ActionEvent event) throws IOException {
         Pane page=FXMLLoader.load(getClass().getResource("Ajouterrdv.fxml"));
        pane.getChildren().setAll(page);
    
    }

    @FXML
    private void modifierrdv(ActionEvent event) throws IOException {
        Pane page=FXMLLoader.load(getClass().getResource("Modifierrdv.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void supprimerrdv(ActionEvent event) throws SQLException {
                rendezVousC cs = new rendezVousC();
        cs.Supprim(a);
        table1.refresh();
        table1.setItems(cs.afficherrdv());
    }
    private void Afficherrdv(){
       rendezVousC sp = new rendezVousC();       
            
            rf.setCellValueFactory(new PropertyValueFactory<>("ref_rdv_clin"));
            hd.setCellValueFactory(new PropertyValueFactory<>("h_debut"));
            hf.setCellValueFactory(new PropertyValueFactory<>("h_fin"));
           date.setCellValueFactory(new PropertyValueFactory<>("date"));
            mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
          
           
             table1.setItems(sp.afficherrdv());           
        }

    @FXML
    private void re(ActionEvent event) throws IOException {
        Pane page=FXMLLoader.load(getClass().getResource("client.fxml"));
        pane.getChildren().setAll(page);
    }


 
    
}
