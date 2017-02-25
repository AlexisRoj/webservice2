/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package om.innovagenesis.aplicaciones.android.entidades;

/**
 * Clase para ingresos de usuarios al sistema
 * @author alexi
 */
public class Users {
    
    
    private int user_id;
    private String user_name;
    private String user_pass;

    public Users() {
    }
  

    public Users(String user_name, String user_pass) {
        //constructor nombre de usuario y contraseña        
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public Users(String user_pass) {
        //Contructor solo para contraseña
        this.user_pass = user_pass;
    }
   
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    @Override
    //Metodo toString
    public String toString() {
        return "Users{" + "user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass + '}'+ "\n\n" ;
    }    
    
    
}
