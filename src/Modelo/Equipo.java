/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author FYR
 */
public class Equipo { 
   private String NombreEquipo;
   private double BonoEquipo;

    public double getBonoEquipo() {
        return BonoEquipo;
    }

    public void setBonoEquipo(double BonoEquipo) {
        this.BonoEquipo = BonoEquipo;
    }

    

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }
}
