package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.HibernateUtil;

public class GestorAlquiler {

    public GestorAlquiler(){
    }

    public Alquiler registrarAlquiler(Cliente cliente, Ejemplar ejemplar){
        Alquiler alquiler = new Alquiler(cliente,ejemplar);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(alquiler);
        session.getTransaction().commit();
        return alquiler;
    }

    public Alquiler buscarAlquiler(Long numeroAlquiler){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Alquiler alquiler = session.get(Alquiler.class, numeroAlquiler);
        session.getTransaction().commit();

        return alquiler;
    }

    public void finalizarAlquiler(Alquiler alquiler){
        alquiler.finalizar();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(alquiler);
        session.getTransaction().commit();
    }

    public Ejemplar buscarEjemplar(String codigo) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ejemplar ejemplar = session.get(Ejemplar.class, codigo);
        return ejemplar;
    }
    /*
    public void registrarEjemplar(String codigo, Boolean estado, Pelicula pelicula) {
        this.ejemplar = new Ejemplar();
        this.ejemplar.setCodigo(codigo);
        this.ejemplar.setEstadoDisponibilidad(estado);
        this.ejemplar.setPelicula(pelicula);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.ejemplar);
        session.getTransaction().commit();
        //HibernateUtil.guardar(ejemplar);

    }*/
}
