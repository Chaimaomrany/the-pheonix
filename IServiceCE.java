/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IServiceCE {
     public void Ajouterservice(Service r);
          public List<Service> Afficherservice() throws SQLException;
 public boolean delete(int ref) throws SQLException;
  public boolean chercher(int ref) throws SQLException;
   
    
}
