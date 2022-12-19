/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Conexion {

    private Connection con;
    private String pass = "";
    private String URL = "jdbc:mysql://localhost:3306/tallermec_db";
    private String user = "root";

    public Conexion() {
    }

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conectar MySql... " + e.getMessage());
        }
        return con;
    }
}
