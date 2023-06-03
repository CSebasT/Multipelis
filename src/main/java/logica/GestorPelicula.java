package logica;

import java.util.Calendar;
import java.util.List;
import persistencia.PersistenciaPelicula;

public class GestorPelicula {

    public double obtenerPuntajePromedioGenero(Long codigoGenero){
        List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas(codigoGenero);
        double puntaje = 0;
        double promedio = 0;
        double numeroElementos = 0;
        for(Pelicula pelicula : peliculas){
            if(pelicula.getGenero().getCodigo() == codigoGenero){
                puntaje += pelicula.getPuntaje().getPuntajeTotal();
                numeroElementos++;
            }
        }
        promedio = (puntaje/numeroElementos);
        return promedio;
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
        Calendar fechaActual = Calendar.getInstance();
        if (año<=fechaActual.get(Calendar.YEAR)){

        }
        return true;
    }

}
