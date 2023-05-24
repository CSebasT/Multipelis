package logica;

import javax.persistence.*;

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
    private int precio;

    public Alquiler(){

    }

    public Alquiler(Cliente cliente, Ejemplar ejemplar) {
        this.estadoDevolucion = false;
        this.cliente = cliente;
        ejemplar.setEstadoDisponibilidad(false);
        this.ejemplar = ejemplar;

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


    public void finalizar() {
        setEstadoDevolucion(true);
        ejemplar.setEstadoDisponibilidad(true);
    }
}
