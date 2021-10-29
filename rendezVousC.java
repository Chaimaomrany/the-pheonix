/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.rendezVous;
import Entities.service;

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
import javax.mail.Message;
import utils.database;

/**
 *
 * @author oussama
 */
public class rendezVousC implements Service1<rendezVous>{


      private Statement ste;
    private PreparedStatement pre;
Connection connection;
public rendezVousC(){
connection= database.getInstance().getConnection();
}
/////////////////////////////////////////AJOUTER/////////////////////////////////////////////

      @Override
 public void Ajout(rendezVous object) {
        try {
            String req = "INSERT INTO rendez_vous_clinique (h_debut,h_fin,date,mail) VALUES('"+object.getH_debut()+"','"+object.getH_fin()+"','"+object.getDate()+"','"+object.getMail()+"')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(rendezVousC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("prblem");
        }
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  
public void Modif(rendezVous object ,int id) {
        try {
            System.out.println(object.getRef_rdv_clin());
            String req = " UPDATE rendez_vous_clinique SET h_debut = '"+object.getH_debut()+"', h_fin = '"+object.getH_fin()+"', date = '"+object.getDate()+"' WHERE ref_rdv_clin='"+id+"'";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(rendezVousC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    ////////////////////////////////////////////////////////////////////////////////////
 public boolean Supprim(int ref_rdv_clin) throws SQLException{
         
      if(Chercher1(ref_rdv_clin)){
           System.out.println("exist");
        pre=connection.prepareStatement("delete from pidev.`rendez_vous_clinique` where ref_rdv_clin = (?);");
        pre.setInt(1,ref_rdv_clin);
          pre.execute();
    return true;}
        else 
     {System.out.println("nexiste pas");
           return false;}

     }
 /////////////////////////////////////////////////////////////////////////////////////
 public boolean Chercher1(int ref_rdv_clin) {
        String req="select * from rendez_vous_clinique ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=connection.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
            
                list.add(rs.getInt(1));
             

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(rendezVousC.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(ref_rdv_clin);  
    }
   /////////////////////////////////////////////////////////////////////////////////////////////
public ObservableList<rendezVous> afficherrdv() {
           ObservableList<rendezVous> listeService=FXCollections.observableArrayList();

        
        try {
            String req="select * from rendez_vous_clinique  ";
            ste=connection.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                rendezVous f;
                f = new rendezVous(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

                listeService.add(f);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(rendezVousC.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listeService;

         
        
    } 
    
    
    
    
    
    
    
    
    
    
    
    

 


    @Override
    public void Supprim(rendezVous object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<rendezVous> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modif(rendezVous object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public ObservableList<?> afficherService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
