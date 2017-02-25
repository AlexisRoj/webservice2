/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.innovagenesis.aplicaciones.android.dao.DaoUsers;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class TestDeleteUsers {
    
    public static void main(String[] args) {
        //Método encargado de borrar usuarios
        DaoUsers daoUsers = DaoUsers.getIntanceUsers();
        
        try {
            daoUsers.delete("Chino");
            System.out.println("Usuario Borrado");
        } catch (SQLException ex) {
            Logger.getLogger(TestDeleteUsers.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Borrando");
        }
    }
    
   
    
}
