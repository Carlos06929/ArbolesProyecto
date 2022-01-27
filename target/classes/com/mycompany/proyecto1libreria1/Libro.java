/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1libreria1;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author hp
 */
public class Libro implements Serializable {
    
    private String titulo;
    private String  edicion;
    private String idioma;
    private String descripcion;
    List<Autor>autores=new LinkedList<>();
    private int nPaginas;
    private int ejemplar;
    

    public Libro() {
        this.titulo = "";
        this.edicion ="";
        this.idioma ="";
        this.descripcion ="";
        this.nPaginas =0;
        this.ejemplar =0;
        autores=null;
    }
    
    public Libro(String titulo, String edicion, String idioma, String descripcion, int nPaginas, int ejemplar,List<Autor>lista) {
        this.titulo = titulo;
        this.edicion = edicion;
        this.idioma = idioma;
        this.descripcion = descripcion;
        this.nPaginas = nPaginas;
        this.ejemplar = ejemplar;
        for(int i=0;i<lista.size();i++){
            autores.add(lista.get(i));
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Autor> getAutores() {
       
        return autores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAutores(List<Autor> autores) {
        
        this.autores=autores;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public void setEjemplar(int ejemplar) {
        this.ejemplar = ejemplar;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public int getEjemplar() {
        return ejemplar;
    }

    @Override
    public String toString() {
        String s="";
        s=s+"TITULO: "+titulo+"\n"+"EDICION: "+edicion+"\n"+"IDIOMA: "+ idioma+"\n"+"DESCRIPCION: "+descripcion
                +"\n"+"Nº PAGINAS: "+ nPaginas+"\n"+"EJEMPLARES : "+ ejemplar+"\n"+"AUTORES: ";
        for(int i=0;i<autores.size();i++){
            s=s+autores.get(i).toString()+"\n";
        }
        return s;
    }

   
    
    
    
    
}
