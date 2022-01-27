/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IArbolBusqueda<K extends Comparable<K>,V> {
    void vaciar();
    boolean esArbolVacio();
    int size();
    int altura();
    int nivel();
    K minimo();
    K maximo();
    void insertar(K clave,V valor);
    V eliminar(K clave);
    boolean contiene(K clave);
    V buscar(K clave);
    List<V> llenarListaValores(List<K> listaClaves);
    List<K> recorridoInorden();
    List<K> recorridoPreOrden();
    List<K> recorridoPosOrden();
    List<K> recorridoPorNiveles();
}
