/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpa_concecionaria.logica;

import com.mycompany.jpa_concecionaria.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author elavincho
 */
public class Controladora {

    ControladoraPersistencia controlPersist = new ControladoraPersistencia();

    public void agregarAutomovil(String modelo, String marca, String motor, String color,
            String patente, int cantPuertas) {

        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);

        controlPersist.agregarAutomovil(auto);
    }

    public List<Automovil> traerAutos() {

        return controlPersist.traerAutos();
    }

    public void eliminarAuto(int idAuto) {
        controlPersist.eliminarAuto(idAuto);
    }

    public Automovil traerAuto(int idAuto) {
        return controlPersist.traerAuto(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String marca,
            String motor, String color, String patente, int cantPuertas) {

        auto.setColor(color);
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setPatente(patente);
        auto.setMotor(motor);
        auto.setCantPuertas(cantPuertas);

        controlPersist.modificarauto(auto);
    }
}
