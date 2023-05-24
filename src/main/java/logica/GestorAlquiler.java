package logica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.*;

public class GestorAlquiler {
    public GestorAlquiler(){
    }

    public Alquiler registrarAlquiler(Cliente cliente, Ejemplar ejemplar, int dias){
        double precio = calcularPrecioAlquiler(cliente,ejemplar,dias);

        Alquiler alquiler = new Alquiler(cliente,ejemplar, precio);

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

         if(puntosPorFidelidad == 100){
             precioAlquiler = 0;
             cliente.setPuntosPorFidelidad(0);
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
