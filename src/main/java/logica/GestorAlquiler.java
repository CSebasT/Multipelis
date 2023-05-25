package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.*;

import java.util.Date;

public class GestorAlquiler {
    public GestorAlquiler(){
    }

    public Alquiler registrarAlquiler(Cliente cliente, Ejemplar ejemplar, int dias){
        double precio = calcularPrecioAlquiler(cliente,ejemplar,dias);

        Alquiler alquiler = new Alquiler(cliente,ejemplar, precio);

        int numeroDeUsos = ejemplar.getNumeroDeUsos() +1;
        ejemplar.setNumeroDeUsos(numeroDeUsos);

        PersistenciaAlquiler.registrarAlquiler(alquiler);



        return alquiler;
    }

    public Alquiler buscarAlquiler(Long numeroAlquiler){
        Alquiler alquiler = PersistenciaAlquiler.consultarAlquiler(numeroAlquiler);
        return alquiler;
    }

    public void finalizarAlquiler(Alquiler alquiler){
        alquiler.finalizar();

        PersistenciaAlquiler.actualizarAlquiler(alquiler);
    }

    public Ejemplar buscarEjemplar(String codigo) {
        Ejemplar ejemplar = PersistenciaAlquiler.consultarEjemplar(codigo);
        return ejemplar;
    }

    public double calcularPrecioAlquiler(Cliente cliente, Ejemplar ejemplar, int dias) {

         int puntosPorFidelidad;
         double precioAlquiler = ejemplar.getCostoPorDia() * dias;
         puntosPorFidelidad = 5 + cliente.getPuntosPorFidelidad();
         cliente.setPuntosPorFidelidad(puntosPorFidelidad);

         if(puntosPorFidelidad == 25){
             precioAlquiler = precioAlquiler - precioAlquiler * 0.25;
         } else if (puntosPorFidelidad == 50){
             precioAlquiler = precioAlquiler - precioAlquiler * 0.5;
         } else if (puntosPorFidelidad == 75) {
             precioAlquiler = precioAlquiler - precioAlquiler * 0.75;
         } else if (puntosPorFidelidad == 100) {
             precioAlquiler = 0;
             cliente.setPuntosPorFidelidad(0);
         }


        Date fechaActual = new Date();
         Date fechaDeDescuento = ejemplar.getPelicula().getFechaDescuento();
         if((fechaActual.getDay()==fechaDeDescuento.getDay()) && (fechaActual.getMonth()==fechaDeDescuento.getMonth())){
             precioAlquiler = precioAlquiler * (1 - ejemplar.getPelicula().getDescuentoPorGenero());
         }
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
