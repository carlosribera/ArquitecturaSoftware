package PatronEstado;

/**
 *
 * @author andre
 */
public class Estado {

    // Atributos
    protected IEstadoVehiculo estadoVehiculo;
    private String estadoActual = "";
    private String mensaje = "";

    // Constructores
    public Estado(IEstadoVehiculo estado) {
        this.estadoVehiculo = estado;
    }

    public Estado(String estadoActual, String mensaje) {
        this.estadoActual = estadoActual;
        this.mensaje = mensaje;
    }

    //Getters and Setters
    public void setEstado(IEstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public void setEstadoActual(String estado) {
        this.estadoActual = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstadoActual() {
        return this.estadoActual;
    }

    public IEstadoVehiculo getEstado() {
        return this.estadoVehiculo;
    }

    public String getMensaje() {
        return mensaje;
    }

}
