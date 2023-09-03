/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author elavincho
 */
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombreUsuario;
    private String contrasena;
    /* Es super importante hacer una relacion bidireccional para evirtar que JPA
    cree una tabla intermedia*/
    @ManyToOne
    @JoinColumn(name="id_rol") /*Colocamos en nombre de la columna a la que se va a unir
    NO puede tener el mismo nombre que otro atributo ya que se va a crear el forein key*/
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String contrasena, Rol unRol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.unRol = unRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

}
