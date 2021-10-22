/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Iservicesproduit {
        public void Ajouterproduit(Produit p) ;
        public List<Produit> Afficherproduit() throws SQLException;
        public boolean delete(int id) throws SQLException;
        public boolean chercher(int id) throws SQLException;


    
}
