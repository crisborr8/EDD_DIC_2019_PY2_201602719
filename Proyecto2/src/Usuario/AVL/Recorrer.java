package Usuario.AVL;

import Frame.Frame;
import java.awt.Color;

public class Recorrer extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    int[] valores;
    EDD.AVL avl;
    EDD.AVL.Nodo raiz;
    
    public Recorrer(Inicio ini){
        this.ini = ini;
        setAVL_Recorrer();
        rb0.setSelected(true);
    }
    //**************************************************************************
    //**************************************************************************
    //RECORRIDOS
    //PREORDEN
    @Override
    protected void setRb0(){
        if(rb0.isSelected()){
            rb1.setSelected(false);
            rb2.setSelected(false);
        }else{
            rb1.setSelected(true);
        }
    }
    //INORDEN
    @Override
    protected void setRb1(){
        if(rb1.isSelected()){
            rb0.setSelected(false);
            rb2.setSelected(false);
        }else{
            rb2.setSelected(true);
        }
    }
    //POSTORDEN
    @Override
    protected void setRb2(){
        if(rb2.isSelected()){
            rb0.setSelected(false);
            rb1.setSelected(false);
        }else{
            rb0.setSelected(true);
        }
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
            avl.setGraf(false);
            for(int i = 0; i < valores.length; i++){
                raiz = avl.insertarDato(raiz, valores[i]);
            }
            avl.setTipo(2);
            avl.setGrafica();
            avl.setRaiz(raiz);
            avl.graficar("");
            avl.setGraf(true);
        }
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        if(raiz != null && !chb0.isSelected() && avl.isAlive()){
            if(rb0.isSelected()) avl.setTRec(0);
            if(rb1.isSelected()) avl.setTRec(1);
            if(rb2.isSelected()) avl.setTRec(2);
            avl.setAuto(chb0.isSelected());
            avl.setTipo(2);
            avl.setBucle(false);
        }
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        if(raiz != null){
            if(rb0.isSelected()) avl.setTRec(0);
            if(rb1.isSelected()) avl.setTRec(1);
            if(rb2.isSelected()) avl.setTRec(2);
            avl.setAuto(chb0.isSelected());
            avl.setBucle(false);
            avl.setTipo(2);
            if(!avl.isAlive()) avl.start();
        }
    }
    //REGRESAR
    @Override
    protected void setBtn3(){
        frame.setVisible(false);
        ini.setVisible();
    }
}
