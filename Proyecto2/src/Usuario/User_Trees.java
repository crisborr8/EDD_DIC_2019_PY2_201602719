package Usuario;

public class User_Trees extends Frame.Frame{
    
    User_TreesAVL uTA;
    User_TreesB uTB;
    User_Menu uM;
    EDD.Hash hash;
    int carnet;
    
    public User_Trees(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTrees();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());     
    }
    
    @Override
    protected void setBtn0(){
        clear();
        uTA = new User_TreesAVL(hash, carnet);
    }
    @Override
    protected void setBtn1(){
        clear();
        uTB = new User_TreesB(hash, carnet);
    }
    @Override
    protected void setBtn2(){
        clear();
        uM = new User_Menu(hash, carnet);
    }
}
