/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.facture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.myDB;

/**
 *
 * @author Sabrine
 */
public class servicefacture implements service<facture>{
    private Connection cnx;
    private java.sql.Statement ste;
    private PreparedStatement pre;
    private String id;

    public servicefacture() {
        cnx = myDB.getInstance().getConnection();
    }
    public void Ajouterfac(facture r) {
        try {
            //  Statement stm = cnx.createStatement();
            pre = cnx.prepareStatement("INSERT INTO facture (Prix_unitaire, Quantite, Somme_prix, Date, mail) VALUES (?,?,?,?,?)");

            
            pre.setString(1, r.getPrix_unitaire());
            pre.setString(2, r.getQuantite());
            pre.setString(3, r.getSomme_prix());
            pre.setString(4, r.getDate());
             pre.setString(5, r.getMail());

            pre.executeUpdate();
            //  stm.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
   }
    public ObservableList<facture> findAll() {
            ObservableList<facture> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM facture ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                facture sf = new facture();
                sf.setReference_facture(rs.getInt(1));
                sf.setPrix_unitaire(rs.getString(2));
                sf.setQuantite(rs.getString(3));
                sf.setSomme_prix(rs.getString(4));
                sf.setDate(rs.getString(5));
                sf.setMail(rs.getString(6));
                list.add(sf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicerendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    
    
     public ObservableList<facture> Affiche() throws SQLException {

        try {
            String req = "select * from facture ";
            ObservableList<facture> list = FXCollections.observableArrayList();
            list = FXCollections.observableArrayList();
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {

                facture f = new facture();

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
            req ="DELETE FROM facture WHERE `Reference_facture`='"+id+"'";
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
//      return true;}
//       else 
//       {System.out.println("nexiste pas");
//            return false;}
        return true;
    }
    
    
    
}

