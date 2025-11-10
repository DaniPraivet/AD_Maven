package dev.danipraivet.new_app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Autores")
public class Autores {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "nacionalidad", length = 50)
    private String language;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}