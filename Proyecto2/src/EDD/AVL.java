package EDD;

public class AVL extends Thread{
    
    //**************************************************************************
    //**************************************************************************
    //ATRIBUTOS
    private int num;
    private int tipo;
    private int tRec;
    private Nodo raiz;
    private boolean auto;
    private boolean graf;
    private boolean bucle;
    private int[] valores;
    private Graficar.Graficar graficar;
    public class Nodo{
        private int num;
        private int alt;
        private String color;
        private Nodo izq;
        private Nodo der;
        public Nodo(int num){
            this.num = num;
            alt = 0;
            color = "white";
        }
        public void setNum(int num) { this.num = num; }
        public void setAlt(int alt) { this.alt = alt; }
        public void setColor(String color) { this.color = color; }
        public void setIzq(Nodo izq) { this.izq = izq; }
        public void setDer(Nodo der) { this.der = der; }
        public int getNum() { return num; }
        public int getAlt() { return alt; }
        public String getColor() { return color; }
        public Nodo getIzq() { return izq; }
        public Nodo getDer() { return der; }
    }
    
    //**************************************************************************
    //**************************************************************************
    //SETS
    public void setNum(int num) { this.num = num; }
    public void setTipo(int tipo) { this.tipo = tipo; }
    public void setTRec(int tRec) { this.tRec = tRec; }
    public void setRaiz(Nodo raiz) { this.raiz = raiz; }
    public void setAuto(boolean auto) { this.auto = auto; }
    public void setGraf(boolean graf) { this.graf = graf; }
    public void setBucle(boolean bucle) { this.bucle = bucle; }
    public void setValores(int[] valores) { this.valores = valores; }
    public void setGrafica() { graficar = new Graficar.Graficar(); }
    
    //**************************************************************************
    //**************************************************************************
    //GETS
    public Nodo getRaiz() { return raiz; }
    
    //**************************************************************************
    //**************************************************************************
    //RUN
    public void run(){
        setGrafica();
        switch(tipo){
            case 0:
                boolean insertar = true;
                while(insertar){
                    if(!bucle){
                        System.out.println("Iniciando insercion");
                        for(int i = 0; i < valores.length; i++){
                            graficar("Num: " + valores[i]);
                            raiz = insertarDato(raiz, valores[i]);
                            graficar("");
                        }
                        bucle = true;
                        System.out.println("Insercion Finalizada");
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
            case 2:
                boolean recorrido = true;
                while(recorrido){
                    if(!bucle){
                        System.out.println("Iniciando recorrido");
                        Limpiar(raiz);
                        switch(tRec){
                            case 0:
                                Preorden(raiz);
                            break;
                            case 1:
                                Inorden(raiz);
                            break;
                            case 2:
                                Postorden(raiz);
                            break;
                        }
                        graficar("Recorrido Finalizado");
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
        if(act == null) return new Nodo(numero);
        act.setColor("green");
        graficar("Num " + numero);
        act.setColor("white");
        if(numero < act.getNum()) act.setIzq(insertarDato(act.getIzq(), numero));
        else act.setDer(insertarDato(act.getDer(), numero));
        act.setColor("green");
        graficar("");
        act.setColor("white");
        calcAltura(act);
        int factEqu = getFactorEquilibrio(act);
        if(factEqu <= -2) act = despDer(act);
        else if(2 <= factEqu) act = despIzq(act);
        calcAltura(act);
        return act;
    }
    
    //**************************************************************************
    //**************************************************************************
    //ELIMINAR
    private Nodo eliminarDato(Nodo act){
        act.setColor("green");
        graficar("Num: " + num);
        act.setColor("white");
        if(act.getNum() == num){
            act.setColor("red");
            if(act.getIzq() == null && act.getDer() == null){
                graficar("ENCONTRADO!");
                return null;
            }
            else if(act.getIzq() != null){
                if(act.getDer() == null){
                    act.getIzq().setColor("blue");
                    graficar("ENCONTRADO!");
                    act = act.getIzq();
                }
                else if(act.getIzq().getDer() == null){
                    act.getIzq().setColor("blue");
                    graficar("ENCONTRADO!");
                    act.getIzq().setColor("white");
                    act.getIzq().setDer(act.getDer());
                    act = act.getIzq();
                }
                else if(act.getIzq().getDer().getDer() == null){
                    act.getIzq().setColor("blue");
                    act.getIzq().getDer().setColor("yellow");
                    graficar("ENCONTRADO!");
                    act.setNum(act.getIzq().getDer().getNum());
                    act.getIzq().setDer(act.getIzq().getDer().getIzq());
                    graficar("");
                    act.getIzq().setColor("white");
                    act.setColor("white");
                    calcAltura(act.getIzq());
                    int factEqu = getFactorEquilibrio(act.getIzq());
                    if(factEqu <= -2) act.setIzq(despDer(act.getIzq()));
                    else if(2 <= factEqu) act.setIzq(despIzq(act.getIzq()));
                }
                else{
                    Nodo masDer = getMasDer(act.getIzq());
                    masDer.setColor("blue");
                    masDer.getDer().setColor("yellow");
                    graficar("ENCONTRADO!");
                    act.setNum(masDer.getDer().getNum());
                    masDer.setDer(masDer.getDer().getIzq());
                    graficar("");
                    masDer.setColor("white");
                    act.setColor("white");
                    calcAltura(masDer);
                    int factEqu = getFactorEquilibrio(masDer);
                    if(factEqu <= -2) masDer = despDer(masDer);
                    else if(2 <= factEqu) masDer = despIzq(masDer);
                    act.setIzq(setMasDer(act.getIzq(), masDer));
                }
            }
            else{
                if(act.getIzq() == null){
                    act.getDer().setColor("blue");
                    graficar("ENCONTRADO!");
                    act = act.getDer();
                }
                else if(act.getDer().getIzq() == null){
                    act.getDer().setColor("blue");
                    graficar("ENCONTRADO!");
                    act.getDer().setColor("white");
                    act.getDer().setIzq(act.getIzq());
                    act = act.getDer();
                }
                else if(act.getDer().getIzq().getIzq() == null){
                    act.getDer().setColor("blue");
                    act.getDer().getIzq().setColor("yellow");
                    graficar("ENCONTRADO!");
                    act.setNum(act.getDer().getIzq().getNum());
                    act.getDer().setIzq(act.getDer().getIzq().getDer());
                    graficar("");
                    act.getDer().setColor("white");
                    act.setColor("white");
                    calcAltura(act.getDer());
                    int factEqu = getFactorEquilibrio(act.getDer());
                    if(factEqu <= -2) act.setDer(despDer(act.getDer()));
                    else if(2 <= factEqu) act.setDer(despIzq(act.getDer()));
                }
                else{
                    Nodo masIzq = getMasIzq(act.getDer());
                    masIzq.setColor("blue");
                    masIzq.getIzq().setColor("yellow");
                    graficar("ENCONTRADO!");
                    act.setNum(masIzq.getIzq().getNum());
                    masIzq.setIzq(masIzq.getIzq().getDer());
                    graficar("");
                    masIzq.setColor("white");
                    act.setColor("white");
                    calcAltura(masIzq);
                    int factEqu = getFactorEquilibrio(masIzq);
                    if(factEqu <= -2) masIzq = despDer(masIzq);
                    else if(2 <= factEqu) masIzq = despIzq(masIzq);
                    act.setDer(setMasIzq(act.getDer(), masIzq));
                }
            }
        }
        else if(num < act.getNum()){
            if(act.getIzq() == null) graficar(num + " NO EXISTE!");
            else act.setIzq(eliminarDato(act.getIzq()));
        }
        else{
            if(act.getDer() == null) graficar(num + " NO EXISTE!");
            else act.setDer(eliminarDato(act.getDer()));
        }
        act.setColor("green");
        graficar("Num: " + num);
        act.setColor("white");
        calcAltura(act);
        int factEqu = getFactorEquilibrio(act);
        if(factEqu <= -2) act = despDer(act);
        else if(2 <= factEqu) act = despIzq(act);
        return act;
    }
    private Nodo getMasDer(Nodo act){
        if(act.getDer().getDer() != null) return getMasDer(act.getDer());
        else return act;
    }
    private Nodo setMasDer(Nodo act, Nodo nuevoDer){
        if(act.getDer().getDer() != null) act.setDer(setMasDer(act.getDer(), nuevoDer));
        else return nuevoDer;
        return act;
    }
    private Nodo getMasIzq(Nodo act){
        if(act.getIzq().getIzq() != null) return getMasIzq(act.getIzq());
        else return act;
    }
    private Nodo setMasIzq(Nodo act, Nodo nuevoIzq){
        if(act.getIzq().getIzq() != null) act.setIzq(setMasIzq(act.getIzq(), nuevoIzq));
        else return nuevoIzq;
        return act;
    }
    
    //**************************************************************************
    //**************************************************************************
    //RECORRIDO
    private void Limpiar(Nodo act){
        act.setColor("white");
        if(act.getIzq() != null) Limpiar(act.getIzq());
        if(act.getDer() != null) Limpiar(act.getDer());
    }
    private void Preorden(Nodo act){
        act.setColor("green");
        graficar("Preorden");
        act.setColor("red");
        if(act.getIzq() != null){
            Preorden(act.getIzq());
            act.setColor("green");
            graficar("Preorden");
            act.setColor("red");
        }
        if(act.getDer() != null){
            Preorden(act.getDer());
            act.setColor("green");
            graficar("Preorden");
            act.setColor("red");
        }
    }
    private void Inorden(Nodo act){
        act.setColor("green");
        graficar("Inorden");
        act.setColor("blue");
        if(act.getIzq() != null){
            Inorden(act.getIzq());
            act.setColor("green");
            graficar("Inorden");
            act.setColor("red");
        }
        act.setColor("red");
        if(act.getDer() != null){
            Inorden(act.getDer());
            act.setColor("green");
            graficar("Inorden");
            act.setColor("red");
        }
    }
    private void Postorden(Nodo act){
        act.setColor("green");
        graficar("Postorden");
        act.setColor("blue");
        if(act.getIzq() != null){
            Postorden(act.getIzq());
            act.setColor("green");
            graficar("Postorden");
            act.setColor("blue");
        }
        if(act.getDer() != null){
            Postorden(act.getDer());
            act.setColor("green");
            graficar("Postorden");
        }
        act.setColor("red");
    }
    
    //**************************************************************************
    //**************************************************************************
    //ORDENAMIENTOS
    //DERECHA
    private Nodo despDer(Nodo act){
        act.setColor("red");
        act.getDer().setColor("blue");
        Nodo t0 = act;
        Nodo t1 = act.getDer();
        Nodo t2 = act.getDer().getIzq();
        if(getFactorEquilibrio(t1) < 0){
            graficar("Equilibrando - SIMPLE DERECHA");
            t0.setDer(t1.getIzq());
            t1.setIzq(t0);
            act = t1;
        }
        else{
            t2.setColor("yellow");
            graficar("Equilibrando - DOBLE DERECHA");
            t0.setDer(t2.getIzq());
            t1.setIzq(t2.getDer());
            t2.setIzq(t0);
            t2.setDer(t1);
            act = t2;
        }
        t0.setColor("white");
        t1.setColor("white");
        if(t2 != null) t2.setColor("white");
        return act;
    }
    //IZQUIERDA
    private Nodo despIzq(Nodo act){
        act.setColor("red");
        act.getIzq().setColor("blue");
        Nodo t0 = act;
        Nodo t1 = act.getIzq();
        Nodo t2 = act.getIzq().getDer();
        if(getFactorEquilibrio(t1) > 0){
            graficar("Equilibrando - SIMPLE IZQUIERDA");
            t0.setIzq(t1.getDer());
            t1.setDer(t0);
            act = t1;
        }
        else{
            t2.setColor("yellow");
            graficar("Equilibrando - DOBLE IZQUIERDA");
            t0.setIzq(t2.getDer());
            t1.setDer(t2.getIzq());
            t2.setDer(t0);
            t2.setIzq(t1);
            act = t2;
        }
        t0.setColor("white");
        t1.setColor("white");
        if(t2 != null) t2.setColor("white");
        return act;
    }
    
    //**************************************************************************
    //**************************************************************************
    //METODOS DE ALTURA
    private void calcAltura(Nodo act){
        if(act.getDer() == null && act.getIzq() == null) act.setAlt(1);
        else{
            if(act.getIzq() != null) calcAltura(act.getIzq());
            if(act.getDer() != null) calcAltura(act.getDer());
            if(act.getIzq() == null) act.setAlt(act.getDer().getAlt() + 1);
            else if(act.getDer() == null) act.setAlt(act.getIzq().getAlt() + 1);
            else if(act.getIzq().getAlt() > act.getDer().getAlt()) act.setAlt(act.getIzq().getAlt() + 1);
            else act.setAlt(act.getDer().getAlt() + 1);
        }
    }
    private int getFactorEquilibrio(Nodo act){
        if(act.getIzq() != null || act.getDer() != null){
            if(act.getIzq() == null) return -act.getDer().getAlt();
            else if(act.getDer() == null) return act.getIzq().getAlt();
            else return act.getIzq().getAlt() - act.getDer().getAlt();
        }
        else return 0;
    }
    
    //**************************************************************************
    //**************************************************************************
    //GRAFICA
    public void graficar(String extra){
        if(graf){
            graficar.graficarAVL(extra, raiz);
            if(auto) esperar(5000);
            else{
                bucle = true;
                while(bucle) esperar(50);
            }
        }
        else if(tipo == 1 || tipo == 2){
            System.out.println("Graficando...");
            graficar.graficarAVL(extra, raiz);
        }
    }
    private void esperar(int t){
        try{
            Thread.sleep(t);
        }catch(Exception ex){}
    }
    
}
