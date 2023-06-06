package logica;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Column(name = "duracion", nullable = false)
    private int duracion;
    @Column(name = "año_lanzamiento", nullable = false)
    private int añoLanzamiento;
    @Column(name = "sinopsis", nullable = false, length = 150)
    private String sinopsis;
    @OneToOne()
    @JoinColumn(name = "codigo_puntaje")
    private Puntaje puntaje;
    @OneToOne()
    @JoinColumn(name = "codigo_genero")
    private Genero genero;
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Ejemplar> ejemplares = new ArrayList<>();

    public Pelicula() {
    }

    public Pelicula(String codigo, String titulo, int duracion, int añoLanzamiento, String sinopsis, Genero genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.añoLanzamiento = añoLanzamiento;
        this.sinopsis = sinopsis;
        this.genero = genero;
    }

    public void agregarPuntaje(double nuevoPuntaje) {
        puntaje.actualizar(nuevoPuntaje);
    }

    public double obtenerDescuentoGenero() {
        return genero.obtenerDescuento();
    }

    public boolean verificarNecesidadDeEjemplares(){
        for (Ejemplar ejemplar: ejemplares){
            if (!ejemplar.isEstaDesgastado()){
                return false;
            }
        }
        return true;
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

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }


}
