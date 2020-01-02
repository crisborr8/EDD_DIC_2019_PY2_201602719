package EDD;

public class B extends Thread{

    //**************************************************************************
    //**************************************************************************
    //ATRIBUTOS
    private int num;
    private int tipo;
    private int orden;
    private Nodo raiz;
    private boolean auto;
    private boolean graf;
    private boolean bucle;
    private boolean romper;
    private int valores[];
    Graficar.Graficar graficar;
    public class Nodo{
        private boolean pintarTodo;
        private Integer[] claves;
        private String[] colorClave;
        private String[] colorPagina;
        private Nodo[] paginas;
        public Nodo(int orden){
            colorClave = new String[orden - 1];
            colorPagina = new String[orden];
            claves = new Integer[orden - 1];
            paginas = new Nodo[orden];
            pintarTodo = false;
        }
        public void setColorClave(int i, String color) { this.colorClave[i] = color; }
        public void setColorPagina(int i, String color) { this.colorClave[i] = color; }
        public void setPintarTodo(boolean pintarTodo) { this.pintarTodo = pintarTodo; }
        public void setClaves(Integer[] claves) { this.claves = claves; }
        public void setPaginas(Nodo[] paginas) { this.paginas = paginas; }
        public String[] getColorClave() { return colorClave; }
        public String[] getColorPagina() { return colorPagina; }
        public boolean getPintarTodo() { return pintarTodo; }
        public Integer[] getClaves() { return claves; }
        public Nodo[] getPaginas() { return paginas; }
    }
    
    //**************************************************************************
    //**************************************************************************
    //SETS
    public void setNum(int num) { this.num = num; }
    public void setTipo(int tipo) { this.tipo = tipo; }
    public void setRaiz(Nodo raiz) { this.raiz = raiz; }
    public void setAuto(boolean auto) { this.auto = auto; }
    public void setGraf(boolean graf) { this.graf = graf; }
    public void setBucle(boolean bucle) { this.bucle = bucle; }
    public void setValores(int[] valores) { this.valores = valores; }
    public void setGrafica() { graficar = new Graficar.Graficar(); }
    public void setRomper() { romper = false; }
    public void setOrden() { orden = 5; }
    
    //**************************************************************************
    //**************************************************************************
    //GETS
    public Nodo getRaiz() { return raiz; }
    
    //**************************************************************************
    //**************************************************************************
    //RUN
    public void run(){
        setGrafica();
        setOrden();
        switch(tipo){
            case 0:
                boolean insertar = true;
                while(insertar){
                    if(!bucle){
                        System.out.println("Iniciando insercion");
                        for(int i = 0; i < valores.length; i++){
                            romper = false;
                            graficar("Num: " + valores[i]);
                            raiz = insertarDato(raiz, valores[i]);
                            graficar("");
                        }
                        System.out.println("Insercion Finalizada");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
            case 1:
                boolean eliminar = true;
                while(eliminar){
                    if(!bucle){
                        System.out.println("Iniciando eliminacion");
                        raiz = eliminarDato(raiz);
                        graficar("Eliminacion Finalizada");
                        bucle = true;
                    }
                    esperar(50);
                }
            break;
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //INSERTAR
    public Nodo insertarDato(Nodo act, int numero){
        if(act == null) return crearNodo(numero);
        act.setPintarTodo(true);
        graficar("Num: " + numero);
        act.setPintarTodo(false);
        if(existenHijos(act)){
            int i;
            Nodo aux = null;
            for(i = 0; i < act.getClaves().length; i++){
                if(numero < act.getClaves()[i]) break;
                else if(numero > act.getClaves()[i] && i >= act.getClaves().length - 2) break;
                else if(numero > act.getClaves()[i] && act.getClaves()[i + 1] == null) break;
            }
            if(numero < act.getClaves()[i]){
                act.getColorPagina()[i] = "green";
                graficar("Num: " + numero);
                act.getColorPagina()[i] = "white";
                act.getPaginas()[i] = insertarDato(act.getPaginas()[i], numero);
                aux = act.getPaginas()[i];
            }
            else if(numero > act.getClaves()[i]){
                act.getColorPagina()[i + 1] = "green";
                graficar("Num: " + numero);
                act.getColorPagina()[i + 1] = "white";
                act.getPaginas()[i + 1] = insertarDato(act.getPaginas()[i + 1], numero);
                aux = act.getPaginas()[i + 1];
            }
            if(romper == true){
                act.setPintarTodo(true);
                graficar("ROMPIENDO");
                act.setPintarTodo(false);
                if(existeEspacio(act)){
                    for(i = 0; i < act.getClaves().length; i++){
                        if(act.getClaves()[i] == null){
                            act.getClaves()[i] = aux.getClaves()[0];
                            break;
                        }
                    }
                    act.setClaves(ordenarClaves(act.getClaves()));
                    for(i = 0; i < act.getPaginas().length; i++){
                        if(act.getPaginas()[i] == aux) act.getPaginas()[i] = aux.getPaginas()[0];
                        else if(act.getPaginas()[i] == null){
                            act.getPaginas()[i] = aux.getPaginas()[1];
                            break;
                        }
                    }
                    act.setPaginas(ordenarPaginas(act.getPaginas()));
                    for(i = 0; i < act.getClaves().length; i++){
                        if(act.getClaves()[i] == aux.getClaves()[0]){
                            act.getColorClave()[i] = "green";
                            graficar("UNIENDO");
                            act.getColorClave()[i] = "white";
                            break;
                        }
                    }
                    romper = false;
                }
                else{
                    Integer valores[] = new Integer[orden];
                    for(i = 0; i < act.getClaves().length; i++){
                        valores[i] = act.getClaves()[i];
                    }
                    valores[orden - 1] = aux.getClaves()[0];
                    valores = ordenarClaves(valores);
                    Nodo paginas[] = new Nodo[orden + 1];
                    for(i = 0; i < act.getPaginas().length; i++){
                        if(act.getPaginas()[i] == aux) paginas[i] = aux.getPaginas()[0];
                        else paginas[i] = act.getPaginas()[i];
                    }
                    paginas[orden] = aux.getPaginas()[1];
                    paginas = ordenarPaginas(paginas);
                    
                    Nodo izq = new Nodo(orden);
                    izq = setTodoBlanco(izq);
                    Nodo der = new Nodo(orden);
                    der = setTodoBlanco(der);
                    for(i = 0; i < orden/2; i++){
                        izq.getClaves()[i] = valores[i];
                        izq.getPaginas()[i] = paginas[i];
                    }
                    izq.getPaginas()[i] = paginas[i];
                    for(i = orden/2 + 1; i < valores.length; i++){
                        der.getClaves()[i - 1 - orden/2] = valores[i];
                        der.getPaginas()[i - 1 - orden/2] = paginas[i];
                    }
                    der.getPaginas()[i - 1 - orden/2] = paginas[i];
                    numero = valores[orden/2];
                    valores = new Integer[orden - 1];
                    valores[0] = numero;
                    paginas = new Nodo[orden];
                    paginas[0] = izq;
                    paginas[1] = der;
                    act.setClaves(valores);
                    act.setPaginas(paginas);
                    act.setPintarTodo(true);
                    graficar("ROMPIENDO");
                    act.setPintarTodo(false);
                }
            }
        }
        else if(existeEspacio(act)){
            for(int i = 0; i < act.getClaves().length; i++){
                if(act.getClaves()[i] == null){
                    act.getClaves()[i] = numero;
                    break;
                }
            }
            act.setClaves(ordenarClaves(act.getClaves()));
            for(int i = 0; i < act.getClaves().length; i++){
                if(act.getClaves()[i] == numero){
                    act.getColorClave()[i] = "green";
                    graficar("");
                    act.getColorClave()[i] = "white";
                    break;
                }
            }
            act.setPintarTodo(true);
            graficar("");
            act.setPintarTodo(false);
        }
        else{
            act.setPintarTodo(true);
            graficar("ROMPIENDO");
            act.setPintarTodo(false);
            romper = true;
            Integer[] valores = new Integer[orden];
            for(int i = 0; i < act.getClaves().length; i++){
                valores[i] = act.getClaves()[i];
            }
            valores[orden - 1] = numero;
            valores = ordenarClaves(valores);
            act.getPaginas()[0] = new Nodo(orden);
            act.getPaginas()[0] = setTodoBlanco(act.getPaginas()[0]);
            Integer[] nuevosValores = new Integer[orden - 1];
            for(int i = 0; i < orden/2; i++){
                nuevosValores[i] = valores[i];
            }
            act.getPaginas()[0].setClaves(nuevosValores);
            act.getPaginas()[1] = new Nodo(orden);
            act.getPaginas()[1] = setTodoBlanco(act.getPaginas()[1]);
            nuevosValores = new Integer[orden - 1];
            for(int i = 1 + orden/2; i < valores.length; i++){
                nuevosValores[i - 1 - orden/2] = valores[i];
            }
            act.getPaginas()[1].setClaves(nuevosValores);
            numero = valores[orden / 2];
            valores = new Integer[orden - 1];
            valores[0] = numero;
            act.setClaves(valores);
            act.setPintarTodo(true);
            graficar("ROMPIENDO");
            act.setPintarTodo(false);
        }
        return act;
    }
    public boolean existenHijos(Nodo act){
        for(int i = 0; i < act.getPaginas().length; i++){
            if(act.getPaginas()[0] != null) return true;
        }
        return false;
    }
    public boolean existeEspacio(Nodo act){
        for(int i = 0; i < act.getClaves().length; i++){
            if(act.getClaves()[i] == null) return true;
        }
        return false;
    }
    public Nodo crearNodo(int numero){
        Nodo nuevo = new Nodo(orden);
        nuevo.getClaves()[0] = numero;
        nuevo = setTodoBlanco(nuevo);
        return nuevo;
    }
    public Nodo setTodoBlanco(Nodo act){
        for(int i = 0; i < act.getColorClave().length; i++){
            act.getColorClave()[i] = "white";
        }
        for(int i = 0; i < act.getColorPagina().length; i++){
            act.getColorPagina()[i] = "white";
        }
        return act;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ELIMINAR
    public Nodo eliminarDato(Nodo act){
        if(act == null) return null;
        Nodo elim;
        for(int i = 0; i < act.getClaves().length; i++){
            
        }
        return null;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ORDENAMIENTOS
    private Integer[] ordenarClaves(Integer[] claves){
        int aux, i = 0;
        while(claves[i + 1] != null){
            if(claves[i] > claves[i + 1]){
                aux = claves[i];
                claves[i] = claves[i + 1];
                claves[i + 1] = aux;
                if(i > 0) i--;
            }
            else if(i >= claves.length - 2) break;
            else i++;
        }
        return claves;
    }
    private Nodo[] ordenarPaginas(Nodo[] paginas){
        int i = 0;
        Nodo aux;
        while(paginas[i + 1] != null){
            if(paginas[i].getClaves()[0] > paginas[i + 1].getClaves()[0]){
                aux = paginas[i];
                paginas[i] = paginas[i + 1];
                paginas[i + 1] = aux;
                if(i > 0) i--;
            }
            else if(i >= paginas.length - 2) break;
            else i++;
        }
        return paginas;
    }
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICAR
    public void graficar(String extra){
        if(graf){
            graficar.graficarB(extra, raiz);
            if(auto) esperar(5000);
            else{
                bucle = true;
                while(bucle) esperar(50);
            }
        }
        else if(tipo == 1){
            System.out.println("Graficando...");
            graficar.graficarB(extra, raiz);
        }
    }
    private void esperar(int t){
        try{
            Thread.sleep(t);
        }catch(Exception ex){}
    }
}
