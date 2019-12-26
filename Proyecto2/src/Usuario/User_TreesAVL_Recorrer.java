package Usuario;

public class User_TreesAVL_Recorrer extends Frame.Frame{

    User_TreesAVL uTA;
    EDD.Hash hash;
    EDD.ArbolAVL.Nodo raiz;
    Json.Abrir aB;
    int carnet;
    
    public User_TreesAVL_Recorrer(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL_Recorrer();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
        rb0.setSelected(true);
    }
    
    @Override
    protected void setRb0(){
        if(rb0.isSelected()){
            rb1.setSelected(false);
            rb2.setSelected(false);
        }else{
            rb1.setSelected(true);
        }
    }
    protected void setRb1(){
        if(rb1.isSelected()){
            rb0.setSelected(false);
            rb2.setSelected(false);
        }else{
            rb2.setSelected(true);
        }
    }
    protected void setRb2(){
        if(rb2.isSelected()){
            rb0.setSelected(false);
            rb1.setSelected(false);
        }else{
            rb0.setSelected(true);
        }
    }
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
