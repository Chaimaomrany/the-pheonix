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
public class Categorie {
    private int id_categorie ; 
    private String nom;
    private String description; 
   

public Categorie(){
    
}
  public Categorie(int id_categorie,String nom, String description) {
        this.id_categorie= id_categorie;
        this.nom = nom;
        this.description = description;
  }
  
  public Categorie(int aInt, String string, String string0, int aInt0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public Categorie (String nom , String description){
    this.nom = nom ; 
    this.description = description ; 
}

    public Categorie(String nom) {
        this.nom = nom;
    }



    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
    return this.nom+" "+this.description;}
  
}