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
 * @author Sabrine
 */
public class myDB {
    final static String URL ="jdbc:mysql://localhost:3306/pidev";
    final static String LOGIN ="root";
    final static String PWD ="";
    static myDB instance =null ;
    private Connection cnx ;
    
    
        private myDB(){
    
        try {
            cnx=DriverManager.getConnection(URL,LOGIN,PWD);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                   
        }
    
    
    
}
    public static myDB getInstance(){
        if(instance==null){
            instance=new myDB(); 
        }
        
        return instance;
    }
    
public Connection getConnection(){
    return cnx;
}
}
    

