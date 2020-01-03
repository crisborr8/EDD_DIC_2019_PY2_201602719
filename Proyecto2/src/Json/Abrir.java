package Json;

import EDD.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.fasterxml.jackson.core.*;

public class Abrir {
    
    
    private String getPath(){
        JFrame ventana = new JFrame();
        JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos json", "json");
        filechooser.setFileFilter(filter);
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = filechooser.showOpenDialog(ventana);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ABRIR USUARIOS
    public Hash abrirUsuario(Hash hash){
        try{
            int cont, contAux;
            String campo;
            String[] datos;
            String[] cadena;
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(getPath()));
            while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                cont = contAux = 0;
                datos = new String[4];
                while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                    campo = jsonParser.getCurrentName();
                    if("Nombre".equals(campo)){
                        jsonParser.nextToken();
                        datos[1] = jsonParser.getText();
                        cont++;
                    }
                    if("Apellido".equals(campo)){
                        jsonParser.nextToken();
                        datos[2] = jsonParser.getText();
                        cont++;
                    }
                    if("Carnet".equals(campo)){
                        jsonParser.nextToken();
                        cadena = jsonParser.getText().split("-");
                        datos[0] = "";
                        for(String aux: cadena){
                            datos[0] += aux;
                        }
                        cont++;
                    }
                    if("Password".equals(campo)){
                        jsonParser.nextToken();
                        datos[3] = jsonParser.getText();
                        cont++;
                    }
                    if(cont == 4){
                        int disp = hash.getDisp(Integer.parseInt(datos[0]));
                        hash.insertarUsuario(datos, disp, 0);
                        cont = 0;
                    }
                    if(contAux > 5){
                        jsonParser.nextToken();
                        contAux = 0;
                    }
                    else contAux++;
                }
            }
        }catch (Exception ex){
            System.out.println("Error en:\n-->" + ex);
        }
        return hash;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ABRIR ARBOL
    public int[] abrirArbol(){
        int valor[] = new int[0];
        try{
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(getPath()));
            int aux[], i, cont, contAux, num;
            String campo;
            while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                campo = jsonParser.getCurrentName();
                if("Input".equals(campo)){
                    jsonParser.nextToken();
                    while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                        cont = contAux = num = 0;
                        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                            campo = jsonParser.getCurrentName();
                            if("num".equals(campo)){
                                jsonParser.nextToken();
                                num = jsonParser.getIntValue();
                                cont++;
                            }
                            if(cont == 1){
                                aux = new int[valor.length + 1];
                                for(i = 0; i < valor.length; i++){
                                    aux[i] = valor[i];
                                }
                                aux[i] = num;
                                valor = new int[aux.length];
                                valor = aux;
                                cont = 0;
                            }
                            if(contAux > 2){
                                jsonParser.nextToken();
                            }
                            else contAux++;
                        }
                    }
                }
            }
        }catch(Exception ex){
            System.out.println("Error en:\n-->" + ex);
        }
        return valor;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ABRIR ARRAY
    public int[] abrirArray(){
        int valor[] = new int[0];
        try{
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(getPath()));
            int aux[], i, cont, contAux, num;
            String campo;
            while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                campo = jsonParser.getCurrentName();
                if("Array".equals(campo)){
                    jsonParser.nextToken();
                    while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                        cont = contAux = num = 0;
                        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                            campo = jsonParser.getCurrentName();
                            if("num".equals(campo)){
                                jsonParser.nextToken();
                                num = jsonParser.getIntValue();
                                cont++;
                            }
                            if(cont == 1){
                                aux = new int[valor.length + 1];
                                for(i = 0; i < valor.length; i++){
                                    aux[i] = valor[i];
                                }
                                aux[i] = num;
                                valor = new int[aux.length];
                                valor = aux;
                                cont = 0;
                            }
                            if(contAux > 2){
                                jsonParser.nextToken();
                            }
                            else contAux++;
                        }
                    }
                }
            }
        }catch(Exception ex){
            System.out.println("Error en:\n-->" + ex);
        }
        return valor;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ABRIR MATRIZ
    public String[][] abrirMatriz(){
        String[][] matriz = new String[0][0];
        String[][] matrizAux;
        try{
            String[] adyacencia = new String[0];
            String[] adyacenciaAux;
            String campo;
            int cont, contAux, i;
            int ccont, ccontAux;
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(getPath()));
            while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                campo = jsonParser.getCurrentName();
                if("Graph".equals(campo)){
                    jsonParser.nextToken();
                    while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                        cont = contAux = 0;
                        adyacencia = new String[1];
                        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                            campo = jsonParser.getCurrentName();
                            if("Node".equals(campo)){
                                jsonParser.nextToken();
                                adyacencia[0] = jsonParser.getValueAsString();
                                cont++;
                            }
                            if("Adjacency".equals(campo)){
                                jsonParser.nextToken();
                                while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                                    ccont = ccontAux = 0;
                                    while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                                        campo = jsonParser.getCurrentName();
                                        if("Node".equals(campo)){
                                            jsonParser.nextToken();
                                            adyacenciaAux = null;
                                            adyacenciaAux = adyacencia;
                                            adyacencia = new String[adyacencia.length + 1];
                                            for(i = 0; i < adyacenciaAux.length; i++){
                                                adyacencia[i] = adyacenciaAux[i];
                                            }
                                            adyacencia[i] = jsonParser.getValueAsString();
                                            ccont++;
                                        }
                                        ccontAux++;
                                        if(ccontAux != ccont){
                                            ccontAux = ccont = 0;
                                            jsonParser.nextToken();
                                        }
                                    }
                                }
                                cont++;
                            }
                            if(cont == 2){
                                matrizAux = null;
                                matrizAux = matriz;
                                int tamañoM = 0;
                                for(int j = 0; j < matrizAux.length; j++){
                                    if(tamañoM < matrizAux[j].length) tamañoM = matrizAux[j].length;
                                }
                                if(tamañoM > adyacencia.length)
                                    matriz = new String[matriz.length + 1][tamañoM];
                                else
                                    matriz = new String[matriz.length + 1][adyacencia.length];
                                for(i = 0; i < matrizAux.length; i++){
                                    matriz[i] = matrizAux[i];
                                }
                                matriz[i] = adyacencia;
                                cont = contAux = 0;
                            }
                            if(contAux > 3){
                                jsonParser.nextToken();
                            }
                            else contAux++;
                        }
                    }
                }
            }
        }catch(Exception ex){
            System.out.println("Error en:\n-->" + ex);
        }
        return matriz;
    }
}
