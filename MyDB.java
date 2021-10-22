/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class MyDB {
       final static String URL ="jdbc:mysql://127.0.0.1:3306/pidev";
    final static String LOGIN ="root";
    final static String PWD ="";
    static MyDB instance =null ;
    private Connection cnx ;
    
    
        private MyDB(){
    
        try {
            cnx=DriverManager.getConnection(URL,LOGIN,PWD);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            System.out.println("pas de connection");
                   
        }
    
    
    
}
    public static MyDB getInstance(){
        if(instance==null){
            instance=new MyDB(); 
        }
        
        return instance;
    }
    
public Connection getConnection(){
    return cnx;
}
}
