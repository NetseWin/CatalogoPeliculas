
package mx.com.gm.peliculas.domain;

public class Pelicula {
    private String nombre;
    
    //constructor vacio
    public Pelicula(){
        
    }
    //constructor con un argumento que inicializa el nombre de la pelicula
    public Pelicula(String nombre){
        this.nombre = nombre;
    }
    //metodo que muestra el nombre
    public String getNombre() {
        return nombre;
    }
    //metodo que modifica el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
    
}
