package PatronEstado;

/**
 *
 * @author andre
 */
public class EnRevision implements IEstadoVehiculo {

    @Override
    public void mantenimiento(Estado estado) {
        estado.setMensaje("Ya no Puedes estar en Mantenimiento");
        estado.setEstadoActual("Revision");
    }

    @Override
    public void reparacion(Estado estado) {
        estado.setEstado(new EnReparacion());
        estado.setMensaje("Ya estas en Reparación otra vez");
        estado.setEstadoActual("Reparacion");
    }

    @Override
    public void revision(Estado estado) {
        estado.setMensaje("Ya estas en Revisión");
        estado.setEstadoActual("Revision");
    }

    @Override
    public void entregado(Estado estado) {
        estado.setEstado(new Entregado());
        estado.setMensaje("Ya fue entregado");
        estado.setEstadoActual("Entregado");
    }
}
