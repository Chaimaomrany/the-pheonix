/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Categorie;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author LENOVO
 */
public class servicecategorie {
    Connection cnx;
    private Statement ste;
    private PreparedStatement pre;
    private String id;

     public servicecategorie() {
        cnx = MyDB.getInstance().getConnection();
    }
     
      public void Ajoutercategorie(Categorie c) {
        try {
           pre = cnx.prepareStatement("INSERT INTO categorie (nom, description) VALUES (?,?)");
            pre.setString(1, c.getNom());
            pre.setString(2, c.getDescription());     
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//    public List AfficheCategorie() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void delete(int id_categorie) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public ObservableList<Categorie> AfficheCategorie() throws SQLException {
        
        try {
            String req="select * from categorie  ";
            ObservableList<Categorie> list =  FXCollections.observableArrayList();
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                
                Categorie f= new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
                
                
                
                
                
                
                
                list.add(f);
                
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicecategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

      return null ;   
        
    }
    public boolean delete(int id) throws SQLException {
        if(chercher(id)){
        pre=cnx.prepareStatement("delete from `pidev`.`categorie` where id_categorie  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
      return true;}
       else 
       {System.out.println("nexiste pas");
            return false;}
     }

    private boolean chercher(int id) {
        String req="select * from categorie ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
            
                list.add(rs.getInt(1));
             

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(servicecategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id);  
    }
    public void ModifierCategorie(Categorie c,int id)  throws NoSuchAlgorithmException {
        PreparedStatement pre;
        try {
                    String req= "UPDATE categorie SET nom =?,description =?"
                   
                    + "where id_categorie=?";
                     pre = cnx.prepareStatement(req);

          pre.setString(1, c.getNom());
    
    
    pre.setString(2, c.getDescription());
  
    
    
   pre.setInt(3, id);
    pre.executeUpdate();
  pre.executeUpdate();
     
            System.out.println("Modification avec success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
