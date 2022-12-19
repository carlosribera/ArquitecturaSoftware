package PatronEstado;

/**
 *
 * @author andre
 */
public class EnMantenimiento implements IEstadoVehiculo {

    public EnMantenimiento() {
    }

    @Override
    public void mantenimiento(Estado estado) {
        estado.setMensaje("Ya esta en Mantenimiento");
        estado.setEstadoActual("Mantenimiento");
    }

    @Override
    public void reparacion(Estado estado) {
        estado.setEstado(new EnReparacion());
        estado.setMensaje("Esta en Reparación");
        estado.setEstadoActual("Reparacion");
    }

    @Override
    public void revision(Estado estado) {
        estado.setMensaje("No puedes Cambiiar a Revisión");
        estado.setEstadoActual("Mantenimiento");
    }

    @Override
    public void entregado(Estado estado) {
        estado.setMensaje("No puedes Cambiar a Entregado");
        estado.setEstadoActual("Mantenimiento");
    }

}
