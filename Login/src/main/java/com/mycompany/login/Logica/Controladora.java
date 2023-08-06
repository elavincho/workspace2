/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Logica;

import com.mycompany.login.Persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author elavincho
 */

public class Controladora {

    ControladoraPersistencia controlPersist = null;
    
    public Controladora(){
        controlPersist= new ControladoraPersistencia();
    }

    public String validarUsuario(String usuario, String contrasenia) {
        
        String mensaje = "";
        List<Usuario> listaUsuarios = controlPersist.traerUsuarios();
        
        for(Usuario usu : listaUsuarios){
            System.out.println("Usuario: " + usu.getNombreUsuario());
            if (usu.getNombreUsuario().equals(usuario)) {
                
                if (usu.getContrasena().equals(contrasenia)) {
                    mensaje = "Usuario y contraseña Correctos!! Bienvenido!!";
                    return mensaje;
                }else{
                    mensaje = "Contraseña Incorrecta!";
                    return mensaje;
                }
            }else{
                mensaje = "Usuario Incorrecto!";
            }
        }
        //El return del final tiene que quedar en caso de que no encuentre lo solicitado
        // para que vuelva al bucle
        return mensaje;
    }
}
