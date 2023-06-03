package logica;

import javax.persistence.*;

@Entity
@Table(name = "puntaje")
public class Puntaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;
    @Column(name = "puntajeTotal", nullable = false)
    private double puntajeTotal;
    @Column(name = "cantidadDePuntajes", nullable = false)
    private int cantidadDePuntajes;

    public Puntaje() {
    }

    public Puntaje(double puntajeTotal, int cantidadDePuntajes) {
        this.puntajeTotal = puntajeTotal;
        this.cantidadDePuntajes = cantidadDePuntajes;
    }

    public void actualizar(double nuevoPuntaje) {
        puntajeTotal = (puntajeTotal*cantidadDePuntajes+nuevoPuntaje)/(cantidadDePuntajes+1);
    }

    /*-------------------------------------------------------------*/
    /* Getters y Setters para el funcionamiento de la persistencia */
    /*-------------------------------------------------------------*/

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
}
