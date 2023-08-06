/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Persistencia;

import com.mycompany.login.Logica.Usuario;
import java.util.List;

/**
 *
 * @author elavincho
 */
public class ControladoraPersistencia {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {
    
        return usuarioJpa.findUsuarioEntities();
        //Equivale a:  select * from usuarios
    }
    
}
