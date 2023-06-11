package modelo.logica;

import java.util.*;

import modelo.persistencia.PersistenciaPelicula;

public class GestorPelicula {

    public double obtenerPuntajePromedioGenero(Long codigoGenero,List<Pelicula> peliculas) {
        double puntaje = 0;
        double numeroElementos = 0;
        List<Pelicula> peliculasGenero = obtenerPeliculasMismoGenero(codigoGenero, peliculas);
        for(Pelicula pelicula:peliculasGenero){
            puntaje += pelicula.getPuntaje().getPuntajeTotal();
            numeroElementos++;
        }
        return (puntaje / numeroElementos);
    }

    public int contarPeliculasGenero(Long codigoGenero, List<Pelicula> peliculas) {
        List<Pelicula> peliculasGenero = obtenerPeliculasMismoGenero(codigoGenero, peliculas);
        int contadorPeliculas = 0;
        for (Pelicula pelicula : peliculasGenero) {
            contadorPeliculas++;
        }
        return contadorPeliculas;
    }

    public int obtenerDuracionPromedioGenero(Long codigoGenero,List<Pelicula> peliculas) {
        int duracionTotal = 0;
        int duracionPromedio;
        int numeroElementos = 0;
        List<Pelicula> peliculasGenero= obtenerPeliculasMismoGenero(codigoGenero,peliculas);
        for (Pelicula pelicula : peliculasGenero) {
            duracionTotal += pelicula.getDuracion();
            numeroElementos++;
        }
        if (numeroElementos == 0) {
            return 0;
        }
        return (duracionTotal / numeroElementos);
    }

    public List<Pelicula> obtenerTresMejoresPeliculasGenero(Long codigoGenero, List<Pelicula> peliculas) {
        List<Pelicula> mejoresPeliculas = obtenerPeliculasMismoGenero(codigoGenero, peliculas);
        Collections.sort(mejoresPeliculas, new PeliculaComparadorPorPuntaje());
        for (int i=3; i<mejoresPeliculas.size();i++){
            mejoresPeliculas.remove(i);
        }
        return mejoresPeliculas;
    }

    public List<Pelicula> obtenerPeliculasMismoGenero(Long codigoGenero, List<Pelicula> peliculas){
        //List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();

        List<Pelicula> listaPeliculasMismoGenero = new ArrayList<Pelicula>();
        for(Pelicula pelicula: peliculas){
            if (pelicula.getGenero().getCodigo() == codigoGenero) {
                listaPeliculasMismoGenero.add(pelicula);
            }
        }
        return listaPeliculasMismoGenero;
    }
    public List<Pelicula> buscarPeliculas(){

        return PersistenciaPelicula.consultarPeliculas();
    }

    public boolean verificarAño(int año) {
        Calendar fechaActual = Calendar.getInstance();
        return año <= fechaActual.get(Calendar.YEAR);
    }

    public Pelicula buscarPelicula(String nombrePelicula) {
        List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
        for(Pelicula pelicula: peliculas){
            if (pelicula.getTitulo().equals(nombrePelicula)){
                return pelicula;
            }
        }
        return null;
    }

    public void registrarPelicula(String codigo, String titulo, int duracion,int añoLanzamiento, String sinopsis,Genero genero) {
        if (buscarPelicula(titulo) == null && verificarAño(añoLanzamiento)) {
            Pelicula pelicula = new Pelicula(codigo, titulo, duracion, añoLanzamiento, sinopsis, genero);
            PersistenciaPelicula.registrarPelicula(pelicula);
        }
    }

}
