/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.rendez_vous_medecin;
import java.sql.SQLException;
import services.servicerendezvous;
import utils.myDB;

/**
 *
 * @author Sabrine
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException  {
        // TODO code application logic here
        myDB.getInstance().getConnection();
        servicerendezvous s=new servicerendezvous();
//        rendez_vous_medecin rd=new rendez_vous_medecin("jhg","lijulk");
        s.delete(1);
    }
    
}
