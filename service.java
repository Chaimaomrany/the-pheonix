/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author oussama
 */
public class service {
    private int ref_s_med;
    private String prix_s_med;
    private String nom_med;
    
    public service(){

}
    
public service(String prix_s_med,String nom_med){
    
   
}

    public service(int ref_s_med, String prix_s_med, String nom_med) {
        this.ref_s_med = ref_s_med;
        this.prix_s_med=prix_s_med;
        this.nom_med=nom_med;
    }

 

    public int getRef_s_med() {
        return ref_s_med;
    }

    public void setRef_s_med(int ref_s_med) {
        this.ref_s_med = ref_s_med;
    }

    public String getPrix_s_med() {
        return prix_s_med;
    }

    public void setPrix_s_med(String prix_s_med) {
        this.prix_s_med = prix_s_med;
    }

    public String getNom_med() {
        return nom_med;
    }

    public void setNom_med(String nom_med) {
        this.nom_med = nom_med;
    }

    public void delete(int ref_s_med) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Supprimer(int ref_s_med) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
}
