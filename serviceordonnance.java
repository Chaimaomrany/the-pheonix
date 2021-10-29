/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ordonnance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.myDB;

/**
 *
 * @author Sabrine
 */
public class serviceordonnance implements service<ordonnance>{

    private Connection cnx;
    private java.sql.Statement ste;
    private PreparedStatement pre;
    private String id;

    public serviceordonnance() {
        cnx = myDB.getInstance().getConnection();
    }
public void Ajouterord(ordonnance r) {
        try {
            //  Statement stm = cnx.createStatement();
            pre = cnx.prepareStatement("INSERT INTO ordonnance (medicament,Date) VALUES (?,?)");

            pre.setString(1, r.getMedicament());
            pre.setString(2, r.getDate());

            pre.executeUpdate();
            //  stm.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 public ObservableList<ordonnance> findAll() {
            ObservableList<ordonnance> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM rendez_vous_medecin ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                ordonnance or= new ordonnance();
                or.setRef_ordonnace(rs.getInt(1));
                or.setMedicament(rs.getString(2));
                or.setDate(rs.getString(3));
                list.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicerendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
  public ObservableList<ordonnance> Affiche() throws SQLException {

        try {
            String req = "select * from rendez_vous_medecin ";
            ObservableList<ordonnance> list = FXCollections.observableArrayList();
            list = FXCollections.observableArrayList();
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {

               ordonnance f = new ordonnance();

                list.add(f);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicerendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

  public boolean delete(int id) throws SQLException {
//        if(chercher(id)){
       
        String req;
            req ="DELETE FROM ordonnance WHERE `ref_ordonnance`='"+id+"'";
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
//      return true;}
//       else 
//       {System.out.println("nexiste pas");
//            return false;}
        return true;
    }
    
}

 
