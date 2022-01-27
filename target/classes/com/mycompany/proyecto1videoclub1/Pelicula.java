/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1videoclub1;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author hp
 */
public class Pelicula implements Serializable {
    
    private String titulo;
    private int  estreno;
    private String idioma;
    private String sinopsis;
    List<Director> directores=new LinkedList<>();
    private String duracion;
    private int copias;
    private String genero;
    

    public Pelicula() {
        this.titulo = "";
        this.estreno =0;
        this.idioma ="";
        this.sinopsis ="";
        this.duracion ="";
        this.copias =0;
        this.genero="";
        directores=null;
        
    }

    public Pelicula(String titulo, int estreno, String idioma, String sinopsis, String duracion, int copias, String genero) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.idioma = idioma;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.copias = copias;
        this.genero=genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

   
    @Override
    public String toString() {
        String s="";
        s=s+"TITULO: "+titulo+"\n"+"ESTRENO: "+estreno+"\n"+"IDIOMA: "+ idioma+"\n"+"SINOPSIS: "+sinopsis
                +"\n"+"DURACION: "+ duracion+"\n"+"COPIAS : "+ copias+"\n"+"DIRECTORES: ";
        for(int i=0;i<directores.size();i++){
            s=s+directores.get(i).toString()+"\n";
        }
        return s;
    }

   
    
    
    
    
}
