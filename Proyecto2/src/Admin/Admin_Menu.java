package Admin;

public class Admin_Menu extends Frame.Frame{
    
    Admin_Carga aC;
    Admin_Editar aE;
    Admin_Eliminar aEl;
    Admin_Ver aV;
    Frame.Login lgn;
    EDD.Hash hash;
    
    public Admin_Menu(EDD.Hash hash){
        this.hash = hash;
        setAdminMenu();
    }
    
    @Override
    protected void setBtn0(){
        clear();
        aC = new Admin_Carga(hash);
    }
    protected void setBtn1(){
        clear();
        aE = new Admin_Editar(hash);
    }
    protected void setBtn2(){
        clear();
        aEl = new Admin_Eliminar(hash);
    }
    protected void setBtn3(){
        clear();
        aV = new Admin_Ver(hash);
    }
    protected void setBtn4(){
        clear();
        lgn = new Frame.Login(hash);
    }
    
}
