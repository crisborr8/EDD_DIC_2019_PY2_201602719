package Usuario;

public class User_TreesAVL_Eliminar extends Frame.Frame{
    
    User_TreesAVL uTA;
    EDD.Hash hash;
    EDD.ArbolAVL.Nodo raiz;
    Json.Abrir aB;
    int carnet;
    
    public User_TreesAVL_Eliminar(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL_Eliminar();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
    }
    
    @Override
    protected void setBtn0(){
        aB = new Json.Abrir();
        raiz = aB.abrirTreeAVL();
    }
    protected void setBtn1(){
        
    }
    protected void setBtn2(){
        
    }
    protected void setBtn3(){
        clear();
        uTA = new User_TreesAVL(hash, carnet);
    }
    
}
