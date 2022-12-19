package Datos.PatronPlantilla;

import Datos.DMecanico;

/**
 *
 * @author andre
 */
public class ListarTodos extends DMecanico {

    @Override
    public void operacionListar() {
        this.sentenciaSQL = "SELECT *FROM mecanico";
    }
}
