package Usuario;

public class User_Menu extends Frame.Frame{
    
    User_Trees uT;
    User_Matriz uM;
    User_Algoritmos uA;
    Frame.Login lgn;
    EDD.Hash hash;
    int carnet;
    
    public User_Menu(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserMenu();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());
    }
    
    @Override
    protected void setBtn0(){
        clear();
        uT = new User_Trees(hash, carnet);
    }
    protected void setBtn1(){
        clear();
        uM = new User_Matriz(hash, carnet);
    }
    protected void setBtn2(){
        clear();
        uA = new User_Algoritmos(hash, carnet);
    }
    protected void setBtn3(){
        clear();
        lgn = new Frame.Login(hash);
    }
    
}
