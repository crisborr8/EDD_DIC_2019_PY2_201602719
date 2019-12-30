package EDD;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ArbolAVL extends Thread{
    
    Grafica.Graficar graficar;
    private int valores[];
    private boolean automatico;
    private boolean continuar;
    private Nodo raiz;
    private int tipo;
    private int num;
    private int tipoRec;
    
    public void setAutomatico(boolean automatico) { this.automatico = automatico; }
    
    public class Nodo{
        private int num;
        private int alt;
        private boolean t0, t1, t2;
        private Nodo der;
        private Nodo izq;
        Nodo(int num) { 
            t0 = t1 = t2 = false;
            this.num = num;
        }
        public void setT0(boolean t0) { this.t0 = t0; }
        public void setT1(boolean t1) { this.t1 = t1; }
        public void setT2(boolean t2) { this.t2 = t2; }
        public void setAlt(int alt) { this.alt = alt; }
        public void setDer(Nodo der) { this.der = der; }
        public void setIzq(Nodo izq) { this.izq = izq; }
        public boolean getT0() { return t0; }
        public boolean getT1() { return t1; }
        public boolean getT2() { return t2; }
        public int getNum() { return num; }
        public int getAlt() { return alt; }
        public Nodo getDer() { return der; }
        public Nodo getIzq() { return izq; }
    }   
    
    public Nodo getRaiz() { return raiz; }
    public void setRaiz(Nodo raiz) { this.raiz = raiz; }
    public void setValores(int valores[]) { this.valores = valores; }
    public void setContinuar(boolean continuar) { this.continuar = continuar; }
    public void setTipo(int tipo) { this.tipo = tipo; }
    public void setTipoRec(int tipoRec) { this.tipoRec = tipoRec; }
    public void setNum(int num) { this.num = num; }
    public ArbolAVL(){
        tipo = -1;
    }
    
    public void run(){
        System.out.println("Iniciando");
        graficar = new Grafica.Graficar();
        switch(tipo){
            case 0:
                for(int i = 0; i < valores.length; i++){
                    System.out.println("ingresado: " + valores[i]);
                    raiz = Insertar(valores[i]);
                }
            break;
            case 1:
                boolean eliminado = true;
                while(eliminado){
                    if(continuar){
                        System.out.println("---eliminando: " + num);
                        raiz = Eliminar(raiz, num);
                        graficar("");
                        continuar = false;
                    }
                    esperar(10);
                }
            break;
            case 2:
                boolean recorrido = true;
                while(recorrido){
                    if(continuar){
                        Limpiar_Nodos(raiz);
                        if(tipoRec == 0){
                            System.out.println("---recorriendo: preorden");
                            Preorden_rec(raiz);
                        }else if(tipoRec == 1){
                            System.out.println("---recorriendo: inorden");
                            Inorden_rec(raiz);
                        }else{
                            System.out.println("---recorriendo: postorden");
                            Postorden_rec(raiz);
                        }
                        graficar("");
                        continuar = false;
                  }  
                  esperar(10);
                }
            break;
        }
    }
    
    public Nodo Insertar(int num){
        Nodo nuevo = new Nodo(num);
        if(raiz == null){
            raiz = nuevo;
            nuevo.setAlt(0);
            graficar("");
        }else{
            raiz = Insertar_Rec(raiz, num);
        }
        return raiz;
    }
    private Nodo Insertar_Rec(Nodo act, int num){
        act.setT0(true);
        graficar(num + ";\n");
        if(num < act.getNum()){
            if(act.getIzq() == null){
                Nodo nuevo = new Nodo(num);
                act.setIzq(nuevo);
            }
            else{
                act.setT0(false);
                act.setIzq(Insertar_Rec(act.getIzq(), num));
            }
        }else{
            if(act.getDer() == null){
                Nodo nuevo = new Nodo(num);
                act.setDer(nuevo);
            }
            else{
                act.setT0(false);
                act.setDer(Insertar_Rec(act.getDer(), num));
            }
        }
        act.setT0(true);
        graficar("");
        setAltura(act);
        int dif = getFacEqu(act);
        System.out.println("--->dif: " + dif + ", en: " + act.getNum());
        if(dif <= -2) act = despDer(act);
        else if(2 <= dif) act = despIzq(act);
        setAltura(act);
        act.setT0(false);
        return act;
    }
    
    public Nodo Eliminar(Nodo raiz, int num){
        if(raiz != null) return Eliminar_rec(raiz, num);
        else return null;
    }
    private Nodo Eliminar_rec(Nodo act, int num){
        act.setT0(true);
        graficar("");
        if(act.getNum() == num){
            if(act.getIzq() != null){
                if(act.getIzq().getDer() == null){
                    act.getIzq().setT1(true);
                    graficar("");
                    act.getIzq().setDer(act.getDer());
                    act = act.getIzq();
                }else{
                    Nodo auxAnt = getIzqDer(act.getIzq());
                    Nodo aux = auxAnt.getDer();
                    aux.setT1(true);
                    graficar("");
                    aux.setDer(act.getDer());
                    auxAnt.setDer(aux.getIzq());
                    aux.setIzq(act.getIzq());
                    act = aux;
                    act.setIzq(ordenarNiveles(act.getIzq()));
                }
                act.setT1(false);
            }
            else if(act.getDer() != null){
                if(act.getDer().getIzq() == null){
                    act.getDer().setT1(true);
                    graficar("");
                    act.getDer().setIzq(act.getIzq());
                    act = act.getDer();
                }else{
                    Nodo auxAnt = getDerIzq(act.getDer());
                    Nodo aux = auxAnt.getIzq();
                    aux.setT1(true);
                    graficar("");
                    aux.setIzq(act.getIzq());
                    auxAnt.setIzq(aux.getIzq());
                    aux.setIzq(act.getIzq());
                    act = aux;
                    act.setDer(ordenarNiveles(act.getDer()));
                }
                act.setT1(false);
            }
            else{
                return null;
            }
        }
        else if(num < act.getNum() && act.getIzq() != null){
            act.setT0(false);
            act.setIzq(Eliminar_rec(act.getIzq(), num));
        }
        else if(act.getDer() != null) {
            act.setT0(false);
            act.setDer(Eliminar_rec(act.getDer(), num));
        }
        if(act.getDer() != null || act.getIzq() != null){
            act.setT0(true);
            graficar("");
            setAltura(act);
            int dif = getFacEqu(act);
            System.out.println("--->dif: " + dif + ", en: " + act.getNum());
            if(dif <= -2) act = despDer(act);
            else if(2 <= dif) act = despIzq(act);
            setAltura(act);
        }
        act.setT0(false);
        return act;
    }
    private Nodo getIzqDer(Nodo act){
        if(act.getDer().getDer() == null) return act;
        else return getIzqDer(act.getDer());
    }
    private Nodo getDerIzq(Nodo act){
        if(act.getIzq().getIzq() == null) return act;
        else return getDerIzq(act.getIzq());
    }
    private Nodo ordenarNiveles(Nodo act){
        if(act.getIzq() != null) act.setIzq(ordenarNiveles(act.getIzq()));
        if(act.getDer() != null) act.setDer(ordenarNiveles(act.getDer()));
        setAltura(act);
        int dif = getFacEqu(act);
        System.out.println("--->dif: " + dif + ", en: " + act.getNum());
        if(dif <= -2) act = despDer(act);
        else if(2 <= dif) act = despIzq(act);
        setAltura(act);
        return act;
    }
    
    private void Limpiar_Nodos(Nodo act){
        act.setT0(false);
        act.setT1(false);
        act.setT2(false);
        if(act.getIzq() != null) Limpiar_Nodos(act.getIzq());
        if(act.getDer() != null) Limpiar_Nodos(act.getDer());
    }
    private void Preorden_rec(Nodo act){
        act.setT2(true);
        graficar("Preorden;\n");
        act.setT2(false);
        act.setT0(true);
        if(act.getIzq() != null){
            Preorden_rec(act.getIzq());
            act.setT0(false);
            act.setT2(true);
            graficar("Preorden;\n");
            act.setT2(false);
            act.setT0(true);
        }
        if(act.getDer() != null){
            Preorden_rec(act.getDer());
            act.setT0(false);
            act.setT2(true);
            graficar("Preorden;\n");
            act.setT2(false);
            act.setT0(true);
        }
        act.setT2(false);
        act.setT0(true);
    }
    private void Inorden_rec(Nodo act){
        act.setT2(true);
        graficar("Inorden;\n");
        act.setT2(false);
        act.setT1(true);
        if(act.getIzq() != null){
            Inorden_rec(act.getIzq());
            act.setT1(false);
            act.setT2(true);
            graficar("Inorden;\n");
            act.setT2(false);
            act.setT0(true);
        }
        if(act.getDer() != null){
            Inorden_rec(act.getDer());
            act.setT1(false);
            act.setT0(false);
            act.setT2(true);
            graficar("Inorden;\n");
            act.setT2(false);
            act.setT0(true);
        }
        act.setT2(false);
        act.setT1(false);
        act.setT0(true);
    }
    private void Postorden_rec(Nodo act){
        act.setT2(true);
        graficar("Postorden;\n");
        act.setT2(false);
        act.setT1(true);
        if(act.getIzq() != null){
            Postorden_rec(act.getIzq());
            act.setT1(false);
            act.setT2(true);
            graficar("Postorden;\n");
            act.setT2(false);
            act.setT1(true);
        }
        if(act.getDer() != null){
            Postorden_rec(act.getDer());
            act.setT1(false);
            act.setT2(true);
            graficar("Postorden;\n");
            act.setT2(false);
            act.setT0(true);
        }
        act.setT2(false);
        act.setT1(false);
        act.setT0(true);
    }
    
    private void setAltura(Nodo act){
        act.setAlt(0);
        if(act.getIzq() != null) setAltura(act.getIzq());
        if(act.getDer() != null) setAltura(act.getDer());
        if(act.getIzq() == null || act.getDer() == null){
            if (act.getIzq() == null && act.getDer() == null) act.setAlt(0);
            else if(act.getIzq() == null) act.setAlt(act.getDer().getAlt() + 1);
            else if(act.getDer() == null) act.setAlt(act.getIzq().getAlt() + 1);
        }else{
            if(act.getIzq().getAlt() > act.getDer().getAlt()) act.setAlt(act.getIzq().getAlt() + 1);
            else act.setAlt(act.getDer().getAlt() + 1);
        }
    }
    private int getFacEqu(Nodo act){
        int dif = 0;
        if(act.getIzq() == null && act.getDer() == null) dif = 0;
        else if(act.getIzq() == null) dif = -act.getDer().getAlt() - 1;
        else if(act.getDer() == null) dif = act.getIzq().getAlt() + 1;
        else dif = act.getIzq().getAlt() - act.getDer().getAlt();
        return dif;
    }
    
    private Nodo despIzq(Nodo act){
        act.setT0(true);
        act.getIzq().setT1(true);
        Nodo t0 = act;
        Nodo t1 = act.getIzq();
        if(getFacEqu(act.getIzq()) > 0){ // simple izq
            System.out.println("simple izq");
            graficar("");
            t0.setIzq(t1.getDer());
            t1.setDer(t0);
            act = t1;
        }else{ //doble izq
            System.out.println("doble izq");
            act.getIzq().getDer().setT2(true);
            Nodo t2 = t1.getDer();
            graficar("");
            t0.setIzq(t2.getDer());
            t1.setDer(t2.getIzq());
            t2.setIzq(t1);
            t2.setDer(t0);
            act = t2;
            t2.setT2(false);
        }
        t0.setT0(false);
        t1.setT1(false);
        return act;
    }
    private Nodo despDer(Nodo act){
        act.setT0(true);
        act.getDer().setT1(true);
        Nodo t0 = act;
        Nodo t1 = act.getDer();
        if(getFacEqu(act.getDer()) < 0){ // simple der
            System.out.println("simple der");
            graficar("");
            t0.setDer(t1.getIzq());
            t1.setIzq(t0);
            act = t1;
        }else{ //doble der
            System.out.println("doble der");
            act.getDer().getIzq().setT2(true);
            Nodo t2 = act.getDer().getIzq();
            graficar("");
            t1.setIzq(t2.getDer());
            t0.setDer(t2.getIzq());
            t2.setIzq(t0);
            t2.setDer(t1);
            act = t2;
            t2.setT2(false);
        }
        t0.setT0(false);
        t1.setT1(false);
        return act;
    }
    
    public void graficar(String extra){
        if(tipo != -1){
            graficar.Cerrar();
            esperar(5);
            if(raiz != null) graficar.Mostrar(extra + graficar.getCodigo_AVL(raiz));
            if(automatico) esperar(25);
            else{
                continuar = false;
                while(!continuar){
                    esperar(10);
                }
            }
        }
    }
    private void esperar(int segundos) {
        try {
                Thread.sleep(segundos * 100);
        } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
        }
    }
}