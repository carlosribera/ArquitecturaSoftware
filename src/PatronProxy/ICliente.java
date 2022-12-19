package PatronProxy;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public interface ICliente {

    public void agregar(String nombre, String apPaterno, String apMaterno, String correo, String direccion, int telefono);

    public void modificar(int id, String nombre, String apPaterno, String apMaterno, String correo, String direccion, int telefono);

    public void eliminar(int id);

    public ArrayList listar();

}
