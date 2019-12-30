package Json;

import EDD.*;
import com.fasterxml.jackson.core.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Abrir{
    
    public String getPath(){
        String path = "";
        JFrame ventana = new JFrame();
        JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos json", "json");
        filechooser.setFileFilter(filter);
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = filechooser.showOpenDialog(ventana);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            System.out.println("abierto");
            System.out.println(path);
        }
        return path;
    }
    
    public Hash abrirUsuarios(Hash hash){
        String path = getPath();
        try{
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(path));
            String[] cadena;
            String nombre = "";
            String apellido = "";
            String carnetAux = "";
            String contraseña = "";
            int carnet = 0;
            int contador, contadorAux;
            while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                contador = 0;
                contadorAux = 0;
                while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                    String campo = jsonParser.getCurrentName();
                    if("Nombre".equals(campo)){
                        jsonParser.nextToken();
                        nombre = jsonParser.getText();
                        contador++;
                    }
                    if("Apellido".equals(campo)){
                        jsonParser.nextToken();
                        apellido = jsonParser.getText();
                        contador++;
                    }
                    if("Carnet".equals(campo)){
                        jsonParser.nextToken();
                        cadena = jsonParser.getText().split("-");
                        carnetAux = "";
                        for(String aux: cadena){
                            carnetAux += aux;
                        }
                        carnet = Integer.parseInt(carnetAux);
                        contador++;
                    }
                    if("Password".equals(campo)){
                        jsonParser.nextToken();
                        contraseña = jsonParser.getText();
                        contador++;
                    }
                    if(contador == 4){
                        int dispercion = hash.getDispercion(carnet);
                        hash.ingresarUsuario(nombre, apellido, contraseña, carnet, dispercion, 0);
                        contador = 0;
                    }
                    if(contadorAux > 5){
                        jsonParser.nextToken();
                        contadorAux = 0;
                    }
                    contadorAux++;
                }
            }
        }catch(JsonParseException e){
            System.out.println("Error al leer el json");
        }catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        return hash;
    }
    
    public int[] abrirTreeAVL(){
        String path = getPath();
        int valor[] = null;
        int aux[];
        int i;
        try{
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(path));
            int numero, contador, contadorAux;
            String campo;
            while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                campo = jsonParser.getCurrentName();
                if("Input".equals(campo)){
                    jsonParser.nextToken();
                    while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                        contador = contadorAux = numero = 0;
                        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                            campo = jsonParser.getCurrentName();
                            if("num".equals(campo)){
                                jsonParser.nextToken();
                                numero = jsonParser.getIntValue();
                                contador++;
                            }else{
                                contadorAux++;
                            }
                            if(contador == 1){
                                contador = contadorAux = 0;
                                System.out.println(numero);
                                if(valor == null) valor = new int[0];
                                aux = new int[valor.length + 1];
                                for(i = 0; i < valor.length; i++){
                                    aux[i] = valor[i];
                                }
                                aux[i] = numero;
                                valor = new int[aux.length];
                                valor = aux;
                            }
                            if(contadorAux > 0){
                                jsonParser.nextToken();
                            }
                        }
                    }
                }
            }
        }catch(JsonParseException e){
            System.out.println("Error al leer el json" + e);
        }catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        return valor;
    }
    public ArbolB.Nodo abrirTreeB(){
        String path = getPath();
        ArbolB.Nodo raiz = null;
        ArbolB b = new ArbolB();
        try{
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new File(path));
            int numero, contador, contadorAux;
            String campo;
            while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                campo = jsonParser.getCurrentName();
                if("Input".equals(campo)){
                    jsonParser.nextToken();
                    while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                        contador = contadorAux = numero = 0;
                        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                            campo = jsonParser.getCurrentName();
                            if("num".equals(campo)){
                                jsonParser.nextToken();
                                numero = jsonParser.getIntValue();
                                contador++;
                            }else{
                                contadorAux++;
                            }
                            if(contador == 1){
                                contador = contadorAux = 0;
                                System.out.println(numero);
                                raiz = b.Insertar(raiz, numero);
                            }
                            if(contadorAux > 0){
                                jsonParser.nextToken();
                            }
                        }
                    }
                }
            }
        }catch(JsonParseException e){
            System.out.println("Error al leer el json" + e);
        }catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        return raiz;
    }
}
