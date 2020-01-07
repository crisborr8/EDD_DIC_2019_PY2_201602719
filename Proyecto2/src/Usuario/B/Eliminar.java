package Usuario.B;

import Frame.Frame;
import java.awt.Color;

public class Eliminar extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    int[] valores;
    EDD.B b;
    EDD.B.Nodo raiz;
    
    public Eliminar(Inicio ini){
        this.ini = ini;
        setB_Eliminar();
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
            b.setGraf(false);
            b.setTipo(0);
            raiz = null;
            b.setOrden();
            for(int i = 0; i < valores.length; i++){
                System.out.println("-->" + valores[i]);
                b.setRomper();
                raiz = b.insertarDato(raiz, valores[i]);
            }
            b.setTipo(1);
            b.setGrafica();
            b.setRaiz(raiz);
            b.graficar("");
            b.setGraf(true);
        }
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        if(raiz != null && !chb0.isSelected() && b.isAlive()){
            try{
                b.setNum(Integer.parseInt(txt0.getText()));
                lbl6.setForeground(Color.blue);
                lbl6.setText("Arbol abierto");
                b.setAuto(chb0.isSelected());
                b.setTipo(1);
                b.setBucle(false);
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
                b.setNum(Integer.parseInt(txt0.getText()));
                lbl6.setForeground(Color.blue);
                lbl6.setText("Arbol abierto");
                b.setAuto(chb0.isSelected());
                b.setBucle(false);
                b.setTipo(1);
                if(!b.isAlive()) b.start();
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
