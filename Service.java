/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author houss
 * @param <o>
 */
public interface Service<o> {
    
    void Ajouter(o object);
    void Modifier(o object);
    void Supprimer(o object);
    List<o> findAll();
    
}
