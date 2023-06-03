package logica;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
//Isma
public class ClientePuntosTest {
    private static Cliente cliente = null;

    @BeforeClass
    public static void setUpClass(){
        //Conexion
        //this.cliente = ;
    }

    @Test
    public void given_client_when_search_discount_then_ok() {
        double descuento = cliente.obtenerDescuentoFidelidad();
        assertEquals(0, descuento);
    }


}