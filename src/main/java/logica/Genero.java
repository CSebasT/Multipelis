package logica;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "fechaDescuento", nullable = false, length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaDescuento;
    @Column(name = "porcentajeDescuento", nullable = false)
    private double porcentajeDescuento;

    public Genero() {
    }

    public double obtenerDescuento() {
        double descuento = 0;
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaDeDescuento = fechaDescuento;
        if ((fechaActual.get(Calendar.DAY_OF_MONTH) == fechaDeDescuento.get(Calendar.DAY_OF_MONTH))
                && (fechaActual.get(Calendar.MONTH) == fechaDeDescuento.get(Calendar.MONTH))) {
            descuento  = porcentajeDescuento;
        }
        return descuento;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(Calendar fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
