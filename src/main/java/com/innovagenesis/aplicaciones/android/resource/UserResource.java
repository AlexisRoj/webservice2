/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.resource;

import com.innovagenesis.aplicaciones.android.dao.DaoUsers;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import om.innovagenesis.aplicaciones.android.entidades.Users;


/**
 *
 * @author alexi
 */
@Path("Users")
public class UserResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> get(){
        //Método encargado de listar
        try {
            return DaoUsers.getIntanceUsers().list();
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()
            + "Error al consultar la BD" + ex.getMessage())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post (Users users){
        //Método encargado de insertar
        try {
            DaoUsers.getIntanceUsers().insert(users);
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      @GET
    @Path("{nombreUsuario}/{passUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUsersbyId (@PathParam("nombreUsuario")String nombreUsuario,
            @PathParam("passUsuario")String passUsuario){
        //Método que buscar registros en la base de datos.        
        try {
            return DaoUsers.getIntanceUsers().search(nombreUsuario,passUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("{userName}")
    public Users getUsersbyName (@PathParam("userName")String userName){
        //Metodo utilizado para validar si el usuario existe
        try {
            return DaoUsers.getIntanceUsers().serchUsername(userName);
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }
}
