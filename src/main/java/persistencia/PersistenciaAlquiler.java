package persistencia;

import logica.Alquiler;
import logica.Ejemplar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersistenciaAlquiler {

    public static void registrarAlquiler(Alquiler alquiler) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(alquiler);
        session.getTransaction().commit();
    }

    public static Alquiler consultarAlquiler(Long numeroAlquiler) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Alquiler alquiler = session.get(Alquiler.class, numeroAlquiler);
        session.getTransaction().commit();
        return alquiler;
    }

    public static void actualizarAlquiler(Alquiler alquiler) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(alquiler);
        session.getTransaction().commit();
    }

    public static Ejemplar consultarEjemplar(String codigo) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ejemplar ejemplar = session.get(Ejemplar.class, codigo);
        return ejemplar;
    }

}
