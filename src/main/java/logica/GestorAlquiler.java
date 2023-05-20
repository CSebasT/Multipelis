package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.HibernateUtil;

public class GestorAlquiler {
    private Alquiler alquiler;
    private Ejemplar ejemplar;

    //private Pelicula pelicula;

    public GestorAlquiler(){

    }
    public Alquiler registrarAlquiler(Cliente cliente, Ejemplar ejemplar){
        this.alquiler = new Alquiler(cliente,ejemplar);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.alquiler);
        session.getTransaction().commit();
        return alquiler;
    }


    public Alquiler buscarAlquiler(Long numeroAlquiler){
        this.alquiler = new Alquiler();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        this.alquiler = session.get(Alquiler.class, numeroAlquiler);
        session.getTransaction().commit();

        return this.alquiler;
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
        this.ejemplar = new Ejemplar();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        this.ejemplar = session.get(Ejemplar.class, codigo);
        return this.ejemplar;
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
