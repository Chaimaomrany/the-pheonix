/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.rendez_vous_medecin;

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
import utils.myDB;

/**
 *
 * @author Sabrine
 */
public class servicerendezvous implements service<rendez_vous_medecin>{

    private Connection cnx;
    private java.sql.Statement ste;
    private PreparedStatement pre;
    private String id;

    public servicerendezvous() {
        cnx = myDB.getInstance().getConnection();
    }

    /**
     *
     * @param r
     */
    public void Ajouterrdv(rendez_vous_medecin r) {
        try {
            //  Statement stm = cnx.createStatement();
            pre = cnx.prepareStatement("INSERT INTO rendez_vous_medecin (h_debut,date) VALUES (?,?)");

            pre.setString(1, r.getH_debut());
            pre.setString(2, r.getDate());

            pre.executeUpdate();
            //  stm.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<rendez_vous_medecin> findAll() {
            ObservableList<rendez_vous_medecin> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM rendez_vous_medecin ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                rendez_vous_medecin RdvMed = new rendez_vous_medecin();
                RdvMed.setRef_rdv_med(rs.getInt(1));
                RdvMed.setH_debut(rs.getString(2));
                RdvMed.setDate(rs.getString(3));
                list.add(RdvMed);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicerendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ObservableList<rendez_vous_medecin> Affiche() throws SQLException {

        try {
            String req = "select * from rendez_vous_medecin ";
            ObservableList<rendez_vous_medecin> list = FXCollections.observableArrayList();
            list = FXCollections.observableArrayList();
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {

                rendez_vous_medecin f = new rendez_vous_medecin();

                list.add(f);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicerendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    /**
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     */
    public boolean delete(int id) throws SQLException {
//        if(chercher(id)){
       
        String req;
            req ="DELETE FROM rendez_vous_medecin WHERE `ref_rdv_med`='"+id+"'";
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
//      return true;}
//       else 
//       {System.out.println("nexiste pas");
//            return false;}
        return true;
    }

    public boolean chercher(int id) throws SQLException {
        String req = "select * from rendez_vous_medecin  ";

        List<Integer> list = new ArrayList<>();

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                // System.out.println("kkkk");
                list.add(rs.getInt(4));
                System.out.println(list);

            }
        } catch (SQLException ex) {
            Logger.getLogger(servicerendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list.contains(id);
    }

    public String getdebutbyId(int id) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from rendez_vous_medecin where id=?");
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
            PreparedStatement st = cnx.prepareStatement("select * from rendez_vous_medecin where id=?");
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
            PreparedStatement st = cnx.prepareStatement("select * from rendez_vous_medecin where id=?");
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

    public void Modifierrendez_vous(rendez_vous_medecin f) throws NoSuchAlgorithmException {
        PreparedStatement pre;
        try {
            String req = "UPDATE rendez_vous_medecin SET h_debut =?,date =?";
            pre = cnx.prepareStatement(req);

            //pre.setInt(6, id);
            pre.setString(1, f.getH_debut());
            pre.setString(2, f.getDate());

            pre.executeUpdate();
            pre.executeUpdate();

            System.out.println("Modification avec success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    public List Affiche() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//       
}
