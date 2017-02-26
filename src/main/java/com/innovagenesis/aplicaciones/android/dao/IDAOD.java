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
public interface IDAOD<T> {
    
    void insertDonante(T entidad) throws SQLException;

    void deleteDonante(int donanante_ced) throws SQLException;

    List<T> listDonante() throws SQLException;

    T searchUsercedDonante(int donante_ced) throws SQLException;

    void updateDonante(T entidad) throws SQLException;

    
}
