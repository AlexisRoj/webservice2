/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class Conexion {
    
    private Connection connection; // Conexion a la base de datos
    private final String driver = "com.mysql.cj.jdbc.Driver"; // Drivers conexion
    private final String user = "admin_examen";
    private final String pass = "Admin123+";
    private final String urlDataBase = "jdbc:mysql://localhost:3306/db_examen_siete?serverTimezone=UTC"
            + "&autoReconnect=true&useSSL=false";
    
    private static Conexion conexion;

    private Conexion() {
    }
    
    public static Conexion getIntance () throws SQLException{
        if (conexion == null){
            //
            conexion = new Conexion();
        }
        conexion.conectar();
        return conexion;
    }
    
    private void conectar () throws SQLException{
        if (connection == null || connection.isClosed()) {
             try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Connecion a la base de datos
            connection = DriverManager.getConnection(urlDataBase,user,pass);
        }
    }
    
    public boolean existeConexion() throws SQLException{
        // Valida la conexion al sistema    
        return connection != null && !connection.isClosed();
    }    
    
    public Connection getCon() {
        // trae la conexion
        return connection;
    }
    
}
