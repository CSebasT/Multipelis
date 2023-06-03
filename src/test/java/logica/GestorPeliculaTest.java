package logica;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

//Cesar
public class GestorPeliculaTest {
    private static GestorPelicula gestorPelicula = null;

    @BeforeClass
    public static void setUpClass(){
        gestorPelicula = new GestorPelicula();
    }

    @Test
    public void given_year_when_verify_then_ok() {
        boolean esValido = gestorPelicula.verificarAño(2010);
        assertTrue(esValido);
    }

    @Test
    public void given_genre_when_duration_average_then_ok() {
        int duracion = gestorPelicula.obtenerDuracionPromedioGenero(1L);
        assertEquals(100,duracion);
    }

    @Test
    public void given_title_when_search_then_ok() {
        Object objeto = gestorPelicula.buscarPelicula("Mi película");
        assertNotNull(objeto);
    }
}