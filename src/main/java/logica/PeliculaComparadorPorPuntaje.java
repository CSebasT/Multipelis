package logica;

import java.util.Comparator;

public class PeliculaComparadorPorPuntaje implements Comparator<Pelicula> {


    @Override
    public int compare(Pelicula o1, Pelicula o2) {
        double puntaje1 = o1.getPuntaje().getPuntajeTotal();
        double puntaje2 = o2.getPuntaje().getPuntajeTotal();
        return (puntaje2-puntaje1 >0)? 1:-1;
    }
}
