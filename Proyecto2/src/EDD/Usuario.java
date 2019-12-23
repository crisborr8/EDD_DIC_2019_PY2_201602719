package EDD;

public class Usuario {
    
    private String nombre;
    private String apellido;
    private String contraseña;
    private int carnet;
    
    //**************************************************************************
    //**************************************************************************
    //SET DEL USUARIO
    public void setUsuario(String nombre, String apellido, String contraseña, int carnet){
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.carnet = carnet;
    }
    
    //**************************************************************************
    //**************************************************************************
    //GETS DEL USUARIO
    public String getNombre(){ return nombre;}
    public String getApellido() { return apellido;}
    public String getContraseña() { return contraseña;}
    public int getCarnet() { return carnet;}
    
}
