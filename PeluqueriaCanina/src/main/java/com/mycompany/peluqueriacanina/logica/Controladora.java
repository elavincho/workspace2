/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author elavincho
 */
public class Controladora {
    
    ControladoraPersistencia controlPersist = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String nombreDuenio, 
            String celDuenio, String observacion, String alergico, String atencionEspecial) {
        
        //Creamos el dueño y asignamos los valores
         Duenio dueno = new Duenio();
         dueno.setNombre(nombreDuenio);
         dueno.setCelDuenio(celDuenio);
         //Creamos la mascota y asignamos los valores
         Mascota mascota = new Mascota();
         mascota.setNombre(nombreMascota);
         mascota.setRaza(raza);
         mascota.setColor(color);
         mascota.setAlergico(alergico);
         mascota.setAtencion_especial(atencionEspecial);
         mascota.setObservaciones(observacion);
         mascota.setDuenio(dueno);
         
         controlPersist.guardar(dueno, mascota);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersist.traerMascotas();
        
    }

    public void borrarMascota(int num_cliente) {
        
        controlPersist.borrarMascota(num_cliente);
        
    }

    public Mascota traerMascota(int num_cliente) {
    
        return controlPersist.traerMascota(num_cliente);
        
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, 
            String color, String nombreDuenio, String celDuenio, String observacion, 
            String alergico, String atencionEspecial) {
        
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observacion);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencionEspecial);
        
        //Modifico la mascota con los nuevos datos
        controlPersist.modificarMascota(masco);
        //Creamos un metodo para buscar dueño
        Duenio dueno = this.buscarDuenio(masco.getDuenio().getId_duenio());
        //Seteamos al dueño sus valores nuevos
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);
        //llamar al modificar dueño
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        
        return controlPersist.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {

        controlPersist.modificarDuenio(dueno);
    }
    
    
}
