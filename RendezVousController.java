/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.rendez_vous_medecin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.servicerendezvous;

/**
 * FXML Controller class
 *
 * @author Sabrine
 */
public class RendezVousController implements Initializable {

    @FXML
    private DatePicker calender;
    @FXML
    private Pane MIN;
    
     @FXML
    private TextField heure;
          @FXML
    private TextField date;
              @FXML
    private TextField minute;
    @FXML
    private TextField hhr;
    @FXML
    private Pane HR;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button ajouter;
    private servicerendezvous sr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sr = new servicerendezvous();
    }    
    @FXML
    private void ajouter(ActionEvent event){
        rendez_vous_medecin r = new rendez_vous_medecin();
        r.setDate(date.getText());
        r.setH_debut(heure.getText());
        
     try {
        
         
        sr.Ajouterrdv(r);
     }catch(Exception e){
         System.out.println("erreur");
     }
     
    }
    private void modifier(ActionEvent event)
    {
        
    }
}
