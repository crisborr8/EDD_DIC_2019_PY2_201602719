package Usuario;

public class User_TreesAVL extends Frame.Frame{
    
    User_TreesAVL_Insertar uTAI;
    User_TreesAVL_Eliminar uTAE;
    User_TreesAVL_Recorrer uTAR;
    User_Trees uT;
    EDD.Hash hash;
    int carnet;
    
    public User_TreesAVL(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL();
        int disp = hash.getDispercion(carnet);
        EDD.Usuario usuario = hash.getUsuario(carnet, disp);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
    }
    
    @Override
    protected void setBtn0(){
        clear();
        uTAI = new User_TreesAVL_Insertar(hash, carnet);
    }
    protected void setBtn1(){
        clear();
        uTAE = new User_TreesAVL_Eliminar(hash, carnet);
    }
    protected void setBtn2(){
        clear();
        uTAR = new User_TreesAVL_Recorrer(hash, carnet);
    }
    protected void setBtn3(){
        clear();
        uT = new User_Trees(hash, carnet);
    }
    
}
