package logica;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero", nullable = false)
    private Long numero;
    @Column(name = "estado_devolucion", nullable = false)
    private Boolean estadoDevolucion;
    @OneToOne()
    @JoinColumn(name = "cedula_cliente")
    private Cliente cliente;

    @OneToOne()
    @JoinColumn(name = "codigo_ejemplar")
    private Ejemplar ejemplar;

    @Column(name = "dias", nullable = false)
    private int dias;

    @Column(name = "precio", nullable = false)
    private double precio;

    public Alquiler(){

    }

    public Alquiler(Cliente cliente, Ejemplar ejemplar, int dias) {
        this.estadoDevolucion = false;
        this.cliente = cliente;
        this.ejemplar = ejemplar;
        this.precio = calcularPrecio();
        ejemplar.alquilar();
        cliente.aumentarPuntos();
    }



    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Boolean getEstadoDevolucion() {
        return estadoDevolucion;
    }

    public void setEstadoDevolucion(Boolean estadoDevolucion) {
        this.estadoDevolucion = estadoDevolucion;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void finalizar(double puntaje) {
        setEstadoDevolucion(true);
        ejemplar.devolver(puntaje);
    }

    public double calcularPrecio() {
        double precioAlquiler = ejemplar.getCostoPorDia() * dias;
        int puntosPorFidelidad;

        double temp = cliente.obtenerDescuentoFidelidad();
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

}
