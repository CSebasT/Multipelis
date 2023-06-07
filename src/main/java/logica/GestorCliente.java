package logica;

import persistencia.*;

public class GestorCliente {

    public void registrarCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        if (verificarCedula(cedula)) {
            Cliente cliente = new Cliente(cedula, nombre, apellido, direccion, telefono, correo);
            PersistenciaCliente.registrarCliente(cedula, cliente);
        }
    }

    public boolean verificarCedula(String cedula) {
        boolean cedulaCorrecta = false;

        if (cedula.length() == 10) {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito < 6) {
                int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = calcularSumaValidezCedula(cedula, coefValCedula);

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                } else if ((10 - (suma % 10)) == verificador) {
                    cedulaCorrecta = true;
                }
            }
        }
        return cedulaCorrecta;
    }

    private int calcularSumaValidezCedula(String cedula, int[] coefValCedula) {
        int suma = 0;
        for (int i = 0; i < cedula.length() - 1; i++) {
            int digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
            suma += ((digito % 10) + (digito / 10));
        }
        return suma;
    }



    public Cliente buscarCliente(String cedula) {
        Cliente cliente = PersistenciaCliente.consultarCliente(cedula);
        return cliente;
    }



}
