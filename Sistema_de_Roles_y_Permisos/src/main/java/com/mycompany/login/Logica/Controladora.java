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

    public Usuario validarUsuario(String usuario, String contrasenia) {
        
        //String mensaje = "";
        Usuario user = null;
        List<Usuario> listaUsuarios = controlPersist.traerUsuarios();
        
        for(Usuario usu : listaUsuarios){
            System.out.println("Usuario: " + usu.getNombreUsuario());
            if (usu.getNombreUsuario().equals(usuario)) {
                
                if (usu.getContrasena().equals(contrasenia)) {
                    //mensaje = "Usuario y contraseña Correctos!! Bienvenido!!";
                    //return mensaje;
                    user = usu;
                    return user;
                }else{
                    //mensaje = "Contraseña Incorrecta!";
                    //return mensaje;
                    user = null;
                    return user;
                }
            }else{
                //mensaje = "Usuario Incorrecto!";
                user = null;
                //return user;  No se puede retornar el usuario, ya que si no encuentra el
                //usuario todo el cliclo retorna null y no encuentra a otros usuarios
            }
        }
        //El return del final tiene que quedar en caso de que no encuentre lo solicitado
        // para que vuelva al bucle
        //return mensaje;
        return user;
    }

    
    public List<Usuario> traerUsuarios() {
        return controlPersist.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersist.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        //Instanciamos al usuario ya que no tenemos todos los datos del usuario
        //solo agregamos los que tenemos.
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasena(contra);
        //Como Rol es un objeto hay que instanciarlo tambien
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        //Como traerRol(rolRecibido) no existe lo creamos aca en la controladora
        
        //Verificamos que encuentre el rol
        if(rolEncontrado != null){
            usu.setUnRol(rolEncontrado);
        }
        
        //Guardamos el usuario en la BD
        controlPersist.crearUsuario(usu);
        //Como crear usuario no existe lo creamos 
        
    }

    private Rol traerRol(String rolRecibido) {
        
        List<Rol> listaRoles = controlPersist.traerRoles();
        for(Rol rol : listaRoles){
            //Si encuentra el rol recibido que devuelva el rol
            if(rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        }
        //Si no lo encuentra que devuelva null
        return null;
    }

    public void borrarUsuario(int id_usuario) {
        controlPersist.borrarUsuario(id_usuario);
    }

    public Usuario treaerUsuario(int id_usuario) {
       return controlPersist.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rolRecibido) {
       
        usu.setNombreUsuario(usuario);
        usu.setContrasena(contra);
        //Reutilizamos el mismo metodo (traerRol)que se encuentra en el metodo
        //(crearuUsuario) de la controladora
        
        //Como Rol es un objeto hay que instanciarlo tambien
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        //Como traerRol(rolRecibido) no existe lo creamos aca en la controladora
        
        //Verificamos que encuentre el rol
        if(rolEncontrado != null){
            usu.setUnRol(rolEncontrado);
        }
        
        controlPersist.editarUsuario(usu);
        
    }
}
