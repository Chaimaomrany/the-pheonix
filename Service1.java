/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;
import Entities.rendezVous;
import java.sql.SQLException;


/**
 *
 * @author houss
 * @param <a>
 */
public interface Service1<a> {
    
    void Ajout(a object);
    void Modif(a object);
    void Supprim(a object);
    List<a> find();
    
}
