package logica;

import org.junit.Test;

import static org.junit.Assert.*;
import org.mockito.Mockito;

public class IComprobradorPeliculasTest {
    @Test
    public void given_real_title_when_verify_then_ok() {
        IComprobradorPeliculas iComprobradorPeliculas = Mockito.mock(IComprobradorPeliculas.class);
        Mockito.when(iComprobradorPeliculas.verificarTitulo("Titanic")).thenReturn(true);
        assertTrue(iComprobradorPeliculas.verificarTitulo("Titanic"));
    }

}