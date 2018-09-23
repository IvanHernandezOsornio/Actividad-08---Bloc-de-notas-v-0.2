
package modelo;

/**
 * 
 * @author Familia Hernández
 */

public class Modelos {     //creamos un paquete de modelos
    
    private String leer;        //almacenamos una variables ed apoyo 
    private String guardar;
    private String menu;

    public String getLeer() {
        return leer;
    }

    public void setLeer(String leer) {
        this.leer = leer;
    }
                                                        //(alt + insert) 
    public String getGuardar() {                        // creamos metodos Get y Set para cada una de ellas
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
    
    
   
   
    
}
