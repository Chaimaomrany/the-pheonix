/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Iservicescategorie {
     public void Ajoutercategorie(Categorie c) ;
        public List<Categorie> Affichercategorie() throws SQLException;
        public boolean delete(int id) throws SQLException;
        public boolean chercher(int id) throws SQLException;
    
}
