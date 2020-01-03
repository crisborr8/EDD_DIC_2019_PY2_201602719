package Usuario.Matriz;

import Frame.Frame;

public class Inicio extends Frame{
    
    Usuario.Usuario_Inicio ini;
    
    public Inicio(Usuario.Usuario_Inicio ini){
        this.ini = ini;
        frame.setVisible(false);
        setUserMatriz();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //ADYACENCIA
    @Override
    protected void setBtn0(){
        Adyacencia ady = new Adyacencia(this);
        ady.setDatos(datos);
        frame.setVisible(false);
    }
    //REC POR ANCHURA
    @Override
    protected void setBtn1(){
        Anchura anch = new Anchura(this);
        anch.setDatos(datos);
        frame.setVisible(false);
    }
    //REC POR PROFUNDIDAD
    @Override
    protected void setBtn2(){
        Profundidad prof = new Profundidad(this);
        prof.setDatos(datos);
        frame.setVisible(false);
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        ini.setVisible();
        frame.setVisible(false);
    }
}
