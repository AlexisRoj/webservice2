/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexi
 */
public interface IDAOU <T>{
    
    
    void insert(T entidad) throws SQLException;

    void delete(String username) throws SQLException;

    List<T> list() throws SQLException;

    T search(String nombreUsuarioString, String passUsuarioString) throws SQLException;

    T serchUsername(String Username) throws SQLException;

    void update(T entidad) throws SQLException;
    
}
