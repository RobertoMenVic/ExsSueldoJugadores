/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author FYR
 */
public class Jugador {
    
      public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String  getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getTotalGoles() {
        return totalGoles;
    }

    public void setTotalGoles(int totalGoles) {
        this.totalGoles = totalGoles;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public double getSueldo_comple() {
        return sueldo_comple;
    }

    public void setSueldo_comple(double sueldo_comple) {
        this.sueldo_comple = sueldo_comple;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    private String nombre;
    private String  nivel;
    private int totalGoles;
    private double sueldo;
    private double bono;
    private double sueldo_comple;
    private String equipo;
  
}
