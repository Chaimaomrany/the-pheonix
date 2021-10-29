/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Service;
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
import services.IServiceCE;
import utiles.Maconnection;

/**
 *
 * @author hp
 */
public class serviceCE {
      Connection cnx;
    private Statement ste;
    private PreparedStatement pre;
    private String ref;
    public serviceCE() {
         cnx = Maconnection.getInstance().getConnection();

        
    }
    public List<Service> Afficherservice()  {
        
        try {
            String req="select * from service_esthethiques  ";
            List<Service> list = new ArrayList<>();
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                Service f= new Service (rs.getInt(1),rs.getString(2),rs.getString(3));
                
                
                
                
                
                
                
                list.add(f);
                
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(serviceRDV.class.getName()).log(Level.SEVERE, null, ex);
        }

      return null ;   
        
    } 
    public void Ajouterservice(Service r) {
        try {
            //  Statement stm = cnx.createStatement();
           pre = cnx.prepareStatement("INSERT INTO service_esthethiques ( prix_s_esth,nom_s_esth) VALUES (?,?)");
            
           
            pre.setString(1, r.getPrix());
            pre.setString(2, r.getNom());
          
            pre.executeUpdate();
            //  stm.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public boolean delete(int ref) throws SQLException {
        if(chercher(ref)){
           System.out.println("exist");
        pre=cnx.prepareStatement("delete from `pidev`.`service_esthethiques` where ref_s_esth = (?);");
        pre.setInt(1,ref);
          pre.execute();
    return true;}
        else 
     {System.out.println("nexiste pas");
           return false;}

     }
     public boolean chercher(int ref) {
        String req="select * from service_esthethiques ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
            
                list.add(rs.getInt(1));
             

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(serviceCE.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(ref);  
    }

     public String getprixbyRef (int ref){
         try {
            PreparedStatement st = cnx.prepareStatement("select * from service_esthethiques where ref_s_esth = (?);");
            st.setInt(1, ref);
            ResultSet rs = st.executeQuery();
          //  rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("prix_s_esth");
            }
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
        return "";

         
     }
     public String getnombyRef(int ref) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from service_esthethiques where ref_s_esth = (?);");
            st.setInt(1, ref);
            ResultSet rs = st.executeQuery();
          //  rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("nom_s_esth");
            }
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
        return "";

    }
     public void Modiffierservice( Service f,int ref)  throws NoSuchAlgorithmException {
        PreparedStatement pre;
        try {
                    String req= "UPDATE service_esthethiques SET prix_s_esth =?,nom_s_esth =?"
                   
                    + "where ref_s_esth=?";
                     pre = cnx.prepareStatement(req);

          pre.setString(1, f.getPrix());
    
    
    pre.setString(2, f.getNom());
  
    
 
   
    pre.setInt(3, ref);
    pre.executeUpdate();
  pre.executeUpdate();
     
            System.out.println("Modification avec success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
}
