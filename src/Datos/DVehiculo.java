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
public class DVehiculo {

    private int idVehiculo;
    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private int idCliente;
    private String estado;

    private Conexion conexion;
    private Connection con;

    public DVehiculo() {
    }

    public void agregar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "INSERT INTO vehiculo (marca, modelo, color, matricula, idcliente, estado) VALUES (?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.marca);
            ps.setString(2, this.modelo);
            ps.setString(3, this.color);
            ps.setString(4, this.matricula);
            ps.setInt(5, this.idCliente);
            ps.setString(6, this.estado);
            ps.execute();
            System.out.println("vehiculo Insertado exitosamente...");
        } catch (Exception e) {
            System.out.println(" Error al Insertar vehiculo... " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void modificar() {
        System.out.println("modifica " + this.idVehiculo + this.marca + this.idCliente);
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "UPDATE vehiculo SET marca=?, modelo=?, color=?, matricula=?, idcliente=?, estado=? WHERE idvehiculo=" + this.idVehiculo;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.marca);
            ps.setString(2, this.modelo);
            ps.setString(3, this.color);
            ps.setString(4, this.matricula);
            ps.setInt(5, this.idCliente);
            ps.setString(6, this.estado);
            ps.execute();
            ps.close();
            System.out.println("vehiculo modificado exitosamente");
        } catch (Exception e) {
            System.out.println("error al vehiculo.." + e.getMessage());
        }
    }

    public void eliminar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "DELETE FROM vehiculo WHERE idvehiculo=" + this.idVehiculo;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            ps.close();
            System.out.println("vehiculo Eliminado exitosamente...");
        } catch (Exception e) {
            System.out.println("Error al Elimar vehiculo... ");
        }
    }

    public ArrayList listar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps = null;
        ArrayList<Object[]> mec = new ArrayList<>();
        String sql = "SELECT *FROM vehiculo";
        try {
            ps = con.prepareCall(sql);
            ResultSet r;
            r = ps.executeQuery();
            while (r.next()) {
                mec.add(new Object[]{
                    r.getInt(1),//id
                    r.getString(2),//marcca
                    r.getString(3),//mode
                    r.getString(4),
                    r.getString(5), //matri               
                    r.getInt(6), //idCli
                    r.getString(7)
                });
            }
            System.out.println("listando vehiculos... ");
        } catch (Exception e) {
            System.out.println("Error al listar vehiculos....");
            return null;
        }
        return mec;
    }

    // Getters and Setters
    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

}
