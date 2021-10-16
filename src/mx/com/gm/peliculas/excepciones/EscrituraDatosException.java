
package mx.com.gm.peliculas.excepciones;

public class EscrituraDatosException  extends AccesoDatosException{
    // creamos el constructor que recibe un string de nombre mensaje, que 
    //hace referencia al mensaje que queremos que muestre al arrojar esta exception
    public EscrituraDatosException(String mensaje){
        //mensaje enviado al constructor de la clase padre.
        super(mensaje);
    }
}
