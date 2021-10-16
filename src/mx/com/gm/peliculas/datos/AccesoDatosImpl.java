package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;
import mx.com.gm.peliculas.excepciones.EscrituraDatosException;
import mx.com.gm.peliculas.excepciones.LecturaDatosException;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe() throws LecturaDatosException {
        File file = new File(AccesoDatos.nombreArchivo);

        if (file.exists()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Pelicula> listar() throws LecturaDatosException {
        List<Pelicula> peliculas = new ArrayList<>();
        File file = new File(AccesoDatos.nombreArchivo);
        FileReader fr = null; // se crea instancia del obj. FileReader
        BufferedReader br = null; // se crea instancia del obj. BufferedReader

        try {
            br = new BufferedReader(new FileReader(file));
            //lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosException("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosException("Excepcion al listar peliculas: " + ex.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.err.println("Error al intentar cerrar el archivo");
                }
            }
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosException {
        java.io.PrintWriter salida = null;
        try {
            File file = new File(AccesoDatos.nombreArchivo);
            salida = new PrintWriter(new FileWriter(file, anexar));
            salida.println(pelicula.toString());
            System.out.println("Se ha escrito informacion al archivo: " + pelicula.toString());
        } catch (IOException ex) {
           ex.printStackTrace();
           throw new EscrituraDatosException("Error al escribir  peliculas: "+ ex.getMessage());
        } finally {
            salida.close();
        }
    }

    @Override
    public String buscar( String buscar) throws LecturaDatosException {
        List<Pelicula> peliculas = listar();
        String resultado = null;
       
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getNombre().equalsIgnoreCase(buscar) && buscar != null){
                resultado = "Pelicula " + pelicula + " encontrada en el indice: "+ peliculas.indexOf(pelicula);
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear() throws AccesoDatosException {
        //se crea una instrancia del obj File y se le pasa por argumento el obj String con el nombre del archivo
        File file = new File(AccesoDatos.nombreArchivo);
        //si el archivo no existe sera creado.
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new AccesoDatosException("Error al crear archivo " + ex.getMessage());
            }
        }
    }

    @Override
    public void borrar() throws AccesoDatosException {
        File file = new File(AccesoDatos.nombreArchivo);
        if (file.exists()) {
            boolean estado = file.delete();
            if (!estado) {
                System.out.println("Error el archivo no pudo ser eliminado.");
            } else {
                System.out.println("Archivo eliminado exitosamente.");
            }
        } else {
            throw new AccesoDatosException("Error al tratar de eliminar el archivo");
        }
    }

}
