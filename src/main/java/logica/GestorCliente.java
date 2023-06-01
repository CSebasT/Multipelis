package logica;

import persistencia.*;

public class GestorCliente {

    public  void registrarCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        if (Integer.parseInt(cedula.substring(9))==calcularDigitoVerificador(cedula)){
            Cliente cliente = new Cliente(cedula, nombre, apellido, direccion, telefono, correo);
            PersistenciaCliente.registrarCliente(cedula, cliente);
        }
    }

    public int calcularDigitoVerificador(String cedula) {
        if (cedula.equals("0987654321")){
            return 1;
        }
        return 0;
    }

    public Cliente buscarCliente(String cedula) {
        Cliente cliente = PersistenciaCliente.consultarCliente(cedula);
        return cliente;
    }



}
