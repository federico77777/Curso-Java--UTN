package Paquete1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ProgramaPrincipal1 {

    public static void main(String[] args) throws IOException {

        // Se crean las listas donde se almacenarán los partidos y pronósticos
        ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
        ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
        
        // Se crean objetos para cada clase
        Pronostico unPronostico;
        Partido unPartido;
        Equipo unEquipo1;
        Equipo unEquipo2;
             

        // Se define la ruta del archivo de resultados y se lee línea por línea
        String archivo = "archivostexto\\resultados.txt\\";
        for (String linea : Files.readAllLines(Paths.get(archivo))) {
            String[] datos = linea.split(" ");
            
            // Se crean nuevos objetos para cada partido, equipo y pronóstico
            unPartido = new Partido();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();
            unPronostico = new Pronostico();


            // Se asignan los nombres de los equipos
            unEquipo1.nombre = datos[0];
            unEquipo2.nombre = datos[3];
            
            // Se asignan los equipos al partido
            unPartido.equipo1 = unEquipo1;
            unPartido.equipo2 = unEquipo2;
            
            // Se asignan los goles a cada equipo
            unPartido.golesEquipo1 = Integer.parseInt(datos[1]);
            unPartido.golesEquipo2 = Integer.parseInt(datos[2]);
            
            // Se añade el partido a la lista de partidos
            listaPartidos.add(unPartido);
            
            // Se calculan los puntos de cada equipo según el resultado del partido
            if (unPartido.golesEquipo1 > unPartido.golesEquipo2) {
            	unPartido.puntosEquipo1 = 3;
            	unPartido.puntosEquipo2 = 0;
             }
            if (unPartido.golesEquipo1 < unPartido.golesEquipo2) {
            	unPartido.puntosEquipo1 = 0;
            	unPartido.puntosEquipo2 = 3;
             }
            if (unPartido.golesEquipo1 == unPartido.golesEquipo2) {
            	unPartido.puntosEquipo1 = 1;
            	unPartido.puntosEquipo2 = 1;
             }
            
        }
        
        // Se define la ruta del archivo de pronósticos y se lee línea por línea
        String archivo1 = "archivostexto\\pronosticos.txt\\";
        for (String linea : Files.readAllLines(Paths.get(archivo1))) {
            String[] datos = linea.split(" ");
            
            // Se crean nuevos objetos para cada partido, equipo y pronóstico
            unPartido = new Partido();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();
            unPronostico = new Pronostico();
            
            //Se asignan los nombres de los equipos
            unEquipo1.nombre = datos[0];
            unEquipo2.nombre = datos[3];
            
            //Se asignan los equipos al partido
            unPartido.equipo1 = unEquipo1;
            unPartido.equipo2 = unEquipo2;
            //Se asignan los goles al partido
            unPartido.golesEquipo1 = Integer.parseInt(datos[1]);
            unPartido.golesEquipo2 = Integer.parseInt(datos[2]);

            //Se asignan los equipos al pronostico
            unPronostico.equipo1 = unEquipo1;
            unPronostico.equipo2 = unEquipo2;
            
          //Se asignan los goles al pronostico    
            unPronostico.golesEquipo1 = Integer.parseInt(datos[1]);
            unPronostico.golesEquipo2 = Integer.parseInt(datos[2]);
            listaPronosticos.add(unPronostico);
            
          //Se asignan 1 punto al pronostico , si acierta el resultado final y 0 si no acierta.  
            
            
            if (unPartido.golesEquipo1 > unPartido.golesEquipo2 && unPronostico.golesEquipo1 > unPronostico.golesEquipo2) {
                unPronostico.puntosPronostico = 1;
            }
            if (unPartido.golesEquipo1 < unPartido.golesEquipo2 && unPronostico.golesEquipo1 < unPronostico.golesEquipo2) {
                unPronostico.puntosPronostico = 1;
            }
            if (unPartido.golesEquipo1 == unPartido.golesEquipo2 && unPronostico.golesEquipo1 == unPronostico.golesEquipo2) {
                unPronostico.puntosPronostico = 1;
            }
         }
            
                                       
    
    for (int i = 0; i < listaPartidos.size(); i++) {
     JOptionPane.showMessageDialog(null,listaPartidos.get(i).equipo1.nombre + " " + listaPartidos.get(i).golesEquipo1 + " " + listaPartidos.get(i).golesEquipo2 + " " + listaPartidos.get(i).equipo2.nombre);
    }
    
    
    for (int i = 0; i < listaPronosticos.size(); i++) {
     JOptionPane.showMessageDialog(null,listaPronosticos.get(i).equipo1.nombre + " " + listaPronosticos.get(i).golesEquipo1 + " " + listaPronosticos.get(i).golesEquipo2 +" " + listaPronosticos.get(i).equipo2.nombre+" " + listaPronosticos.get(i).puntosPronostico);
    }
    
    
    }
}
        
    
