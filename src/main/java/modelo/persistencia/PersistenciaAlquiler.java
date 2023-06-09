package modelo.persistencia;

import modelo.logica.Alquiler;
import modelo.logica.Ejemplar;
import org.hibernate.Session;

public class PersistenciaAlquiler {

    public static void registrarAlquiler(Alquiler alquiler) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(alquiler);
        session.getTransaction().commit();
        session.close();
    }

    public static Alquiler consultarAlquiler(Long numeroAlquiler) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Alquiler alquiler = session.get(Alquiler.class, numeroAlquiler);
        session.getTransaction().commit();
        session.close();
        return alquiler;
    }

    public static void actualizarAlquiler(Alquiler alquiler) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(alquiler);
        session.getTransaction().commit();
        session.close();
    }

    public static Ejemplar consultarEjemplar(String codigo) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Ejemplar ejemplar = session.get(Ejemplar.class, codigo);
        session.close();
        return ejemplar;
    }

}
