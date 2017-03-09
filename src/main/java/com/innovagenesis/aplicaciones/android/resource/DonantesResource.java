/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.resource;

import com.innovagenesis.aplicaciones.android.dao.DaoDonantes;
import com.innovagenesis.aplicaciones.android.entidades.Donantes;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexi
 */
@Path("Donantes")
public class DonantesResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Donantes> get(){
        //Método encargado de listar los donantes
        try {
            return DaoDonantes.getInstanceDonantes().listDonante();
        } catch (SQLException ex) {
            Logger.getLogger(DonantesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)    
    public void post(Donantes donantes){
        //Método encargado de insertar donantes
        try {
            DaoDonantes.getInstanceDonantes().insertDonante(donantes);
        } catch (SQLException ex) {
            Logger.getLogger(DonantesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @GET
    @Path("{donante_ced}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Donantes> getDonantesbyId(@PathParam("donante_ced")String donante_ced){
        //Método encargado de buscar por id
        try {
            return DaoDonantes.getInstanceDonantes().searchDonanteLike(donante_ced);
        } catch (SQLException ex) {
            Logger.getLogger(DonantesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @DELETE
    @Path("{donante_ced}")
    public void delete(@PathParam("donante_ced")int donante_ced){
        //Método encargado de borrar un donante
        try {
            DaoDonantes.getInstanceDonantes().deleteDonante(donante_ced);
        } catch (SQLException ex) {
            Logger.getLogger(DonantesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @PUT
    @Path("{donante_ced}")
    public void update(@PathParam("donante_ced")int donante_ced, Donantes donantes){
        //Metodo encargado de actualizar un donante
        donantes.setDonante_ced(donante_ced);
        
        try {
            DaoDonantes.getInstanceDonantes().updateDonante(donantes);
        } catch (SQLException ex) {
            Logger.getLogger(DonantesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
