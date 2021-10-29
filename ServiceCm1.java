/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.rendezVous;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oussama
 * @param <HO>
 */
public interface ServiceCm1<HO> {
        void Ajouter(HO object);
    void Modifier(HO object);
    public boolean Supprimer(int ref_rdv_clin) throws SQLException;
    public List<rendezVous> Afficherrdv() throws SQLException;
    public boolean Chercher1(int ref_rdv_clin);
    
}
