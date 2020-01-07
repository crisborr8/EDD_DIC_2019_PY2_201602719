package EDD;

public class Ordenamiento extends Thread{
    
    //**************************************************************************
    //**************************************************************************
    //ATRIBUTOS
    private int tipoOrd;
    private int[] valores;
    private String[] colores;
    private boolean auto;
    private boolean bucle;
    private Graficar.Graficar graficar;
    
    //**************************************************************************
    //**************************************************************************
    //SETS
    public void setTipoOrd(int tipoOrd) { this.tipoOrd = tipoOrd; }
    public void setValores(int valores[]) { this.valores = valores; }
    public void setAuto(boolean auto) { this.auto = auto; }
    public void setBucle(boolean bucle) { this.bucle = bucle; }
    public void setGrafica() { graficar = new Graficar.Graficar(); }
    public int[] getValores() { return valores; }
    
    //**************************************************************************
    //**************************************************************************
    //RUN
    public void run(){
        setGrafica();
        colores = new String[valores.length];
        setBlanco();
        switch(tipoOrd){
            case 0:
                boolean burbuja = true;
                while(burbuja){
                    if(!bucle){
                        System.out.println("Iniciando burbuja");
                        Burbuja();
                        System.out.println("Burbuja Finalizado");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
            case 1:
                boolean insercion = true;
                while(insercion){
                    if(!bucle){
                        System.out.println("Iniciando insercion");
                        Insercion();
                        System.out.println("Insercion Finalizado");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
            case 2:
                boolean quicksort = true;
                while(quicksort){
                    if(!bucle){
                        System.out.println("Iniciando quicksort");
                        Quicksort(valores, 0, "");
                        System.out.println("Quicksort Finalizado");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //ORDENAMIENTO
    private void Burbuja(){
        int aux;
        boolean ordenado;
        graficar("Burbuja");
        for(int i = 1; i < valores.length; i++){
            ordenado = true;
            for(int j = 0; j < valores.length - 1; j++){
                colores[j] = "green";
                graficar("Burbuja");
                colores[j] = "white";
                if(valores[j] > valores[j + 1]){
                    colores[j] = "red";
                    colores[j + 1] = "blue";
                    graficar("Intercambio");
                    colores[j] = colores[j + 1] = "white";
                    aux = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = aux;
                    colores[j] = "blue";
                    colores[j + 1] = "red";
                    graficar("Intercambio");
                    colores[j] = colores[j + 1] = "white";
                    ordenado = false;
                }
            }
            if(ordenado) break;
        }
    }
    private void Insercion(){
        int aux;
        for(int i = 1; i < valores.length; i++){
            colores[i] = "green";
            graficar("Insercion");
            for(int j = i; j > 0; j--){
                colores[i] = "green";
                colores[j] = "cyan";
                graficar("¿Es menor que " + valores[j - 1] + "?");
                colores[j] = "white";
                if(valores[j] < valores[j - 1]){
                    colores[j] = "red";
                    colores[j - 1] = "blue";
                    graficar("Intercambio");
                    aux = valores[j];
                    valores[j] = valores[j - 1];
                    valores[j - 1] = aux;
                    colores[j] = "blue";
                    colores[j - 1] = "red";
                    graficar("Intercambio");
                    colores[j] = colores[j - 1] = "white";
                }
                else break;
            }
            colores[i] = "white";
        }
    }
    private void Quicksort(int v[], int i, String extra){
        int aux[];
        int izq[] = new int[0];
        int der[] = new int[0];
        int j, k, pivote = v[0];
        colores[i] = "green";
        graficar(extra + "Actual: " + pivote);
        colores[i] = "white";
        for(j = i; (j - i) < v.length; j++){
            if(v[j - i] < pivote){
                aux = null;
                aux = izq;
                izq = new int[izq.length + 1];
                for(k = 0; k < aux.length; k++) izq[k] = aux[k];
                izq[k] = v[j - i];
            }
            else if(v[j - i] > pivote){
                aux = null;
                aux = der;
                der = new int[der.length + 1];
                for(k = 0; k < aux.length; k++) der[k] = aux[k];
                der[k] = v[j - i];
            }
        }
        for(j = i; (j - i) < izq.length; j++) valores[j] = izq[j - i];
        k = j;
        valores[k] = pivote;
        colores[k] = "cyan";
        k++;
        for(j = k; (j - k) < der.length; j++) valores[j] = der[j - k];
        if(izq.length > 1){
            graficar(extra + "-Pivote " + pivote + "-");
            Quicksort(izq, i, extra + "-Pivote " + pivote + ": IZQ-");
            for(j = i; (j - i) < izq.length; j++) colores[j] = "yellow";
        }
        if(der.length > 1){
            graficar(extra + "-Pivote " + pivote + "-");
            Quicksort(der, k, extra + "-Pivote " + pivote + ": DER-");
            for(j = k; (j - k) < der.length; j++) colores[j] = "yellow";
        }
        colores[k - 1] = "yellow";
        graficar(extra);
    }
    //**************************************************************************
    //**************************************************************************
    //EXTRAS
    private void setBlanco(){
        for(int i = 0; i < colores.length; i++){
            colores[i] = "white";
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICAR
    private void graficar(String extra){
        String titulo = "Ordenamiento "; 
        if(tipoOrd == 0) titulo += "de Burbuja";
        else if(tipoOrd == 1) titulo += " por Insercion";
        else titulo += " Quicksort";
        graficar.graficarOrd(titulo, extra, valores, colores);
        if(auto) esperar(5000);
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
