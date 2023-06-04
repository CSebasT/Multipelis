package logica;

import org.junit.BeforeClass;
import org.junit.Test;
import persistencia.PersistenciaPelicula;

import static org.junit.Assert.*;

public class PeliculaTest {
    private static Pelicula pelicula = null;

    @BeforeClass
    public static void setUpClass(){
        pelicula = PersistenciaPelicula.consultarPelicula("0001");
    }

    @Test
    public void given_pelicula_when_verify_replacement_then_false() {
        assertFalse(pelicula.verificarNecesidadDeEjemplares());
    }
}