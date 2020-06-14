package Dao;

import Modelo.VeterinarioModelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeterinarioDao extends Conexion {
    
    //2. Crear un metodo (public void + listar/inactivar) 
    public void agregarVeterinario(VeterinarioModelo veterinario) throws SQLException{
        //3. Crea un bloqur try
        try {
            //4. conectar la base de datos (this. conexion) 
            this.conexion();
            String sql = "INSERT INTO VETERINARIO VALUES (null, ?, ?, str_to_date( ?,'%d/%m/%Y'), ?, ?, ?, ?)";
            //5. Crear un prepared statement + alias = this.getCn(). preparedstatement (sql)
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            //6. ps.set + tipo de variable + (numero de lista, tabla + .get + Variable)
            ps.setInt(1, veterinario.getId());
            ps.setString(2, veterinario.getNombre());
            ps.setString(3, veterinario.getApellido());
            ps.setString(4, veterinario.getFecha_nacimiento());
            ps.setString(5, veterinario.getDireccion());
            ps.setString(6, veterinario.getCel());
            ps.setString(7, veterinario.getDni());
            //7. executar actualizacion
            ps.executeUpdate();
        } catch (SQLException e) {
            //Opcional: Añadir una salida para mensaje de error
            System.err.println("Ocurrió un error al agregar veterinario: "+ e.getMessage());
            //8. Añadir un finally para terminar el método
        } finally{
            //Desconectar
            this.Desconnection();
        }
    }
    
    //9. Agregar un método para listar
    public ArrayList<VeterinarioModelo> ListarVeterinario() throws SQLException {
        this.conexion();
        ResultSet rs;
        ArrayList<VeterinarioModelo> lista;
        try {
            String sql = "SELECT id_veterinario, name_veterinarian, surname_veterinarian, birthdate, direction, n_cel, n_dni from veterinario" ;
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                        new VeterinarioModelo(
                                rs.getInt("ID"),
                                rs.getString("NOMBRE"),
                                rs.getString("APELLIDO"),
                                rs.getString("FECHA_NACIMIENTO"),
                                rs.getString("DIRECCION"),
                                rs.getString("CELULAR"),
                                rs.getString("DNI")
                        )
                );
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("Error al listar veterinario: "+ e.getMessage());
            return null;
        } finally{
            this.Desconnection();
        }
    }
}
