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
        //Método encargado de listar
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
    @Path("{donantes_ced}")
    @Produces(MediaType.APPLICATION_JSON)
    public Donantes getDonantesbyId(@PathParam("donantes_ced")int donantes_ced){
        //Método encargado de buscar por id
        try {
            return DaoDonantes.getInstanceDonantes().searchUsercedDonante(donantes_ced);
        } catch (SQLException ex) {
            Logger.getLogger(DonantesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
