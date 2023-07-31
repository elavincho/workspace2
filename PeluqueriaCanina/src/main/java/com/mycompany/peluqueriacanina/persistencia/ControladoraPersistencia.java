/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elavincho
 */
public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();
    
    public void guardar(Duenio dueno, Mascota mascota) {
        //Creamos en la BD el dueño
        duenioJpa.create(dueno);
        //Creamos en la BD la mascota
        mascotaJpa.create(mascota);
    }
    
    public List<Mascota> traerMascotas() {
        //findMascotaEntities() busca todos los registros que tiene la tabla mascota
        return mascotaJpa.findMascotaEntities();
        
    }
    
    public void borrarMascota(int num_cliente) {
        
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Mascota traerMascota(int num_cliente) {
        
        return mascotaJpa.findMascota(num_cliente);
    }
    
    public void modificarMascota(Mascota masco) {
        
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Duenio traerDuenio(int id_duenio) {
        
        return duenioJpa.findDuenio(id_duenio);
    }
    
    public void modificarDuenio(Duenio dueno) {
        
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
