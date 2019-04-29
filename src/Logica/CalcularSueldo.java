/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Bono;
import Modelo.Equipo;
import Modelo.Jugador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CalcularSueldo {
    //metodo sueldoTotal encotraremos el saldo total del jugador. 
    public ArrayList<Jugador> SueldoTotal(ArrayList<Jugador> listJugador)
    {
        //se ocupara la variable para calcular el sueldo total.  
        double SueltoT;
        //se inicaliza arreglo de tipo jugador
        ArrayList<Jugador> ListJugadoreSueldo = new ArrayList<Jugador>();
      
        //la variable obtendra lo que retorne el metodo BonoIndividual     
        ListJugadoreSueldo = calcularBono(listJugador);
        //se hace el recorrido de la lista tipo jugador
        for(Jugador item :ListJugadoreSueldo)
        {
            // se calcula el sueldo total del jugador 
            SueltoT=((item.getSueldo_comple()*item.getBono())/100) + item.getSueldo();
            // se agrega el sueldo total en la lista de tipo jugador.
            item.setSueldo_comple(SueltoT);
        }
       //se retorna el arreglo  
       return ListJugadoreSueldo;
    }
    private ArrayList<Jugador> calcularBono(ArrayList<Jugador> listJugador)
   {
        //se almacenara el porcentaje real de jugador
        double TotalBono = 0;
        //se almacenara el porcentaje del bono equipo 
        double subTotalEquipo = 0;
        // se almacenara el porcentaje del bono individual
        double subTotalIndividual = 0;
        //declaramos dos arreglos de tipo bono para realizar el recorrido de la lista bono equipo y bono individual.
        ArrayList<Bono> BonoIndividual = new ArrayList<Bono>();
        ArrayList<Equipo> BonoEquipo = new ArrayList<Equipo>();     
        //la variable obtendra lo que retorne el metodo BonoEquipo
        BonoEquipo = BonoEquipo(listJugador);
        //la variable obtendra lo que retorne el metodo BonoIndividual
        BonoIndividual = BonoIndividual(listJugador);
        //se hace el recorrido de la lista jugador
        for(Jugador item : listJugador)
        {
            //se hace el recorrido de la lista bono equipo
            for(Equipo itemEquipoB : BonoEquipo)
            {
                //validamos que el equipo del jugador sea igual al que almacena la lista bonoEquipon  
                if(item.getEquipo().equals(itemEquipoB.getNombreEquipo()))
                //se almacenara el porcentaje que tenga la lista equipo     
                subTotalEquipo = itemEquipoB.getBonoEquipo();
            }
            //se hace el recorrido de la lista bono individual.    
            for(Bono miBono : BonoIndividual)
            {
                //validamos que el nombre del jugador sea igual al que almacena la lista bonoIndividual  
                if(item.getNombre().equals(miBono.getNombreJugador()))
                subTotalIndividual = miBono.getPorcentajeIndividual();
            }
            // despues de que se hace el recorrido del jugador y obteniendo el porcentaje por equipo y porsentaje individual
            //calcularemos el porcentaje real que le corresponde al jugador.
            TotalBono = (subTotalEquipo + subTotalIndividual)/2 ;
            //inicializamos las variables en cero para el siguiente jugador
            subTotalEquipo = 0; subTotalIndividual = 0;
            //se almacena el porcentaje real que se encuentra en la variable totalBono en el arreglo jugador
            item.setSueldo_comple(TotalBono);
        }
      // por ultimo se retorna el arreglo de tipo jugador.  
      return listJugador;
   }
   //El metodo BonoIndividual calcularemos el porcentaje del bono que le corresponde a cada jugador por goles anotador individual     
   private ArrayList<Bono> BonoIndividual(ArrayList<Jugador> listJugador)
    {
        //variable creada para almacenar el porcentaje obtenido por bono individual 
        double porcentaje=0;
        // asignacion de arreglo de tipo bono, almacenaremos el bono obtenido por cada jugador
        ArrayList<Bono> listBonos = new ArrayList<>();
        //crear variable de tipo bono.
        Bono itemBono; 
        // se realizara el recorrido del arreglo de tipo jugador, para identificar el nivel y el total de goles del jugador.  
        for (Jugador item : listJugador)
        {
            //inicializar la variable  
            itemBono = new Bono();
            // identificamos el nivel del jugador del listado de jugadores
            
                switch(item.getNivel())
                {
                    case "A":
                        //calculamos el porcentaje del bono indivudal por jugador
                        porcentaje=((item.getTotalGoles()*100)/Cat_Nivel.Clase_A.getMetaGoles());
                    break;
                    case "B":
                        porcentaje=((item.getTotalGoles()*100)/Cat_Nivel.Clase_B.getMetaGoles());
                    break;
                    case "C":
                        porcentaje=((item.getTotalGoles()*100)/Cat_Nivel.Clase_C.getMetaGoles());
                    break;
                    case "Cuauh":
                        porcentaje=((item.getTotalGoles()*100)/Cat_Nivel.Clase_D.getMetaGoles());
                    break;
                    default:JOptionPane.showMessageDialog(null, "El nivel de algunos jugadores no se encuentran en el catalogo por ende no le gorresponde el bono individual."); break ;
                }
            
            
            //se almacena el nombre de jugador del arreglo jugador
            itemBono.setNombreJugador(item.getNombre());
            // si el jugador mete mas goles que el maximo de goles se le dara el 100%
            double porcetajeIndividual=porcentaje>100? 100: porcentaje;
            itemBono.setPorcentajeIndividual(porcetajeIndividual);
            listBonos.add(itemBono);
            porcentaje=0;
        }
      //Se retorna el listado anteriormente llenado.  
      return listBonos;
   }
   private ArrayList<Equipo> BonoEquipo(ArrayList<Jugador> listJugador)
    {
        // se crean dos variables para que almacenen temporal el numero de goles y el numero de goles meta
        int golesOptenidosEquipo=0, golesMetaEquipo=0;
        double porcentaje;
        ArrayList<Equipo> listEquipos = new ArrayList<>();
        //realiza el barrido de lista de equipos
        for(Equipo equipo : Equipos(listJugador))
        {   
            //realiza el barrido de la lista jugadores
            for(Jugador item : listJugador)
            {
                if(item.getEquipo().equals(equipo.getNombreEquipo()))
                {   //se valida de que nivel es el jugador 
                    switch(item.getNivel())
                    {
                        case "A":
                            //realizamos el conteo de goles anotador 
                            golesOptenidosEquipo += item.getTotalGoles();
                            //se hace el conteo de meta de goles.
                            golesMetaEquipo += Cat_Nivel.Clase_A.getMetaGoles();
                        break;
                        case "B":
                            golesOptenidosEquipo += item.getTotalGoles();
                            golesMetaEquipo += Cat_Nivel.Clase_B.getMetaGoles(); 
                        break;
                        case "C":
                            golesOptenidosEquipo += item.getTotalGoles();
                            golesMetaEquipo += Cat_Nivel.Clase_C.getMetaGoles(); 
                        break;
                        case "Cuauh":
                            golesOptenidosEquipo += item.getTotalGoles();
                            golesMetaEquipo += Cat_Nivel.Clase_D.getMetaGoles(); 
                        break;
                        default:JOptionPane.showMessageDialog(null, "El nivel de algunos jugadores no se encuentran en el catalogo eso causara alteracion en el porcentaje grupal."); break; 
                    }
                 
                }
            }
            // calcula el porcentaje que le corresponde
            porcentaje=(golesOptenidosEquipo*100)/golesMetaEquipo;
            //se valida que el porcentaje total se maximo 100
            double porcentajeEquipo = porcentaje > 100 ? 100 : porcentaje;
            //se almacena el porcentajeEquipo en la variable equipo
            equipo.setBonoEquipo(porcentajeEquipo);
            //se hace el llenado de la lista equipos en donde almacena el grupo y el porcentaje obtenido por equipo
            listEquipos.add(equipo);
            //resetea las variables para el siguiente equipo
            golesOptenidosEquipo = 0; golesMetaEquipo=0;
        } 
        //retorna la lista equipos
        return listEquipos;
    }
   //metodo Equipos guadara en una lista los equipos sin repetir ningun equipo. 
   private ArrayList<Equipo> Equipos(ArrayList<Jugador> listJugador)
   {
        //se crea un ArrayList de tipo equipo en donde despues la ocuparemos para almacenar los equipos que contega ganada jugador.
        ArrayList<Equipo> TodosEquipos = new ArrayList<Equipo>();
        // se crea un ArrayList de tipo equipo para despues campara los equipos.
        ArrayList<Equipo> listEquipos = new ArrayList<Equipo>();
        // se crea el objeto de tipo equipo. 
        Equipo itemEquipo;
        //se hace el barrido de la lista de jugadores 
        for(Jugador itemJugador : listJugador)
        {
            // se hace la instacia 
            itemEquipo = new Equipo();
            // se almacena la informacion del equipo
            itemEquipo.setNombreEquipo(itemJugador.getEquipo());
            // se hace el llenado de la lista equipos de los equipos que tiene cada jugador.
            TodosEquipos.add(itemEquipo);
        }
        // listEquipos guadar la lista de TodosEquipos
        listEquipos = TodosEquipos;
        // declaramos una variable para la validacion de que solo el primer equipo de los repetidos no lo elimine.
        int bandera=0;
        // hacemos el recorrido de la lista listEquipos
        for (int i=0; i<listEquipos.size();i++){
            // hacemos el recorrido de la lista TodosEquipos
            for (int e=0; e<=TodosEquipos.size();e++){
                //se hace la comparacion si los quipos son iguales entra al if. 
                if (TodosEquipos.get(i).getNombreEquipo().equals(listEquipos.get(e).getNombreEquipo())){
                    //aqui validamos que el primer equipo repetido no se elimine.
                    bandera++;
                    // en caso de que la bandera se mayor a 1, entra a aliminar el equipos de la lista listEquipos  
                    if(bandera>1)
                    {
                        //se elimina el equipo de la lista listEquipos 
                        listEquipos.remove(e);
                        //se reinicia la bandera 
                        bandera=0;
                    }
                }
                
            }
        }
      //retorna la lista de equipos sin los repetidos  
      return TodosEquipos;
   }
      
}
