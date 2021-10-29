/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.rendez_vous;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IServiceRDV {
    public void Ajouterrdv(rendez_vous r);
        public List<rendez_vous> Afficherrendez_vous() throws SQLException;
 public boolean delete(int id) throws SQLException;
    public boolean chercher(int id) throws SQLException;
    
}
