package Negocio;

import Datos.DDetalleReparacion;
import Datos.DReparacion;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class NReparacion {

    private DReparacion dreparacion;
    private ArrayList<DDetalleReparacion> ddetalleReparacion;

    public NReparacion() {
        dreparacion = new DReparacion();
        ddetalleReparacion = new ArrayList<>();
    }

    public void agregar(
            Date fecha,
            String observacion,
            float costototal,
            int idvehiculo,
            ArrayList<Object[]> detalle
    ) {
        for (int i = 0; i < detalle.size(); i++) {
            System.out.println("mostrar :" + " 0: " + detalle.get(i)[0] + " 1: " + detalle.get(i)[1] + " 2: " + detalle.get(i)[2]);
            //montototal=montototal+Integer.parseInt( String.valueOf(detalle.get(i)[1]));
        }
        this.dreparacion.setFecha(fecha);
        this.dreparacion.setObservacion(observacion);
        this.dreparacion.setCostoTotal(costototal);
        this.dreparacion.setIdVehiculo(idvehiculo);
        this.dreparacion.agregar();

        int IdReparacion = this.dreparacion.ultimoId();// aunque en postgres se puede insertar y te devuelve el id con returning
        System.out.println("UltimoID reparacion " + IdReparacion);

        for (int i = 0; i < detalle.size(); i++) {
            System.out.println("list: " + String.valueOf(detalle.get(i)[0]) + " : " + String.valueOf(detalle.get(i)[1]) + " : " + String.valueOf(detalle.get(i)[2]));
            DDetalleReparacion d = new DDetalleReparacion();
            d.setIdreparacion(IdReparacion);// id de cabecera
            d.setIdmecanico(Integer.parseInt(String.valueOf(detalle.get(i)[0]))); //idvehi
            d.setObservacion(String.valueOf(detalle.get(i)[1])); //obs
            d.setPrecio(Float.valueOf(String.valueOf(detalle.get(i)[2]))); //idprecio

            ddetalleReparacion.add(i, d);
            ddetalleReparacion.get(i).agregar();
        }

    }

    public void modificar(
            int idreparacion,
            Date fecha,
            String observacion,
            float costototal,
            int idvehiculo,
            ArrayList<Object[]> detalle
    ) {
        DDetalleReparacion ddetalleRep = new DDetalleReparacion();
        ddetalleRep.eliminarPorId(idreparacion);

        for (int i = 0; i < detalle.size(); i++) {
            System.out.println("mostrar :" + " 0: " + detalle.get(i)[0] + " 1: " + detalle.get(i)[1] + " 2: " + detalle.get(i)[2]);
            //montototal=montototal+Integer.parseInt( String.valueOf(detalle.get(i)[1]));
        }
        this.dreparacion.setIdReparacion(idreparacion);
        this.dreparacion.setFecha(fecha);
        this.dreparacion.setObservacion(observacion);
        this.dreparacion.setCostoTotal(costototal);
        this.dreparacion.setIdVehiculo(idvehiculo);
        this.dreparacion.modificar();

        for (int i = 0; i < detalle.size(); i++) {
            System.out.println("list: " + String.valueOf(detalle.get(i)[0]) + " : " + String.valueOf(detalle.get(i)[1]) + " : " + String.valueOf(detalle.get(i)[2]));
            DDetalleReparacion d = new DDetalleReparacion();
            d.setIdreparacion(idreparacion);// id de cabecera
            d.setIdmecanico(Integer.parseInt(String.valueOf(detalle.get(i)[0]))); //idvehi
            d.setObservacion(String.valueOf(detalle.get(i)[1])); //obs
            d.setPrecio(Float.valueOf(String.valueOf(detalle.get(i)[2]))); //idprecio

            ddetalleReparacion.add(i, d);
            ddetalleReparacion.get(i).agregar();
        }

    }

    public void eliminar(int idReparacion) {
        this.dreparacion.setIdReparacion(idReparacion);
        this.dreparacion.eliminar();
        DDetalleReparacion ddetalleRep = new DDetalleReparacion();
        ddetalleRep.eliminarPorId(idReparacion);
    }

    public ArrayList listar() {
        return dreparacion.listar();
    }

    public ArrayList listarDetallePorId(int idReparacion) {
        DDetalleReparacion ddetalleRep = new DDetalleReparacion();
        return ddetalleRep.listarPorId(idReparacion);
    }

}
