package Usuario.B;

import Frame.Frame;
import java.awt.Color;

public class Insertar extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    int[] valores;
    EDD.B b;
    EDD.B.Nodo raiz;
    
    public Insertar(Inicio ini){
        this.ini = ini;
        setB_Insertar();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //ABRIR
    @Override
    protected void setBtn0(){
        abrir = new Json.Abrir();
        valores = abrir.abrirArbol();
        lbl6.setForeground(Color.red);
        if(valores.length == 0) lbl6.setText("Error al abrir");
        else{
            lbl6.setForeground(Color.blue);
            lbl6.setText("Arbol abierto");
            b = new EDD.B();
            b.setTipo(0);
            b.setGraf(true);
            raiz = null;
        }
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        if(valores.length > 0 && !chb0.isSelected() && b.isAlive()){
            b.setAuto(chb0.isSelected());
            b.setBucle(false);
        }
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        if(valores.length > 0){
            b.setAuto(chb0.isSelected());
            b.setBucle(false);
            if(!b.isAlive()){
                b.setValores(valores);
                b.setRaiz(raiz);
                b.start();
            }
        }
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        frame.setVisible(false);
        ini.setVisible();
    }
}
