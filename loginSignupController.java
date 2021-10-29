/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.user;

import java.io.IOException;
import static java.lang.Thread.State.NEW;
import utils.mysqlconnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author doues
 */
public class loginSignupController implements Initializable {
    
   

    @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private ComboBox role;

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_up;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField txt_prenom_up;

    @FXML
    private TextField mail_up;

    @FXML
    private PasswordField txt_password_up;


    @FXML
    private TextField contact_up;

    @FXML
    private TextField adresse_up;

    @FXML
    private ComboBox role_up;

    @FXML
    private Button btn_signup;

    @FXML
    private ImageView image_signup;
    
    Connection conn = null ;
    ResultSet rs = null ;
    PreparedStatement pst = null ;
    
    public void connexion() throws IOException {
        Stage stage = (Stage) btn_login.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
        
        
        
    }
    
    
    public void LoginpaneShow () {
        pane_login.setVisible(true);
        pane_up.setVisible(false);
    }
    
    public void SignuppaneShow (){
        pane_login.setVisible(false);
        pane_up.setVisible(true);
    }

    
         @FXML
    private void Login (ActionEvent event) throws Exception {
    conn = mysqlconnect.ConnectDb();
    String sql ="Select * from user where mail = ? and mdp = ? and role = ? " ;   
        try {
        pst = conn.prepareCall(sql);
        pst.setString(1, txt_username.getText());
        pst.setString(2, txt_password.getText());
         pst.setString(3, role.getValue().toString());
        rs = pst.executeQuery();
        
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "mail and password is correct");
            
            btn_login.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
            Scene scene = new Scene (root);
            Stage mainStage = new Stage();
            mainStage.setScene(scene);
            
            mainStage.show();
            
        }else
            JOptionPane.showMessageDialog(null, "invalid mail and password or role ");       
        
        } catch(Exception e){
            JOptionPane.showMessageDialog (null, e);
            
            
        }
        Pane page=FXMLLoader.load(getClass().getResource("/pi.user/Acceuil.fxml"));
        pane_login.getChildren().setAll(page);
   
    }
    
    public void add_users(ActionEvent event) {
        
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into user (nom,prenom,mail,mdp,contact,role,localisation) values (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_username_up.getText());
            pst.setString(2,txt_prenom_up.getText());
            pst.setString(3,mail_up.getText());
            pst.setString(4,txt_password_up.getText());
            pst.setString(5,contact_up.getText());
            pst.setString(6,role_up.getValue().toString());
            pst.setString(7,adresse_up.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Saved");
            
            
        }catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
        }
        
        
    }
    
    
    
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        role_up.getItems().addAll("Patient","Medecin","Prop.Centre esthetique","Prop boutique","Coach","Admin","Prop clinique");
        role.getItems().addAll("Patient","Medecin","Prop.Centre esthetique","Prop boutique","Coach","Admin","Prop clinique");
    }    
    
  
}
