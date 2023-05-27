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
