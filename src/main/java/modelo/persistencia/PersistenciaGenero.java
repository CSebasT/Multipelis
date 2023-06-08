package modelo.persistencia;

import modelo.logica.Genero;
import org.hibernate.Session;

public class PersistenciaGenero {
    public static Genero buscarGenero(Long numeroGenero) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Genero genero = session.get(Genero.class, numeroGenero);
        session.close();
        return genero;
    }
}
