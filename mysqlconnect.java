

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import pi.user.Adminuser;



/**
 *
 * @author amir
 */

public class mysqlconnect {

    public static mysqlconnect getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    
     Connection conn = null;
    public static Connection ConnectDb(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pidev","root","");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }  
    }
    
    
        /* public static ObservableList<Adminuser> getDatausers() {
            
            Connection conn = ConnectDb();
            ObservableList<Adminuser> Adminlist = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM user ");
                ResultSet rs = ps.executeQuery();
            
                while (rs.next()) {
                Adminlist.add(new Adminuser(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("mdp"), rs.getString("contact"), rs.getString("role"), rs.getString("adress")));
            }
            } 
    catch (Exception e) {
         }
         return Adminlist ;
         }*/
         
    
}    
        
        


