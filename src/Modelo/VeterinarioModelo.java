package Modelo;

public class VeterinarioModelo {
    
    //1. Crear las Variables en privado(Private)
    private int id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String direccion;
    private String cel;
    private String dni;
    
    //2. Crear un getter and setter con todas las variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    //3. Crear un constructor con todos
    public VeterinarioModelo(int id, String nombre, String apellido, String fecha_nacimiento, String direccion, String cel, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.cel = cel;
        this.dni = dni;
    }
    //4. Crear un constructor vacio
    public VeterinarioModelo() {
        
    }
    
}
