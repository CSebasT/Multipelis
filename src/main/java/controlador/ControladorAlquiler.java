package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.*;

import java.io.IOException;

@WebServlet(name="controladorAlquiler", value="/alquileres")
public class ControladorAlquiler extends HttpServlet {
    GestorAlquiler gestorAlquiler = new GestorAlquiler();
    GestorCliente gestorCliente = new GestorCliente();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = (request.getParameter("accion") == null) ? "desconocido" : request.getParameter("accion");

        switch (accion) {
            case "registrar":
                registrarAlquiler(request, response);
                break;
            case "devolver":
                devolverAlquiler(request, response);
                break;
        }
    }

    private void devolverAlquiler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numero = request.getParameter("numeroAlquiler");
        Alquiler alquiler = gestorAlquiler.buscarAlquiler(Long.parseLong(numero));
        gestorAlquiler.finalizarAlquiler(alquiler,Integer.parseInt(request.getParameter("puntaje")));
        request.setAttribute("pelicula",alquiler.getEjemplar().getPelicula());
        request.setAttribute("ejemplar",alquiler.getEjemplar());
        request.setAttribute("cliente",alquiler.getCliente());
        request.getRequestDispatcher("/devolucionInfo.jsp").forward(request, response);
    }

    private void registrarAlquiler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ejemplar ejemplar = gestorAlquiler.buscarEjemplar(request.getParameter("codigoEjemplar"));
        Pelicula pelicula = ejemplar.getPelicula();
        Cliente cliente = gestorCliente.buscarCliente(request.getParameter("cedulaCliente"));
        request.setAttribute("cliente",cliente);
        request.setAttribute("pelicula", pelicula);
        Alquiler alquiler = null;
        try {
            alquiler = gestorAlquiler.registrarAlquiler(cliente,ejemplar,Integer.parseInt(request.getParameter("numeroDias")));
            request.setAttribute("alquiler", alquiler);
            request.getRequestDispatcher("/alquilerInfo.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
