package Datos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author andre
 */
public class DReparacion {

    private int idReparacion;
    private Date fecha;
    private String observacion;
    private float costoTotal;
    private int idVehiculo;

    private Conexion conexion;
    private Connection con;

    public DReparacion() {
    }

    // Getters and Setters
    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdReparacion() {
        return idReparacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    //Metodos y funciones CRUD
    public void agregar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "INSERT INTO reparacion (fecha, observacion, costototal, idvehiculo) VALUES (?,?,?,?);";
        //System.out.println("fecha3 "+(java.sql.Date)this.fecha);
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) this.fecha);
            ps.setString(2, this.observacion);
            ps.setFloat(3, this.costoTotal);
            ps.setInt(4, this.idVehiculo);
            ps.execute();
            System.out.println("Reparacion Insertado exitosamente...");
        } catch (Exception e) {
            System.out.println(" Error al Insertar Reparacion... " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void modificar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "UPDATE reparacion SET fecha=?, observacion=?, costototal=?, idvehiculo=? WHERE idreparacion=" + this.idReparacion;
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(this.fecha.getTime()));
            ps.setString(2, this.observacion);
            ps.setFloat(3, this.costoTotal);
            ps.setInt(4, this.idVehiculo);
            ps.execute();
            ps.close();
            System.out.println("Reparacion modificado exitosamente");
        } catch (Exception e) {
            System.out.println("error al modificar.." + e.getMessage());
        }
    }

    public void eliminar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "DELETE FROM reparacion WHERE idreparacion=" + this.idReparacion;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            ps.close();
            System.out.println("Reparacion Eliminado exitosamente...");
        } catch (Exception e) {
            System.out.println("Error al Elimar Reparacion... ");
        }
    }

    public ArrayList listar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps = null;
        ArrayList<Object[]> mec = new ArrayList<>();
        String sql = "SELECT *FROM reparacion";
        try {
            ps = con.prepareCall(sql);
            ResultSet r;
            r = ps.executeQuery();
            while (r.next()) {
                mec.add(new Object[]{
                    r.getInt(1),//id
                    r.getDate(2),//fecha
                    r.getString(3),//obs
                    r.getString(4),//cos
                    r.getInt(5)//idvehic                
                });
                //System.out.println("lis "+ r.getInt(1)+" " +r.getString(2));
            }
            System.out.println("listando Reparacion... ");
        } catch (Exception e) {
            System.out.println("Error al listar Reparacion....");
            return null;
        }
        return mec;
    }

    public int ultimoId() {
        int aux = 0;
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps = null;
        String sql = "SELECT MAX(idreparacion) FROM reparacion";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet r;
            r = p.executeQuery();
            //System.out.println("resulSet "+ r);
            while (r.next()) {
                aux = r.getInt(1);
                System.out.println("max: " + r.getInt(1));

            }
        } catch (Exception e) {
            System.out.println("Error Obtener ultimo ID Reparacion...");

        }
        return aux;
    }

}
