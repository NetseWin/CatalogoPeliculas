package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;
import mx.com.gm.peliculas.excepciones.EscrituraDatosException;
import mx.com.gm.peliculas.excepciones.LecturaDatosException;

public interface AccesoDatos {
    
    String nombreArchivo = "pelicula.txt";
    
    public abstract boolean existe()throws LecturaDatosException;
    
    public abstract List<Pelicula> listar() throws LecturaDatosException;
    
    public abstract void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosException;
    
    public abstract String buscar( String buscar) throws LecturaDatosException;
    
    public abstract void crear() throws AccesoDatosException;
    
    public abstract void borrar() throws AccesoDatosException;
}
