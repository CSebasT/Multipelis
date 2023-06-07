package logica;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class PeliculaPromedioParameterizedTest {
    private Long codigoGenero;
    private double expected;
    private GestorPelicula gestorPelicula;

    @Before
    public void setUp(){
        gestorPelicula = new GestorPelicula();
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {1L,3.375},{2L,3.000},{3L,3.875}
        });
    }

    public PeliculaPromedioParameterizedTest(Long codigoGenero, double expected) {
        this.codigoGenero = codigoGenero;
        this.expected = expected;
    }

    @Test
    public void given_genre_when_points_average_then_ok() {
        double promedio = gestorPelicula.obtenerPuntajePromedioGenero(codigoGenero);
        assertEquals(expected,promedio, 0.01);
    }
}



