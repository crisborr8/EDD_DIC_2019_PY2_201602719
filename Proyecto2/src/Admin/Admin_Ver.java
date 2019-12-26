package Admin;

public class Admin_Ver extends Frame.Frame{
    
    Admin_Menu aM;
    EDD.Hash hash;
    
    public Admin_Ver(EDD.Hash hash){
        this.hash = hash;
        setAdminVer();
    }
    
    @Override
    protected void setBtn0(){
        EDD.Hash.Usuario[] tablaHash = hash.getTabla();
        for(int i = 0; i < tablaHash.length; i++){
            if(tablaHash[i] != null){
                System.out.println("-->" + tablaHash[i].getNombre() + " " +
                                   " " + tablaHash[i].getApellido() + "\n" +
                                   "\tContraseña: " + tablaHash[i].getContraseña() + "\n" +
                                   "\tCarnet: " + tablaHash[i].getCarnet() + "\n");
            }
        }
    }
    protected void setBtn1(){
        clear();
        aM = new Admin_Menu(hash);
    }
    
}
