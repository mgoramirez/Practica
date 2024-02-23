
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

    public Arbol() {
    }

    public Arbol(String nombre, String nombreCientifico, String rutaImagen, double altura, double grosor) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.rutaImagen = rutaImagen;
        this.altura = altura;
        this.grosor = grosor;
    }
    
    
}
