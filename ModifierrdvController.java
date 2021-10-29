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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class ModifierrdvController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField rf;
    @FXML
    private TextField hd;
    @FXML
    private TextField hf;
    @FXML
    private TextField date;
    @FXML
    private Button Valider;
    @FXML
    private Button retour;
  private rendezVousC l;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        l=new rendezVousC();
    }    

    @FXML
    private void Valider(ActionEvent event) {
         int i;
               rendezVous x= new rendezVous();
               i= Integer.parseInt(rf.getText());
        x.setH_debut(hd.getText());
        x.setH_fin(hf.getText());
        x.setDate(date.getText());
         System.out.println(hd.getText());
        try{
        l.Modif(x,i);
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
    Pane page=FXMLLoader.load(getClass().getResource("Listerdv.fxml"));
        pane.getChildren().setAll(page);
    }
    
}
