package Controlador;

import Dao.VeterinarioDao;
import Modelo.VeterinarioModelo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VeterinarioControlador {
    
    VeterinarioDao dao = new VeterinarioDao();
    ArrayList<VeterinarioModelo> listaVeterinario = new ArrayList<>();
    
    public boolean agregarVeterinario(String nombre, String apellido, String fecha_nac, String direccion,  String n_cel, String n_dni){
        try {
            dao.agregarVeterinario(new VeterinarioModelo(0, nombre, apellido, fecha_nac, direccion, n_cel, n_dni));
            return true;
        } catch (SQLException e) {
            System.err.println("Ocurrió un error al agregar un nuevo veterinario: "+ e.getMessage());
            return false;
        }
    }      
    
    public DefaultTableModel listarVeterinario() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Fecha Nacimiento", "Dirección", "Nº Celular", "Nº DNI"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Object[] registros = new Object[7];
        try {
            listaVeterinario = dao.ListarVeterinario();
            for(int i=0; i<listaVeterinario.size(); i++){
                registros[0] = listaVeterinario.get(i).getId();
                registros[1] = listaVeterinario.get(i).getNombre();
                registros[2] = listaVeterinario.get(i).getApellido();
                registros[3] = listaVeterinario.get(i).getFecha_nacimiento();
                registros[4] = listaVeterinario.get(i).getDireccion();
                registros[5] = listaVeterinario.get(i).getCel();
                registros[6] = listaVeterinario.get(i).getDni();
                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            System.err.println("Ocurrió un error al listar veterinario: "+ e.getMessage());
            return null;
        }
    }
}
