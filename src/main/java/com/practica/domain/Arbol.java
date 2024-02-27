package com.practica.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Arbol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbol;
    private String nombre;
    private String nombreCientifico;
    private String rutaImagen;
    private double altura;
    private double grosor;

    // Constructor vacío
    public Arbol() {
    }

    // Constructor con todos los campos
    public Arbol(String nombre, String nombreCientifico, String rutaImagen, double altura, double grosor) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.rutaImagen = rutaImagen;
        this.altura = altura;
        this.grosor = grosor;
    }

    // Getter para idArbol
    public Long getIdArbol() {
        return idArbol;
    }

    // Setter para idArbol
    public void setIdArbol(Long idArbol) {
        this.idArbol = idArbol;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para nombreCientifico
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    // Setter para nombreCientifico
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    // Getter para rutaImagen
    public String getRutaImagen() {
        return rutaImagen;
    }

    // Setter para rutaImagen
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    // Getter para altura
    public double getAltura() {
        return altura;
    }

    // Setter para altura
    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Getter para grosor
    public double getGrosor() {
        return grosor;
    }

    // Setter para grosor
    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }
}