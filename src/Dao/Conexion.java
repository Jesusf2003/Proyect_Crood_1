package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private Connection cn;
    
    
    //Método para conecrarse a la Base de Datos
    public void conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/prueba", "root", "");
            System.out.println("Se conectó a la base de datos: Prueba");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar con la base de datos Prueba"+ e.getMessage());
        }
    }
    
    //Método para desconectarse a la Base de Datos
    public void Desconnection() throws SQLException{
        if(cn != null){
            if (cn.isClosed() == false){
                cn.close();
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public static void main(String [] args){
        Conexion cnx = new Conexion();
        cnx.conexion();
    }
}
