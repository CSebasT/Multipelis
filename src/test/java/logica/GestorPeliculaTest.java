package logica;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestorPeliculaTest {

    @Test
    public void given_year_when_verify_then_ok() {
        GestorPelicula gestorPelicula = new GestorPelicula();
        boolean esValido = gestorPelicula.verificarAño(2010);
        assertTrue(esValido);
    }

    @Test
    public void given_year_when_verify_then_error() {
        GestorPelicula gestorPelicula = new GestorPelicula();
        boolean esValido = gestorPelicula.verificarAño(3040);
        assertFalse(esValido);
    }

    @Test
    public void given_genre_when_duration_average_then_ok() {
        GestorPelicula gestorPelicula = new GestorPelicula();
        int duracion = gestorPelicula.obtenerDuracionPromedioGenero(1L);
        assertEquals(100,duracion);
    }

    @Test
    public void given_genre_when_duration_average_then_error() {
        GestorPelicula gestorPelicula = new GestorPelicula();
        int duracion = gestorPelicula.obtenerDuracionPromedioGenero(1L);
        assertNotEquals(-1,duracion);
    }

}