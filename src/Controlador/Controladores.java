/**
 *
 * @author Familia Hernández
 *  Creamos el Paquete Main
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Modelos;
import Vistas.Vista;

public class Controladores implements ActionListener {

    private Modelos modelo;                                  //llamar la clase modelo que contiene las variables
    private Vista  vista;                                //llama a la vista
    JFileChooser seleccionar = new JFileChooser();      // creamos un objeto de FFilechooser
    File archivo;
    FileOutputStream salida;

    public Controladores(Modelos modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.ji_archivo.addActionListener(this);
        this.vista.ji_guardar.addActionListener(this);
        initView();
    }

    public void iniciar_vista() {
        vista.setLocationRelativeTo(null);
    }

    /**
     *
     * @Creamos una condiciones para validacion del ji_archivo y ji_guardar de
     * el paquete vista
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.ji_archivo) {
            ji_Archivo_action_performed();
        }
        if (e.getSource() == vista.ji_guardar) {
            ji_Guardar_action_performed();
        }
    }
    File a;

    private void ji_Archivo_action_performed() {

        JFileChooser fileChooser = new JFileChooser();              //Creamos la opcion  JFileChooser como objeto
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) //verifica si el usuario utiliza la opcion 
        {
            FileReader b = null;
            try {
                a = fileChooser.getSelectedFile(); //Seleccionamos el fichero
                vista.jt_block.setText(a.getAbsolutePath()); // trae el archivo seleccionado a el area de texto 
                System.out.println(a);
                JOptionPane.showMessageDialog(null, "Nombre del archivo: " + a.getName());
                b = new FileReader(a);
                vista.jt_block.read(b, ""); //muestra el contenido del fichero en el jtextarea en la parte de la vista 
            } catch (Exception ex) {
                Logger.getLogger(Controladores.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(Controladores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    /**
     * Creamos el metodo para guardar los archivos
     */
    private void ji_Guardar_action_performed() {
        JFileChooser fileChooser = new JFileChooser();          //Se crea el objeto FileChooser
        int seleccion = fileChooser.showSaveDialog(vista.jt_block);//Se abre la ventaa, guardamos la opcion seleccionada
        if (seleccion == JFileChooser.APPROVE_OPTION) {             //Se evalua si el usuario preciona el boton aceptar
            File fichero = fileChooser.getSelectedFile();           //Seleccionamos el fichero
            try (FileWriter fileWriter = new FileWriter(fichero)) {
                fileWriter.write(vista.jt_block.getText());             //Escribir el texto en el fichero
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void initView() {
        vista.setLocationRelativeTo(null);
        vista.jt_block.setText(modelo.getMenu());
        vista.setVisible(true);
    }

    private String Guardar(File archivo, String Documento) {
        String mensaje = null;
        String documento = "";
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Se a Guardado Correctamente";
        } catch (Exception e) {
            return mensaje;
        }
        return null;
    }
}
