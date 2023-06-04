package logica;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.mockito.Mockito;

public class IPaginaDePeliculasEnLineaTest {
    private IPaginaDePeliculasEnLinea iPaginaDePeliculasEnLinea = null;

    @Before
    public void setUp(){
        iPaginaDePeliculasEnLinea = Mockito.mock(IPaginaDePeliculasEnLinea.class);
    }

    @Test
    public void given_real_title_when_verify_then_ok() {
        Mockito.when(iPaginaDePeliculasEnLinea.verificarTitulo("Titanic")).thenReturn(true);
        assertTrue(iPaginaDePeliculasEnLinea.verificarTitulo("Titanic"));
    }

    @Test
    public void given_title_when_get_score_then_ok() {
        Puntaje puntajeEsperado = new Puntaje(3.5, 10);
        Mockito.when(iPaginaDePeliculasEnLinea.obtenerPuntaje("Titanic")).
                thenReturn(new Puntaje(3.5, 10));
        Puntaje puntajeObtenidoDeLaPagina = iPaginaDePeliculasEnLinea.obtenerPuntaje("Titanic");
        assertEquals(puntajeEsperado.getPuntajeTotal(), puntajeObtenidoDeLaPagina.getPuntajeTotal(), 0);
        assertEquals(puntajeEsperado.getCantidadDePuntajes(), puntajeObtenidoDeLaPagina.getCantidadDePuntajes());
    }
}