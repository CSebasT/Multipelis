package logica;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class PeliculaConteoParameterizedTest {
    private Long codigoGenero;
    private int expected;
    private GestorPelicula gestorPelicula;

    @Before
    public void setUp(){
        gestorPelicula = new GestorPelicula();
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {2L,3},{1L,8},{3L,4}
        });
    }

    public PeliculaConteoParameterizedTest(Long codigoGenero, int expected) {
        this.codigoGenero = codigoGenero;
        this.expected = expected;
    }

    @Test
    public void given_genre_when_points_average_then_ok() {
        int cantidadActual = gestorPelicula.contarPeliculasGenero(codigoGenero);
        assertEquals(expected,cantidadActual);
    }

}