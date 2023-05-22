package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import persistencia.HibernateUtil;

public class GestorCliente {

    public  void registrarCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        Cliente cliente = new Cliente();
        cliente.setCedula(cedula);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if(verificarExistenciaCliente(session, cedula )){
            //System.out.println("Si existe");
            session.getTransaction().rollback();
            return;
        }
        session.save(cliente);
        session.getTransaction().commit();
    }

    public Cliente buscarCliente(String cedula) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, cedula);
        return cliente;
    }

    public boolean verificarExistenciaCliente(Session session, String cedulaAVerificar){
        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM logica.Cliente WHERE cedula = :cedulaAVerificar", Long.class);
        query.setParameter("cedulaAVerificar", cedulaAVerificar);

        Long count = query.uniqueResult();

        return count > 0;
    }
}
