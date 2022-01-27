/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBInarios;

import com.mycompany.proyecto1videoclub1.Director;
import com.mycompany.proyecto1videoclub1.Pelicula;

import java.util.*;


/**
 *
 * @author Usuario
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int i=12312;
        System.out.println("dedewfcewrsd"+i);
        
        IArbolBusqueda<Integer,Libro> arbol=new ArbolBinarioBusqueda<>();
        Autor[] vectorAutores;
        Libro l1=new Libro();
        Autor a1=new Autor();
        List<Autor> lAutores=new LinkedList<>();
        
        
        
        a1.setNombre("Vaca Pinto");
        a1.setNacionalidad("Boliviano");
        lAutores.add(a1);
        a1.setNombre("Mollo");
        a1.setNacionalidad("Mexicano");
        lAutores.add(a1);
        l1.setTitulo("Programacion 1");
        l1.setAutores(lAutores);
        l1.setDescripcion("La programación es el proceso de creación de programas informáticos. Esta definición se puede interpretar de la siguiente manera. "
                + "La programación no es más que una explicación a la computadora de qué, en qué forma y cómo llegar al usuario");
        l1.setEdicion("2020");
        l1.setIdioma("Español");
        l1.setnPaginas(500);  
        l1.setAutores(lAutores);
        arbol.insertar(1,l1);
        System.out.println(arbol.llenarListaValores(arbol.recorridoInorden()));
        lAutores.clear();
        
        
        
        
        a1.setNombre("Miranda");
        a1.setNacionalidad("Boliviano");
        lAutores.add(a1);
        l1.setTitulo("Lenguajes formales");
        l1.setAutores(lAutores);
        l1.setDescripcion("La teoria de automatas y formales se utiliza para la construccion de compiladores");
        l1.setEdicion("1990");
        l1.setIdioma("Ingles");
        l1.setnPaginas(995);   
        l1.setAutores(lAutores);
        arbol.insertar(2, l1);
        lAutores.clear();
        
        a1.setNombre("Vallet");
        a1.setNacionalidad("canadiense");
        lAutores.add(a1);
        a1.setNombre("valentin");
        a1.setNacionalidad("mexicano");
        lAutores.add(a1);
        a1.setNombre("angelica Garzon");
        a1.setNacionalidad("Boliviana");
        lAutores.add(a1);
        l1.setTitulo("Programacion Ensamblador");
        l1.setAutores(lAutores);
        l1.setDescripcion("programacion de bajo nivel de usando librerias de lcnguaje de programacion c++");
        l1.setEdicion("2006");
        l1.setIdioma("Ingles");
        l1.setnPaginas(800);        
        arbol.insertar(3, l1);
        lAutores.clear();
        
        a1.setNombre("gino Barroso");
        a1.setNacionalidad("Brasileño");
        lAutores.add(a1);
        l1.setTitulo("Estructuras de datos 2 en java");
        l1.setAutores(lAutores);
        l1.setDescripcion("Estructuras de datos gerarquicas");
        l1.setEdicion("2015");
        l1.setIdioma("Español");
        l1.setnPaginas(540);        
        arbol.insertar(4, l1);
        lAutores.clear();lAutores.clear();
        
        a1.setNombre("Zuna villagomes");
        a1.setNacionalidad("Boliviana");
        lAutores.add(a1);
         a1.setNombre("Percy Tapia");
        a1.setNacionalidad("Ecuatoriano");
        lAutores.add(a1);
        l1.setTitulo("Introduccion a la informatica");
        l1.setAutores(lAutores);
        l1.setDescripcion("Introduccion al desarollo de algoritimos atravez de diagramas de flujos y pseudocodigos");
        l1.setEdicion("2011");
        l1.setIdioma("Español");
        l1.setnPaginas(300);        
        arbol.insertar(5, l1);
        lAutores.clear();
        
        a1.setNombre("Veixaga Ajuacho");
        a1.setNacionalidad("Boliviano");
        lAutores.add(a1);
        l1.setTitulo("Programacion2");
        l1.setAutores(lAutores);
        l1.setDescripcion("Es el avnace y desarollo de la recursion y algoritmos de busqueda");
        l1.setEdicion("1991");
        l1.setIdioma("Frances");
        l1.setnPaginas(350);        
        arbol.insertar(6, l1);
        lAutores.clear();
        
        a1.setNombre("Molina");
        a1.setNacionalidad("Inglesa");
        lAutores.add(a1);
        a1.setNombre("Oropeza Claure");
        a1.setNacionalidad("Canadiense");
        lAutores.add(a1);
        l1.setTitulo("ingles");
        l1.setAutores(lAutores);
        l1.setDescripcion("El apre4dixaje del idioma ingles para poder desarrollarse mejor en el manejo de las computadoras");
        l1.setEdicion("1900 ac");
        l1.setIdioma("Ingles");
        l1.setnPaginas(600);        
        arbol.insertar(7, l1);
        lAutores.clear();
        System.out.println(arbol.llenarListaValores(arbol.recorridoInorden()));
        System.out.println(arbol.recorridoInorden());
        */
        
//        IArbolBusqueda<Integer,Libro> arbol=new ArbolBinarioBusqueda();
//        
//        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("C:/Users/Usuario/Desktop/Archivos_Proyecto/ABB.txt"))){
//               arbol=(ArbolBinarioBusqueda<Integer, Libro>)fichero.readObject();
//               fichero.close();
//            }catch(ClassNotFoundException | IOException e ){}
//        
//        System.out.println(arbol.recorridoInorden());
 
//        a1.insertar(30,"Fernando");
//        a1.insertar(59,"Roberto");
//        a1.insertar(20, "Juan");
//        a1.insertar(65,"Miguel");
//        a1.insertar(10,"Fabricio");
//        a1.insertar(24,"Celia");
//        a1.insertar(94,"Roxana");
//        a1.insertar(22,"Joel");
//        a1.insertar(1, "Manuel");
//        a1.insertar(25,"Jessica");
//        a1.insertar(50,"Maria");
//        a1.insertar(60,"Ricardo");
//       
//        
//        
//        
//       IArbolBusqueda a5=new ArbolBinarioBusqueda();
//        a5.insertar(30, 1);
//        a5.insertar(59, 2);
//        a5.insertar(20, 3);
//        a5.insertar(65, 4);
//        a5.insertar(10, 5);
//        a5.insertar(24, 6);
//        a5.insertar(94, 7);
//        a5.insertar(22, 8);
//        
//        IArbolBusqueda a6=new AVL();
//        a5.insertar(30, 1);
//        a5.insertar(59, 2);
//        a5.insertar(20, 3);
//        a5.insertar(65, 4);
//        a5.insertar(10, 5);
//        a5.insertar(24, 6);
//        a5.insertar(94, 7);
//        a5.insertar(22, 8);
//       
//        
//        Scanner entrada=new Scanner(System.in);
//        Scanner datos=new Scanner(System.in);
//        System.out.println("                            SELECCION EL NUMERO DE PREGUNTA QUE DESEE");
//        System.out.println("1:TODOS LOS METODOS DE LA INTERFAZ IMPLEMENTADOS");
//        System.out.println("2:PREGUNTA 2");
//        System.out.println("3:PREGUNTA 3");
//        System.out.println("4:PREGUNTA 4");
//        System.out.println("5:PREGUNTA 5");
//        System.out.println("6:PREGUNTA 6");
//        System.out.println("7:PREGUNTA 7");
//        System.out.println("8:PREGUNTA 8");
//        System.out.println("9:PREGUNTA 9");
//        System.out.println("9:PREGUNTA 10");
//        System.out.println("9:PREGUNTA 11");
//        System.out.println("9:SALIR");
//        System.out.println("\nRECORRIDO POR NIVELES ARBOL PRINCIPAL: "+ a1.recorridoPorNiveles());
//        System.out.println("\nRECORRIDO IN ORDEN ARBOL PRINCIPAL: "+ a1.recorridoInorden());
//        int numeroPregunta;
//        boolean a=true;
//        
//           int x=0; 
//            System.out.print("\nIngrese una Opcion: ");
//            numeroPregunta=entrada.nextInt();System.out.println("");
//            
//        switch(numeroPregunta){
//            case 1:
//                System.out.println("TENGO LOS METODOS IMPLEMENTADOS POR FAVOR VERIFIQUE LOS CODIGOS EN SU RESPECTIVA CLASE");
//                break;
//                
//            case 2:
//                System.out.println("CANTIDAD DE NODOS CON SOLO HIJOS IZQUIERDOS EN UN ARBOL BINARIO RECURSIVO: "+((ArbolBinarioBusqueda)a1).cantidadenodosConsoloHijosIzquierdosRec());
//                 break;   
//                 
//             case 3:
//                 System.out.println("CANTIDAD DE NODOS CON SOLO HIJOS IZQUIERDOS ITERATIVO: "+((ArbolBinarioBusqueda)a1).cantidadNodosConSoloHI());
//                 break;
//                 
//             case 4:
//                 System.out.print("INGRESE EL NIVEL EN EL QUE BUSCAR : ");
//                 int niv=datos.nextInt();
//                 System.out.println("CAMTIDAD DE NODOS CON SOLO HIJOS IZQUIERDOS EN EL NIVEL N:  "+((ArbolBinarioBusqueda)a1).cantidadNodosConSoloHIenNivelRec(niv));
//                 break;
//                 
//             case 5:
//                 System.out.print("INGRESE EL NIVEL DONDE SE BUSCARA : ");
//                 x=datos.nextInt();
//                 System.out.println("CANTIDAD DE NODOS CON SOLO HIJOS IZQUIERDOS DESPUES DEL NIVEL N:  "+((ArbolBinarioBusqueda)a1).cantidadNodosConSoloHIdespuesNivel(x));
//                 break;
//                 
//             case 6:
//                 System.out.print("INGRESE EL NIVEL DONDE SE BUSCARA : ");
//                 x=datos.nextInt();
//                 System.out.println("CANTIDAD DE NODOS CON SOLO HIJOS IZQUIERDOS ANTES DEL NIVEL N:  "+((ArbolBinarioBusqueda)a1).cantidadNodosConSoloHIantesNivel(x));
//                 break;
//                 
//             case 7:
//                 System.out.println("RECORRIDO POR NIVELES ARBOL 1: "+ a1.recorridoPorNiveles());
//                 System.out.println("RECORRIDO POR NIVELES ARBOL 2: "+ a5.recorridoPorNiveles());
//                 System.out.println("RECORRIDO POR NIVELES ARBOL 3: "+ a1.recorridoPorNiveles());
//                 System.out.println("VERDADERO SI ARBOL 1 ES SIMILAR A ARBOL 2"+((ArbolBinarioBusqueda)a1).arbolesSimilars((ArbolBinarioBusqueda)a5));
//                 System.out.println("VERDADERO SI ARBOL 1 ES SIMILAR A ARBOL 3"+((ArbolBinarioBusqueda)a1).arbolesSimilars((ArbolBinarioBusqueda)a5));
//                 break;
//                 
//             case 8:
//                 System.out.println("METODO ELIMINAR DE UN ARBOL AVL");
//                 System.out.println("RECORRIDO POR NIVELES ARBOL AVL: "+ a6.recorridoPorNiveles());
//                 System.out.println("ELIMINAR LA CLAVE 10 DEL ARBOL AVL"+a6.eliminar(10));
//                 System.out.println("RECORRIDO POR NIVELES ARBOL AVL SIN LA CLAVE 10: "+ a6.recorridoPorNiveles());
//                 break;
//                
//             case 9:
//                 System.out.print("INGRESE EL NIVEL DESDE DONDE SE BUSCARA: ");
//                 x=datos.nextInt();
//                 System.out.println("CANTIDAD DE NODOS COMPLETOS DESDE EL NIVEL N:  "+((ArbolBinarioBusqueda)a1).cantidadNodosCompletosdespuesNivel(x));
//                 break;
//            case 10:
//                 System.out.println("NO DISPONIBLE");
//                 break;
//            case 11:
//                 System.out.println("METODO QUE RETORNA VERDADERO SI EL ARBOL ES LLENO :    "+((ArbolBinarioBusqueda)a1).arbolLleno());
//                 break;    
//            case 12:
//                 a=false;
//                 break;
//                 
//             default :
//                 System.out.println("ingrese una opcion valida");
//                 
//        }
//         
//         System.out.println("\n\n\n\n\n\n");
//            System.out.println("                            SELECCION EL NUMERO DE PREGUNTA QUE DESEE");
//        System.out.println("1:TODOS LOS METODOS DE LA INTERFAZ IMPLEMENTADOS");
//        System.out.println("2:PREGUNTA 2");
//        System.out.println("3:PREGUNTA 3");
//        System.out.println("4:PREGUNTA 4");
//        System.out.println("5:PREGUNTA 5");
//        System.out.println("6:PREGUNTA 6");
//        System.out.println("7:PREGUNTA 7");
//        System.out.println("8:PREGUNTA 8");
//        System.out.println("9:PREGUNTA 9");
//        System.out.println("\nRECORRIDO POR NIVELES ARBOL PRINCIPAL: "+ a1.recorridoPorNiveles());
//        System.out.println("\nRECORRIDO IN ORDEN ARBOL PRINCIPAL: "+ a1.recorridoInorden());
//        }
//    

//IArbolBusqueda<Integer,String> a6=new AVL<>();
//        a6.insertar(30, "ds");
//        a6.insertar(20, "654");
//        a6.insertar(65,"87");
//        a6.insertar(69,"658");
//       a6.insertar(82, "984");
//        a6.insertar(66, "ef");
////        a6.insertar(96, 8);
//        System.out.println(a6.recorridoPorNiveles());
    }
    
    }
    
