package persistencia;

import logica.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class PersistenciaCliente {

    public static boolean verificarExistenciaCliente(Session session, String cedulaAVerificar){

        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM logica.Cliente WHERE cedula = :cedulaAVerificar", Long.class);
        query.setParameter("cedulaAVerificar", cedulaAVerificar);

        Long count = query.uniqueResult();

        return count > 0;
    }

    public static void registrarCliente(String cedula, Cliente cliente) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if(PersistenciaCliente.verificarExistenciaCliente(session, cedula)){
            //System.out.println("Si existe");
            session.getTransaction().rollback();
            return;
        }
        session.save(cliente);
        session.getTransaction().commit();
    }

    public static Cliente consultarCliente(String cedula) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, cedula);
        return cliente;
    }
}
