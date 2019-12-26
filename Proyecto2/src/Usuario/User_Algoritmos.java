package Usuario;

public class User_Algoritmos extends Frame.Frame{
    
    User_Menu uM;
    EDD.Hash hash;
    int carnet;
    
    public User_Algoritmos(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserAlgoritmos();
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
        
    }
    protected void setBtn1(){
        
    }
    protected void setBtn2(){
        
    }
    protected void setBtn3(){
        clear();
        uM = new User_Menu(hash, carnet);
    }
    
}
