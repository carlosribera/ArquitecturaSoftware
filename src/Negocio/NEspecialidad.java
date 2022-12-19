package Negocio;

import Datos.DEspecialidad;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class NEspecialidad {

    private DEspecialidad despecialidad;

    public NEspecialidad() {
        despecialidad = new DEspecialidad();
    }

    public void agregar(String nombre) {
        this.despecialidad.setNombre(nombre);
        this.despecialidad.agregar();
    }

    public void eliminar(int id) {
        this.despecialidad.setIdEspecialidad(id);
        this.despecialidad.eliminar();
    }

    public ArrayList listar() {
        return this.despecialidad.listar();
    }

    public void modificar(int id, String nombre) {
        this.despecialidad.setIdEspecialidad(id);;
        this.despecialidad.setNombre(nombre);
        this.despecialidad.modificar();
    }

}
