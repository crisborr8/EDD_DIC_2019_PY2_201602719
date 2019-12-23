package Usuario;

public class User_TreesAVL_Insertar extends Frame.Frame{
    
    User_TreesAVL uTA;
    EDD.Hash hash;
    int carnet;
    
    public User_TreesAVL_Insertar(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL_Insertar();
        int disp = hash.getDispercion(carnet);
        EDD.Usuario usuario = hash.getUsuario(carnet, disp);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
    }
    
    @Override
    protected void setBtn0(){
        
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
