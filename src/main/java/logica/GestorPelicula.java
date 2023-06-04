package logica;

import java.util.*;

import persistencia.PersistenciaPelicula;

public class GestorPelicula {
    //ANTES
    //public double obtenerPuntajePromedioGenero(Long codigoGenero) {
    //    List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
    //    double puntaje = 0;
    //    double promedio = 0;
    //    double numeroElementos = 0;
    //    for (Pelicula pelicula : peliculas) {
    //        if (pelicula.getGenero().getCodigo() == codigoGenero) {
    //            puntaje += pelicula.getPuntaje().getPuntajeTotal();
    //            numeroElementos++;
    //        }
    //    }
    //    promedio = (puntaje / numeroElementos);
    //    return promedio;
    //}

    //DESPUES
    //ANTES DEL REFACTOR
    //public double obtenerPuntajePromedioGenero(Long codigoGenero) {
    //    double puntaje = 0;
    //    double promedio = 0;
    //    double numeroElementos = 0;
    //    List<Pelicula> peliculas = obtenerPeliculasMismoGenero(codigoGenero);
    //    for(Pelicula pelicula:peliculas){
    //       puntaje += pelicula.getPuntaje().getPuntajeTotal();
    //        numeroElementos++;
    //    }
    //    promedio = (puntaje / numeroElementos);
    //    return promedio;
    //}

    //DESPUES DEL REFACTOR
    public double obtenerPuntajePromedioGenero(Long codigoGenero) {
        double puntaje = 0;
        double promedio = 0;
        double numeroElementos = 0;
        List<Pelicula> peliculas = obtenerPeliculasMismoGenero(codigoGenero);
        for(Pelicula pelicula:peliculas){
            puntaje += pelicula.getPuntaje().getPuntajeTotal();
            numeroElementos++;
        }
        return (puntaje / numeroElementos);
    }

    //ANTES
    //public int contarPeliculasGenero(Long codigoGenero) {
    //    List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
    //    int contadorPeliculas = 0;
    //    for (Pelicula pelicula : peliculas) {
    //        if (pelicula.getGenero().getCodigo() == codigoGenero) {
    //            contadorPeliculas++;
    //        }
    //    }
    //    return contadorPeliculas;
    //}


    //DESPUES
    public int contarPeliculasGenero(Long codigoGenero) {
        List<Pelicula> peliculas = obtenerPeliculasMismoGenero(codigoGenero);
        int contadorPeliculas = 0;
        for (Pelicula pelicula : peliculas) {
            contadorPeliculas++;
        }
        return contadorPeliculas;
    }


    //ANTES
    //public int obtenerDuracionPromedioGenero(Long codigoGenero) {
    //    List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
    //    int duracionTotal = 0;
    //    int duracionPromedio;
    //    int numeroElementos = 0;
    //    for (Pelicula pelicula : peliculas) {
    //        if (pelicula.getGenero().getCodigo() == codigoGenero) {
    //            duracionTotal += pelicula.getDuracion();
    //            numeroElementos++;
    //        }
    //    }
    //    if (numeroElementos == 0) {
    //        return 0;
    //    }
    //    duracionPromedio = (duracionTotal / numeroElementos);
    //    return duracionPromedio;
    //}

    //DESPUES
    //ANTES DEL REFACTOR INLINE TEMP
    //public int obtenerDuracionPromedioGenero(Long codigoGenero) {
    //    int duracionTotal = 0;
    //    int duracionPromedio;
    //    int numeroElementos = 0;
    //    List<Pelicula> peliculas = obtenerPeliculasMismoGenero(codigoGenero);
    //    for (Pelicula pelicula : peliculas) {
    //        duracionTotal += pelicula.getDuracion();
    //        numeroElementos++;
    //    }
    //    if (numeroElementos == 0) {
    //        return 0;
    //    }
    //    duracionPromedio = (duracionTotal / numeroElementos);
    //    return duracionPromedio;
    //}

    //DESPUES DEL REFACTOR
    public int obtenerDuracionPromedioGenero(Long codigoGenero) {
        int duracionTotal = 0;
        int duracionPromedio;
        int numeroElementos = 0;
        List<Pelicula> peliculas = obtenerPeliculasMismoGenero(codigoGenero);
        for (Pelicula pelicula : peliculas) {
            duracionTotal += pelicula.getDuracion();
            numeroElementos++;
        }
        if (numeroElementos == 0) {
            return 0;
        }
        return (duracionTotal / numeroElementos);
    }



    //ANTES
    //public List<Pelicula> obtenerTresMejoresPeliculasGenero(Long codigoGenero) {
    //    List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
    //    List<Pelicula> mejoresPeliculas = new ArrayList<Pelicula>();
    //    for (Pelicula pelicula : peliculas) { //Obtener de un pelis de un genero puede ser un extract method y reemplazar en los otros métodos
    //        if (pelicula.getGenero().getCodigo() == codigoGenero) {
    //            mejoresPeliculas.add(pelicula);
    //        }
    //    }
    //    Collections.sort(mejoresPeliculas, new PeliculaComparadorPorPuntaje());
    //    for (int i=3; i<mejoresPeliculas.size();i++){
    //        mejoresPeliculas.remove(i);
    //    }
    //    return mejoresPeliculas;
    //}

    //DESPUES
    public List<Pelicula> obtenerTresMejoresPeliculasGenero(Long codigoGenero) {
        List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
        List<Pelicula> mejoresPeliculas = new ArrayList<Pelicula>();
        mejoresPeliculas = obtenerPeliculasMismoGenero(codigoGenero);
        Collections.sort(mejoresPeliculas, new PeliculaComparadorPorPuntaje());
        for (int i=3; i<mejoresPeliculas.size();i++){
            mejoresPeliculas.remove(i);
        }
        return mejoresPeliculas;
    }

    //METODO EXTRAIDO
    public List<Pelicula> obtenerPeliculasMismoGenero(Long codigoGenero){
        List<Pelicula> peliculas = PersistenciaPelicula.consultarPeliculas();
        List<Pelicula> listaPeliculasMismoGenero = new ArrayList<Pelicula>();
        for(Pelicula pelicula: peliculas){
            if (pelicula.getGenero().getCodigo() == codigoGenero) {
                listaPeliculasMismoGenero.add(pelicula);
            }
        }
        return listaPeliculasMismoGenero;
    }


    public void registrarPelicula() {

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
}
