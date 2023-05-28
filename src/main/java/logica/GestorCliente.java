package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import persistencia.*;

public class GestorCliente {

    public  void registrarCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        Cliente cliente = new Cliente(cedula, nombre, apellido, direccion, telefono, correo);
        PersistenciaCliente.registrarCliente(cedula, cliente);
    }

    public Cliente buscarCliente(String cedula) {
        Cliente cliente = PersistenciaCliente.consultarCliente(cedula);
        return cliente;
    }




}
