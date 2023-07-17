/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jpa_concecionaria;

import com.mycompany.jpa_concecionaria.igu.Principal;

/**
 * igu = interfaz grafica de usuario
 * @author elavincho
 */
public class JPA_Concecionaria {

    public static void main(String[] args) {
        
        // Instanciamos y hacemos visible a nuestra IGU
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}
