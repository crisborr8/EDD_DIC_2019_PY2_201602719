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
        String codigo = "labelloc = \"t\";\n";
        codigo += "label = \"TABLA HASH\";\n";
        codigo += "rankdir = LR;\n";
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
        String codigo = "labelloc = \"t\";\n";
        codigo += "label=\"ARBOL AVL\";\n";
        codigo += "node [shape=record, style=filled];\n";
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
        String codigo = "labelloc = \"t\";\n";
        codigo += "label=\"ARBOL B\";\n";
        codigo += "node [shape=plaintext, style=filled];\n";
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
    
    //**************************************************************************
    //**************************************************************************
    //ORDENAMIENTO
    public void graficarOrd(String titulo, String extra, int[] valores, String[] colores){
        String label = "label=<<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\">\n";
        label += "<TR>\n";
        for(int i = 0; i < valores.length; i++){
            label += "<TD BGCOLOR=\"" + colores[i] + "\">" + valores[i] + "</TD>\n";
        }
        label += "</TR></TABLE>>";
        String codigo = "labelloc = \"t\";\n";
        codigo += "label=\"" + titulo + "\";\n";
        codigo += "node [shape=plaintext, style=filled];\n";
        if(!extra.equals("")) codigo += "extra [label=\"" + extra + "\", shape=plaintext];\n";
        codigo += "array [" + label + "];\n";
        Mostrar(codigo);
    }
    
    //**************************************************************************
    //**************************************************************************
    //MATRIZ
    public void graficarAdy(String titulo, String ingresar, String[][] color, String[][] matriz){
        String nodos = "";
        String relaciones = "";
        String mat_ady = "_matriz [shape=plaintext,\n";
        mat_ady += "label=< <TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\">\n";
        for(int i = 0; i < matriz.length; i++){
            mat_ady += "<TR>\n";
            for(int j = 0; j < matriz[i].length; j++){
                mat_ady += "<TD BGCOLOR=\"" + color[i][j] + "\">" + matriz[i][j] + "</TD>\n";
                if(i > 0 && j > 0 && j >= i){
                    nodos += "_" + matriz[0][j] + " [fillcolor=" + color[0][j] + ", "
                               +  "label=\"" + matriz[0][j] + "\"];\n";
                    for(int k = 0; k < Integer.parseInt(matriz[i][j]); k++)
                            relaciones += "_" + matriz[0][j] + "->_" + matriz[i][0] + ";\n";
                }
            }
            mat_ady += "</TR>\n";
        }
        mat_ady += "</TABLE>>];\n";
        
        String codigo = "labelloc = \"t\";\n";
        codigo += "label=\"" + titulo + "\";\n";
        //codigo += "ordering = out;\n";
        codigo += "node [style=filled];\n";
        codigo += "_agregar [shape=plaintext, label=\"" + ingresar + "\"];\n";
        codigo += "edge [arrowhead=none];\n";
        codigo += nodos + relaciones + mat_ady;
        Mostrar(codigo);
    }
    public void graficarRec(String titulo, String nodoColor, String[][] matriz, String[][] reProf){        
        String nodosMat = "";
        String relacMat = "";
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] != null){
                    nodosMat += "_" + matriz[i][j] + " [label=\"" + matriz[i][j] + "\"];\n"; 
                    if(j > 0) relacMat += "_" + matriz[i][0] + "->_" + matriz[i][j] + ";\n";
                }
            }
        }
        
        String codigo = "labelloc = \"t\";\n";
        codigo += "label=\"" + titulo + "\";\n";
        codigo += "node [style=filled];\n";
        codigo += "edge [arrowhead=none];\n";
        codigo += nodosMat + relacMat;
        if(reProf[0][0] != null) codigo += getCodigoRec(0, reProf);
        if(!nodoColor.equals("")){
            codigo += nodoColor + " [fillcolor=green];\n";
            codigo += "_" + nodoColor + " [fillcolor=green];\n";
        }
        Mostrar(codigo);
    }
    private String getCodigoRec(int i, String[][] matriz){
        System.out.println("-->" + matriz[i][0]);
        if(matriz[i].length == 1) return matriz[i][0];
        String codigo = "";
        for(int j = 1; j < matriz[i].length; j++){
            if(matriz[i][j] != null){
                System.out.println("--->" + matriz[i][0] + " con " + matriz[i][j]);
                codigo += matriz[i][0] + "->" + matriz[i][j] + ";\n";
                int ni = getI(matriz, matriz[i][j]);
                if(ni != -1) codigo += getCodigoRec(ni, matriz);
            }
        }
        return codigo;
    }
    private int getI(String[][]matriz, String dato){
        for(int i = 0; i < matriz.length; i++){
            if(matriz[i][0] != null)
                if(matriz[i][0].equals(dato)) return i;
        }
        return -1;
    }
}
