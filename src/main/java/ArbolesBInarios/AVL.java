/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;

/**
 *
 * @author Usuario
 */
public class AVL<K extends Comparable<K>,V> extends ArbolBinarioBusqueda<K, V> {
    
        private static final byte DIFERENCIA_MAXIMA=1;
    
    @Override
    public void insertar(K clave, V valor) {
         if (clave==null) {
            throw new IllegalArgumentException("clave no puede ser nula");
        }
        if (valor==null) {
            throw new IllegalArgumentException("valor no puede ser cero");
        }
        raiz=insertar(raiz,clave,valor);
    }
    
    private NodoBinario<K,V> insertar(NodoBinario<K,V> nodoactual,K clave, V valor){
        if (NodoBinario.esNodoVacio(nodoactual)) {
            NodoBinario<K,V> nuevonodo=new NodoBinario<>(clave,valor);
            return nuevonodo;
        }
        
        K clavecatual=nodoactual.getClave();
        if (clave.compareTo(clavecatual)>0) {
            NodoBinario<K,V> supuestonuevohijoderecho=insertar(nodoactual.getHijoDerecho(), clave, valor);
            nodoactual.setHijoDerecho(supuestonuevohijoderecho);
            return balancear(nodoactual);
        }
        
        if (clave.compareTo(clavecatual)<0) {
            NodoBinario<K,V> supuestohijoizquierdo=
                    insertar(nodoactual.getHijoIzquierdo(), clave, valor);
            nodoactual.setHijoIzquierdo(supuestohijoizquierdo);
            return balancear(nodoactual);
        }
         nodoactual.setValor(valor);
         return nodoactual;
        }
    
        @Override
     protected NodoBinario<K,V> eliminar(NodoBinario<K,V> nodoactual,K claveEliminar){
        if (nodoactual==null) {
            throw new IllegalArgumentException("el nodo esta vacio");
        }
        //aqui recorre el arbol hasta pillar el nodo donde esta la clave a eliminar
        //hay supuesto hijos por que cuando va un nodo puede que vuelva nodo vacio nomasia
        K claveactual=nodoactual.getClave();
        if (claveEliminar.compareTo(claveactual)>0) {
                NodoBinario<K,V> supuestoNuevoHijoDerecho=eliminar(nodoactual.getHijoDerecho(), claveEliminar);
                nodoactual.setHijoDerecho(supuestoNuevoHijoDerecho);
                return balancear(nodoactual);
        }
        if (claveEliminar.compareTo(claveactual)<0) {
            NodoBinario<K,V> supuestoNuevoHijoIzquierdo=eliminar(nodoactual.getHijoIzquierdo(), claveEliminar);
            nodoactual.setHijoIzquierdo(supuestoNuevoHijoIzquierdo);
            return balancear(nodoactual);
        }
        
        //ya enocntrado el nodo
        //se observa que tipo de caso es
        //  CASO 1
        if (nodoactual.esHoja()) {
            return (NodoBinario<K,V>)NodoBinario.nodoVacio();//nodo
        }
        //CASO 2
        
        if (nodoactual.esVacioHijoIzquierdo() && !nodoactual.esVacioHijoDerecho()) {
            return nodoactual.getHijoDerecho();
        }
        if (!nodoactual.esVacioHijoIzquierdo() && nodoactual.esVacioHijoDerecho()) {
            return nodoactual.getHijoIzquierdo();
        }
        
        //CASO 3
        NodoBinario<K,V> nodoReemplazo=buscarSucesor(nodoactual.getHijoDerecho());
        
        NodoBinario<K,V> posibleNuevoHijo=eliminar(nodoactual.getHijoDerecho(),nodoReemplazo.getClave());
        nodoactual.setHijoDerecho(posibleNuevoHijo);
        
        nodoReemplazo.setHijoDerecho(nodoactual.getHijoDerecho());
        nodoReemplazo.setHijoIzquierdo(nodoactual.getHijoIzquierdo());
        
        nodoactual.setHijoDerecho((NodoBinario<K,V>)NodoBinario.nodoVacio());
        nodoactual.setHijoIzquierdo((NodoBinario<K,V>)NodoBinario.nodoVacio());
        
        return nodoReemplazo;
    }
    
    private NodoBinario<K,V> buscarSucesor(NodoBinario<K,V> nodoactual){
        if (NodoBinario.esNodoVacio(nodoactual)) {
            return nodoactual;
        }
        NodoBinario<K,V> nodoAnterior=null;
        while (!NodoBinario.esNodoVacio(nodoactual)) {            
            nodoAnterior=nodoactual;
            nodoactual=nodoactual.getHijoIzquierdo();
        }
        return nodoAnterior;
    }
    
    private NodoBinario<K,V> balancear(NodoBinario<K,V> nodoactual){
        int alturaRamaizquierda=altura(nodoactual.getHijoIzquierdo());
        int alturaRamaderecha=altura(nodoactual.getHijoDerecho());
        int diferenciaAltura =alturaRamaizquierda-alturaRamaderecha;
        if (diferenciaAltura>DIFERENCIA_MAXIMA) {
            
                NodoBinario<K,V> hijoIzquierdo=nodoactual.getHijoIzquierdo();
                 alturaRamaizquierda=altura(hijoIzquierdo.getHijoIzquierdo());
                 alturaRamaderecha=altura(hijoIzquierdo.getHijoDerecho());
                 if (alturaRamaderecha>alturaRamaizquierda) {
                     return rotacionDobleDerecha(nodoactual);
                }else{
                     return rotacionSimplederecha(nodoactual);
                 }
            //hay problema rama izquierda
        }else if(diferenciaAltura<-DIFERENCIA_MAXIMA){
                NodoBinario<K,V> hijoDerecho=nodoactual.getHijoDerecho();
                 alturaRamaizquierda=altura(hijoDerecho.getHijoIzquierdo());
                 alturaRamaderecha=altura(hijoDerecho.getHijoDerecho());
                 if (alturaRamaderecha<alturaRamaizquierda) {
                     return rotacionDobleIzquierda(nodoactual);
                }else{
                     return rotacionSimpleIzquierda(nodoactual);
                 }
            //hay problema en la rama derecha
        }
        //si llego por aca, no hay problema, entonces
        //no hacemos nada, retornamos el mismo nodo
        return nodoactual;
    }

    private NodoBinario<K, V> rotacionDobleIzquierda(NodoBinario<K, V> nodoactual) {
        nodoactual.setHijoDerecho(rotacionSimplederecha(nodoactual.getHijoDerecho()));
        return rotacionSimpleIzquierda(nodoactual);
    }

    private NodoBinario<K, V> rotacionSimplederecha(NodoBinario<K, V> nodoactual) {
        NodoBinario<K,V> nodoaRetornar=nodoactual.getHijoIzquierdo();
        nodoactual.setHijoIzquierdo(nodoaRetornar.getHijoDerecho());
        nodoaRetornar.setHijoDerecho(nodoactual);
        return nodoaRetornar;
    }

    private NodoBinario<K, V> rotacionDobleDerecha(NodoBinario<K, V> nodoactual) {
        nodoactual.setHijoIzquierdo(rotacionSimpleIzquierda(nodoactual.getHijoIzquierdo()));
        return rotacionSimplederecha(nodoactual);
    }

    private NodoBinario<K, V> rotacionSimpleIzquierda(NodoBinario<K, V> nodoactual) {
        NodoBinario<K,V> nodoaRetornar=nodoactual.getHijoDerecho();
        nodoactual.setHijoDerecho(nodoaRetornar.getHijoIzquierdo());
        nodoaRetornar.setHijoIzquierdo(nodoactual);
        return nodoaRetornar;
    }
    
    
}
