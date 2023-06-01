package logica;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientePuntosTest {
    private Cliente cliente = null;

    @BeforeClass
    public void setUpClass(){
        //Conexion
        //this.cliente = ;
    }

    @Test
    public void given_client_when_search_discount_then_ok() {
        double descuento = cliente.obtenerDescuentoFidelidad();
        assertEquals(0, descuento);
    }

    @Test
    public void given_client_when_search_discount_then_error() {
        double descuento = cliente.obtenerDescuentoFidelidad();
        assertNotEquals(-0.14, descuento);
    }

    @AfterClass
    public void tearDownClass(){
        //Conexión
    }

}