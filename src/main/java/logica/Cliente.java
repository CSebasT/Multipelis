package logica;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Column(name = "apellido", nullable = true, length = 50)
    private String apellido;
    @Column(name = "correo", nullable = true, length = 100)
    private String correo;
    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;
    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;
    @Column(name = "puntosPorFidelidad", nullable = true)
    private int puntosPorFidelidad;


    public void registrarCliente(){

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPuntosPorFidelidad() {
        return puntosPorFidelidad;
    }

    public void setPuntosPorFidelidad(int puntosPorFidelidad) {
        this.puntosPorFidelidad = puntosPorFidelidad;
    }


    public void aumentarPuntos() {
        puntosPorFidelidad = 5 + puntosPorFidelidad;
    }
}
