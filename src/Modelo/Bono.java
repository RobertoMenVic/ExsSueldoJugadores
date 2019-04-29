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
public class Bono {
    
    public Bono(){}
    private String NombreJugador;

    public String getNombreJugador() {
        return NombreJugador;
    }

    public void setNombreJugador(String NombreJugador) {
        this.NombreJugador = NombreJugador;
    }
      private double porcentajeIndividual;

    public double getPorcentajeIndividual() {
        return porcentajeIndividual;
    }

    public void setPorcentajeIndividual(double porcentajeIndividual) {
        this.porcentajeIndividual = porcentajeIndividual;
    }
}
