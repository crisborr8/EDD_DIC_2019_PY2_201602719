package Usuario;

import Frame.Frame;

public class Usuario_Inicio extends Frame{
    
    Usuario_Arbol usAr;
    Login.Login lg;
    EDD.Hash hash;
    
    public Usuario_Inicio(Login.Login lg){
        this.lg = lg;
        frame.setVisible(false);
        usAr = new Usuario_Arbol(this);
        setUserInicio();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //ARBOLES
    @Override
    protected void setBtn0(){
        usAr.setDatos(datos);
        frame.setVisible(false);
        usAr.setVisible();
    }
    //MATRIZ
    @Override
    protected void setBtn1(){
        
    }
    //ORDENAMIENTOS
    @Override
    protected void setBtn2(){
        
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        lg.setVisible();
        frame.setVisible(false);
    }
}
