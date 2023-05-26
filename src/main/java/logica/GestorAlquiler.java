package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.*;

import java.util.Calendar;


public class GestorAlquiler {
    public GestorAlquiler() {
    }

    public Alquiler registrarAlquiler(Cliente cliente, Ejemplar ejemplar, int dias) {
        double precio = calcularPrecioAlquiler(cliente, ejemplar, dias);
        Alquiler alquiler = new Alquiler(cliente, ejemplar, precio);
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

    public double calcularPrecioAlquiler(Cliente cliente, Ejemplar ejemplar, int dias) {
        double precioAlquiler = ejemplar.getCostoPorDia() * dias;
        int puntosPorFidelidad;

        double temp = 0;
        puntosPorFidelidad = cliente.getPuntosPorFidelidad();
        if (puntosPorFidelidad == 25) {
            temp = 0.25;
        } else if (puntosPorFidelidad == 50) {
            temp = 0.5;
        } else if (puntosPorFidelidad == 75) {
            temp = 0.75;
        } else if (puntosPorFidelidad == 100) {
            temp = 1;
            cliente.setPuntosPorFidelidad(0);
        }
        precioAlquiler = precioAlquiler * (1 - temp);

        temp = 0;
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaDeDescuento = ejemplar.getPelicula().getFechaDescuento();

        if ((fechaActual.get(Calendar.DAY_OF_MONTH) == fechaDeDescuento.get(Calendar.DAY_OF_MONTH)) && (fechaActual.get(Calendar.MONTH) == fechaDeDescuento.get(Calendar.MONTH))) {
            temp  = ejemplar.getPelicula().getDescuentoPorGenero();
        }
        precioAlquiler = precioAlquiler * (1 - temp);
        return precioAlquiler;
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
