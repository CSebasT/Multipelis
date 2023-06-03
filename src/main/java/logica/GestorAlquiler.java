package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.*;

import java.util.Calendar;


public class GestorAlquiler {
    public GestorAlquiler() {

    }

    public Alquiler registrarAlquiler(Cliente cliente, Ejemplar ejemplar, int dias) throws Exception {

        Alquiler alquiler = new Alquiler(cliente, ejemplar, dias);
        PersistenciaAlquiler.registrarAlquiler(alquiler);
        return alquiler;
    }

    public Alquiler buscarAlquiler(Long numeroAlquiler) {
        Alquiler alquiler = PersistenciaAlquiler.consultarAlquiler(numeroAlquiler);
        return alquiler;
    }

    public void finalizarAlquiler(Alquiler alquiler, double puntuacion) {
        alquiler.finalizar(puntuacion);
        PersistenciaAlquiler.actualizarAlquiler(alquiler);
    }


    public Ejemplar buscarEjemplar(String codigo) {
        Ejemplar ejemplar = PersistenciaAlquiler.consultarEjemplar(codigo);
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
