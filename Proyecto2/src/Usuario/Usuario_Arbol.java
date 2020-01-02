package Usuario;

import Frame.Frame;

public class Usuario_Arbol extends Frame{
    
    Usuario.AVL.Inicio iniAVL;
    Usuario.B.Inicio iniB;
    Usuario_Inicio usIn;
    
    public Usuario_Arbol(Usuario_Inicio usIn){
        this.usIn = usIn;
        iniAVL = new Usuario.AVL.Inicio(this);
        iniB = new Usuario.B.Inicio(this);
        frame.setVisible(false);
        setUserArbol();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //AVL
    @Override
    protected void setBtn0(){
        frame.setVisible(false);
        iniAVL.setVisible();
        iniAVL.setDatos(datos);
    }
    //B
    @Override
    protected void setBtn1(){
        frame.setVisible(false);
        iniB.setVisible();
        iniB.setDatos(datos);
    }
    //REGRESAR
    @Override
    protected void setBtn2(){
        frame.setVisible(false);
        usIn.setVisible();
    }
}
