/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.dao;

import com.innovagenesis.aplicaciones.android.entidades.Donantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexi
 */
public class DaoDonantes implements IDAOD<Donantes>{
    
    PreparedStatement insertDonante;
    PreparedStatement deleteDonante;
    PreparedStatement listDonantes;
    PreparedStatement searchDonantes;
    PreparedStatement updateDonante;
    String query;
    
    private static DaoDonantes instanceDonantes;

        public DaoDonantes() {
        //Constructor vacio
    }

    public Donantes load(ResultSet set) throws SQLException {
        // Carga el resultado de la consulta
        Donantes donantes = new Donantes();

        donantes.setDonante_ced(set.getInt("donante_ced"));
        donantes.setDonante_nombre(set.getString("donante_nombre"));
        donantes.setDonante_apellido(set.getString("donante_apellido"));
        donantes.setDonante_edad(set.getInt("donante_edad"));
        donantes.setDonante_tipo_sangre(set.getString("donante_tipo_sangre"));
        donantes.setDonante_peso(set.getInt("donante_peso"));
        donantes.setDonante_estatura(set.getInt("donante_estatura"));

        return donantes;

    }

    public static DaoDonantes getInstanceDonantes() {
        //Clase singleton
        if (instanceDonantes == null) {
            instanceDonantes = new DaoDonantes();
        }
        return instanceDonantes;
    }

    @Override
    public void insertDonante(Donantes entidad) throws SQLException {
        //Método encargado de realizar las inserciones en donante
        query = "INSERT INTO TBL_DONANTES "
                + "(DONANTE_CED ,"
                + "DONANTE_NOMBRE,"
                + "DONANTE_APELLIDO,"
                + "DONANTE_EDAD,"
                + "DONANTE_TIPO_SANGRE,"
                + "DONANTE_PESO,"
                + "DONANTE_ESTATURA)"
                + "VALUES "
                + "(?,?,?,?,?,?,?)";

        if (insertDonante == null) {
            insertDonante = Conexion.getIntance().getCon().prepareStatement(query);
        }

        insertDonante.setInt(1, entidad.getDonante_ced());
        insertDonante.setString(2, entidad.getDonante_nombre());
        insertDonante.setString(3, entidad.getDonante_apellido());
        insertDonante.setInt(4, entidad.getDonante_edad());
        insertDonante.setString(5, entidad.getDonante_tipo_sangre());
        insertDonante.setInt(6, entidad.getDonante_peso());
        insertDonante.setInt(7, entidad.getDonante_estatura());
        insertDonante.executeUpdate();
    }

    @Override
    public void deleteDonante(int donante_ced) throws SQLException {
        //Método encargado de borrar un donante
        query = "DELETE FROM TBL_DONANTES WHERE DONANTE_CED = ?";

        if (deleteDonante == null) {
            deleteDonante = Conexion.getIntance().getCon().prepareStatement(query);
        }
        deleteDonante.setInt(1, donante_ced);
        deleteDonante.execute();
    }

    @Override
    public List<Donantes> listDonante() throws SQLException {
        //Encargado de recorrer toda la lista
        query = "SELECT * FROM TBL_DONANTES";

        if (listDonantes == null) {
            listDonantes = Conexion.getIntance().getCon().prepareStatement(query);
        }
        ResultSet set = listDonantes.executeQuery();
        ArrayList<Donantes> resultDonantes;
        resultDonantes = new ArrayList<>();

        while (set.next()) {
            //Recorre la base de datos
            resultDonantes.add(load(set));
        }
        return resultDonantes;
    }

    @Override
    public void updateDonante(Donantes entidad) throws SQLException {
        //Método encargado de realizar el update de los datos
        query = "UPDATE TBL_DONANTES SET "
                + "DONANTE_NOMBRE = ?,"
                + "DONANTE_APELLIDO = ?,"
                + "DONANTE_EDAD = ?,"
                + "DONANTE_TIPO_SANGRE = ?,"
                + "DONANTE_PESO = ?,"
                + "DONANTE_ESTATURA = ?"
                + " WHERE DONANTE_CED = ?";
        
        if (updateDonante == null) {
            updateDonante = Conexion.getIntance().getCon().prepareStatement(query);            
        }
        
        updateDonante.setString(1, entidad.getDonante_nombre());
        updateDonante.setString(2, entidad.getDonante_apellido());
        updateDonante.setInt(3, entidad.getDonante_edad());
        updateDonante.setString(4, entidad.getDonante_tipo_sangre());
        updateDonante.setInt(5, entidad.getDonante_peso());
        updateDonante.setInt(6, entidad.getDonante_estatura());
        updateDonante.setInt(7, entidad.getDonante_ced());
        updateDonante.executeUpdate();
    }

    @Override
    public Donantes searchUsercedDonante(int donante_ced) throws SQLException {
        //Método encargado de realizar la consulta por numero de cedula
        query = "SELECT * FROM TBL_DONANTES WHERE DONANTE_CED = ?";

        if (searchDonantes == null) {
            searchDonantes = Conexion.getIntance().getCon().prepareStatement(query);
        }

        searchDonantes.setInt(1, donante_ced);
        ResultSet set = searchDonantes.executeQuery();

        return set != null && set.next() ? load(set) : null;

    }
      
    
}
