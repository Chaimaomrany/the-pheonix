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
public class facture {
    private int Reference_facture;
    private String Prix_unitaire;
    private String Quantite;
    private String Somme_prix;
    private String Date;
    private String mail;
    
    
    public facture(){
    }
    
    public facture(String prix_unitaire, String quantite, String somme_prix, String date, String mail){
    this.Prix_unitaire = prix_unitaire;
    this.Quantite = quantite;
    this.Somme_prix = somme_prix;
    this.Date = date;
    this.mail = mail;
     
    }

    public int getReference_facture() {
        return Reference_facture;
    }

    public void setReference_facture(int Reference_facture) {
        this.Reference_facture = Reference_facture;
    }

    public String getPrix_unitaire() {
        return Prix_unitaire;
    }

    public void setPrix_unitaire(String Prix_unitaire) {
        this.Prix_unitaire = Prix_unitaire;
    }

    public String getQuantite() {
        return Quantite;
    }

    public void setQuantite(String quantite) {
        this.Quantite = quantite;
    }

    public String getSomme_prix() {
        return Somme_prix;
    }

    public void setSomme_prix(String Somme_prix) {
        this.Somme_prix = Somme_prix;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date= Date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "facture{" + "Reference_facture=" + Reference_facture + ", Prix_unitaire=" + Prix_unitaire + ", Quantite=" + Quantite + ", Somme_prix=" + Somme_prix + ", Date=" + Date + ", mail=" + mail + '}';
    }

    
    
    
}
