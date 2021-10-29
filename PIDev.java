/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.rendezVous;
import Entities.service;
import Services.CentresMedicauxService;
import Services.rendezVousC;
import java.sql.SQLException;

import utils.database;

/**
 *
 * @author oussama
 */
public class PIDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        database.getInstance();
       database db1= database.getInstance();
       
   //CentresMedicaux cm = new CentresMedicaux("ouss","azezaezae",2035662,"zaeca","azezae");
//        service c =new service("12dt","oussama");
//        CentresMedicauxService cs =new CentresMedicauxService();
//        cs.Ajouter(c); 
        //cs.Modifier(c);
        //cs.Supprimer(1);
        ////////////////////////////////////////////////////////////////////////
        //rendezVous a =new rendezVous("11:22h","12:20h", "12/12/2020");
         rendezVous a =new rendezVous(1,"12h", "18h", "azeaze","11zaeaze");
        rendezVousC az =new rendezVousC() ;
       
        
        az.Ajout(a); 
        //az.Modif(a,1);
        //az.Supprim(1);
        
    }}

 
    
    
