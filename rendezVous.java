/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.mail.Message;

/**
 *
 * @author hp
 */
public class rendezVous {

    public static void send(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int ref_rdv_clin;
    private String h_debut;
    private String h_fin;
    private String date;
    private String mail;
    
 
    
    public rendezVous(){
    }
    public rendezVous(int ref_rdv_clin, String h_debut,String h_fin,String date,String mail){
    this.ref_rdv_clin=ref_rdv_clin;
    this.h_debut=h_debut;
    this.h_fin=h_fin;
    this.date=date;
    this.mail=mail;
}

    public rendezVous(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public String getH_debut() {
        return h_debut;
    }

    public void setH_debut(String h_debut) {
        this.h_debut = h_debut;
    }

    public String getH_fin() {
        return h_fin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setH_fin(String h_fin) {
        this.h_fin = h_fin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRef_rdv_clin() {
        return ref_rdv_clin;
    }

    public void setRef_rdv_clin(int ref_rdv_clin) {
        this.ref_rdv_clin = ref_rdv_clin;
    }
    
    
    
    
}