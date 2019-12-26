package Admin;

public class Admin_Carga extends Frame.Frame{
    
    Admin_Menu aM;
    EDD.Hash hash;
    Json.Abrir aB;
    
    public Admin_Carga(EDD.Hash hash){
        this.hash = hash;
        setAdminCargar();
    }
    
    @Override
    protected void setBtn0(){
        aB = new Json.Abrir();
        hash = aB.abrirUsuarios(hash);
        //int carnet = 5013058;
        //int dispercion = hash.getDispercion(carnet);
        //hash.ingresarUsuario("user", "1", "contra01", carnet, dispercion);
        //carnet = 650215;
    }
    protected void setBtn1(){
        clear();
        aM = new Admin_Menu(hash);
    }
}
