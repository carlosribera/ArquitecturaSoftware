package Negocio;

import Datos.DVehiculo;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class NVehiculo {

    private DVehiculo dvehiculo;

    public NVehiculo() {
        this.dvehiculo = new DVehiculo();
    }

    public void agregar(String marca, String modelo, String color, String matricula, int idcliente, String estado) {
        this.dvehiculo.setMarca(marca);
        this.dvehiculo.setModelo(modelo);
        this.dvehiculo.setColor(color);
        this.dvehiculo.setMatricula(matricula);
        this.dvehiculo.setIdCliente(idcliente);
        this.dvehiculo.setEstado(estado);
        this.dvehiculo.agregar();
    }

    public void modificar(int id, String marca, String modelo, String color, String matricula, int idcliente, String estado) {
        this.dvehiculo.setIdVehiculo(id);
        this.dvehiculo.setMarca(marca);
        this.dvehiculo.setModelo(modelo);
        this.dvehiculo.setColor(color);
        this.dvehiculo.setMatricula(matricula);
        this.dvehiculo.setIdCliente(idcliente);
        this.dvehiculo.setEstado(estado);
        this.dvehiculo.modificar();
    }

    public void eliminar(int id) {
        this.dvehiculo.setIdVehiculo(id);
        this.dvehiculo.eliminar();
    }

    public ArrayList listar() {
        return this.dvehiculo.listar();
    }
}
