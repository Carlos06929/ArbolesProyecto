/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1videoclub1;
import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Director implements Serializable{
    
    private String nombre;
    private String nacionalidad;

    public Director(){
        nombre="";
        nacionalidad="";
    }
    public Director( String nombre, String nacionalidad) {
        
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

  
    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public void vaciar(){
        this.nombre="";
        this.nacionalidad="";
    }

    @Override
    public String toString() {
        String s="";
        s=s+"Nombre: "+nombre+"\nNacionalidad: "+nacionalidad;
        return s;
    }
    
    
    
    
    
    
    
    
    
}
