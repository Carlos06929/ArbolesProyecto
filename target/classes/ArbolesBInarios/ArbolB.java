/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;
import Excepciones.ExcepcionClaveNoExiste;
import java.util.Stack;
import java.io.Serializable;
/**
 *
 * @author Roberto
 */
public class ArbolB <K extends Comparable<K>,V> extends MVias<K,V>{
    private int nroMaximoDeDatos;
    private int nroMinimoDeDatos;
    private int nroMinimoDeHijos;
    
    public ArbolB(){
        super();
        this.nroMaximoDeDatos=2;
        this.nroMinimoDeDatos=1;
        this.nroMinimoDeHijos=2;
    }
    
    public ArbolB(int orden){
        super(orden);
        this.nroMaximoDeDatos=super.orden-1;
        this.nroMinimoDeDatos=this.nroMaximoDeDatos/2;
        this.nroMinimoDeHijos=this.nroMinimoDeDatos+1;
    }
    
  
    public void insertar1(K claveAInsertar,V valorAInsertar){
        if (valorAInsertar==null) {
           throw new RuntimeException("No se permite insertar valores nulos");
        }
        if (claveAInsertar==null) {
            throw new RuntimeException("No se permite insertar claves nulas");
        }
        if (this.esArbolVacio()) {
            this.raiz= new NodoMVias<>(this.orden+1,claveAInsertar,valorAInsertar);
            return ;
        }
        Stack<NodoMVias<K,V>> pilaDeAncestros= new Stack<>();
        NodoMVias<K,V> nodoactual=this.raiz;
        while (!NodoMVias.esNodoVacio(nodoactual)) {            
            int posicionDeClave=super.existeClaveEnNodo(nodoactual, claveAInsertar);
            if (posicionDeClave!=POSICION_INVALIDA) {
                nodoactual.setValor(posicionDeClave, valorAInsertar);
                nodoactual=NodoMVias.nodoVacio();
            }else{
                if (nodoactual.esHoja()) {
                    if(!nodoactual.estanClavesLlenas()){
                        this.insertarDatosOrdenadosEnNodo(nodoactual, claveAInsertar, valorAInsertar);
                         if (nodoactual.cantidadDeClavesNoVacias()>this.nroMaximoDeDatos) {
                            this.dividir(nodoactual,pilaDeAncestros);
                        }
                    }else{
                             int posicionPorDondeBajar=porDondeBajar(nodoactual,claveAInsertar);
                             NodoMVias<K,V>nuevo=new NodoMVias<>(this.orden+1,claveAInsertar,valorAInsertar);
                             nodoactual.setHijo(posicionPorDondeBajar,nuevo);
                        }
                    nodoactual=NodoMVias.nodoVacio();
                }else{
                int posicionPorDondeBajar=this.porDondeBajar(nodoactual, claveAInsertar);
                pilaDeAncestros.push(nodoactual);
                nodoactual=nodoactual.getHijo(posicionPorDondeBajar);
                }
            }
        }
        
    }
    
    
    public void dividir(NodoMVias<K,V> nodoactual, Stack<NodoMVias<K,V>> pilaAncestros ){
        K clave=nodoactual.getClave(nroMinimoDeDatos);
        V valor=nodoactual.getValor(nroMinimoDeDatos);
        if(!pilaAncestros.isEmpty()){
        
        NodoMVias<K,V> nodoAux=pilaAncestros.pop();
        insertarDatosOrdenadosEnNodo2(nodoAux, clave, valor);
        
        int num=existeClaveEnNodo(nodoAux, clave);
        nodoAux.setHijo(num,new NodoMVias<>(this.orden+1));
        nodoAux.setHijo(num+1,new NodoMVias<>(this.orden+1));
        int num1=0;
        int num2=0;
        for (int i = nodoactual.cantidadDeClavesNoVacias()-1; i >=0; i--) {
            if (nodoactual.getClave(i).compareTo(clave)>0) {
                insertarDatosOrdenadosEnNodo(nodoAux.getHijo(num+1), nodoactual.getClave(i), nodoactual.getValor(i));
                num1=existeClaveEnNodo(nodoAux.getHijo(num+1),nodoactual.getClave(i));
                num2=existeClaveEnNodo(nodoactual, nodoactual.getClave(i));
                nodoAux.getHijo(num+1).setHijo(num1+1,nodoactual.getHijo(num2+1) );
            }else if(nodoactual.getClave(i).compareTo(clave)<0){
                insertarDatosOrdenadosEnNodo(nodoAux.getHijo(num), nodoactual.getClave(i), nodoactual.getValor(i));
                num1=existeClaveEnNodo(nodoAux.getHijo(num),nodoactual.getClave(i));
                num2=existeClaveEnNodo(nodoactual, nodoactual.getClave(i));
                nodoAux.getHijo(num).setHijo(num1,nodoactual.getHijo(num2+1) );
            }
          }   
        }else{
                NodoMVias<K,V> nuevaRaiz=new NodoMVias<>(this.orden+1,clave,valor);
                this.raiz=nuevaRaiz;
                nuevaRaiz.setHijo(0,new NodoMVias<>(this.orden+1));
                nuevaRaiz.setHijo(1,new NodoMVias<>(this.orden+1));
                int num2=0;
                int num=0;
                for (int i = nodoactual.cantidadDeClavesNoVacias()-1; i >=0; i--) {
                 if (nodoactual.getClave(i).compareTo(clave)>0) {
                    insertarDatosOrdenadosEnNodo(nuevaRaiz.getHijo(1), nodoactual.getClave(i), nodoactual.getValor(i));
                    num=existeClaveEnNodo(nuevaRaiz.getHijo(1),nodoactual.getClave(i));
                    num2=existeClaveEnNodo(nodoactual, nodoactual.getClave(i));
                    nuevaRaiz.getHijo(1).setHijo(num+1,nodoactual.getHijo(num2) );
                }else if(nodoactual.getClave(i).compareTo(clave)<0){
                    insertarDatosOrdenadosEnNodo(nuevaRaiz.getHijo(0), nodoactual.getClave(i), nodoactual.getValor(i));
                    num=existeClaveEnNodo(nuevaRaiz.getHijo(0),nodoactual.getClave(i));
                    num2=existeClaveEnNodo(nodoactual, nodoactual.getClave(i));
                    nuevaRaiz.getHijo(0).setHijo(num,nodoactual.getHijo(num2+1) );
            }
          }   
        }
    }
    
    
    public void insertarDatosOrdenadosEnNodo2(NodoMVias<K,V>nodoActual,K claveAInsertar,V valorAInsertar){
        int res=0;
       for(int i=nodoActual.cantidadDeClavesNoVacias()-1;i>=0;i--){
                K claveActual=nodoActual.getClave(i);
                V valorActual=nodoActual.getValor(i);
                    if(claveActual.compareTo(claveAInsertar)>0){
                        nodoActual.setClave(i+1, claveActual);
                        nodoActual.setValor(i+1,valorActual);
                        nodoActual.setHijo(i+2,nodoActual.getHijo(i+1) );
                        
                    }else{
                     res=i+1;
                     break;
                    }

        }

        nodoActual.setClave(res, claveAInsertar);
        nodoActual.setValor(res, valorAInsertar);
        
    }
   
    public V eliminar1(K claveEliminar) throws ExcepcionClaveNoExiste{
        if (true) {
            throw new IllegalArgumentException("Clase a eliminar no puede ser nula");
        }
        Stack<NodoMVias<K,V>> pilaDeAncestros=new Stack<>();
        NodoMVias<K,V> nodoactual=this.buscarNodoDeLaClave(claveEliminar,pilaDeAncestros);
        if (NodoMVias.esNodoVacio(nodoactual)) {
            throw new ExcepcionClaveNoExiste();
        }
        int posicionClaveAElimarEnElNodo=super.porDondeBajar(nodoactual, claveEliminar)-1;
        V valoraARetornar=nodoactual.getValor(posicionClaveAElimarEnElNodo);
        if (nodoactual.esHoja()) {
            super.eliminarDatoDelNodo(nodoactual,posicionClaveAElimarEnElNodo);
            if (nodoactual.cantidadDeClavesNoVacias()<this.nroMinimoDeDatos) {
                if (pilaDeAncestros.empty()) {
                    if (nodoactual.cantidadDeClavesNoVacias()==0) {
                        super.vaciar();
                    }
                }else{
                    this.prestarOFusionar(nodoactual,pilaDeAncestros);
                }
            }
        }else{
            pilaDeAncestros.push(nodoactual);
            NodoMVias<K,V> nodoDelPredecesor=this.buscarNodoDeClavePredecesora(pilaDeAncestros,
                    nodoactual.getHijo(posicionClaveAElimarEnElNodo));
            int posicionDelPredecesor=nodoDelPredecesor.cantidadDeClavesNoVacias()-1;
            K clavePredecesora=nodoDelPredecesor.getClave(posicionDelPredecesor);
            V valorDelPredecesor=nodoDelPredecesor.getValor(posicionDelPredecesor);
            super.eliminarDatoDelNodo(nodoDelPredecesor,posicionDelPredecesor);
            nodoactual.setClave(posicionClaveAElimarEnElNodo, clavePredecesora);
            nodoactual.setValor(posicionClaveAElimarEnElNodo, valorDelPredecesor);
            if (nodoDelPredecesor.cantidadDeClavesNoVacias()<this.nroMinimoDeDatos) {
                this.prestarOFusionar(nodoDelPredecesor,pilaDeAncestros);
            }
        }
        return valoraARetornar;
    }
    
    public void prestarOFusionar(NodoMVias<K,V> nodoactual,Stack<NodoMVias<K,V>> pilaAncestros){
        
    
    }
     public NodoMVias<K,V> buscarNodoDeClavePredecesora(Stack<NodoMVias<K,V>> pilAncestros,NodoMVias<K,V> nodoActual){
     NodoMVias<K,V> nodoRetorno=NodoMVias.nodoVacio();
     
     NodoMVias<K,V>nodoAuxiliar=nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()-1);
        while(!NodoMVias.esNodoVacio(nodoAuxiliar)){
            nodoRetorno=nodoAuxiliar;
            nodoAuxiliar=nodoAuxiliar.getHijo(nodoAuxiliar.cantidadDeClavesNoVacias()-1);
        }
        return nodoRetorno;
    }
    
    public NodoMVias<K,V> buscarNodoDeLaClave(K claveABuscar,Stack<NodoMVias<K,V>> pilaAncestros){
        NodoMVias<K,V> nodoRetorno=NodoMVias.nodoVacio();
         if(esArbolVacio()){
            return null;
        }
        NodoMVias<K,V>nodoActual=this.raiz;  
            while(!NodoMVias.esNodoVacio(nodoActual)){
                boolean sw=false;
                for(int i=0;sw==false && i<nodoActual.cantidadDeClavesNoVacias();i++){
                    K claveActual=nodoActual.getClave(i);
                        if(claveActual.compareTo(claveABuscar)==0){
                            return nodoActual;
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
     
        return nodoRetorno;
    
    }
    
}
