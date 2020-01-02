package Graficar;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.awt.Desktop;
import EDD.*;

public class Graficar {
    
    private void Mostrar(String codigo){
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
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICAR USUARIOS
    public void graficar_Hash(Hash hash){
        Hash.Nodo tabla[] = hash.getTabla();
        String codigo = "rankdir = LR;\n";
        codigo += "node [shape=box];\n";
        String label = "";
        int disp, carnet;
        for(int i = tabla.length - 1; i >= 0; i--){
            if(tabla[i] != null){
                carnet = Integer.parseInt(tabla[i].getDatos()[0]);
                label = "Carnet: " + carnet + "\\n";
                label += "Nombre: " + tabla[i].getDatos()[1] + "\\n";
                label += "Apellido: " + tabla[i].getDatos()[2]+ "\\n";
                label += "Contraseña: " + tabla[i].getDatos()[3]+ "\\n";
                codigo += "_" + carnet + " [label=\"" + label + "\"];\n";
                disp = hash.getDisp(carnet);
                disp = hash.getDisp(carnet, disp, 0);
                label = "Clave: " + disp;
                codigo += disp + " [label=\"" + label + "\"];\n";
                codigo += disp + "->_" + carnet + ";\n";
            }
        }
        Mostrar(codigo);
    }
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICAR AVL
    public void graficarAVL(String extra, AVL.Nodo raiz){
        String codigo = "node [shape=record, style=filled];\n";
        if(!extra.equals("")) codigo += "extra [label=\"" + extra + "\", shape=plaintext];\n";
        if(raiz != null) codigo += getCodigoAVL(raiz);
        Mostrar(codigo);
    }
    private String getCodigoAVL(AVL.Nodo act){
        String codigo = "_" + act.getNum() + "[label=\"<i>|" + act.getNum() + "|<d>\", fillcolor=" + act.getColor() + "];\n";
        if(act.getIzq() != null){
            codigo += "_" + act.getNum() + ":i->_" + act.getIzq().getNum() + ";\n";
            codigo += getCodigoAVL(act.getIzq());
        }
        if(act.getDer() != null){
            codigo += "_" + act.getNum() + ":d->_" + act.getDer().getNum() + ";\n";
            codigo += getCodigoAVL(act.getDer());
        }
        return codigo;
    }
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICAR B
    public void graficarB(String extra, B.Nodo raiz){
        String codigo = "node [shape=plaintext, style=filled];\n";
        if(!extra.equals("")) codigo += "extra [label=\"" + extra + "\", shape=plaintext];\n";
        if(raiz != null) codigo += getCodigoB(raiz);
        Mostrar(codigo);
    }
    private String getCodigoB(B.Nodo act){
        String nombre = "_" + act.getClaves()[0];
        String label = "label=<<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\">\n";
        label += "<TR>\n";
        int i;
        for(i = 0; i < act.getClaves().length; i++){
            if(act.getClaves()[i] != null){
                if(act.getPintarTodo()){
                    label += "<TD PORT=\"p" + i + "\" BGCOLOR=\"green\"></TD>\n";
                    label += "<TD PORT=\"c" + i + "\" BGCOLOR=\"green\">";
                }
                else{
                    label += "<TD PORT=\"p" + i + "\" BGCOLOR=\"" + act.getColorPagina()[i] + "\"></TD>\n";
                    label += "<TD PORT=\"c" + i + "\" BGCOLOR=\"" + act.getColorClave()[i] + "\">";
                }
                label += act.getClaves()[i] + "</TD>\n";
            }
            else break;
        }
        if(act.getPintarTodo())  label += "<TD PORT=\"p" + i + "\" BGCOLOR=\"green\"></TD>\n";
        else label += "<TD PORT=\"p" + i + "\" BGCOLOR=\"" + act.getColorPagina()[i] + "\"></TD>\n";
        label += "</TR></TABLE>>";
        String codigo = nombre + " [" + label + "];\n";
        for(i = 0; i < act.getPaginas().length; i++){
            if(act.getPaginas()[i] != null){
                codigo += nombre + ":p" + i + "->_" + act.getPaginas()[i].getClaves()[0] + ";\n";
                codigo += getCodigoB(act.getPaginas()[i]);
            }
            else break;
        }
        return codigo;
    }
}
