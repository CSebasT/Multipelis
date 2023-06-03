package logica;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

//Cesar
public class GestorPeliculaTest {
    private GestorPelicula gestorPelicula = null;

    @Before
    public void setUpClass() {
        gestorPelicula = new GestorPelicula();
    }

    @Test
    public void given_year_when_verify_year_then_ok() {
        boolean esValido = gestorPelicula.verificarAño(2010);
        assertTrue(esValido);
    }

    @Test
    public void given_genre_when_duration_average_then_ok() {
        int duracion = gestorPelicula.obtenerDuracionPromedioGenero(1L);
        assertEquals(50, duracion);
    }

    @Test
    public void given_genre_when_get_top_3_then_ok() {
        String[] titulosPeliculasEsperadas = new String[]{"El gato con botas","¿Qué pasó ayer?", "Los Simpson: La película"};
        List<Pelicula> mejoresPeliculas = gestorPelicula.obtenerTresMejoresPeliculasGenero(3l);
        String[] titulosMejoresPeliculas = new String[3];
        for (int i = 0; i < 3; i++) {
            titulosMejoresPeliculas[i] = mejoresPeliculas.get(i).getTitulo();
        }
        assertArrayEquals(titulosPeliculasEsperadas,titulosMejoresPeliculas);
    }
    @Test
    public void given_title_when_search_then_ok() {
        Object objeto = gestorPelicula.buscarPelicula("Mi película");
        assertNotNull(objeto);
    }
}