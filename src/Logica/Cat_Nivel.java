/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author FYR
 */
public enum Cat_Nivel 
{
    Clase_A ("A", 5), //Separamos con comas

    Clase_B ("B", 10),

    Clase_C("C", 15),

    Clase_D ("Cuauh", 20);

    private final String Nivel; 

    private final int MetaGoles; 

    Cat_Nivel (String Nivel, int MetaGoles) { 

        this.Nivel = Nivel;

        this.MetaGoles = MetaGoles;

    } 
    //Métodos de la clase tipo Enum

    public String getNivel() { return Nivel; }

    public int getMetaGoles() { return MetaGoles; }
}
