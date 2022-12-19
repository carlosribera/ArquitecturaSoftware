package Negocio;

import Datos.DCliente;
import PatronProxy.ICliente;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class NCliente implements ICliente {

    private DCliente dcliente;

    public NCliente() {
        this.dcliente = new DCliente();
    }

    @Override
    public void agregar(String nombre, String apPaterno, String apMaterno, String correo, String direccion, int telefono) {
        this.dcliente.setNombre(nombre);
        this.dcliente.setApPaterno(apPaterno);
        this.dcliente.setApMaterno(apMaterno);
        this.dcliente.setCorreo(correo);
        this.dcliente.setDireccion(direccion);
        this.dcliente.setTelefono(telefono);
        this.dcliente.agregar();
    }

    @Override
    public void modificar(int id, String nombre, String apPaterno, String apMaterno, String correo, String direccion, int telefono) {
        this.dcliente.setIdCliente(id);
        this.dcliente.setNombre(nombre);
        this.dcliente.setApPaterno(apPaterno);
        this.dcliente.setApMaterno(apMaterno);
        this.dcliente.setCorreo(correo);
        this.dcliente.setTelefono(telefono);
        this.dcliente.setDireccion(direccion);
        this.dcliente.modificar();
    }

    @Override
    public void eliminar(int id) {
        this.dcliente.setIdCliente(id);
        this.dcliente.eliminar();
    }

    @Override
    public ArrayList listar() {
        return this.dcliente.listar();
    }

}
