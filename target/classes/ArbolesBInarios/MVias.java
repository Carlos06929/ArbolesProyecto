/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;

import Excepciones.ExcepcionClaveNoExiste;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;


/**
 *
 * @author hp
 */
public class MVias<K extends Comparable<K>,V> implements IArbolBusqueda<K,V>, Serializable {
    
     protected NodoMVias<K,V>raiz;
    protected int orden;
    protected int POSICION_INVALIDA=-1;
    public MVias(){
        this.orden=3;
    }
    public MVias(int orden){
        if(orden<3){
            throw new RuntimeException("orden invalido");
        }
        this.orden=orden;
    }

    @Override
    public void vaciar() {
      this.raiz=NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoMVias.esNodoVacio(this.raiz);
    }

    @Override
    public int size() {
        if(esArbolVacio()){
            return 0;
        }
        int cantidad=0;
        NodoMVias<K,V>nodoActual=NodoMVias.nodoVacio();
        Queue<NodoMVias<K,V>>colaDeNodos=new LinkedList<>();
        colaDeNodos.offer(this.raiz);
            while(!colaDeNodos.isEmpty()){
                nodoActual=colaDeNodos.poll();
                cantidad++;
                    for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
                        if(!nodoActual.esHijoVacio(i)){
                            colaDeNodos.offer(nodoActual.getHijo(i));
                        }
                    }
                    if(!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())){
                        colaDeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
                    }
            }
            return cantidad;
    }

    @Override
    public int altura() {
         if(esArbolVacio()){
           return 0;
       }
       int alturaDelArbol=0;
       Queue<NodoMVias<K,V>>colaDeNodos=new LinkedList<>();
       colaDeNodos.offer(this.raiz);
       NodoMVias<K,V>nodoActual=NodoMVias.nodoVacio();
                while(!colaDeNodos.isEmpty()){
                    int cantidadDeNodosEnLaCola=colaDeNodos.size();
                    int i=0;
                    while(i<cantidadDeNodosEnLaCola){
                      nodoActual=colaDeNodos.poll();
                        for(int x=0;x<nodoActual.cantidadDeClavesNoVacias();x++){
                            if(!nodoActual.esHijoVacio(x)){
                                colaDeNodos.offer(nodoActual.getHijo(x));
                            }
                        }
                        if(!NodoMVias.esNodoVacio(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()))){
                            colaDeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
                        }
                        i++;
                    }
                    alturaDelArbol++;
                }
                return alturaDelArbol;
    }

    @Override
    public int nivel() {
       return altura()-1;
    }

    @Override
    public K minimo() {
       if(esArbolVacio()){
          return null;
      }
      NodoMVias<K,V>nodoActual=this.raiz;
      K claveMenor=(K)NodoMVias.datoVacio();
        while(!NodoMVias.esNodoVacio(nodoActual)){
            claveMenor=nodoActual.getClave(0);
            nodoActual=nodoActual.getHijo(0);
        }
      return claveMenor;
    
    }

    @Override
    public K maximo() {
        if(esArbolVacio()){
           return null;
       }
       NodoMVias<K,V>nodoActual=this.raiz;
       K claveMayor=(K)NodoMVias.datoVacio();
        while(!NodoMVias.esNodoVacio(nodoActual)){
              claveMayor=nodoActual.getClave(nodoActual.cantidadDeClavesNoVacias()-1);
              nodoActual=nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias());
        }
      return claveMayor;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if(esArbolVacio()){
             this.raiz=new NodoMVias<>(orden,claveAInsertar,valorAInsertar);
             return;
         }
         NodoMVias<K,V>nodoActual=this.raiz;
                while(!NodoMVias.esNodoVacio(nodoActual)){
                    int posicionClaveEnNodo=existeClaveEnNodo(nodoActual,claveAInsertar);
                    if(posicionClaveEnNodo!=POSICION_INVALIDA){
                        nodoActual.setValor(posicionClaveEnNodo, valorAInsertar);
                        nodoActual=NodoMVias.nodoVacio();
                    }else{
                    if(nodoActual.esHoja()){
                        if(!nodoActual.estanClavesLlenas()){
                            insertarDatosOrdenadosEnNodo(nodoActual,claveAInsertar,valorAInsertar); 
                        }else{
                             int posicionPorDondeBajar=porDondeBajar(nodoActual,claveAInsertar);
                             NodoMVias<K,V>nuevo=new NodoMVias<>(this.orden,claveAInsertar,valorAInsertar);
                             nodoActual.setHijo(posicionPorDondeBajar,nuevo);
                        }
                        nodoActual=NodoMVias.nodoVacio();
                    }else{
                        int posicionBajar=porDondeBajar(nodoActual,claveAInsertar);                            
                            if(NodoMVias.esNodoVacio(nodoActual.getHijo(posicionBajar))){
                                NodoMVias<K,V>nuevoHijo=new NodoMVias<>(this.orden,claveAInsertar,valorAInsertar);
                                nodoActual.setHijo(posicionBajar,nuevoHijo);
                                nodoActual=NodoMVias.nodoVacio();
                            }else{
                                nodoActual=nodoActual.getHijo(posicionBajar);
                            }
                    }
                  }  
                }
    }
    public int porDondeBajar(NodoMVias<K,V>nodoActual,K claveABuscar){
        int i=0;
        boolean llegoAlFinal=false;
            while(i<nodoActual.cantidadDeClavesNoVacias()){
                K claveActual=nodoActual.getClave(i);
                    if(claveActual.compareTo(claveABuscar)<0){
                        i++;
                    }else{
                        break;
                    }       
            }
           
            return i;
    }
    public void insertarDatosOrdenadosEnNodo(NodoMVias<K,V>nodoActual,K claveAInsertar,V valorAInsertar){
        int res=0;
       for(int i=nodoActual.cantidadDeClavesNoVacias()-1;i>=0;i--){
                K claveActual=nodoActual.getClave(i);
                V valorActual=nodoActual.getValor(i);
                    if(claveActual.compareTo(claveAInsertar)>0){
                        nodoActual.setClave(i+1, claveActual);
                        nodoActual.setValor(i+1,valorActual);
                    }else{
                     res=i+1;
                     break;
                    }
          
        }

        nodoActual.setClave(res, claveAInsertar);
        nodoActual.setValor(res, valorAInsertar);
        
    }
    protected int existeClaveEnNodo(NodoMVias<K,V>nodoActual,K claveABuscar){
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
            K claveActual=nodoActual.getClave(i);
                if(claveActual.compareTo(claveABuscar)==0){
                    return i;
                }
        }
        return -1;
    }

     @Override
    public V eliminar(K claveAEliminar){
    if(claveAEliminar==null){
         throw new IllegalArgumentException("La clave no puede ser nula");
     }
     V valorRetorno=this.buscar(claveAEliminar);
        if(valorRetorno==null){
         throw new IllegalArgumentException("La clave no Existe en el arbol");
            
        }
     this.raiz=eliminar(this.raiz,claveAEliminar);
             return valorRetorno;
    }
    public NodoMVias<K,V> eliminar(NodoMVias<K,V>nodoActual,K claveAEliminar){
        if (nodoActual==null) {
            return nodoActual;
        }
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
                K claveActual=nodoActual.getClave(i);
                if(claveActual.compareTo(claveAEliminar)==0){
                    if(nodoActual.esHoja()){
                        this.eliminarDatoDelNodo(nodoActual,i);
                        if(nodoActual.cantidadDeClavesNoVacias()==0){
                            return NodoMVias.nodoVacio();
                        }
                        return nodoActual;
                    }else{//SI SE LLEGA ACA ENTOCES LA CLAVE NO ESTA EN UNA HOJA
                          K claveReemplazo;
                            if(this.hayDatosMasAdelante(nodoActual,i)){
                             claveReemplazo=this.buscarSucesorEnInOrden(nodoActual,claveAEliminar);
                            }else{
                             claveReemplazo=this.buscarPredecesorEnInOrden(nodoActual,claveAEliminar);    
                            }
                            V valorDeReemplazo=this.buscar(claveReemplazo);
                            nodoActual=eliminar(nodoActual,claveReemplazo);
                            nodoActual.setClave(i, claveReemplazo);
                            nodoActual.setValor(i, valorDeReemplazo);
                            return nodoActual;
                    }           
                }
                if(claveAEliminar.compareTo(claveActual)<0){
                    NodoMVias<K,V>posibleHijo=this.eliminar(nodoActual.getHijo(i), claveAEliminar);
                    nodoActual.setHijo(i, posibleHijo);
                    return nodoActual;
                    
                }
                
        }
            //SI LLEGA AQUI EL FINAL DEL FOR HAY QUE BUSCAR POR EL LADO DERECHO DEL NODO LA POSICION ORDEN;
            NodoMVias<K,V>supuesto=this.eliminar(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()),claveAEliminar);
            nodoActual.setHijo(nodoActual.cantidadDeClavesNoVacias(), supuesto);
            return nodoActual;
        
    }
    
    public K buscarPredecesorEnInOrden(NodoMVias<K,V>nodoActual,K claveABuscar){
     K claveDeRetorno=(K)NodoMVias.datoVacio();
     int posicion=this.porDondeBajar(nodoActual, claveABuscar);
     if(!NodoMVias.esNodoVacio(nodoActual.getHijo(posicion))){
     NodoMVias<K,V>nodoAuxiliar=nodoActual.getHijo(posicion);
        while(!NodoMVias.esNodoVacio(nodoAuxiliar)){
            claveDeRetorno=nodoAuxiliar.getClave(nodoAuxiliar.cantidadDeClavesNoVacias()-1);
            nodoAuxiliar=nodoAuxiliar.getHijo(nodoAuxiliar.cantidadDeClavesNoVacias());
        }
        return claveDeRetorno;
     }else{
         return nodoActual.getClave(posicion-1);
     }
    }
    public K buscarSucesorEnInOrden(NodoMVias<K,V>nodoActual,K claveABuscar){
        K claveDeRetorno=(K)NodoMVias.datoVacio();
        int posicion=this.porDondeBajar(nodoActual, claveABuscar)+1;
        if(!NodoMVias.esNodoVacio(nodoActual.getHijo(posicion))){
        
        
        NodoMVias<K,V>nodoAuxiliar=nodoActual.getHijo(posicion);
        while(!NodoMVias.esNodoVacio(nodoAuxiliar)){
            claveDeRetorno=nodoAuxiliar.getClave(0);
            nodoAuxiliar=nodoAuxiliar.getHijo(0);
        }
            return claveDeRetorno;      
        }else{
            return nodoActual.getClave(posicion);
        }
    }
    public boolean hayDatosMasAdelante(NodoMVias<K,V>nodoActual,int posicion){
       
      return nodoActual.cantidadDeClavesNoVacias()-1>posicion
              || !NodoMVias.esNodoVacio(nodoActual.getHijo(posicion+1));
    
    }
    public void eliminarDatoDelNodo(NodoMVias<K,V>nodoActual,int posicion){
        
        for(int i=posicion;i<nodoActual.cantidadDeClavesNoVacias();i++){
            if (i==nodoActual.cantidadDeClavesNoVacias()-1) {
                nodoActual.setClave(i,(K)NodoMVias.datoVacio());
                nodoActual.setValor(i,(V)NodoMVias.datoVacio());
            }else{
                nodoActual.setClave(i,nodoActual.getClave(i+1));
                nodoActual.setValor(i,nodoActual.getValor(i+1));
            }
        }
    }   
    

    @Override
    public boolean contiene(K clave) {
         return buscar(clave)!=null;
    }

    

    @Override
    public V buscar(K claveABuscar) {
        
        if(esArbolVacio()){
            return null;
        }
        NodoMVias<K,V>nodoActual=this.raiz;  
            while(!NodoMVias.esNodoVacio(nodoActual)){
                boolean sw=false;
                for(int i=0;sw==false && i<nodoActual.cantidadDeClavesNoVacias();i++){
                    K claveActual=nodoActual.getClave(i);
                        if(claveActual.compareTo(claveABuscar)==0){
                            return nodoActual.getValor(i);
                        }
                        if(claveABuscar.compareTo(claveActual)<0){
                            nodoActual=nodoActual.getHijo(i);
                            sw=true;
                        }
                        
                   } 
                 if(sw==false){
                         nodoActual=nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias());
                        }
               
            }
        return (V)NodoMVias.datoVacio();
    }

    @Override
    public List<K> recorridoInorden() {
       List<K>recorrido=new LinkedList<>();
       recorridoEnInOrden(this.raiz,recorrido);
       return recorrido;
    }
    private void recorridoEnInOrden(NodoMVias<K,V>nodoActual,List<K>recorrido){
        if(NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
            recorridoEnInOrden(nodoActual.getHijo(i),recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()),recorrido);
    
    }

    @Override
    public List<K> recorridoPreOrden() {
        List<K>recorrido=new LinkedList<>();
       recorridoEnPreOrden(this.raiz,recorrido);
       return recorrido;
    }
    public void recorridoEnPreOrden(NodoMVias<K,V>nodoActual,List<K>recorrido){
        if(NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        
        recorrido.add(nodoActual.getClave(0));
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
            recorrido.add(nodoActual.getClave(i));
            recorridoEnPreOrden(nodoActual.getHijo(i),recorrido);
        }
        recorridoEnPreOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()),recorrido);
    
    }
    

    @Override
    public List<K> recorridoPosOrden() {
          List<K>recorrido=new LinkedList<>();
       recorridoEnPostOrden(this.raiz,recorrido);
       return recorrido;
    }
    private void recorridoEnPostOrden(NodoMVias<K,V>nodoActual,List<K>recorrido){
        
        if(NodoMVias.esNodoVacio(nodoActual)){
            return ;
        }
        
        recorridoEnPostOrden(nodoActual.getHijo(0),recorrido);
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
            recorridoEnPostOrden(nodoActual.getHijo(i+1),recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        
    }

    @Override
    public List<K> recorridoPorNiveles() {
       List<K>listaDeClaves=new LinkedList<>();
        if(esArbolVacio()){
            return listaDeClaves;
        }
        Queue<NodoMVias<K,V>>colaDeNodos=new LinkedList<>();
        colaDeNodos.offer(this.raiz);
            while(!colaDeNodos.isEmpty()){
                NodoMVias<K,V>nodoActual=colaDeNodos.poll();
                for(int i=0;i<nodoActual.cantidadDeClavesNoVacias();i++){
                    listaDeClaves.add(nodoActual.getClave(i));
                    if(!NodoMVias.esNodoVacio(nodoActual.getHijo(i))){
                        colaDeNodos.offer(nodoActual.getHijo(i));
                    }
                }
                if(!NodoMVias.esNodoVacio(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()))){
                    colaDeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
                }
                 
            }
        return listaDeClaves;
    }
     
    
     private K mayorLlave(NodoMVias<K, V> p) {
        if(NodoMVias.esNodoVacio(p))
            return null;
        if(p.esHoja()) {
            K may = p.getClave(0);
            for(int i = 1; i < p.cantidadDeClavesNoVacias(); i++) {
                if(may.compareTo(p.getClave(i)) < 0) {
                    may = p.getClave(i);
                }
            }
        }
        
        K may = p.getClave(0);
        for(int i = 1; i < p.cantidadDeClavesNoVacias(); i++) {
            if(may.compareTo(p.getClave(i)) < 0) {
                may = p.getClave(i);
            }
        }
        
        for(int i = 0; i < orden; i++) {
            K m = mayorLlave(p.getHijo(i));
            if (m != null) {
                if (may.compareTo(m) < 0)
                    may = m;
            }
        }
        return may;
    }

     public boolean nodosSoloHojaOHijosNoVacio() {
        if(raiz == null)
            return false;
        int nivelRaiz = 3;
        return nodosSoloHojaOHijosNoVacio(raiz, nivelRaiz, 0);
    }  
     
    private boolean nodosSoloHojaOHijosNoVacio(NodoMVias<K, V> p, int ultimo, int n) {
        if (NodoMVias.esNodoVacio(p))
            return true;
        
        if (p.esHoja())
            return true;
        
        if (ultimo == n) {
            if (p.esHoja() == false)
                return false;
            return true;
        }
        
        for (int i = 0; i < orden; i++) {
            if(nodosSoloHojaOHijosNoVacio(p.getHijo(i), ultimo, n+1) == false)
                return false;
        }
        return true;
    }
    
    public boolean nodoSoloHojaODistintoVacio() {
        if(raiz == null)
            return false;
        return nodoSoloHojaODistintoVacio(raiz);
    }

    
    
    
        public boolean nodoSoloHojaODistintoVacio(NodoMVias<K, V> p) {
        if (NodoMVias.esNodoVacio(p))
            return true;
        
        if (p.esHoja())
            return true;
        
        if(p.cantidadDeHijosNoVacios() < orden)
            return false;
        
        boolean esVerdadero = true;
        for(int i = 0; i < orden; i++) {
            if(nodoSoloHojaODistintoVacio(p.getHijo(i)) == false)
                return false;
        }
        return true;        
    }
    
    
    public boolean esSimilar(MVias arbol) {
        return esSimilar1(raiz, arbol.raiz);
    }
  
    
     public boolean esSimilar1(NodoMVias<K, V> p, NodoMVias<K, V> p2) {
        if(NodoMVias.esNodoVacio(p) && NodoMVias.esNodoVacio(p2))
            return true;
        if(NodoMVias.esNodoVacio(p) || NodoMVias.esNodoVacio(p2))
            return false;
        
        if(p.esHoja() && p2.esHoja()) {
            if(p.cantidadDeClavesNoVacias() == p2.cantidadDeClavesNoVacias())
                return true;
            return false;
        }
        if(p.esHoja() || p2.esHoja())
            return false;        
        
        if(p.cantidadDeHijosNoVacios() != p2.cantidadDeHijosNoVacios()) {
            return false;
        }
                
        for(int i = 0; i < orden-1; i++) {
            if (p.getClave(i).compareTo(p2.getClave(i)) != 0)
                return false;
        }
                
        for(int i = 0; i < orden; i++) {
            if (esSimilar1(p.getHijo(i), p2.getHijo(i)) == false)
                return false;
        }
        return true;
    }

    @Override
    public List<V> llenarListaValores(List<K> listaClaves) {
        List<V> lisValores=new ArrayList<>();
        for (int i = 0; i < listaClaves.size(); i++) {
            V valor=buscar(listaClaves.get(i));
            lisValores.add(valor);
        }
        return lisValores;
    }

}
