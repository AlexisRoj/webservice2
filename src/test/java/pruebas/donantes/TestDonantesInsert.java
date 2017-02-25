/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.donantes;

import com.innovagenesis.aplicaciones.android.dao.DaoDonantes;
import com.innovagenesis.aplicaciones.android.entidades.Donantes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author alexi
 */
public class TestDonantesInsert {
    
    //Pruebas de insertar
    
    public static void main(String[] args) {
        
        DaoDonantes daoDonantes = DaoDonantes.getInstanceDonantes();
        
        Donantes donantes = new Donantes(11021000,"Felicia","Hidalgo",50,"AB+",75,160);
        
        try {
            daoDonantes.insertDonante(donantes);
        } catch (SQLException ex) {
            Logger.getLogger(TestDonantesInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
