package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;
import mx.com.gm.peliculas.excepciones.EscrituraDatosException;
import mx.com.gm.peliculas.excepciones.LecturaDatosException;

public interface AccesoDatos {
    
    String nombreArchivo = "pelicula.txt";
    
    public abstract boolean existe(String nombreArchivo)throws LecturaDatosException;
    
    public abstract List<Pelicula> listar(String nombreArchivo) throws LecturaDatosException;
    
    public abstract void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosException;
    
    public abstract String buscar(String nombreArchivo, String buscar) throws LecturaDatosException;
    
    public abstract void crear(String nombreArchivo) throws AccesoDatosException;
    
    public abstract void borrar(String nombreArchivo) throws AccesoDatosException;
}
