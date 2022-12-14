package com.portafolio.carlosmarcano.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "La Longitud debe ser entre 1 y 50")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "La Longitud debe ser entre 1 y 50")
    private String apellido;

    @NotNull
    @Size(min = 1, max = 50, message = "La Longitud debe ser entre 1 y 50")
    private String cargo;

    @NotNull
    @Size(min = 1, max = 1000, message = "La Longitud debe ser entre 1 y 50")
    private String acercade;

    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String cargo, String acercade, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.acercade = acercade;
        this.img = img;
    }

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

