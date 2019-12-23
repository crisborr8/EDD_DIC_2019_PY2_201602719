package Usuario;

public class User_Menu extends Frame.Frame{
    
    Frame.Login lgn;
    EDD.Hash hash;
    
    public User_Menu(EDD.Hash hash, String usr, String psw){
        this.hash = hash;
        setUserMenu();
        lbl0.setText("Nombre:   " + usr);
        lbl1.setText("Apellido: " + psw);
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
        lgn = new Frame.Login(hash);
    }
    
}
