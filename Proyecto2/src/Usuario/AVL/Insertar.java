package Usuario.AVL;

import Frame.Frame;
import java.awt.Color;

public class Insertar extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    int[] valores;
    EDD.AVL avl;
    EDD.AVL.Nodo raiz;
    
    public Insertar(Inicio ini){
        this.ini = ini;
        setAVL_Insertar();
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
            avl = new EDD.AVL();
            avl.setTipo(0);
            avl.setGraf(true);
            raiz = null;
        }
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        if(valores.length > 0 && !chb0.isSelected() && avl.isAlive()){
            avl.setAuto(chb0.isSelected());
            avl.setBucle(false);
        }
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        if(valores.length > 0){
            avl.setAuto(chb0.isSelected());
            avl.setBucle(false);
            if(!avl.isAlive()){
                avl.setValores(valores);
                avl.setRaiz(raiz);
                avl.start();
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
