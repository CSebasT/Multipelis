package logica;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
//Jhon
@RunWith(value = Parameterized.class)
public class PeliculaConteoParameterizedTest {
    private Long codigoGenero;
    private int expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{2L,1});
        objects.add(new Object[]{1L,2});
        return objects;
    }

    public PeliculaConteoParameterizedTest(Long codigoGenero, int expected) {
        this.codigoGenero = codigoGenero;
        this.expected = expected;
    }

    @Test
    public void given_genre_when_points_average_then_ok() {
        GestorPelicula gestorPelicula = new GestorPelicula();
        int cantidadActual = gestorPelicula.contarPeliculasGenero(codigoGenero);
        assertEquals(expected,cantidadActual);
    }

}