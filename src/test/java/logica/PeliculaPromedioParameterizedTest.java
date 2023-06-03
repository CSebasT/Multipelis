package logica;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
//David
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
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{1L,4});
        objects.add(new Object[]{"0002",0});//Ref
        //objects.add(new Object[]{"No existe",0});
        return objects;
    }

    public PeliculaPromedioParameterizedTest(Long codigoGenero, double expected) {
        this.codigoGenero = codigoGenero;
        this.expected = expected;
    }

    @Test
    public void given_genre_when_points_average_then_ok() {
        double promedio = gestorPelicula.obtenerPuntajePromedioGenero(codigoGenero);
        assertEquals(expected,promedio, 0);
    }


}