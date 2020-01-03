package Usuario.Matriz;

import Frame.Frame;
import java.awt.Color;

public class Profundidad extends Frame{
    
    Inicio ini;
    Json.Abrir abrir;
    String[][] matriz;
    EDD.Matriz matAdy;
    
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
        matriz = abrir.abrirMatriz();
        lbl6.setForeground(Color.red);
        if(matriz.length == 0) lbl6.setText("Error al abrir");
        else{
            lbl6.setForeground(Color.blue);
            lbl6.setText("Arreglo abierto");
            matAdy = new EDD.Matriz();
            matAdy.setTipo(2);
        }
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        if(matriz.length > 0 && !chb0.isSelected() && matAdy.isAlive()){
            matAdy.setAuto(chb0.isSelected());
            matAdy.setBucle(false);
        }
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        if(matriz.length > 0){
            matAdy.setAuto(chb0.isSelected());
            matAdy.setBucle(false);
            if(!matAdy.isAlive()){
                matAdy.setMatriz(matriz);
                matAdy.start();
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
