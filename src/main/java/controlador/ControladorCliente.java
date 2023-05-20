package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.GestorCliente;
import logica.Pelicula;

import java.io.IOException;

@WebServlet(name = "controladorCliente", value = "/cliente")
public class ControladorCliente extends HttpServlet {
    GestorCliente gestorCliente = new GestorCliente();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = (request.getParameter("accion") == null) ? "desconocido" : request.getParameter("accion");

        switch (accion) {
            case "registrar":
                registrarCliente(request, response);
                break;
            case "buscar":
                //buscarCliente(request, response);
                break;
        }
    }

    private void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestorCliente.registrarCliente(request.getParameter("cedulaCliente"), request.getParameter("nombreCliente"),
                request.getParameter("apellidoCliente"), request.getParameter("emailCliente"),
                request.getParameter("direccionCliente"), request.getParameter("telefonoCliente"));

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

/*
    private void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = gestorCliente.buscarCliente(request.getParameter("cedulaCliente"));
        request.setAttribute("cliente",cliente);
        request.getRequestDispatcher("/alquilerFormulario.jsp").forward(request, response);
    }

 */

}
