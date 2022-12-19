package Datos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class DDetalleReparacion {

    private int idDetalleRepacion;
    private int idreparacion;
    private int idmecanico;
    private String observacion;
    private float precio;

    private Connection con;
    private Conexion conexion;

    public DDetalleReparacion() {
    }

    public void agregar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps = null;
        String sql = "INSERT INTO detallereparacion (idreparacion, idmecanico, observacion, precio) VALUES(?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, this.idreparacion);
            ps.setInt(2, this.idmecanico);
            ps.setString(3, this.observacion);
            ps.setFloat(4, this.precio);
            ps.execute();
            ps.close();
            System.out.println("DetalleReparacion insertado exitosamente... ");
        } catch (Exception e) {
            System.out.println("Error Insertar DetalleReparacion...");
        }

    }

    public void modificar() {

    }

    public void eliminarPorId(int id) {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "DELETE FROM detallereparacion WHERE idreparacion=" + id;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            ps.close();
            System.out.println("detalleReparacion Eliminado por Id exitosamente...");
        } catch (Exception e) {
            System.out.println("Error al Elimar Detalle por ID... ");
        }
    }

    public ArrayList listarPorId(int id) {
        conexion = new Conexion();
        con = conexion.conectar();
        ArrayList<Object[]> detalle = new ArrayList<>();
        String query = "SELECT *FROM detallereparacion WHERE idreparacion=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet r;
            r = ps.executeQuery();
            while (r.next()) {
                detalle.add(new Object[]{
                    r.getInt(1),//id
                    r.getInt(2),//idrep
                    r.getInt(3),//idmeca
                    r.getString(4),//obs
                    r.getFloat(5)//pre       
                });
            }
        } catch (Exception e) {
            System.out.println("Error Listar detalle..");
            return null;
        }
        return detalle;
    }

    //Getters and Setters
    public void setIdreparacion(int idreparacion) {
        this.idreparacion = idreparacion;
    }

    public void setIdmecanico(int idmecanico) {
        this.idmecanico = idmecanico;
    }

    public void setIdDetalleRepacion(int idDetalleRepacion) {
        this.idDetalleRepacion = idDetalleRepacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdreparacion() {
        return idreparacion;
    }

    public int getIdmecanico() {
        return idmecanico;
    }

    public int getIdDetalleRepacion() {
        return idDetalleRepacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public float getPrecio() {
        return precio;
    }

}
