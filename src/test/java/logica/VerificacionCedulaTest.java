package logica;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//Isma
public class VerificacionCedulaTest {

    private GestorCliente gestorCliente = null;

    @Before
    private void setUp(){
        gestorCliente = new GestorCliente();
    }

    @Test
    public void given_ci_when_calculate_digit_then_ok() {
        int digitoVerificador = gestorCliente.calcularDigitoVerificador("0987654321");
        assertEquals(1,digitoVerificador);
    }

}