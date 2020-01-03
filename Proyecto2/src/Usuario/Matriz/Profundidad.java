package Usuario.Matriz;

import Frame.Frame;

public class Profundidad extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    
    public Profundidad(Inicio ini){
        this.ini = ini;
        setMat_Profundidad();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //ABRIR
    @Override
    protected void setBtn0(){
        abrir = new Json.Abrir();
        
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        frame.setVisible(false);
        ini.setVisible();
    }
}
