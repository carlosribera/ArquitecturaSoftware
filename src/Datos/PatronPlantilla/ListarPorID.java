package Datos.PatronPlantilla;

import Datos.DMecanico;

/**
 *
 * @author andre
 */
public class ListarPorID extends DMecanico{
    
    @Override
    public void operacionListar() {
       this.sentenciaSQL = "SELECT *FROM mecanico WHERE idespecialidad=" + this.idEspecialidad;
        System.out.println(this.sentenciaSQL);
    }
    
}
