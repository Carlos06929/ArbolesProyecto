/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;
import java.io.Serializable;
/**
 *
 * @author Usuario
 */
public class NodoBinario<K,V> implements Serializable{
    private K clave;
    private V valor;
    private NodoBinario<K,V> hijoIzquierdo;
    private NodoBinario<K,V> hijoDerecho;
    
    public NodoBinario(){
    }
    public NodoBinario(K clave, V valor){
        this.clave=clave;
        this.valor=valor;
    }
    public K getClave(){
    return clave;
    }
    public V getValor(){
    return valor;
    }
    public NodoBinario<K,V> getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    public NodoBinario<K,V> getHijoDerecho(){
        return hijoDerecho;
    }
    public void setClave(K clave){
        this.clave=clave;
    }
    public void setValor(V valor){
        this.valor=valor;
    }
    public void setHijoIzquierdo(NodoBinario<K,V> hijoIzquierdo){
        this.hijoIzquierdo=hijoIzquierdo;
    }
    public void setHijoDerecho(NodoBinario<K,V> hijoDerecho){
        this.hijoDerecho=hijoDerecho;
    }
    public boolean esVacioHijoIzquierdo(){
        return esNodoVacio(this.getHijoIzquierdo());
    }
    public boolean esVacioHijoDerecho(){
        return esNodoVacio(this.getHijoDerecho());
    }
    public boolean esHoja(){
        return esVacioHijoIzquierdo() && esVacioHijoDerecho();
    }
    public boolean nodoCompleto(){
        return !esVacioHijoIzquierdo() && !esVacioHijoDerecho();
    }
    public static boolean esNodoVacio(NodoBinario nodo){
        return nodo==nodoVacio();
    }
    public static NodoBinario<?,?> nodoVacio(){
    return null;
    }
}
