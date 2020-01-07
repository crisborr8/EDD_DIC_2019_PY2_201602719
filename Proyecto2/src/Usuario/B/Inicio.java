package Usuario.B;

import Frame.Frame;
import Usuario.Usuario_Arbol;

public class Inicio extends Frame{
    
    Usuario_Arbol usArb;
    
    public Inicio(Usuario_Arbol usArb){
        this.usArb = usArb;
        frame.setVisible(false);
        setB();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //INSERTAR
    @Override
    protected void setBtn0(){
        Insertar ins = new Insertar(this);
        frame.setVisible(false);
        ins.setDatos(datos);
    }
    //ELIMINAR
    @Override
    protected void setBtn1(){
        Eliminar eli = new Eliminar(this);
        frame.setVisible(false);
        eli.setDatos(datos);
    }
    //RECORRER
    @Override
    protected void setBtn2(){
        frame.setVisible(false);
        usArb.setVisible();
    }
}
