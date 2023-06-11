package modelo;

import modelo.logica.GestorPelicula;
import modelo.logica.Pelicula;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class GestorPeliculaTest {
    private GestorPelicula gestorPelicula = null;
    private List<Pelicula> peliculas = null;

    @Before
    public void setUp() {
        gestorPelicula = new GestorPelicula();
        peliculas = gestorPelicula.buscarPeliculas();
        System.out.println(peliculas.get(0).getGenero());
    }

    @Test
    public void given_genre_when_duration_average_then_ok() {
        assertEquals(50, gestorPelicula.obtenerDuracionPromedioGenero(1L, peliculas));
    }

    @Test
    public void given_genre_when_get_top_3_then_ok() {
        String[] titulosPeliculasEsperadas = new String[]{"El gato con botas","¿Qué pasó ayer?", "Los Simpson: La película"};
        List<Pelicula> mejoresPeliculas = gestorPelicula.obtenerTresMejoresPeliculasGenero(3L, peliculas);
        String[] titulosMejoresPeliculas = new String[3];
        for (int i = 0; i < 3; i++) {
            titulosMejoresPeliculas[i] = mejoresPeliculas.get(i).getTitulo();
        }
        assertArrayEquals(titulosPeliculasEsperadas,titulosMejoresPeliculas);
    }

    @Test
    public void given_year_when_verify_year_then_ok() {
        assertTrue(gestorPelicula.verificarAño(2010));
    }

    @Test(timeout=6000)
    public void given_title_when_search_then_ok() {
        assertNotNull(gestorPelicula.buscarPelicula("Mi película"));
    }
}