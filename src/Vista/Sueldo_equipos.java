/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Logica.CalcularSueldo;
import Modelo.Jugador;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author FYR
 */
public class Sueldo_equipos {

    
    public static void main(String[] args) {
        //metodo en donde leeremos el archivo json
        Entrada();
    }
    //se hace la busqueda del archivo json y obtendremos la lista que contega, en este caso lista jugadores.
    public static void Entrada()
    {
        //se crea un Arraylista para almacenar cada uno de los objetos de lista Jugadores que tiene el archivo json. 
        ArrayList<Jugador> listJugador = new ArrayList<Jugador>();
        //se hace una instancia de tipo jugador, para almacenar cada uno de los datos que tiene el objeto
        Jugador itemJugador = new Jugador();
        // instacia para trael el archivo json
        JSONParser parser = new JSONParser();
        // se valida que el proceso no falle, por ejemplo que no encuentre el archivo o que los datos de cada objeto de 
        //la lista jugador con traer el archivo json cuadren con lo que se espera. 
        try {
            // se hace la busqueda del archivo json.
            Object obj = parser.parse(new FileReader("C:\\Users\\FYR\\Downloads\\Exa_Sueldo_Jugadores\\jugadores.json"));
            //se hace un casting de tipo ojeto ha JSONArray
            JSONArray jsonObject = (JSONArray)obj;
            // se hace el recorrido del tamoño de la lista obtenido de archivo json
            for(int i=0; i < jsonObject.size() ; i++)
            {
                // se castea el JSONArray en JSONObject
                JSONObject object = (JSONObject)jsonObject.get(i);
                //obtendremos cada uno de los datos de cada objeto que contega la lista del archivo json.
                String nombre = object.get("nombre").toString();
                //se almacena el dato obtendido del arraglo  en la instacia itemJugador
                itemJugador.setNombre(nombre);

                String nivel = object.get("nivel").toString();
                itemJugador.setNivel(nivel);

                String goles = object.get("goles").toString();
                // se hace el cansting del valor de tipo cadena por el esperado, en este caso un int.
                int iGoles=Integer.parseInt(goles);
                itemJugador.setTotalGoles(iGoles);

                String sueldo = object.get("sueldo").toString();
                double dSueldo = Double.parseDouble(sueldo);
                itemJugador.setSueldo(dSueldo);

                String bono = object.get("bono").toString();
                double dBono = Double.parseDouble(bono);
                itemJugador.setBono(dBono);

                String equipo = object.get("equipo").toString();
                itemJugador.setEquipo(equipo);
                // despues de almacenar cada uno de los datos del objeteno que trae la lista se agrega en la lista detipo jugador  
                listJugador.add(itemJugador);
                // se resetea la variable de tipo jugador para el siguiente objeto en caso de que espero otro obtejo del la lista., 
                itemJugador = new Jugador();

            }
        } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error no se encontro el archivo JSon revisar URL");
                //manejo de error
        } catch (IOException e) {
                //manejo de error
        } catch (ParseException e) {
                //manejo de error
        }
     //metodo que imprime la lista jugador.   
     salida(listJugador);
    }
    // se imprimira los datos de la lista jugador junto con el total sueldo de cada uno de los jugadores. 
    public static void salida(ArrayList<Jugador> listJugador)
    {
        //se instancia el  objeto calcular de tipo CalcularSueldo
        CalcularSueldo calcular = new CalcularSueldo();
        // se creo un ArrayList de tipo jugador para almacenar lo que retorna el metodo SueldoTotal
        ArrayList<Jugador> jugadoresPagados = calcular.SueldoTotal(listJugador);
        //se hace el recorrido de la lista jugadoresPagados
        for(Jugador datosJugador:jugadoresPagados)
        {   
            //se imprimen los datos del objeto
            System.out.println("Nombre: "+datosJugador.getNombre()+" ");
            System.out.println("Equipo: "+datosJugador.getEquipo()+" ");
            System.out.println("Nivel: "+datosJugador.getNivel()+" ");
            System.out.println("Sueldo: "+datosJugador.getSueldo()+" ");
            System.out.println("Bono: "+datosJugador.getBono()+" ");
            System.out.println("Total Goles: "+datosJugador.getTotalGoles()+" ");
            System.out.println("Sueldo Total: "+datosJugador.getSueldo_comple()+"\n\n ");
        }
    }
    
}
