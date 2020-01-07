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
                        System.out.println("Iniciando eliminacion de " + num);
                        romper = false;
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
    private boolean existenHijos(Nodo act){
        for(int i = 0; i < act.getPaginas().length; i++){
            if(act.getPaginas()[0] != null) return true;
        }
        return false;
    }
    private boolean existeEspacio(Nodo act){
        for(int i = 0; i < act.getClaves().length; i++){
            if(act.getClaves()[i] == null) return true;
        }
        return false;
    }
    private Nodo crearNodo(int numero){
        Nodo nuevo = new Nodo(orden);
        nuevo.getClaves()[0] = numero;
        nuevo = setTodoBlanco(nuevo);
        return nuevo;
    }
    private Nodo setTodoBlanco(Nodo act){
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
        else if(existenHijos(act)){
            act.setPintarTodo(true);
            graficar("Eliminar: " + num);
            act.setPintarTodo(false);
            for(int i = 0; i < act.getClaves().length; i++){
                if(num < act.getClaves()[i]){
                    act.getColorPagina()[i] = "green";
                    graficar("Eliminar: " + num);
                    act.getColorPagina()[i] = "white";
                    act.getPaginas()[i] = eliminarDato(act.getPaginas()[i]);
                    if(romper == true) act = merge(act, act.getPaginas()[i]);
                    break;
                }
                else if(num == act.getClaves()[i]){
                    act.getColorClave()[i] = "green";
                    graficar("ENCONTRADO!!: " + num);
                    act.getColorClave()[i] = "white";
                    
                    
                    
                    break;
                }
                else if(num > act.getClaves()[i] && i == act.getClaves().length - 1){
                    act.getColorPagina()[i + 1] = "green";
                    graficar("Eliminar: " + num);
                    act.getColorPagina()[i + 1] = "white";
                    act.getPaginas()[i + 1] = eliminarDato(act.getPaginas()[i + 1]);
                    if(romper == true) act = merge(act, act.getPaginas()[i + 1]);
                    break;
                }
                else if(num > act.getClaves()[i] && act.getClaves()[i + 1] == null){
                    act.getColorPagina()[i + 1] = "green";
                    graficar("Eliminar: " + num);
                    act.getColorPagina()[i + 1] = "white";
                    act.getPaginas()[i + 1] = eliminarDato(act.getPaginas()[i + 1]);
                    if(romper == true) act = merge(act, act.getPaginas()[i + 1]);
                    break;
                }
            }
        }
        else{
            act = eliminarClave(act);
            if(act.getClaves()[1] == null) romper = true;
        }
        act.setPintarTodo(true);
        graficar("Eliminar: " + num);
        act.setPintarTodo(false);
        return act;
    }
    private Nodo merge(Nodo padre, Nodo hijo){
        System.out.println("MERGE!");
        Nodo hermanoIzq = null;
        Nodo hermanoDer = null;
        for(int i = 0; i < padre.getPaginas().length; i++){
            if(padre.getPaginas()[i] == hijo){
                if(i != 0){
                    if(padre.getPaginas()[i - 1].getClaves()[2] != null){
                        hermanoIzq = padre.getPaginas()[i - 1];
                        break;
                    }
                }
                if(i < padre.getPaginas().length - 1){
                    if(padre.getPaginas()[i + 1].getClaves()[2] != null){
                        hermanoDer = padre.getPaginas()[i + 1];
                        break;
                    }
                }
                break;
            }
        }
        int nNum = 0, aux;
        Nodo paginaAux = null;
        if(hermanoIzq != null){
            hermanoIzq.setPintarTodo(true);
            graficar("Prestar hermano izquierdo");
            hermanoIzq.setPintarTodo(false);
            for(int i = 0; i < hermanoIzq.getClaves().length; i++){
                if(i == hermanoIzq.getClaves().length - 1){
                    hermanoIzq.getColorClave()[i] = "green";
                    graficar("Nodo prestado");
                    hermanoIzq.getColorClave()[i] = "white";
                    nNum = hermanoIzq.getClaves()[i];
                    hermanoIzq.getClaves()[i] = null;
                    paginaAux = hermanoIzq.getPaginas()[i + 1];
                    break;
                }
                else if(hermanoIzq.getClaves()[i + 1] == null){
                    hermanoIzq.getColorClave()[i] = "green";
                    graficar("Nodo prestado");
                    hermanoIzq.getColorClave()[i] = "white";
                    nNum = hermanoIzq.getClaves()[i];
                    hermanoIzq.getClaves()[i] = null;
                    paginaAux = hermanoIzq.getPaginas()[i + 1];
                    break;
                }
            }
            for(int i = 0; i < padre.getClaves().length; i++){
                if(nNum < padre.getClaves()[i]){
                    padre.getColorClave()[i] = "green";
                    graficar("Nodo padre a mover");
                    padre.getColorClave()[i] = "white";
                    aux = padre.getClaves()[i];
                    padre.getClaves()[i] = nNum;
                    nNum = aux;
                    for(int j = 0; j < padre.getPaginas()[i + 1].getClaves().length; j++){
                        if(padre.getPaginas()[i + 1].getClaves()[j] == null){
                            padre.getPaginas()[i + 1].getClaves()[j] = nNum;
                            padre.getPaginas()[i + 1].setClaves(ordenarClaves(padre.getPaginas()[i + 1].getClaves()));
                            padre.getPaginas()[i + 1].getPaginas()[j + 1] = paginaAux;
                            padre.getPaginas()[i + 1].setPaginas(ordenarPaginas(padre.getPaginas()[i + 1].getPaginas()));
                            break;
                        }
                    }
                    break;
                }
            }
            padre.setPintarTodo(true);
            graficar("Cambio realizado");
            padre.setPintarTodo(false);
            romper = false;
        }
        else if(hermanoDer != null){
            hermanoDer.setPintarTodo(true);
            graficar("Prestar hermano derecho");
            hermanoDer.setPintarTodo(false);
            nNum = hermanoDer.getClaves()[0];
            paginaAux = hermanoDer.getPaginas()[0];
            hermanoDer.getColorClave()[0] = "green";
            graficar("Nodo prestado");
            hermanoDer.getColorClave()[0] = "white";
            for(int i = 1; i < hermanoDer.getClaves().length; i++){
                hermanoDer.getClaves()[i - 1] = hermanoDer.getClaves()[i];
                hermanoDer.getClaves()[i] = null;
                hermanoDer.getPaginas()[i - 1] = hermanoDer.getPaginas()[i];
                hermanoDer.getPaginas()[i] = null;
            }
            for(int i = 0; i < padre.getClaves().length; i++){
                if(i == padre.getClaves().length - 1){
                    padre.getColorClave()[i - 1] = "green";
                    graficar("Nodo padre a mover");
                    padre.getColorClave()[i - 1] = "white";
                    aux = padre.getClaves()[i - 1];
                    padre.getClaves()[i - 1] = nNum;
                    nNum = aux;
                    for(int j = 0; j < padre.getPaginas()[i - 1].getClaves().length; j++){
                        if(padre.getPaginas()[i - 1].getClaves()[j] == null){
                            padre.getPaginas()[i - 1].getClaves()[j] = nNum;
                            padre.getPaginas()[i - 1].setClaves(ordenarClaves(padre.getPaginas()[i - 1].getClaves()));
                            padre.getPaginas()[i - 1].getPaginas()[j + 1] = paginaAux;
                            padre.getPaginas()[i - 1].setPaginas(ordenarPaginas(padre.getPaginas()[i - 1].getPaginas()));
                            break;
                        }
                    }
                    break;
                }
                else if(padre.getClaves()[i] == null){
                    padre.getColorClave()[i - 1] = "green";
                    graficar("Nodo padre a mover");
                    padre.getColorClave()[i - 1] = "white";
                    aux = padre.getClaves()[i - 1];
                    padre.getClaves()[i - 1] = nNum;
                    nNum = aux;
                    for(int j = 0; j < padre.getPaginas()[i - 1].getClaves().length; j++){
                        if(padre.getPaginas()[i - 1].getClaves()[j] == null){
                            padre.getPaginas()[i - 1].getClaves()[j] = nNum;
                            padre.getPaginas()[i - 1].setClaves(ordenarClaves(padre.getPaginas()[i - 1].getClaves()));
                            padre.getPaginas()[i - 1].getPaginas()[j + 1] = paginaAux;
                            padre.getPaginas()[i - 1].setPaginas(ordenarPaginas(padre.getPaginas()[i - 1].getPaginas()));
                            break;
                        }
                    }
                    break;
                }
                else if(nNum < padre.getClaves()[i]){
                    padre.getColorClave()[i - 1] = "green";
                    graficar("Nodo padre a mover");
                    padre.getColorClave()[i - 1] = "white";
                    aux = padre.getClaves()[i - 1];
                    padre.getClaves()[i - 1] = nNum;
                    nNum = aux;
                    for(int j = 0; j < padre.getPaginas()[i - 1].getClaves().length; j++){
                        if(padre.getPaginas()[i - 1].getClaves()[j] == null){
                            padre.getPaginas()[i - 1].getClaves()[j] = nNum;
                            padre.getPaginas()[i - 1].setClaves(ordenarClaves(padre.getPaginas()[i - 1].getClaves()));
                            padre.getPaginas()[i - 1].getPaginas()[j + 1] = paginaAux;
                            padre.getPaginas()[i - 1].setPaginas(ordenarPaginas(padre.getPaginas()[i - 1].getPaginas()));
                            break;
                        }
                    }
                    break;
                }
            }
            padre.setPintarTodo(true);
            graficar("Cambio realizado");
            padre.setPintarTodo(false);
            romper = false;
        }
        else{
            if(padre.getPaginas()[0] != hijo){
                
            }
            else{
                
            }
        }
        return padre;
    }
    private Nodo eliminarClave(Nodo act){
        for(int i = 0; i < act.getClaves().length; i++){
            if(act.getClaves()[i] == num){
                act.getColorClave()[i] = "green";
                graficar("ENCONTRADO!!: " + num);
                act.getColorClave()[i] = "white";
                act.getClaves()[i] = null;
                while(i < act.getClaves().length - 1){
                    act.getClaves()[i] = act.getClaves()[i + 1];
                    act.getClaves()[i + 1] = null;
                    i++;
                }
                break;
            }
        }
        return act;
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
