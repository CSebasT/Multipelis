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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_pelicula")
    private Pelicula pelicula;

    public Ejemplar(){

    }

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
}
