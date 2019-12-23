package Admin;

public class Admin_Carga extends Frame.Frame{
    Admin_Menu aM;
    EDD.Hash hash;
    
    public Admin_Carga(EDD.Hash hash){
        this.hash = hash;
        setAdminCargar();
    }
    
    @Override
    protected void setBtn0(){
        int carnet = 5013058;
        int dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "1", "contra01", carnet, dispercion);
        carnet = 650215;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "2", "contra02", carnet, dispercion);
        carnet = 8406510;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "3", "contra03", carnet, dispercion);
        carnet = 220158;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "4", "contra04", carnet, dispercion);
        carnet = 9801651;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "5", "contra05", carnet, dispercion);
        carnet = 32105160;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "6", "contra06", carnet, dispercion);
        carnet = 654098;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "7", "contra07", carnet, dispercion);
        carnet = 1650650;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "8", "contra08", carnet, dispercion);
        carnet = 78908;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "9", "contra09", carnet, dispercion);
        carnet = 840980;
        dispercion = hash.getDispercion(carnet);
        hash.ingresarUsuario("user", "10", "contra10", carnet, dispercion);
    }
    protected void setBtn1(){
        clear();
        aM = new Admin_Menu(hash);
    }
}
