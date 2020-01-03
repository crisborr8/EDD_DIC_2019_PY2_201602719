package Usuario.Ordenamiento;

import Frame.Frame;
import java.awt.Color;

public class Quicksort extends Frame{    
    
    Inicio ini;
    Json.Abrir abrir;
    int valores[];
    EDD.Ordenamiento ord;
    
    public Quicksort(Inicio ini){
        this.ini = ini;
        setOrd_Quicksort();
    }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //ABRIR
    @Override
    protected void setBtn0(){
        abrir = new Json.Abrir();
        valores = abrir.abrirArray();
        lbl6.setForeground(Color.red);
        if(valores.length == 0) lbl6.setText("Error al abrir");
        else{
            lbl6.setForeground(Color.blue);
            lbl6.setText("Arreglo abierto");
            ord = new EDD.Ordenamiento();
            ord.setTipoOrd(2);
        }
    }
    //SIGUIENTE
    @Override
    protected void setBtn1(){
        if(valores.length > 0 && !chb0.isSelected() && ord.isAlive()){
            ord.setAuto(chb0.isSelected());
            ord.setBucle(false);
        }
    }
    //INICIAR
    @Override
    protected void setBtn2(){
        if(valores.length > 0){
            ord.setAuto(chb0.isSelected());
            ord.setBucle(false);
            if(!ord.isAlive()){
                ord.setValores(valores);
                ord.start();
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
