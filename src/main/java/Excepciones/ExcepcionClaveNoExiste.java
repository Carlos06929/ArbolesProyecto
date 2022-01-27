
package Excepciones;


public class ExcepcionClaveNoExiste extends Exception {
    public ExcepcionClaveNoExiste(){
        super("La clave que ingreso no existe");
    }
    
    public ExcepcionClaveNoExiste(String mensaje){
        super(mensaje);
    }
}
