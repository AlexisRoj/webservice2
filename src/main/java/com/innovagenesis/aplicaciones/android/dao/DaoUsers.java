/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.innovagenesis.aplicaciones.android.entidades.Users;

/**
 *
 * @author alexi
 */
public class DaoUsers implements IDAOU<Users>{

    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement search;
    private PreparedStatement list;
    private PreparedStatement serchUsername;
    private String query;

    private static DaoUsers instancieUsers;

    private DaoUsers() {
    }

    public static DaoUsers getIntanceUsers() {
        //Clase Singleton
        if (instancieUsers == null) {
            instancieUsers = new DaoUsers();
        }
        return instancieUsers;
    }

    @Override
    public void insert(Users entidad) throws SQLException {

        //Método encargado de agregar registros a la base de datos      
        query = "INSERT INTO TBL_USERS(USER_NAME,USER_PASS) VALUES (?,?)";
        if (insert == null) {
            insert = Conexion.getIntance().getCon().prepareStatement(query);
        }
        insert.setString(1, entidad.getUser_name());
        insert.setString(2, entidad.getUser_pass());
        insert.executeUpdate();

    }

    @Override
    public void delete(String username) throws SQLException {

        //Método encargado de eliminar registros
        query = "DELETE FROM TBL_USERS WHERE USER_NAME = ?";

        if (delete == null) {
            delete = Conexion.getIntance().getCon().prepareStatement(query);
        }

        delete.setString(1, username);
        delete.execute();
    }

    @Override
    public List<Users> list() throws SQLException {

        //Método encargado de listar todos los elementos de la BD        
        query = "SELECT * FROM TBL_USERS";

        if (list == null) {
            list = Conexion.getIntance().getCon().prepareStatement(query);
        }

        ResultSet set = list.executeQuery();
        ArrayList<Users> resultUserses;
        resultUserses = new ArrayList<>();

        while (set.next()) {
            //Recorre la base de datos
            resultUserses.add(load(set));
        }
        return resultUserses;
    }

    @Override
    public Users search(String nombreUsuarioString, String passUsuarioString)
            throws SQLException {

        //Metodo encargado de realizar la busqueda
        query = "SELECT * FROM TBL_USERS "
                + "WHERE USER_NAME = ?"
                + "AND USER_PASS = ?";

        if (search == null) {
            search = Conexion.getIntance().getCon().prepareStatement(query);
        }

        search.setString(1, nombreUsuarioString);
        search.setString(2, passUsuarioString);
        ResultSet set = search.executeQuery();

        return set != null && set.next() ? load(set) : null;
    }
    
    @Override
    public Users serchUsername (String username) throws SQLException{
        
       //Metodo encargado de realizar la busqueda del usuario
        query = "SELECT * FROM TBL_USERS "
                + "WHERE USER_NAME = ?";
        
        if (serchUsername == null) {
            serchUsername = Conexion.getIntance().getCon().prepareStatement(query);            
        }
        
        serchUsername.setString(1, username);
        ResultSet set = serchUsername.executeQuery();
        
        return set != null && set.next() ? load(set) : null;
    }   

     
    @Override
    public void update(Users entidad) throws SQLException {

        //Actualiza la contraseña
        query = "UPDATE TBL_USERS SET USER_PASS = ? WHERE USER_NAME = ?";

        if (update == null) {
            update = Conexion.getIntance().getCon().prepareStatement(query);
        }

        // el primer valor corresponde al parametro del query que corresponde
        update.setString(1, entidad.getUser_pass());
        update.setString(2, entidad.getUser_name());

        update.executeUpdate();
    }

    public Users load(ResultSet set) throws SQLException {
        //Carga el resultado de la consulta
        Users users = new Users();

        users.setUser_id(set.getInt("user_id"));
        users.setUser_name(set.getString("user_name"));
        users.setUser_pass(set.getString("user_pass"));

        return users;
    } 
    
}
