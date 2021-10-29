/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Sabrine
 */
public class consultation_en_ligne {
    private Date date;
    private Date h_debut;
    private Date h_fin;
    private int id_med;
    
    
   public consultation_en_ligne (){
   
   }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getH_debut() {
        return h_debut;
    }

    public void setH_debut(Date h_debut) {
        this.h_debut = h_debut;
    }

    public Date getH_fin() {
        return h_fin;
    }

    public void setH_fin(Date h_fin) {
        this.h_fin = h_fin;
    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }
   
   
    
}
