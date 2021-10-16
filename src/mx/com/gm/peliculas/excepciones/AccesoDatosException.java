
package mx.com.gm.peliculas.excepciones;
//heredamos de Exception para que el compilador nos indique que debemos 
//encerrar con un bloque try-catch en tiempo de compilacion.
public class AccesoDatosException extends Exception{
    //creamos el constructor que recibe un parametro de tipo String 
    //donde escribiremos el mensaje que queremos que se muestre al 
    //lanzar la excepcion.
    public AccesoDatosException(String mensaje){
        //dicho mensaje lo enviamos al constructor de la clase padre,
        //es decir, al constructor de Exception.
        super(mensaje);
    } 
}
