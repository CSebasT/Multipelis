package modelo;

import modelo.logica.Cliente;
import modelo.logica.GestorCliente;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientePuntosTest {
    private static Cliente cliente = null;
    private static GestorCliente gestorCliente = null;

    @BeforeClass
    public static void setUpClass(){
        gestorCliente = new GestorCliente();
        cliente = gestorCliente.buscarCliente("1726547209");
    }

    @Test
    public void given_client_when_search_discount_then_ok() {
        double descuento = cliente.obtenerDescuentoFidelidad();
        assertEquals(1, descuento,0);
    }


}