/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.rendezVous;
import Services.rendezVousC;
import Utils.MailRendezVous;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class AjouterrdvController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField hd;
    @FXML
    private TextField hf;
    @FXML
    private TextField date;
    @FXML
    private Button ajout;
    @FXML
    private Button retour;
    private rendezVousC l;
    @FXML
    private TextField mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        l=new rendezVousC();
        MailRendezVous mailer;
        mailer = new MailRendezVous();
    }    

    
            
            
    @FXML
    private void ajout(ActionEvent event) {
               rendezVous x= new rendezVous();
        x.setH_debut(hd.getText());
        x.setH_fin(hf.getText());
        x.setDate(date.getText());
        x.setMail(mail.getText());
         System.out.println(hd.getText());
        try{
        l.Ajout(x);
         MailRendezVous mailer = new MailRendezVous();
        mailer.SendMail(ajout.getText());
        System.out.println("rendez-vous confirmé");
        }catch(Exception e){System.out.println(e.getMessage());}
       ////////////////////////////////////////////////////////////:
       String title = "Ajout avec succes !";
        String message = "Ajout avec succes !";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(15));
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Pane page=FXMLLoader.load(getClass().getResource("listerdv.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void mail(ActionEvent event) {
    }
    
}
