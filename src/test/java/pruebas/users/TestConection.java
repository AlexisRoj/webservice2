/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.innovagenesis.aplicaciones.android.dao.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class TestConection {
    
    public static void main(String[] args) {
        
        try {
            if(Conexion.getIntance().existeConexion()){
                System.out.println("Conexion Establecida");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al realizar la conexion");
        }
    }
    
}
