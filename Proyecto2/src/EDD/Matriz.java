package EDD;

public class Matriz extends Thread{
    
    //**************************************************************************
    //**************************************************************************
    //ATRIBUTOS
    private int tipo;
    private boolean auto;
    private boolean bucle;
    private String[] visitado;
    private String[][] matriz;
    private Graficar.Graficar graficar;
    
    //**************************************************************************
    //**************************************************************************
    //SETS
    public void setTipo(int tipo) { this.tipo = tipo; }
    public void setAuto(boolean auto) { this.auto = auto; }
    public void setBucle(boolean bucle) { this.bucle = bucle; }
    public void setMatriz(String[][] matriz) { this.matriz = matriz; }
    public void setGrafica() { graficar = new Graficar.Graficar(); }
    
    //**************************************************************************
    //**************************************************************************
    //RUN
    public void run(){
        setGrafica();
        switch(tipo){
            case 0:
                boolean adyacencia = true;
                while(adyacencia){
                    if(!bucle){
                        System.out.println("Iniciando adyacencia");
                        Adyacencia();
                        System.out.println("Adyacencia finalizada");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
            case 1:
                boolean anchura = true;
                while(anchura){
                    if(!bucle){
                        System.out.println("Iniciando rec por anchura");
                        recAnch();
                        System.out.println("Rec. por ancura finalizada");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
            case 2:
                boolean profundidad = true;
                while(profundidad){
                    if(!bucle){
                        System.out.println("Iniciando rec por profundidad");
                        recProf();
                        System.out.println("Rec. por profundidad finalizada");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //ADYACENCIA
    private void Adyacencia(){
        String[][] matAdy = new String[1][1];
        String[][] color = new String[1][1];
        String[][] matAux;
        matAdy[0][0] = "Matriz";
        color[0][0] = "white";
        int x, y;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(!existeDato(matAdy[0], matriz[i][j])){
                    graficar("Ingresar\\nNodo " + matriz[i][j], color, matAdy);
                    matAux = null;
                    matAux = matAdy;
                    matAdy = new String[matAdy.length + 1][matAdy.length + 1];
                    color = new String[color.length + 1][color.length + 1];
                    for(x = 0; x < matAdy.length; x++){
                        for(y = 0; y < matAdy[x].length; y++){
                            color[x][y] = "white";
                            if(x < matAux.length && y < matAux[x].length)
                                matAdy[x][y] = matAux[x][y];
                            else
                                matAdy[x][y] = "0";
                        }
                    }
                    x = y = matAdy.length - 1;
                    matAdy[0][y] = matriz[i][j];
                    matAdy[x][0] = matriz[i][j];
                }
                if(j > 0){
                    graficar("Relacionar\\nNodo " + matriz[i][j] + " con Nodo " + matriz[i][0], color, matAdy);
                    x = getX(matAdy[0], matriz[i][0]);
                    y = getY(matAdy, matriz[i][j]);
                    matAdy[x][y] = "" + (Integer.parseInt(matAdy[x][y]) + 1);
                    matAdy[y][x] = matAdy[x][y];
                    color[x][y] = "green";
                    color[y][x] = "green";
                    color[0][y] = "cyan";
                    color[y][0] = "cyan";
                    color[x][0] = "yellow";
                    color[0][x] = "yellow";
                    graficar("Relacionado!", color, matAdy);
                    color[x][y] = "white";
                    color[y][x] = "white";
                    color[0][y] = "white";
                    color[y][0] = "white";
                    color[x][0] = "white";
                    color[0][x] = "white";
                }
            }
        }
        graficar("Finalizado!", color, matAdy);
    }
    private boolean existeDato(String[] datos, String nDato){
        for(int i = 0; i < datos.length; i++){
            if(datos[i].equals(nDato)) return true;
        }
        return false;
    }
    private int getX(String[] datos, String dato){
        for(int i = 0; i < datos.length; i++){
            if(datos[i].equals(dato)) return i;
        }
        return -1;
    }
    private int getY(String[][] datos, String dato){
        for(int i = 0; i < datos[0].length; i++){
            if(datos[0][i].equals(dato)) return i;
        }
        return -1;
    }
    
    //**************************************************************************
    //**************************************************************************
    //REC. POR PROFUNDIAD
    private void recProf(){
        ordenarMatriz();
        String[][] matAdy = new String[matriz.length][matriz.length];
        graficarRec("", matAdy);
        visitado = new String[matriz.length];
        visitado[0] = matriz[0][0];
        matAdy = setMatProf(0, 0, matAdy);
    }
    private String[][] setMatProf(int iMat, int iAdy, String[][] matAdy){
        matAdy[iAdy][0] = matriz[iMat][0];
        int jAdy = 1;
        if(matriz[iMat].length == 1) graficarRec(matriz[iMat][0], matAdy);
        for(int j = 1; j < matriz[iMat].length; j++){
            if(!estaVisitado(matriz[iMat][j])){
                for(int i = 0; i < visitado.length; i++){
                    if(visitado[i] == null){
                        visitado[i] = matriz[iMat][j];
                        break;
                    }
                }
                matAdy[iAdy][jAdy] = matriz[iMat][j];
                jAdy++;
                graficarRec(matriz[iMat][j], matAdy);
                matAdy = setMatProf(getI(matriz[iMat][j]), iAdy + 1, matAdy);
                //graficarRec(matriz[iMat][j], matAdy);
            }
        }
        return matAdy;
    }
    
    //**************************************************************************
    //**************************************************************************
    //REC. POR ANCHURA
    private void recAnch(){
        ordenarMatriz();
        String[][] matAdy = new String[matriz.length][matriz.length];
        graficarRec("", matAdy);
        visitado = new String[matriz.length];
        visitado[0] = matriz[0][0];
        matAdy = setMatAnch(0, 0, matAdy);
    }
    private String[][] setMatAnch(int iMat, int iAdy, String[][] matAdy){
        matAdy[iAdy][0] = matriz[iMat][0];
        int jAdy = 1;
        if(matriz[iMat].length == 1) graficarRec(matriz[iMat][0], matAdy);
        for(int j = 1; j < matriz[iMat].length; j++){
            if(!estaVisitado(matriz[iMat][j])){
                for(int i = 0; i < visitado.length; i++){
                    if(visitado[i] == null){
                        visitado[i] = matriz[iMat][j];
                        break;
                    }
                }
                matAdy[iAdy][jAdy] = matriz[iMat][j];
                jAdy++;
                graficarRec(matriz[iMat][j], matAdy);
            }
        }
        for(int j = 1; j < matAdy[iAdy].length; j++){
            if(matAdy[iAdy][j] != null){
                matAdy = setMatAnch(getI(matAdy[iAdy][j]), iAdy + 1, matAdy);
                //graficarRec(matAdy[iAdy][j], matAdy);
            }
        }
        return matAdy;
    }
    
    //**************************************************************************
    //**************************************************************************
    //EXTRAS
    private int getI(String dato){
        for(int i = 0; i < matriz.length; i++){
            if(matriz[i][0] != null)
                if(matriz[i][0].equals(dato)) return i;
        }
        return -1;
    }
    private boolean estaVisitado(String dato){
        for(int i = 0; i < visitado.length; i++){
            if(visitado[i] == null) return false;
            else if(visitado[i].equals(dato)) return true;
        }
        return false;
    }
    private void ordenarMatriz(){
        String aux;
        String[] auxV;
        for(int i = 0; i < matriz.length - 1; i++){
            if(matriz[i][0] != null){
                for(int j = 1; j < matriz[i].length - 1; j++){
                    if(matriz[i][j + 1] != null){
                        if(matriz[i][j].compareTo(matriz[i][j + 1]) > 0){
                            aux = matriz[i][j];
                            matriz[i][j] = matriz[i][j + 1];
                            matriz[i][j + 1] = aux;
                            if(j > 1) j -= 2;
                        }
                    }
                }
                if(matriz[i + 1][0] != null){
                    if(matriz[i][0].compareTo(matriz[i + 1][0]) > 0){
                        auxV = matriz[i];
                        matriz[i] = matriz[i + 1];
                        matriz[i + 1] = auxV;
                        if(i > 0) i -= 2;
                    }
                }
            }
        }
    }
    
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICAR
    private void graficar(String ingresar, String[][] color, String[][] matAdy){
        String titulo = "Matriz "; 
        if(tipo == 0){
            titulo += "de Adyacencia";
            graficar.graficarAdy(titulo, ingresar, color, matAdy);
        }
        if(auto) esperar(3000);
        else{
            bucle = true;
            while(bucle) esperar(50);
        }
    }
    private void graficarRec(String color, String[][] matAdy){
        String titulo = "Rec. por Profundidad";
        if (tipo == 1) titulo = "Rec. por Anchura";
        graficar.graficarRec(titulo, color, matriz, matAdy);
        if(auto) esperar(3000);
        else{
            bucle = true;
            while(bucle) esperar(50);
        }
    }
    private void esperar(int t){
        try{
            Thread.sleep(t);
        }catch(Exception ex){}
    }
}
