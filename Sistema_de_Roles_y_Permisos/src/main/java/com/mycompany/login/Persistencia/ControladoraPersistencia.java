/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Persistencia;

import com.mycompany.login.Logica.Rol;
import com.mycompany.login.Logica.Usuario;
import com.mycompany.login.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elavincho
 */
public class ControladoraPersistencia {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
    
        return usuarioJpa.findUsuarioEntities();
        //Equivale a:  select * from usuarios
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
        //Equivale a: select * from rol
    }

    public void crearUsuario(Usuario usu) {
        usuarioJpa.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        try {
            usuarioJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuarioJpa.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu) {
        
        try {
            usuarioJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
