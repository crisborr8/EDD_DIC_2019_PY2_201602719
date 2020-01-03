package Usuario.Ordenamiento;

import Frame.Frame;

public class Inicio extends Frame{
    
    Usuario.Usuario_Inicio ini;
    
    public Inicio(Usuario.Usuario_Inicio ini){
        this.ini = ini;
        frame.setVisible(false);
        setUserOrdenamiento();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //BURBUJA
    @Override
    protected void setBtn0(){
        Burbuja bur = new Burbuja(this);
        bur.setDatos(datos);
        frame.setVisible(false);
    }
    //INSERCION
    @Override
    protected void setBtn1(){
        Insercion ins = new Insercion(this);
        ins.setDatos(datos);
        frame.setVisible(false);
    }
    //QUICKSORT
    @Override
    protected void setBtn2(){
        Quicksort qui = new Quicksort(this);
        qui.setDatos(datos);
        frame.setVisible(false);
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        ini.setVisible();
        frame.setVisible(false);
    }
    
}
