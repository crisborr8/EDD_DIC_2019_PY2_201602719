package Usuario.AVL;

import Frame.Frame;
import java.awt.Color;

public class Eliminar extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    int[] valores;
    EDD.AVL avl;
    EDD.AVL.Nodo raiz;
    
    public Eliminar(Inicio ini){
        this.ini = ini;
        setAVL_Eliminar();
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
            raiz = null;
            for(int i = 0; i < valores.length; i++){
                raiz = avl.insertarDato(raiz, valores[i]);
            }
            avl.setTipo(1);
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
            try{
                avl.setNum(Integer.parseInt(txt0.getText()));
                lbl6.setForeground(Color.blue);
                lbl6.setText("Arbol abierto");
                avl.setAuto(chb0.isSelected());
                avl.setTipo(1);
                avl.setBucle(false);
            }catch(Exception ex){
                lbl6.setForeground(Color.red);
                lbl6.setText("Nodo incorrecto");
            }
        }
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        if(raiz != null){
            try{
                avl.setNum(Integer.parseInt(txt0.getText()));
                lbl6.setForeground(Color.blue);
                lbl6.setText("Arbol abierto");
                avl.setAuto(chb0.isSelected());
                avl.setBucle(false);
                avl.setTipo(1);
                if(!avl.isAlive()) avl.start();
            }catch(Exception ex){
                lbl6.setForeground(Color.red);
                lbl6.setText("Nodo incorrecto");
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
