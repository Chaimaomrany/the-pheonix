/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Sabrine
 */
public class medecin {
    private int id_med;
    private String nom;
    private String prenom;
    private String specialite;
    private String contact;
    
    
    public medecin(){
        
    }
        
 public medecin (String nom, String prenom, String specialite, String contact){
     this.nom = nom;
     this.prenom = prenom;
     this.contact = contact;
     this.specialite= specialite;
}

    public int getId_med() {
        return id_med;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getContact() {
        return contact;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
 
 
 
 
 
 
}