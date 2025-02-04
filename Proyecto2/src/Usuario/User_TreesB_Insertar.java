package Usuario;

public class User_TreesB_Insertar extends Frame.Frame{
    
    User_TreesB uTB;
    EDD.Hash hash;
    EDD.ArbolB.Nodo raiz;
    Json.Abrir aB;
    int carnet;
    
    public User_TreesB_Insertar(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesB_Insertar();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
    }
    
    @Override
    protected void setBtn0(){
        aB = new Json.Abrir();
        raiz = aB.abrirTreeB();
    }
    protected void setBtn1(){
        
    }
    protected void setBtn2(){
        
    }
    protected void setBtn3(){
        clear();
        uTB = new User_TreesB(hash, carnet);
    }
    
}
