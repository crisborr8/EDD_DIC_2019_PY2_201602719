package Usuario;

public class User_Matriz extends Frame.Frame{
    
    User_Menu uM;
    EDD.Hash hash;
    int carnet;
    
    public User_Matriz(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserMatriz();
        int disp = hash.getDispercion(carnet);
        EDD.Usuario usuario = hash.getUsuario(carnet, disp);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());     
        rb0.setSelected(true);
    }
    
    @Override
    protected void setRb0(){
        if(rb0.isSelected()){
            rb1.setSelected(false);
        }else{
            rb1.setSelected(true);
        }
    }
    protected void setRb1(){
        if(rb1.isSelected()){
            rb0.setSelected(false);
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
