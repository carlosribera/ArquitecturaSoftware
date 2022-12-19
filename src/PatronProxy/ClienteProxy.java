package PatronProxy;

import Negocio.NCliente;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class ClienteProxy implements ICliente {

    private NCliente ncliente;

    public ClienteProxy() {
        ncliente = new NCliente();
    }

    @Override
    public void agregar(String nombre, String apPaterno, String apMaterno, String correo, String direccion, int telefono) {
        ncliente.agregar(nombre, apPaterno, apMaterno, correo, direccion, telefono);
    }

    @Override
    public void modificar(int id, String nombre, String apPaterno, String apMaterno, String correo, String direccion, int telefono) {
        ncliente.modificar(id, nombre, apPaterno, apMaterno, correo, direccion, telefono);
    }

    @Override
    public void eliminar(int id) {
        ncliente.eliminar(id);
    }

    @Override
    public ArrayList listar() {
        return ncliente.listar();
    }

}
