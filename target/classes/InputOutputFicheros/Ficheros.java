/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputOutputFicheros;

import java.io.*;
import ArbolesBInarios.*;
import com.mycompany.proyecto1videoclub1.Pelicula;


/**
 *
 * @author Usuario
 */
public class Ficheros {
    public void Ficheros(){
    
    }
    
    public void escribirFicheroABB(IArbolBusqueda<Integer,Pelicula> arbol){
     //C:/Users/Usuario/Desktop/Archivos_Proyecto/   
    try(ObjectOutputStream fichero1 = new ObjectOutputStream(new FileOutputStream("Archivos_Arboles/ABB.txt"))){
            fichero1.writeObject(arbol);
            fichero1.close();
        } catch(EOFException e){
            }
            catch(IOException e){
            }
    }
    
    public void escribirFicheroAVL(IArbolBusqueda<Integer,Pelicula> arbol){
    try(ObjectOutputStream fichero1 = new ObjectOutputStream(new FileOutputStream("Archivos_Arboles/AVL.txt"))){
            fichero1.writeObject(arbol);
            fichero1.close();
        } catch(EOFException e){
            }
            catch(IOException e){
            }
    }
    
    public void escribirFicheroMV(IArbolBusqueda<Integer,Pelicula> arbol){
    try(ObjectOutputStream fichero1 = new ObjectOutputStream(new FileOutputStream("Archivos_Arboles/MVias.txt"))){           
        fichero1.writeObject(arbol);
            fichero1.close();
        } catch(EOFException e){
            }
            catch(IOException e){
            }
    }
    
    public void escribirFicheroAB(IArbolBusqueda<Integer,Pelicula> arbol){
     //C:/Users/Usuario/Desktop/Archivos_Proyecto/   
    try(ObjectOutputStream fichero1 = new ObjectOutputStream(new FileOutputStream("Archivos_Arboles/AB.txt"))){
        System.out.println(arbol);
            fichero1.writeObject(arbol);
            fichero1.close();
        } catch(EOFException e){
            }
            catch(IOException e){
            }
    }
    
    public IArbolBusqueda<Integer,Pelicula> leerFicheroABB(IArbolBusqueda<Integer,Pelicula> arbol){
        //C:/Users/Usuario/Desktop/Archivos_Proyecto/
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("Archivos_Arboles/ABB.txt"))){
               arbol=(ArbolBinarioBusqueda<Integer, Pelicula>)fichero.readObject();
               fichero.close();
            }catch(ClassNotFoundException | IOException e ){}
        return arbol;
    }
    public IArbolBusqueda<Integer,Pelicula> leerFicheroAVL(IArbolBusqueda<Integer,Pelicula> arbol){
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("Archivos_Arboles/AVL.txt"))){
               arbol=(AVL<Integer, Pelicula>)fichero.readObject();
               fichero.close();
            }catch(ClassNotFoundException | IOException e ){}
        return arbol;
    }
    
    public IArbolBusqueda<Integer,Pelicula> leerFicheroMV(IArbolBusqueda<Integer,Pelicula> arbol){
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("Archivos_Arboles/MVias.txt"))){
               arbol=(MVias<Integer, Pelicula>)fichero.readObject();
               fichero.close();
            }catch(ClassNotFoundException | IOException e ){}
        return arbol;
    }
    
    public IArbolBusqueda<Integer,Pelicula> leerFicheroAB(IArbolBusqueda<Integer,Pelicula> arbol){
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("Archivos_Arboles/AB.txt"))){
               arbol=(ArbolB<Integer, Pelicula>)fichero.readObject();
               System.out.println(arbol);
               fichero.close();
            }catch(ClassNotFoundException | IOException e ){}
        return arbol;
    }
    
    public boolean existeArbol(int i){
        File archivo=null;
        switch (i) {
            case 1:
                archivo=new File("Archivos_Arboles/ABB.txt");
                break;
            case 2:
                archivo=new File("Archivos_Arboles/AVL.txt");
                break;
            case 3:
                archivo=new File("Archivos_Arboles/MVias.txt");
                break;
            case 4:
                archivo=new File("Archivos_Arboles/AB.txt");
                break;
            default:
                break;
        }
         return archivo.exists();
    }
}
