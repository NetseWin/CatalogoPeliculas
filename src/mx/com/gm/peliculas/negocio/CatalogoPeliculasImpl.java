
package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;
import mx.com.gm.peliculas.excepciones.EscrituraDatosException;
import mx.com.gm.peliculas.excepciones.LecturaDatosException;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
       this. datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
         boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (EscrituraDatosException ex) {
             System.err.println("Error de acceso a datos");
        } catch (LecturaDatosException ex) {
            System.err.println("Error de acceso a datos");
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (LecturaDatosException ex) {
            System.err.println("Error de acceso a datos");
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);
                    
        } catch (LecturaDatosException ex) {
            System.out.println("Error de acceso datos en el metodo buscar pelicula");
            ex.printStackTrace();
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }} catch (LecturaDatosException ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
        } catch (AccesoDatosException ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
        }
    }
}
