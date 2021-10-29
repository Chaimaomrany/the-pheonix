/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.service;
import Services.CentresMedicauxService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class AjouterServiceController implements Initializable {

    private CentresMedicauxService l;

    @FXML
    private TextField nomService;
    @FXML
    private TextField prixService;
    @FXML
    private ImageView imageView;

    @FXML
    private AnchorPane pane;
    @FXML
    private Button retour;
    @FXML
    private Button valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       l=new CentresMedicauxService();
    }    

    @FXML
    private void valider(ActionEvent event) {
        service x= new service();
        x.setPrix_s_med(prixService.getText());
        x.setNom_med(nomService.getText());
         System.out.println(prixService.getText());
        try{
        l.Ajouter(x);
        }catch(Exception e){System.out.println(e.getMessage());}
    }
     private void imageView(ActionEvent event) {       
    Image image = new Image("/icons/download.jpg");
          imageView =setImage(image);
        }

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void retour(ActionEvent event)throws IOException  {
 
     Pane page=FXMLLoader.load(getClass().getResource("ListeService.fxml"));
        pane.getChildren().setAll(page);
    
    }    
}
