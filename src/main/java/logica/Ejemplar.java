package logica;

import javax.persistence.*;

@Entity
@Table(name = "ejemplar")
public class Ejemplar {
    @Id
    @Column(name = "codigo", nullable = false, length = 4)
    private String codigo;
    @Column(name = "estado_disponibilidad", nullable = false)
    private Boolean estadoDisponibilidad;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_pelicula")
    private Pelicula pelicula;
    @Column(name = "costoPorDia", nullable = false)
    private double costoPorDia;
    @Column(name = "numeroDeUsos", nullable = false)
    private int numeroDeUsos;
    @Column(name = "estaDesgastado", nullable = false)
    private boolean estaDesgastado;

    public Ejemplar(){

    }

    public double getCostoPorDia() {
        return costoPorDia;
    }

    public void devolver(double puntaje) {
        estadoDisponibilidad = true;
        estaDesgastado = numeroDeUsos>=50;
        pelicula.agregarPuntaje(puntaje);
    }

    public void alquilar() {
        estadoDisponibilidad = false;
        numeroDeUsos = numeroDeUsos + 1;
    }

    public double obtenerDescuentoGenero() {
        return pelicula.obtenerDescuentoGenero();
    }

    /*-------------------------------------------------------------*/
    /* Getters y Setters para el funcionamiento de la persistencia */
    /*-------------------------------------------------------------*/

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(Boolean estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setCostoPorDia(double costoPorDia) {
        this.costoPorDia = costoPorDia;
    }

    public int getNumeroDeUsos() {
        return numeroDeUsos;
    }

    public void setNumeroDeUsos(int numeroDeUsos) {
        this.numeroDeUsos = numeroDeUsos;
    }

    public boolean isEstaDesgastado() {
        return estaDesgastado;
    }

    public void setEstaDesgastado(boolean estaDesgastado) {
        this.estaDesgastado = estaDesgastado;
    }
}
