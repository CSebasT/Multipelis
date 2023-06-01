package logica;

import org.junit.Test;

import static org.junit.Assert.*;
//Isma
public class VerificacionCedulaTest {

    @Test
    public void given_ci_when_calculate_digit_then_ok() {
        GestorCliente gestorCliente = new GestorCliente();
        int digitoVerificador = gestorCliente.calcularDigitoVerificador("0987654321");
        assertEquals(1,digitoVerificador);
    }

    @Test
    public void given_ci_when_calculate_digit_then_error() {
        GestorCliente gestorCliente = new GestorCliente();
        int digitoVerificador = gestorCliente.calcularDigitoVerificador("0987654320");
        assertNotEquals(1,digitoVerificador);
    }

}