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
public class TestSearchUsers {
    
    public static void main(String[] args) {
        
        DaoUsers daoUsers = DaoUsers.getIntanceUsers();
        //Busca un usuario
        try {
            System.out.println(daoUsers.search("Alex", "Chichis"));
        } catch (SQLException ex) {
            Logger.getLogger(TestSearchUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
;
        
        
    }
}
