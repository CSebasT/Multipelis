package logica;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerificacionCedulaTest {

    private GestorCliente gestorCliente = null;

    @Before
    public void setUp(){
        gestorCliente = new GestorCliente();
    }

    @Test
    public void given_ci_when_calculate_digit_then_ok() {
        boolean digitoVerificador = gestorCliente.verificarCedula("1726547209");
        assertTrue(digitoVerificador);
    }

}