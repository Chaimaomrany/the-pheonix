/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Produit;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.Iservicesproduit;
import utils.MyDB;

/**
 *
 * @author LENOVO
 */
public class serviceproduit{
      Connection cnx;
    private Statement ste;
    private PreparedStatement pre;
    private String id;

     public serviceproduit() {
        cnx = MyDB.getInstance().getConnection();
    }
    
    public void Ajouterproduit(Produit p) {
        try {
           pre = cnx.prepareStatement("INSERT INTO produit (prix, nom, categorie ) VALUES (?,?,?)");
            pre.setString(2, p.getNom());
            pre.setString(3, p.getCategorie());
            pre.setString(1, p.getPrix());
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
 
    
    public ObservableList<Produit> AfficheProduit() throws SQLException {
        
        try {
            String req="select * from produit  ";
            ObservableList<Produit> list =  FXCollections.observableArrayList();
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                
                Produit f= new Produit(rs.getInt(1),rs.getString(4),rs.getString(2),rs.getString(3));
                
                
                
                
                
                
                
                list.add(f);
                
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(serviceproduit.class.getName()).log(Level.SEVERE, null, ex);
        }

      return null ;   
        
    }

    
    
    public boolean delete(int id) throws SQLException {
        if(chercher(id)){
        pre=cnx.prepareStatement("delete from `pidev`.`produit` where id_produit  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
      return true;}
       else 
       {System.out.println("nexiste pas");
            return false;}
     }
      public boolean chercher(int id) throws SQLException {
         String req="select * from produit  ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
            
                list.add(rs.getInt(1));
             

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(serviceproduit.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id);  
    }   
   

        public void ModifierProduit(Produit p,int id)  throws NoSuchAlgorithmException {
        PreparedStatement pre;
        try {
                    String req= "UPDATE produit SET nom =?,prix =?,categorie =?"
                   
                    + "where id_produit=?";
                     pre = cnx.prepareStatement(req);

          pre.setString(1, p.getNom());
    
    
    pre.setString(2, p.getPrix());
  
    
    pre.setString(3,p.getCategorie());
    
   pre.setInt(4, id);
    pre.executeUpdate();
  pre.executeUpdate();
     
            System.out.println("Modification avec success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
