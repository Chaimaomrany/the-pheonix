/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.rendez_vous;
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
import services.IServiceRDV;
import utiles.Maconnection;

/**
 *
 * @author hp
 */
public class serviceRDV implements IServiceRDV {
    Connection cnx;
    private Statement ste;
    private PreparedStatement pre;
    private String id;
 public serviceRDV() {
        cnx = Maconnection.getInstance().getConnection();
    }
    

    @Override
    public void Ajouterrdv(rendez_vous r) {
        try {
            //  Statement stm = cnx.createStatement();
           pre = cnx.prepareStatement("INSERT INTO rendez_vous_centre_esthethique (date,h_debut, h_fin) VALUES (?,?,?)");
            
            pre.setString(2, r.getH_debut());
            pre.setString(1, r.getDate());
            pre.setString(3, r.getH_fin());
            //pre.setString(4, r.getService());
          
            pre.executeUpdate();
            //  stm.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public ObservableList<rendez_vous> rendez_vous()  {
        
        try {
            String req="select * from rendez_vous_centre_esthethique  ";
            ObservableList<rendez_vous> list =  FXCollections.observableArrayList();
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                
                rendez_vous f;
                f = new rendez_vous(rs.getString(1),rs.getString(2),rs.getString(3));
                
                
                
                
                
                
                
                list.add(f);
                
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(serviceRDV.class.getName()).log(Level.SEVERE, null, ex);
        }

      return null ;   
        
    }
     
     @Override
    public List<rendez_vous> Afficherrendez_vous()  {
        
        try {
            String req="select * from rendez_vous_centre_esthethique  ";
            List<rendez_vous> list = new ArrayList<>();
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                rendez_vous f= new rendez_vous(rs.getString(3),rs.getString(4),rs.getString(2),rs.getInt(1));
                
                
                
                
                
                
                
                list.add(f);
                
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(serviceRDV.class.getName()).log(Level.SEVERE, null, ex);
        }

      return null ;   
        
    }
        @Override
     public boolean delete(int id) throws SQLException {
      // if(chercher(id)){
           System.out.println("exist");
        pre=cnx.prepareStatement("delete from `pidev`.`rendez_vous_centre_esthethique` where id= (?);");
        pre.setInt(1,id);
          pre.execute();
//      return true;}
//      else 
//      {System.out.println("nexiste pas");
//            return false;}
return true;
  }
     @Override
    public boolean chercher(int id) throws SQLException {
         String req="select * from rendez_vous_centre_esthethique  ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
               // System.out.println("kkkk");
                list.add(rs.getInt(4));
                System.out.println(list);
                

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(serviceRDV.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id);  
    }
    public String getdebutbyId(int id) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from rendez_vous_centre_esthethique where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
          //  rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("h_debut");
            }
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
        return "";

    }
    
    public String getfinbyId(int id) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from rendez_vous_centre_esthethique where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
          //  rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("h_fin");
            }
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
        return "";

    }
       public String getdatebyId(int id) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from rendez_vous_centre_esthethique where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
          //  rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("date");
            }
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
        return "";

    }
         public void Modifierrendez_vous( rendez_vous f,int id)  throws NoSuchAlgorithmException {
        PreparedStatement pre;
        try {
                    String req= "UPDATE rendez_vous_centre_esthethique SET h_debut =?,h_fin =?,date =?"
                   
                    + "where id=?";
                     pre = cnx.prepareStatement(req);

          pre.setString(1, f.getH_debut());
    
    
    pre.setString(2, f.getH_fin());
  
    
    pre.setString(3,f.getDate());
   
   pre.setInt(4, id);
    pre.executeUpdate();
  pre.executeUpdate();
     
            System.out.println("Modification avec success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       
}
