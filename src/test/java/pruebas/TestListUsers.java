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
public class TestListUsers {
    
    public static void main(String[] args) {
        
        DaoUsers daoUsers = DaoUsers.getIntanceUsers();
        
        try {
            System.out.println(daoUsers.list());
        } catch (SQLException ex) {
            Logger.getLogger(TestListUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
