package logica;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;
    @OneToOne()
    @JoinColumn(name = "genero")
    private Genero genero;
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Column(name = "duracion", nullable = false)
    private int duracion;
    @Column(name = "año_lanzamiento", nullable = false)
    private int añoLanzamiento;
    @Column(name = "sinopsis", nullable = false, length = 150)
    private String sinopsis;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.MERGE)
    private List<Ejemplar> ejemplares = new ArrayList<>();


    @Column(name = "puntajeTotal", nullable = false)
    private double puntajeTotal;
    @Column(name = "cantidadDePuntajes", nullable = false)
    private int cantidadDePuntajes;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public double getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(double puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public int getCantidadDePuntajes() {
        return cantidadDePuntajes;
    }

    public void setCantidadDePuntajes(int cantidadDePuntajes) {
        this.cantidadDePuntajes = cantidadDePuntajes;
    }

    public void agregaPuntaje(double nuevoPuntaje) {
        puntajeTotal = (puntajeTotal*cantidadDePuntajes+nuevoPuntaje)/cantidadDePuntajes+1;
    }
}
