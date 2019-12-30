package Grafica;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import EDD.*;

public class Graficar {
    
    File file;
    
    public void Mostrar(String codigo){
        codigo = "digraph G{\n" + codigo;
        codigo += "\n}";
        try{       
            BufferedWriter writer = new BufferedWriter(new FileWriter("imagen.dot"));
            writer.write(codigo);
            writer.close();
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "imagen.png", "imagen.dot" );
            pbuilder.redirectErrorStream( true );
            pbuilder.start();
            Desktop desktop = Desktop.getDesktop();
            File file = new File("imagen.png");
            if(file.exists()) desktop.open(file);
	}catch (Exception e){ 
            e.printStackTrace(); 
        }
    }
    
    public void Cerrar(){
        try{
            Runtime.getRuntime().exec("taskkill /IM imagen.png");
        }catch(Exception ex){}
    }
    
    public String getCodigo_AVL(ArbolAVL.Nodo act){
        String codigo = act.getNum() + "";
        if(act.getT0()) codigo += " [style=filled, fillcolor=red]";
        else if(act.getT1()) codigo += " [style=filled, fillcolor=blue]";
        else if(act.getT2()) codigo += " [style=filled, fillcolor=green]";
        codigo += ";\n";
        if(act.getIzq() != null){
            codigo += act.getNum() + "->" + act.getIzq().getNum() + ";\n";
            codigo += getCodigo_AVL(act.getIzq());
        }
        if(act.getDer() != null){
            codigo += act.getNum() + "->" + act.getDer().getNum() + ";\n";
            codigo += getCodigo_AVL(act.getDer());
        }
        return codigo;
    }
    
}
