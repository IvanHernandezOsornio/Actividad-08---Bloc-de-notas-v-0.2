
package main;

import controlador.Controladores;           
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.Modelos;
import Vistas.Vista;
/**
 * 
 * @author Familia Hernández
 *  Creamos el Paquete Main
 */
public class Main {
public void readFile(String path){                          //Creamos el metodo para leer archivos
        try{
            String row;
            try (FileReader file = new FileReader(path)){               //Busca en la ruta para seleccion del archivo
                BufferedReader bufferedReader = new BufferedReader(file);          //si no se encuentra crea una nuevo
                while ((row = bufferedReader.readLine()) != null) {
                    System.out.println(row);
                }
                bufferedReader.close();
            }
        } catch(FileNotFoundException err){                                     // si no se encuentra marcara un error
            System.err.println("File not found: " + err.getMessage());
        } catch(IOException err){
            System.err.println("Error on I/O operation: " + err.getMessage());
        }
    }
    
     public void writeFile(String path, String message){                //creamos el metodo de escritura y gurdado el archivo
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }
        }catch(FileNotFoundException err){
            System.err.println("File not found: " + err.getMessage());
        } catch(IOException err){
            System.err.println("Error on I/O operation: " + err.getMessage());
        }
    }
/**
 * 
 * @Colocamos los paquetes con los metodos 
 */
    public static void main(String[] args) {                           
                                                                        
        Modelos modelo = new Modelos();
         Vista vistas = new Vista();
         Controladores controlador = new Controladores (modelo, vistas);
        
         controlador.iniciar_vista();
         vistas.setVisible(true);
  }
}
