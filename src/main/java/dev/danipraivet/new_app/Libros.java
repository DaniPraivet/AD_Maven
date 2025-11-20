package dev.danipraivet.new_app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="Libros")
public class Libros {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "codigoAutor")
    private String codigoAutor;

    @Column(name = "fechaLanzamiento")
    private LocalDateTime fechaLanzamiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(String codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public LocalDateTime getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigoAutor='" + codigoAutor + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}
