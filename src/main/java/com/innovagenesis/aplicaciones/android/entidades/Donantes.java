/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.aplicaciones.android.entidades;

/**
 *Atrapa los datos de donantes
 * @author alexi
 */
public class Donantes {
    
    private int donante_ced;
    private String donante_nombre;
    private String donante_apellido;
    private int donante_edad;
    private String donante_tipo_sangre;
    private int donante_peso;
    private int donante_estatura;

    public Donantes() {
    }

    public Donantes(int donante_ced, String donante_nombre, 
            String donante_apellido, int donante_edad, 
            String donante_tipo_sangre, int donante_peso, 
            int donante_estatura) {
        //Constructor para prueba de update/insert        
        this.donante_ced = donante_ced;
        this.donante_nombre = donante_nombre;
        this.donante_apellido = donante_apellido;
        this.donante_edad = donante_edad;
        this.donante_tipo_sangre = donante_tipo_sangre;
        this.donante_peso = donante_peso;
        this.donante_estatura = donante_estatura;
    }

    public Donantes(String donante_nombre, 
            //Constructor para update
            String donante_apellido, 
            int donante_edad, 
            String donante_tipo_sangre, 
            int donante_peso, 
            int donante_estatura) {
        this.donante_nombre = donante_nombre;
        this.donante_apellido = donante_apellido;
        this.donante_edad = donante_edad;
        this.donante_tipo_sangre = donante_tipo_sangre;
        this.donante_peso = donante_peso;
        this.donante_estatura = donante_estatura;
    }
    
    
    
    public int getDonante_ced() {
        return donante_ced;
    }

    public void setDonante_ced(int donante_ced) {
        this.donante_ced = donante_ced;
    }

    public String getDonante_nombre() {
        return donante_nombre;
    }

    public void setDonante_nombre(String donante_nombre) {
        this.donante_nombre = donante_nombre;
    }

    public String getDonante_apellido() {
        return donante_apellido;
    }

    public void setDonante_apellido(String donante_apellido) {
        this.donante_apellido = donante_apellido;
    }

    public int getDonante_edad() {
        return donante_edad;
    }

    public void setDonante_edad(int donante_edad) {
        this.donante_edad = donante_edad;
    }

    public String getDonante_tipo_sangre() {
        return donante_tipo_sangre;
    }

    public void setDonante_tipo_sangre(String donante_tipo_sangre) {
        this.donante_tipo_sangre = donante_tipo_sangre;
    }

    public int getDonante_peso() {
        return donante_peso;
    }

    public void setDonante_peso(int donante_peso) {
        this.donante_peso = donante_peso;
    }

    public int getDonante_estatura() {
        return donante_estatura;
    }

    public void setDonante_estatura(int donante_estatura) {
        this.donante_estatura = donante_estatura;
    }  

    @Override
    public String toString() {
        return "Donantes{" + "donante_ced=" + donante_ced + ", donante_nombre=" 
                + donante_nombre + ", donante_apellido=" + donante_apellido + 
                ", donante_edad=" + donante_edad + ", donante_tipo_sangre=" + 
                donante_tipo_sangre + ", donante_peso=" + donante_peso + 
                ", donante_estatura=" + donante_estatura + '}'+"\n\n";
    }
     
    
}
