package Usuario;

import Frame.Frame;

public class Usuario_Inicio extends Frame{
    
    Usuario.Ordenamiento.Inicio iniOrd;
    Usuario.Matriz.Inicio iniMat;
    Usuario_Arbol usAr;
    Login.Login lg;
    EDD.Hash hash;
    
    public Usuario_Inicio(Login.Login lg){
        this.lg = lg;
        frame.setVisible(false);
        usAr = new Usuario_Arbol(this);
        iniMat = new Usuario.Matriz.Inicio(this);
        iniOrd = new Usuario.Ordenamiento.Inicio(this);
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
        iniMat.setDatos(datos);
        frame.setVisible(false);
        iniMat.setVisible();
    }
    //ORDENAMIENTOS
    @Override
    protected void setBtn2(){
        iniOrd.setDatos(datos);
        frame.setVisible(false);
        iniOrd.setVisible();
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        lg.setVisible();
        frame.setVisible(false);
    }
}
