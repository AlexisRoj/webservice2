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
import com.innovagenesis.aplicaciones.android.entidades.Users;

/**
 *
 * @author alexi
 */
public class TestDaoUpdate {

    public static void main(String[] args) {

        DaoUsers daoUsers = DaoUsers.getIntanceUsers();
        //Actualiza los registros
        try {
            
            Users users = new Users("Alex","Chichis");          

            daoUsers.update(users);
        } catch (SQLException ex) {
            Logger.getLogger(TestDaoUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
