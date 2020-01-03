package EDD;

public class Matriz extends Thread{
    
    //**************************************************************************
    //**************************************************************************
    //ATRIBUTOS
    private int tipo;
    private boolean auto;
    private boolean bucle;
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
            break;
            case 2:
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
    //GRAFICAR
    private void graficar(String ingresar, String[][] color, String[][] matAdy){
        String titulo = "Matriz "; 
        if(tipo == 0){
            titulo += "de Adyacencia";
            graficar.graficarAdy(titulo, ingresar, color, matAdy);
        }
        else if(tipo == 1){
            titulo = "Rec. por Anchura";
        }
        else{
            titulo = "Rec. por Profundidad";
        }
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
