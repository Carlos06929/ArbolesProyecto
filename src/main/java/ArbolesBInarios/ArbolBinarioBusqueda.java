/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class ArbolBinarioBusqueda<K extends Comparable<K>,V> implements IArbolBusqueda<K,V>,Serializable {
    protected NodoBinario<K,V> raiz;
    
    public ArbolBinarioBusqueda(){
    
    }
    
    public ArbolBinarioBusqueda(List<K> clavesInOrden, List<V> valoresInOrden,
                                List<K> clavesNoInOrden, List<V> valoresNoInOrden,
                                boolean usandoPreOrden){
  
         if (clavesInOrden==null || clavesNoInOrden==null ||
            valoresInOrden==null || valoresNoInOrden==null) {
            throw new IllegalArgumentException("los parametros no pueden ser null");
        }
        if (clavesInOrden.isEmpty() || clavesNoInOrden.isEmpty() ||
            valoresInOrden.isEmpty() || valoresNoInOrden.isEmpty()) {
            throw new IllegalArgumentException("los parametros no pueden ser vacios");
        }
         if (clavesInOrden.size()!=clavesNoInOrden.size() ||
            clavesInOrden.size()!=valoresNoInOrden.size() ||
            clavesInOrden.size()!=valoresInOrden.size()) {
            throw new IllegalArgumentException("los parametros no pueden ser de diferentes tamaños");
        }
         
        if (usandoPreOrden) {
            raiz=reconstruirConPreOrden(clavesInOrden, valoresInOrden, clavesNoInOrden, valoresNoInOrden);
        }else{
            raiz=reconstruirConPosOrden(clavesInOrden, valoresInOrden, clavesNoInOrden, valoresNoInOrden);
        }
    
    }
    
     private NodoBinario<K,V> reconstruirConPreOrden(List<K> clavesInOrden, List<V> valoresInOrden,
                                         List<K> clavesPreOrden, List<V> valoresPreOrden) {
         if (clavesInOrden.isEmpty()) {
             return null;
         }
         
         int posicionClavePadreEnPreorden=0;
         K clavePadre=clavesPreOrden.get(posicionClavePadreEnPreorden);
         V valorPadre=valoresPreOrden.get(posicionClavePadreEnPreorden);
         int posicionClavePadreEnInOrden=posicionDeClave(clavePadre, clavesInOrden);
         
                 
         //Para Armar la rama izquierda
         List<K> clavesInOrdenPorIzquierda=clavesInOrden.subList(0, posicionClavePadreEnInOrden);
         List<V> valoresInOrdenPorIzquierda=valoresInOrden.subList(0, posicionClavePadreEnInOrden);
         List<K> ClavesPreOrdenPorIzquierda=clavesPreOrden.subList(1, posicionClavePadreEnInOrden+1);
         List<V> ValoresPreOrdenPorIzquierda=valoresPreOrden.subList(1, posicionClavePadreEnInOrden+1);
         NodoBinario<K,V> hijoIzquierdo=reconstruirConPreOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                                                           ClavesPreOrdenPorIzquierda, ValoresPreOrdenPorIzquierda);
         //para armar rama derecha
         List<K> clavesInOrdenPorDerecha=clavesInOrden.subList(posicionClavePadreEnInOrden+1,clavesInOrden.size());
         List<V> valoresInOrdenPorDerecha=valoresInOrden.subList(posicionClavePadreEnInOrden+1,valoresInOrden.size());
         List<K> ClavesPreOrdenPorDerecha=clavesPreOrden.subList(posicionClavePadreEnInOrden+1,clavesPreOrden.size());
         List<V> ValoresPreOrdenPorDerecha=valoresPreOrden.subList(posicionClavePadreEnInOrden+1,valoresPreOrden.size());
         NodoBinario<K,V> hijoDerecha=reconstruirConPreOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                                                           ClavesPreOrdenPorDerecha, ValoresPreOrdenPorDerecha);        
         //Armando el nodoActual
         NodoBinario<K,V> nodoactual=new NodoBinario(clavePadre,valorPadre);
         nodoactual.setHijoIzquierdo(hijoIzquierdo);
         nodoactual.setHijoDerecho(hijoDerecha);
         return nodoactual;
     }
     
     private NodoBinario<K,V> reconstruirConPosOrden(List<K> clavesInOrden, List<V> valoresInOrden, 
                                         List<K> clavesPosOrden, List<V> valoresPosOrden) {
         if (clavesInOrden.isEmpty()) {
             return null;
         }
         
         int posicionClavePadreEnPreorden=valoresPosOrden.size()-1;
         K clavePadre=clavesPosOrden.get(posicionClavePadreEnPreorden);
         V valorPadre=valoresPosOrden.get(posicionClavePadreEnPreorden);
         int posicionClavePadreEnInOrden=posicionDeClave(clavePadre, clavesInOrden);
         
                 
         //Para Armar la rama izquierda
         List<K> clavesInOrdenPorIzquierda=clavesInOrden.subList(0, posicionClavePadreEnInOrden);
         List<V> valoresInOrdenPorIzquierda=valoresInOrden.subList(0, posicionClavePadreEnInOrden);
         List<K> ClavesPreOrdenPorIzquierda=clavesPosOrden.subList(0, posicionClavePadreEnInOrden);
         List<V> ValoresPreOrdenPorIzquierda=valoresPosOrden.subList(0, posicionClavePadreEnInOrden);
         NodoBinario<K,V> hijoIzquierdo=reconstruirConPosOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                                                           ClavesPreOrdenPorIzquierda, ValoresPreOrdenPorIzquierda);
         //para armar rama derecha
         List<K> clavesInOrdenPorDerecha=clavesInOrden.subList(posicionClavePadreEnInOrden+1,clavesInOrden.size());
         List<V> valoresInOrdenPorDerecha=valoresInOrden.subList(posicionClavePadreEnInOrden+1,valoresInOrden.size());
         List<K> ClavesPreOrdenPorDerecha=clavesPosOrden.subList(posicionClavePadreEnInOrden,clavesPosOrden.size()-1);
         List<V> ValoresPreOrdenPorDerecha=valoresPosOrden.subList(posicionClavePadreEnInOrden,valoresPosOrden.size()-1);
         NodoBinario<K,V> hijoDerecha=reconstruirConPosOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                                                           ClavesPreOrdenPorDerecha, ValoresPreOrdenPorDerecha);        
         //Armando el nodoActual
         NodoBinario<K,V> nodoactual=new NodoBinario(clavePadre,valorPadre);
         nodoactual.setHijoIzquierdo(hijoIzquierdo);
         nodoactual.setHijoDerecho(hijoDerecha);
         return nodoactual;
    }
     
     private int posicionDeClave(K claveBuscar,List<K> ListaDeCLaves){
         for (int i = 0; i < ListaDeCLaves.size(); i++) {
             K claveactual=ListaDeCLaves.get(i);
             if (claveBuscar==claveactual) {
                 return i;
             }
         }
         return -1;
     }
    
    @Override
    public void vaciar() {
        this.raiz=(NodoBinario<K,V>)NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int size() {
        if (this.esArbolVacio()) {
            return 0;
        }
        int cantNodos=0;
         Stack<NodoBinario<K,V>> pilaNodos=new Stack<>();
        pilaNodos.push(raiz);
        while (!pilaNodos.isEmpty()){
            NodoBinario<K,V> nodoactual=pilaNodos.pop();
            cantNodos++;
            if (nodoactual.getHijoDerecho()!=null) {
                pilaNodos.push(nodoactual.getHijoDerecho());
            }
            if (nodoactual.getHijoIzquierdo()!=null) {
                pilaNodos.push(nodoactual.getHijoIzquierdo());
            }
        }
        return cantNodos;
    }

    @Override
    public int altura() {
        return altura(raiz);
    }
    
    protected int altura(NodoBinario<K,V> nodoactual){
        if (nodoactual==null) {
            return 0;
        }
        int alturaIzquierda=altura(nodoactual.getHijoIzquierdo());
        int alturaDerecha=altura(nodoactual.getHijoDerecho());
        /*if(alturaIzquierda>alturaDerecha){
            return alturaIzquierda+1;    
        }
        return alturaDerecha+1;*/
        return alturaIzquierda>alturaDerecha?alturaIzquierda+1:alturaDerecha+1;
    }
    
    private int alturaIterativo(){
        if (esArbolVacio()) {
            return 0;
        }
        int alturaArbol=0;
        Queue<NodoBinario<K,V>> colaNodos=new LinkedList<>();
        colaNodos.offer(raiz);
        while (!colaNodos.isEmpty()) {            
            int cantidadNodosCola=colaNodos.size();
            int i=0;
            while (i<cantidadNodosCola) {                
                NodoBinario<K,V> nodoactual=colaNodos.poll();
                if (!nodoactual.esVacioHijoIzquierdo()) {
                    colaNodos.offer(nodoactual.getHijoIzquierdo());
                }if (!nodoactual.esVacioHijoDerecho()) {
                    colaNodos.offer(nodoactual.getHijoDerecho());
                }
                i++;
            }
            alturaArbol++;
        }
        return alturaArbol;
    }
    
    @Override
    public int nivel() {
        return altura()-1;
    }

    @Override
    public K minimo() {
        if (this.esArbolVacio()) {
            return null;
        }
        NodoBinario<K,V> nodoactual=raiz;
        NodoBinario<K,V> nodoanterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoactual)) {            
            nodoanterior=nodoactual;
            nodoactual=nodoactual.getHijoIzquierdo();
        }
        return nodoanterior.getClave();
    }

       //vamos  a implementar un metodo que retorne si un arbol binario solo tiene nodos completos, es decir que tengan sus dos hijos
        //diferentes de vacio en el nivel n;
    public boolean tieneNodosCompletosEnNivel(int nivelObjetivo){
        return tieneNodosCompletosEnNivel(this.raiz,nivelObjetivo,0);
    }
    private boolean tieneNodosCompletosEnNivel(NodoBinario<K,V> nodoactual, int nivelObjetivo, int nivelactual){
        if(NodoBinario.esNodoVacio(nodoactual)){
            return true;
        }
        
        
        if(nivelactual==nivelObjetivo){
            return !nodoactual.esVacioHijoIzquierdo() && !nodoactual.esVacioHijoDerecho();
        }
        boolean completoPorIzquierda=this.tieneNodosCompletosEnNivel(nodoactual.getHijoIzquierdo(),nivelObjetivo, nivelactual+1);
        boolean completoPorDerecha=this.tieneNodosCompletosEnNivel(nodoactual.getHijoDerecho(),nivelObjetivo, nivelactual+1);
        return completoPorIzquierda && completoPorDerecha;
    }
    
    @Override
    public K maximo() {
        if (esArbolVacio()) {
            return null;
        }
        NodoBinario<K,V> nodoactual=raiz;
        NodoBinario<K,V> nodoanterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoactual)) {            
            nodoanterior=nodoactual;
            nodoactual=nodoactual.getHijoDerecho();
        }
        return nodoanterior.getClave();
    }

    @Override
    public void insertar(K clave, V valor) {
           if (clave==null) {
            throw new IllegalArgumentException("clave no puede ser nula");
        }
        if (valor==null) {
            throw new IllegalArgumentException("valor no puede ser cero");
        }
        if (esArbolVacio()) {
            this.raiz=new NodoBinario(clave,valor);
            return;
        }
        NodoBinario<K,V> nodoactual=raiz;
        NodoBinario<K,V> nodoanterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        while (nodoactual!=null){            
            K claveactual=nodoactual.getClave();
            nodoanterior=nodoactual;
            if (claveactual.compareTo(clave)>0) {
                nodoactual=nodoactual.getHijoIzquierdo();
            }else if (claveactual.compareTo(clave)<0) {
                nodoactual=nodoactual.getHijoDerecho();
            }else{//la clave ya existe entoncesm reemplazo solo el valor
                nodoactual.setValor(valor);
            }
        }//si llega a este punto quiere decir que la clave nop ecxiste
        //entonces se debe crear un nuevo nodo con la clave y el valor a insertar
        //y el nodo anterior es el padre de es nuevo nodo
        NodoBinario<K,V> nuevonodo=new NodoBinario(clave,valor);
        K claveanterior=nodoanterior.getClave();
        if (claveanterior.compareTo(clave)>0) {
            nodoanterior.setHijoIzquierdo(nuevonodo);
        }else{
            nodoanterior.setHijoDerecho(nuevonodo);
        }
    }

    @Override
    public V eliminar(K clave) {
         V valorRetornar=buscar(clave);
          if (valorRetornar==null) {
              throw new IllegalArgumentException("el dato no esxixte");
        }
          raiz=eliminar(raiz,clave);
          return valorRetornar;
    }
    
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
                return nodoactual;
        }
        if (claveEliminar.compareTo(claveactual)<0) {
            NodoBinario<K,V> supuestoNuevoHijoIzquierdo=eliminar(nodoactual.getHijoIzquierdo(), claveEliminar);
            nodoactual.setHijoIzquierdo(supuestoNuevoHijoIzquierdo);
            return nodoactual;
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

    @Override
    public boolean contiene(K clave) {
        return buscar(clave)!=null;
    }

    @Override
    public V buscar(K clave_buscar) {
        if (clave_buscar==null) {
            throw new IllegalArgumentException("clave no puede ser cero");
        }
        if (this.esArbolVacio()) {
            return null;
        }
        NodoBinario<K,V> nodoactual=raiz;
        while(!NodoBinario.esNodoVacio(nodoactual)){
           
           K clave_actual=nodoactual.getClave();
            if (clave_actual.compareTo(clave_buscar)>0) {
                nodoactual=nodoactual.getHijoIzquierdo();
            }else if (clave_actual.compareTo(clave_buscar)<0) {
                nodoactual=nodoactual.getHijoDerecho();
            }else{
                return nodoactual.getValor();
            }
        }
        //si llega a este punto quiere decir que la clave no esta en el arbol
        return null;
    }
    
    public List<V> llenarListaValores(List<K> listadeClaves){
        List<V> valoresLista=new ArrayList();
        int i=0;
        
        while (i<listadeClaves.size()) {            
            valoresLista.add(buscar(listadeClaves.get(i)));
            i++;
        }
        return valoresLista;
    }

    @Override
    public List<K> recorridoInorden() {
        List<K> recorrido=new LinkedList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<K,V>> piladeNodos=new Stack<>();
        NodoBinario<K,V> nodoactual=this.raiz;
        meterpilaInOrden(nodoactual, piladeNodos);
        
        while(!piladeNodos.isEmpty()){
        nodoactual=piladeNodos.pop();
        recorrido.add(nodoactual.getClave());
        if (!nodoactual.esVacioHijoDerecho()){
            nodoactual=nodoactual.getHijoDerecho();
            meterpilaInOrden(nodoactual, piladeNodos);
        }
        
        }
        return recorrido;
    }
    
    private void meterpilaInOrden(NodoBinario<K, V> nodoactual, Stack<NodoBinario<K, V>> piladeNodos) {
        while (!NodoBinario.esNodoVacio(nodoactual)){
            piladeNodos.push(nodoactual);
            nodoactual=nodoactual.getHijoIzquierdo();
        }
    }
    
    public List<K> recoInOrdenRec(){
        List<K> recorrido=new ArrayList<>();
        //para poder resolver el recorrido inorden recursivo se necesita
        //un metodo amigo que resuelva el ancho del problma
        recoInOrdenRec(recorrido,raiz);
       return recorrido;
    }
    
    private void recoInOrdenRec(List<K> recorrido, NodoBinario<K,V> nodoactual) {
         //simulamos el n para el caso base
         if (nodoactual==null) {
             return;
         }
         recoInOrdenRec(recorrido,nodoactual.getHijoIzquierdo());
         recorrido.add(nodoactual.getClave());
         recoInOrdenRec(recorrido, nodoactual.getHijoDerecho());
    }

    @Override
    public List<K> recorridoPreOrden() {
        List<K> recorrido=new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaNodos=new Stack<>();
        pilaNodos.push(raiz);
        while (!pilaNodos.isEmpty()) {            
            NodoBinario<K,V> nodoactual=pilaNodos.pop();
            recorrido.add(nodoactual.getClave());
            if (!nodoactual.esVacioHijoDerecho()) {
                pilaNodos.push(nodoactual.getHijoDerecho());
            }
            if (!nodoactual.esVacioHijoIzquierdo()) {
                pilaNodos.push(nodoactual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }
    
    @Override
    public List<K> recorridoPosOrden() {
        List<K> recorrido=new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaNodos=new Stack<>();
        NodoBinario<K,V> nodoactual=raiz;
        //Proceso inicial antes de interar la pila primero llenarla
        llenarPilaParaPosOrden(pilaNodos,nodoactual);
        //aqui empezamos a iterar sobre la pila pero tambien se ocupra el l
        //llenar la pila 
        while (!pilaNodos.isEmpty()) {            
            nodoactual=pilaNodos.pop();
            recorrido.add(nodoactual.getClave());
            if (!pilaNodos.isEmpty()) {
                NodoBinario<K,V> nodoTope=pilaNodos.peek();
                if (!nodoTope.esVacioHijoDerecho() && nodoactual!=nodoTope.getHijoDerecho()) {
                    //volver a rellenar la pila si es que el hijo derecho tiene hijos
                    //izquierdos
                    llenarPilaParaPosOrden(pilaNodos,nodoTope.getHijoDerecho());
                }
            }
        }
        return recorrido;
    }
    
     private void llenarPilaParaPosOrden(Stack<NodoBinario<K,V>> pilaNodos, NodoBinario<K,V> nodoactual) {
         //esto se tiene que provar directamente preguntar si el nodo atual es null sin llamara a los metodos static
         while (!NodoBinario.esNodoVacio(nodoactual)) {             
             pilaNodos.push(nodoactual);
             if (!nodoactual.esVacioHijoIzquierdo()) { 
                 nodoactual=nodoactual.getHijoIzquierdo();
             }else{
                 nodoactual=nodoactual.getHijoDerecho();
             }
         }
     }
     
     public List<K> recoPosOrdenRec(){
        List<K> recorrido=new ArrayList<>();
        //para poder resolver el recorrido inorden recursivo se necesita
        //un metodo amigo que resuelva el ancho del problma
        recoPosOrdenRec(recorrido,raiz);
       return recorrido;
    }
    
     private void recoPosOrdenRec(List<K> recorrido, NodoBinario<K,V> nodoactual) {
         //simulamos el n para el caso base
         if (NodoBinario.esNodoVacio(nodoactual)) {
             return; 
         }
         recoPosOrdenRec(recorrido,nodoactual.getHijoIzquierdo());
         recoPosOrdenRec(recorrido, nodoactual.getHijoDerecho());
         recorrido.add(nodoactual.getClave());
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido=new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Queue<NodoBinario<K,V>> colaNodos=new LinkedList<>();
        colaNodos.offer(raiz);
        while (!colaNodos.isEmpty()) {            
            NodoBinario<K,V> nodoactual=colaNodos.poll();
            recorrido.add(nodoactual.getClave());
            if (!nodoactual.esVacioHijoIzquierdo()) {
                colaNodos.offer(nodoactual.getHijoIzquierdo());
            }
            if (!nodoactual.esVacioHijoDerecho()) {
                colaNodos.offer(nodoactual.getHijoDerecho());
            }
        }
        return recorrido;
    }
    
     public int cantidadHijosDerechos(){
       return cantidadHijosDerechos(raiz);
   }
   public int cantidadHijosDerechos(NodoBinario<K,V> nodoactual){
       if (NodoBinario.esNodoVacio(nodoactual)) {
           return 0;
       }
       int hdPorRamaIzquierda=cantidadHijosDerechos(nodoactual.getHijoIzquierdo());
       int hdPorRamaDerecha=cantidadHijosDerechos(nodoactual.getHijoDerecho());
       
       if (!nodoactual.esVacioHijoDerecho()) {
           return hdPorRamaIzquierda+hdPorRamaDerecha+1;
       }
   return hdPorRamaDerecha+hdPorRamaIzquierda;
   }  
   
  public int cantidadNodosConSoloHI(){
        int cant=0;
        if (this.esArbolVacio()) {
            return cant;
        }
        Stack<NodoBinario<K,V>> pilaNodos=new Stack<>();
        NodoBinario<K,V> nodoactual=raiz;
        //Proceso inicial antes de interar la pila primero llenarla
        llenarPilaParaPosOrden(pilaNodos,nodoactual);
        //aqui empezamos a iterar sobre la pila pero tambien se ocupra el l
        //llenar la pila 
        
        while (!pilaNodos.isEmpty()) {            
            nodoactual=pilaNodos.pop();
            if(!nodoactual.esVacioHijoIzquierdo() && nodoactual.esVacioHijoDerecho()){
                cant=cant+1;
            }
           
            if (!pilaNodos.isEmpty()) {
                NodoBinario<K,V> nodoTope=pilaNodos.peek();
                if (!nodoTope.esVacioHijoDerecho() && nodoactual!=nodoTope.getHijoDerecho()) {
                    //volver a rellenar la pila si es que el hijo derecho tiene hijos
                    //izquierdos
                    llenarPilaParaPosOrden(pilaNodos,nodoTope.getHijoDerecho());
                }
            }
        }
        return cant;
  }
   
//   private void llenarPilaParaPosOrden(Stack<NodoBinario<K,V>> pilaNodos, NodoBinario<K,V> nodoactual) {
//         //esto se tiene que provar directamente preguntar si el nodo atual es null sin llamara a los metodos static
//         while (!NodoBinario.esNodoVacio(nodoactual)) {             
//             pilaNodos.push(nodoactual);
//             if (!nodoactual.esVacioHijoIzquierdo()) { 
//                 nodoactual=nodoactual.getHijoIzquierdo();
//             }else{
//                 nodoactual=nodoactual.getHijoDerecho();
//             }
//         }
//     }
   
   public int cantidadenodosConsoloHijosIzquierdosRec(){
        return cantidadenodosConsoloHijosIzquierdosRec(this.raiz);
    }
    private int cantidadenodosConsoloHijosIzquierdosRec(NodoBinario<K,V> nodoactual){
        if (NodoBinario.esNodoVacio(nodoactual)) {
            return 0;
        }
        int cantHIporIzquierda=cantidadenodosConsoloHijosIzquierdosRec(nodoactual.getHijoIzquierdo());
        int canHIporDerecha=cantidadenodosConsoloHijosIzquierdosRec(nodoactual.getHijoDerecho());
        
        if (nodoactual.esVacioHijoDerecho() && !nodoactual.esVacioHijoIzquierdo()) {
            return canHIporDerecha+cantHIporIzquierda+1;
            
        }
        return canHIporDerecha+cantHIporIzquierda;
    }
    
    public int cantidadNodosConSoloHIenNivelRec(int nivelabuscar){
        return cantidadNodosConSoloHIenNivelRec(this.raiz,0,nivelabuscar);
    }
    
    public int cantidadNodosConSoloHIenNivelRec(NodoBinario<K,V> nodoactual,int contador, int nivelabuscar){
        if (NodoBinario.esNodoVacio(nodoactual)) {
            return 0;
        }
        int porIzquierda=cantidadNodosConSoloHIenNivelRec(nodoactual.getHijoIzquierdo(),contador+1,nivelabuscar);
        int porDerecha=cantidadNodosConSoloHIenNivelRec(nodoactual.getHijoDerecho(), contador+1, nivelabuscar);
        if (contador==nivelabuscar) {
            if (nodoactual.esVacioHijoDerecho() && !nodoactual.esVacioHijoIzquierdo()) {
            return porIzquierda+porDerecha+1;
            }
        }
        return porIzquierda+porDerecha;
    }
    
    public int cantidadNodosConSoloHIdespuesNivel(int NivelaBuscar){
        if (esArbolVacio()) {
            return 0;
        }
        int alturaArbol=0;
        int contador=0;
        Queue<NodoBinario<K,V>> colaNodos=new LinkedList<>();
        colaNodos.offer(raiz);
        while (!colaNodos.isEmpty()) {            
            int cantidadNodosCola=colaNodos.size();
            int i=0;
            while (i<cantidadNodosCola) {                
                NodoBinario<K,V> nodoactual=colaNodos.poll();
                if (alturaArbol>NivelaBuscar) {
                    if (nodoactual.esVacioHijoDerecho() && !nodoactual.esVacioHijoIzquierdo()) {
                        contador++;
                    }
                }
                if (!nodoactual.esVacioHijoIzquierdo()) {
                    colaNodos.offer(nodoactual.getHijoIzquierdo());
                }if (!nodoactual.esVacioHijoDerecho()) {
                    colaNodos.offer(nodoactual.getHijoDerecho());
                }
                
                i++;
            }
            alturaArbol++;
        }
        return contador;
    }
    
    public int cantidadNodosConSoloHIantesNivel(int NivelaBuscar){
        if (esArbolVacio()) {
            return 0;
        }
        int alturaArbol=0;
        int contador=0;
        Queue<NodoBinario<K,V>> colaNodos=new LinkedList<>();
        colaNodos.offer(raiz);
        while (!colaNodos.isEmpty()) {            
            int cantidadNodosCola=colaNodos.size();
            int i=0;
            while (i<cantidadNodosCola) {                
                NodoBinario<K,V> nodoactual=colaNodos.poll();
                if (alturaArbol<NivelaBuscar) {
                    if (nodoactual.esVacioHijoDerecho() && !nodoactual.esVacioHijoIzquierdo()) {
                        contador++;
                    }
                }
                if (!nodoactual.esVacioHijoIzquierdo()) {
                    colaNodos.offer(nodoactual.getHijoIzquierdo());
                }if (!nodoactual.esVacioHijoDerecho()) {
                    colaNodos.offer(nodoactual.getHijoDerecho());
                }
                
                i++;
            }
            alturaArbol++;
        }
        return contador;
    }
   
    public boolean arbolesSimilars(ArbolBinarioBusqueda<K,V> a1){
        return arbolesSimilars(this.raiz,a1.raiz);
    }
    public boolean arbolesSimilars(NodoBinario<K,V> nodoactual,NodoBinario<K,V> nodoactual2){
        if (NodoBinario.esNodoVacio(nodoactual) || NodoBinario.esNodoVacio(nodoactual2)) {
            return NodoBinario.esNodoVacio(nodoactual) && NodoBinario.esNodoVacio(nodoactual2);
         }
         boolean simIz=arbolesSimilars(nodoactual.getHijoIzquierdo(),nodoactual2.getHijoIzquierdo());
         boolean simDer=arbolesSimilars(nodoactual.getHijoIzquierdo(),nodoactual2.getHijoIzquierdo());
         return !(simDer!=true || simIz!=true);
    }
    
    public int cantidadNodosCompletosdespuesNivel(int NivelaBuscar){
        if (esArbolVacio()) {
            return 0;
        }
        int alturaArbol=0;
        int contador=0;
        Queue<NodoBinario<K,V>> colaNodos=new LinkedList<>();
        colaNodos.offer(raiz);
        while (!colaNodos.isEmpty()) {            
            int cantidadNodosCola=colaNodos.size();
            int i=0;
            while (i<cantidadNodosCola) {                
                NodoBinario<K,V> nodoactual=colaNodos.poll();
                if (alturaArbol>NivelaBuscar) {
                    if (nodoactual.nodoCompleto()) {
                        contador++;
                    }
                }
                if (!nodoactual.esVacioHijoIzquierdo()) {
                    colaNodos.offer(nodoactual.getHijoIzquierdo());
                }if (!nodoactual.esVacioHijoDerecho()) {
                    colaNodos.offer(nodoactual.getHijoDerecho());
                }
                
                i++;
            }
            alturaArbol++;
        }
        return contador;
    }
    
    public boolean arbolLleno(){
        if (esArbolVacio()) {
            return true;
        }
        Queue<NodoBinario<K,V>> colaNodos=new LinkedList<>();
        colaNodos.offer(raiz);
        while (!colaNodos.isEmpty()) {            
            int cantidadNodosCola=colaNodos.size();
            int i=0;
            while (i<cantidadNodosCola) {                
                NodoBinario<K,V> nodoactual=colaNodos.poll();
                if (nodoactual.nodoCompleto()==false && nodoactual.esHoja()==false) {
                    return false;
                }
                if (!nodoactual.esVacioHijoIzquierdo()) {
                    colaNodos.offer(nodoactual.getHijoIzquierdo());
                }if (!nodoactual.esVacioHijoDerecho()) {
                    colaNodos.offer(nodoactual.getHijoDerecho());
                }
                
                i++;
            }
            
        
            }
        return arbolesSimilars(raiz.getHijoIzquierdo(),raiz.getHijoDerecho());
    }
}
