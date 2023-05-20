package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import persistencia.HibernateUtil;

public class GestorCliente {
    private Cliente cliente;
    public  void registrarCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        this.cliente = new Cliente();
        this.cliente.setCedula(cedula);
        this.cliente.setNombre(nombre);
        this.cliente.setApellido(apellido);
        this.cliente.setDireccion(direccion);
        this.cliente.setTelefono(telefono);
        this.cliente.setCorreo(correo);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if(verificarExistenciaCliente(session, cedula )){
            //System.out.println("Si existe");
            session.getTransaction().rollback();
            return;
        }
        session.save(this.cliente);
        session.getTransaction().commit();
    }

    public Cliente buscarCliente(String cedula) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        this.cliente = session.get(Cliente.class, cedula);
        return this.cliente;
    }

    public boolean verificarExistenciaCliente(Session session, String cedulaAVerificar){
        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM logica.Cliente WHERE cedula = :cedulaAVerificar", Long.class);
        query.setParameter("cedulaAVerificar", cedulaAVerificar);

        Long count = query.uniqueResult();

        return count > 0;
    }
}
