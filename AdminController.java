/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.user;

import java.awt.event.MouseEvent;
import utils.mysqlconnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import static utils.mysqlconnect.ConnectDb;
 

/**
 * FXML Controller class
 *
 * @author doues
 */
public class AdminController implements Initializable {
    
    
      @FXML
    private TextField admin_nom;

    @FXML
    private TextField admin_prenom;

    @FXML
    private TextField admin_contact;

    @FXML
    private TextField admin_adress;

   

        @FXML
    private TextField admin_role;

      @FXML
    private TextField admin_mail;

    @FXML
    private PasswordField admin_password;

    @FXML
    private TableView<Adminuser > admin_table;

    @FXML
    private TableColumn<Adminuser, String> coll_nom;

    @FXML
    private TableColumn<Adminuser, String> coll_prenom;

    @FXML
    private TableColumn<Adminuser, String> coll_mail;

    @FXML
    private TableColumn<Adminuser, String> coll_password;

    @FXML
    private TableColumn<Adminuser, String> coll_contact;
    
    @FXML
    private TableColumn<Adminuser, String> coll_role;

    @FXML
    private TableColumn<Adminuser, String> coll_adress;

    @FXML
    private Button admin_insert;

    @FXML
    private Button admin_update;

    @FXML
            
            void getSelected (MouseEvent event){
                index = admin_table.getSelectionModel().getSelectedIndex();
                if(index <= -1){
                    return;
                }
                admin_nom.setText(coll_nom.getCellData(index).toString());
                admin_prenom.setText(coll_prenom.getCellData(index).toString());
                admin_mail.setText(coll_mail.getCellData(index).toString());
                admin_password.setText(coll_password.getCellData(index).toString());
                admin_contact.setText(coll_contact.getCellData(index).toString());
                admin_role.setText(coll_role.getCellData(index).toString());
                admin_adress.setText(coll_adress.getCellData(index).toString());
            }
    
     /*       String query = null;
    Connection conn = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Adminuser Adminuser = null ;*/
 
     
     
    // ObservabaleList<Adminuser> ListM; 

     int index = -1 ;
     
     
      Connection conn =null;
      ResultSet rs = null ;
      PreparedStatement pst = null ;
      
      
       public void add_users(ActionEvent event) {
        
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into user (nom,prenom,mail,mdp,contact,role,localisation) values (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,admin_nom.getText());
            pst.setString(2,admin_prenom.getText());
            pst.setString(3,admin_mail.getText());
            pst.setString(4,admin_password.getText());
            pst.setString(5,admin_contact.getText());
            pst.setString(6,admin_role.getText());
            pst.setString(7,admin_adress.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Saved");
            UpdateAdmin();
            
            
        }catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
             
        }
        
        
    }
    
       public void delete(ActionEvent event) throws SQLException {
            conn = mysqlconnect.ConnectDb();
             String sql = "delete from user where mail = ?";
             try{
               pst = conn.prepareStatement(sql);
            pst.setString(1,admin_mail.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Delete");
            UpdateAdmin();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            
            
       }
       /////////////////////////
      
       
        //public static ObservableList<Adminuser> getDatausers() throws SQLException {
            
            //Connection conn = mysqlconnect.ConnectDb();
            //ObservableList<Adminuser> Adminlist = FXCollections.observableArrayList();
            //try {
                //PreparedStatement ps = conn.prepareStatement("SELECT * FROM user ");
               // ResultSet rs = ps.executeQuery();
            
                //while (rs.next()) {
               // Adminlist.add(new Adminuser(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("mdp"), rs.getString("contact"), rs.getString("role"), rs.getString("adress")));
            //}
            //} 
   // catch (Exception e) {
       //  }
        // return Adminlist ;
       // ResultSet rs = conn.createStatement().executeQuery("select * from user");
            //while(rs.next()){
               // Adminlist.add(new Adminuser(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("mdp"), rs.getString("contact"), rs.getString("role"), rs.getString("adress")));
           // }
       //  }
       
          
            
            
            
            
        
             
      ObservableList<Adminuser> Adminlist = FXCollections.observableArrayList();
      
    /**
     * Initializes the controller class.
     *
     */
      public void UpdateAdmin() {
          
              coll_nom.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("nom"));
              coll_prenom.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("prenom"));
              coll_mail.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("mail"));
              coll_password.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("mdp"));
              coll_contact.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("contact"));
              coll_role.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("role"));
              coll_adress.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("adress"));
              
    
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           try {
               
            
            Connection conn = mysqlconnect.ConnectDb();
            //ObservableList<Adminuser> Adminlist = FXCollections.observableArrayList();
            //try {
                //PreparedStatement ps = conn.prepareStatement("SELECT * FROM user ");
               // ResultSet rs = ps.executeQuery();
            
                //while (rs.next()) {
               // Adminlist.add(new Adminuser(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("mdp"), rs.getString("contact"), rs.getString("role"), rs.getString("adress")));
            //}
            //} 
   // catch (Exception e) {
       //  }
        // return Adminlist ;
        ResultSet rs = conn.createStatement().executeQuery("select * from user");
            while(rs.next()){
                Adminlist.add(new Adminuser(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("mdp"), rs.getString("contact"), rs.getString("role"), rs.getString("adress")));
            }
            
           }catch(SQLException ex){
               
           }
        
        
      
          
              coll_nom.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("nom"));
              coll_prenom.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("prenom"));
              coll_mail.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("mail"));
              coll_password.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("mdp"));
              coll_contact.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("contact"));
              coll_role.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("role"));
              coll_adress.setCellValueFactory(new PropertyValueFactory<Adminuser,String>("adress"));
              
              admin_table.setItems(Adminlist);
              
         
             
   
    }

    
    

    

    

  

}

     
   
   
    
     

   
