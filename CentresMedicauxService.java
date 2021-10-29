/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.service;
import utils.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author oussama
 */
public class CentresMedicauxService implements Service<service> {
     private Statement ste;
    private PreparedStatement pre;
Connection connection;


    public CentresMedicauxService(){
        connection= database.getInstance().getConnection();
    }

    /*    public CentresMedicauxService() {
    
    }*/

    public void Ajouter(service object) {
        try {
            String req = "INSERT INTO service_medicaux (prix_s_med,nom_med) VALUES('"+object.getPrix_s_med()+"','"+object.getNom_med()+"')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(CentresMedicauxService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("prblem");
        }
        
    }

    

    public void Modifier(service object ,int id) {
        try {
            System.out.println(object.getRef_s_med());
            String req = " UPDATE service_medicaux SET prix_s_med = '"+object.getPrix_s_med()+"', nom_med = '"+object.getNom_med()+"' WHERE ref_s_med='"+id+"'";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CentresMedicauxService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



public ObservableList<service> afficherService() {
           ObservableList<service> listeService=FXCollections.observableArrayList();

        
        try {
            String req="select * from service_medicaux  ";
            ste=connection.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                service f= new service (rs.getInt(1),rs.getString(2),rs.getString(3));

                listeService.add(f);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentresMedicauxService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listeService;

         
        
    }



    
    public boolean Supprimer(int ref_s_med) throws SQLException{
         
      if(Chercher(ref_s_med)){
           System.out.println("exist");
        pre=connection.prepareStatement("delete from pidev.`service_medicaux` where ref_s_med = (?);");
        pre.setInt(1,ref_s_med);
          pre.execute();
    return true;}
        else 
     {System.out.println("nexiste pas");
           return false;}

     }
     public boolean Chercher(int ref_s_med) {
        String req="select * from service_medicaux ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=connection.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
            
                list.add(rs.getInt(1));
             

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(CentresMedicauxService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(ref_s_med);  
    }

    @Override
    public void Modifier(service object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Supprimer(service object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void Chercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<service> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }


    
    
//    @Override
//    public void Chercher() {
//                List<CentresMedicauxService> listT = new ArrayList<>();
//        String req = "SELECT * FROM Service Centres Medicaux";
//        try {
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()){
//                CentresMedicauxService cm = new CentresMedicauxService();
//                cm.setRefService(rs.getInt(1));
//                cm.setCode_cm(rs.getString("code_cm"));
//        
//                listT.add(cm);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CentresMedicauxService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //return listT;
//    }      

//    private void setRefService(int aInt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void setCode_cm(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void Supprimer(service object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void Supprimer(int parseInt, String valueOf) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void Supprimer(int parseInt, Comparator<String> CASE_INSENSITIVE_ORDER) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void Modifier(service object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }




