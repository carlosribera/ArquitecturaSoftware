package PatronEstado;

/**
 *
 * @author andre
 */
public interface IEstadoVehiculo {

    public void mantenimiento(Estado estado);

    public void reparacion(Estado estado);

    public void revision(Estado estado);

    public void entregado(Estado estado);
}
