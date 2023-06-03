package logica;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class AlquilerTest {
    private Alquiler alquiler = null;
    private Cliente cliente = null;
    private Pelicula pelicula = null;
    private Ejemplar ejemplar = null;
    private Genero genero = null;

    @Before
    public void setUp() {
        alquiler = new Alquiler();
        cliente = new Cliente();
        pelicula = new Pelicula();
        ejemplar = new Ejemplar();
        genero = new Genero();
        Calendar fechaDescuento = Calendar.getInstance();
        fechaDescuento.set(2001, Calendar.FEBRUARY, 10);
        genero.setPorcentajeDescuento(0.0);
        genero.setFechaDescuento(fechaDescuento);
        ejemplar.setCostoPorDia(3);
        ejemplar.setPelicula(pelicula);
        pelicula.setGenero(genero);
        cliente.setPuntosPorFidelidad(0);
        alquiler.setDias(-3);
        alquiler.setCliente(cliente);
        alquiler.setEjemplar(ejemplar);
    }

    @Test(expected = RuntimeException.class)
    public void given_negative_days_when_calculate_price_then_exception() throws Exception {
        double precioReal = alquiler.calcularPrecio();
        assertEquals(9, precioReal, 0);
    }
}