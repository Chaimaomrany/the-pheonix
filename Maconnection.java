/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**

/**
 *
 * @author hp
 */
public class Maconnection {
     final static String URL ="jdbc:mysql://127.0.0.1:3306/pidev";
    final static String LOGIN ="root";
    final static String PWD ="";
    static Maconnection instance =null ;
    private Connection cnx ;
    
    private Maconnection(){
    
        try {
            cnx=DriverManager.getConnection(URL,LOGIN,PWD);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            System.out.println("pas de connection");
                   
        }
    
    
    
}
    public static Maconnection getInstance(){
        if(instance==null){
            instance=new Maconnection(); 
        }
        
        return instance;
    }
    
public Connection getConnection(){
    return cnx;
}
    
}
