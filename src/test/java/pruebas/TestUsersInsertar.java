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
import om.innovagenesis.aplicaciones.android.entidades.Users;

/**
 *
 * @author alexi
 */
public class TestUsersInsertar {
    
    public static void main(String[] args) {
        
        DaoUsers daoUsers = DaoUsers.getIntanceUsers();
        
        try {
            daoUsers.insert(new Users("Chino","1234"));
        } catch (SQLException ex) {
            Logger.getLogger(TestUsersInsertar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
