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
public class DCliente {

    private int idCliente;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String correo;
    private String direccion;
    private int telefono;

    private Conexion conexion;
    private Connection con;

    public DCliente() {
    }

    //Getters and Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    // Metodos y funciones CRUD
    public void agregar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "INSERT INTO cliente (nombre, appaterno, apmaterno, correo, direccion, telefono) VALUES (?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.apPaterno);
            ps.setString(3, this.apMaterno);
            ps.setString(4, this.correo);
            ps.setString(5, this.direccion);
            ps.setInt(6, this.telefono);
            ps.execute();
            System.out.println("Cliente Insertado exitosamente...");
        } catch (Exception e) {
            System.out.println(" Error al Insertar Cliente... " + e.getMessage());
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
        String sql = "UPDATE cliente SET nombre=?, appaterno=?, apmaterno=?, correo=?, direccion=?, telefono=? WHERE idcliente=" + this.idCliente;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.apPaterno);
            ps.setString(3, this.apMaterno);
            ps.setString(4, this.correo);
            ps.setString(5, this.direccion);
            ps.setInt(6, this.telefono);
            ps.execute();
            ps.close();
            System.out.println("modificador exitosamente");
        } catch (Exception e) {
            System.out.println("error al modificar.." + e.getMessage());
        }
    }

    public void eliminar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps
                = null;
        String sql = "DELETE FROM cliente WHERE idcliente=" + this.idCliente;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            ps.close();
            System.out.println("Cliente Eliminado exitosamente...");
        } catch (Exception e) {
            System.out.println("Error al Elimar Cliente... ");
        }
    }

    public ArrayList listar() {
        conexion = new Conexion();
        con = conexion.conectar();
        PreparedStatement ps = null;
        ArrayList<Object[]> cli = new ArrayList<>();
        String sql = "SELECT *FROM cliente";
        try {
            ps = con.prepareCall(sql);
            ResultSet r;
            r = ps.executeQuery();
            while (r.next()) {
                cli.add(new Object[]{
                    r.getInt(1),//id
                    r.getString(2),//nombre
                    r.getString(3),//appaterno
                    r.getString(4),//apmaterno
                    r.getString(5),//correo
                    r.getString(6),//direccion
                    r.getInt(7),//telefono
                });
                //System.out.println("lis "+ r.getInt(1)+" " +r.getString(2));
            }
            System.out.println("listando Clientes... ");
        } catch (Exception e) {
            System.out.println("Error al listar....");
            return null;
        }
        return cli;
    }

}
