
package mx.com.gm.peliculas.excepciones;

public class LecturaDatosException extends AccesoDatosException{
    //contructor con un argumento String que envia el mensaje que queremos que se muestre
    //al haber una excepcion de este tipo
    public LecturaDatosException(String mensaje){
        //el mensaje lo enviamos al constructor de la clase padre.
        super(mensaje);
    }
}
