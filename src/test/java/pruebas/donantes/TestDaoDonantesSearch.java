/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.donantes;

import com.innovagenesis.aplicaciones.android.dao.DaoDonantes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class TestDaoDonantesSearch {
    
    public static void main(String[] args) {
        //Realiza prueba de busqueda por cedula
        DaoDonantes daoDonantes = DaoDonantes.getInstanceDonantes();
        
        try {
            System.out.println(daoDonantes.searchDonanteLike("2"));
        } catch (SQLException ex) {
            Logger.getLogger(TestDaoDonantesSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
