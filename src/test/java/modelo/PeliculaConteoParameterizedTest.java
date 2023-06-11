package modelo;

import modelo.logica.GestorPelicula;
import modelo.logica.Pelicula;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class PeliculaConteoParameterizedTest {
    private final Long codigoGenero;
    private final int expected;
    private GestorPelicula gestorPelicula;
    private List<Pelicula> peliculas = null;

    @Before
    public void setUp(){
        gestorPelicula = new GestorPelicula();
        peliculas = gestorPelicula.buscarPeliculas();
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {1L,8},{2L,3},{3L,4}
        });
    }

    public PeliculaConteoParameterizedTest(Long codigoGenero, int expected) {
        this.codigoGenero = codigoGenero;
        this.expected = expected;
    }

    @Test
    public void given_genre_when_points_average_then_ok() {
        int cantidadActual = gestorPelicula.contarPeliculasGenero(codigoGenero,peliculas);
        assertEquals(expected,cantidadActual);
    }

}