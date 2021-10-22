/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author LENOVO
 */
public class Produit {
    private int id_produit;
    private String prix ; 
    private String categorie ; 
    private String nom;

public Produit(){
    
}

    public Produit(String nom, String prix , String categorie) {
        this.prix = prix;
        this.categorie = categorie;
        this.nom = nom;
    }
       public Produit(int id_produit,String nom, String prix , String categorie) {
        this.id_produit= id_produit;
        this.prix = prix;
        this.categorie = categorie;
        this.nom = nom;
    }
 


public Produit (String prix , String categorie){
    this.prix = prix ; 
    this.categorie = categorie ; 
}

    public Produit(int aInt, String string, String string0, int aInt0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getCategorie() {
        return categorie;
    }
    
    
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        return this.nom+" "+this.prix+" "+this.categorie;
    }
  
    
}
