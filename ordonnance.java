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
public class ordonnance {
   
    private String medicament;
    private int ref_ordonnance;
    private String Date;
    
    public ordonnance (){
    
    }
    public ordonnance (String medicament, int ref_ordonnance, String Date){
       
       
        this.medicament = medicament;
        this.ref_ordonnance = ref_ordonnance;
        this.Date = Date;
    
    
    }

    

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public int getRef_ordonnance() {
        return ref_ordonnance;
    }

    public void setRef_ordonnace(int ref_ordonnance) {
        this.ref_ordonnance = ref_ordonnance;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "ordonnance{" + "medicament=" + medicament + ", ref_ordonnance=" + ref_ordonnance + ", Date=" + Date + '}';
    }

    
    
    
    
}
