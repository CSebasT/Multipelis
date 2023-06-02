package logica;

import java.util.List;
import persistencia.PersistenciaPelicula;

public class GestorPelicula {

    public double obtenerPuntajePromedioGenero(Long codigoGenero){
        List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas(codigoGenero);
        int promedio = 0;
        int cantidad = 0;
        for(Pelicula pelicula : peliculas){
            if(pelicula.getGenero().getCodigo() == codigoGenero){
                promedio += pelicula.getPuntaje().getPuntajeTotal();
                cantidad++;
            }
        }

        return 0;
    }

    public int contarPeliculasGenero(Long codigoGenero){
        List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas(codigoGenero);
        int contadorPeliculas = 0;
        for(Pelicula pelicula : peliculas){
            if(pelicula.getGenero().getCodigo() == codigoGenero){
                contadorPeliculas++;
            }
        }
        return contadorPeliculas;
    }

    public int obtenerDuracionPromedioGenero(Long codigoGenero){

        return 100;
    }

    public void registrarPelicula(){

    }


    public boolean verificarAño(int año){

        return true;
    }

}
