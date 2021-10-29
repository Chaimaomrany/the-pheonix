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
 * @author houss
 */
public class database {
    private final String url = "jdbc:mysql://localhost:3306/pidev";
    private final String user = "root";
    private final String pwd = "";
    private Connection connection;
    private static database instance;
    
    public database(Connection connection) {
        this.connection = connection;
    }
    
    
    
    private database(){
        try {
            connection=DriverManager.getConnection(url,user,pwd);
            System.out.println("Connexion établie");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static database getInstance(){
        if (instance == null){
            instance = new database();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
    
