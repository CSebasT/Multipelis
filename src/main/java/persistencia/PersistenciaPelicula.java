package persistencia;

import logica.Cliente;
import logica.Pelicula;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class PersistenciaPelicula {
    public static List<Pelicula> consultarPeliculas (){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "FROM Pelicula";
        Query query = session.createQuery(hql);
        List<Pelicula> peliculas = query.list();
        session.getTransaction().commit();
        session.close();
        return peliculas;
    }

    public static Pelicula consultarPelicula(String codigoPelicula) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Pelicula pelicula = session.get(Pelicula.class, codigoPelicula);
        session.close();
        return pelicula;
    }

    public static void registrarPelicula(Pelicula pelicula) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(pelicula);
        session.getTransaction().commit();
        session.close();
    }
}
