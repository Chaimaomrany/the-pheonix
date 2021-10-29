/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Sabrine
 */
public class rendez_vous_medecin {
   
    private int ref_rdv_med;
    private String date;
    private String h_debut;
   
  

   

    
     
    public rendez_vous_medecin (){
    }

    public rendez_vous_medecin(String jhg, String lijulk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

   

    public int getRef_rdv_med() {
        return ref_rdv_med;
    }

    public void setRef_rdv_med(int ref_rdv_med) {
        this.ref_rdv_med = ref_rdv_med;
    }
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getH_debut() {
        return h_debut;
    }

    public void setH_debut(String h_debut) {
        this.h_debut = h_debut;
    }

    public rendez_vous_medecin(int ref_rdv_med, String date, String h_debut) {
        this.ref_rdv_med = ref_rdv_med;
        this.date = date;
        this.h_debut = h_debut;
    }

    @Override
    public String toString() {
        return "rendez_vous_medecin{" + "ref_rdv_med=" + ref_rdv_med + ", date=" + date + ", h_debut=" + h_debut + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.ref_rdv_med;
        hash = 83 * hash + Objects.hashCode(this.date);
        hash = 83 * hash + Objects.hashCode(this.h_debut);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final rendez_vous_medecin other = (rendez_vous_medecin) obj;
        if (this.ref_rdv_med != other.ref_rdv_med) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.h_debut, other.h_debut)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    

 

    

   

   
    
    
    
}
