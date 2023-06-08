package modelo;

import modelo.logica.Alquiler;
import modelo.logica.GestorAlquiler;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlquilerTest {
    private static Alquiler alquiler = null;
    private static GestorAlquiler gestorAlquiler= null;

    @BeforeClass
    public static void setUpClass() {
        gestorAlquiler = new GestorAlquiler();
        alquiler = gestorAlquiler.buscarAlquiler(1L);
    }

    @Test(expected = Exception.class)
    public void given_negative_days_when_calculate_price_then_exception() throws Exception {
        alquiler.setDias(-1);
        assertEquals(9, alquiler.calcularPrecio(), 0);
    }
}