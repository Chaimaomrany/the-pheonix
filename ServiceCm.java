/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.service;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oussama
 * @param <HO>
 */
public interface ServiceCm<HO> {
        void Ajouter(HO object);
    void Modifier(HO object);
    public boolean Supprimer(int ref_s_med) throws SQLException;
    public List<service> Afficherservice() throws SQLException;
    public boolean Chercher(int ref_s_med);
    
}
