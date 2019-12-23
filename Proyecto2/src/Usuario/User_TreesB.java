package Usuario;

public class User_TreesB extends Frame.Frame{
        
    User_TreesB_Insertar uTBI;
    User_TreesB_Eliminar uTBE;
    User_Trees uT;
    EDD.Hash hash;
    int carnet;
    
    public User_TreesB(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesB();
        int disp = hash.getDispercion(carnet);
        EDD.Usuario usuario = hash.getUsuario(carnet, disp);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
    }
    
    @Override
    protected void setBtn0(){
        clear();
        uTBI = new User_TreesB_Insertar(hash, carnet);
    }
    protected void setBtn1(){
        clear();
        uTBE = new User_TreesB_Eliminar(hash, carnet);
    }
    protected void setBtn2(){
        clear();
        uT = new User_Trees(hash, carnet);
    }
}
