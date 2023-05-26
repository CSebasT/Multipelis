package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import persistencia.*;

public class GestorCliente {

    public  void registrarCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        Cliente cliente = new Cliente();
        cliente.setCedula(cedula);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);


        PersistenciaCliente.registrarCliente(cedula, cliente);
    }

    public Cliente buscarCliente(String cedula) {
        Cliente cliente = PersistenciaCliente.consultarCliente(cedula);
        return cliente;
    }




}
