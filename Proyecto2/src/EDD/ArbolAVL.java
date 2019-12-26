package EDD;

public class ArbolAVL {
    public class Nodo{
        private int num;
        private int alt;
        private Nodo der;
        private Nodo izq;
        Nodo(int num) { this.num = num; }
        public void setAlt(int alt) { this.alt = alt; }
        public void setDer(Nodo der) { this.der = der; }
        public void setIzq(Nodo izq) { this.izq = izq; }
        public int getNum() { return num; }
        public int getAlt() { return alt; }
        public Nodo getDer() { return der; }
        public Nodo getIzq() { return izq; }
    }   
    
    public Nodo Insertar(Nodo raiz, int num){
        Nodo nuevo = new Nodo(num);
        if(raiz == null){
            raiz = nuevo;
            nuevo.setAlt(0);
        }else{
            raiz = Insertar_Rec(raiz, num);
        }
        return raiz;
    }
    private Nodo Insertar_Rec(Nodo act, int num){
        if(num < act.getNum()){
            if(act.getIzq() == null){
                Nodo nuevo = new Nodo(num);
                act.setIzq(nuevo);
            }
            else act = Insertar_Rec(act.getIzq(), num);
        }else{
            if(act.getDer() == null){
                Nodo nuevo = new Nodo(num);
                act.setDer(nuevo);
            }
            else act = Insertar_Rec(act.getDer(), num);
        }
        setAltura(act);
        int dif = getFacEqu(act);
        if(dif <= -2) act = despIzq(act);
        else if(2 <= dif) act = despDer(act);
        setAltura(act);
        return act;
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
        if(act.getIzq() == null) dif = -act.getDer().getAlt();
        else if(act.getDer() == null) dif = act.getIzq().getAlt();
        else dif = act.getIzq().getAlt() - act.getDer().getAlt();
        return dif;
    }
    
    private Nodo despIzq(Nodo act){
        if(getFacEqu(act.getIzq()) > 0){ // simple izq
            Nodo t1 = act;
            Nodo t2 = act.getIzq();
            t1.setIzq(t2.getDer());
            t2.setDer(t1);
            return t2;
        }else{ //doble izq
            Nodo t1 = act;
            Nodo t2 = act.getIzq();
            Nodo t3 = act.getIzq().getDer();
            t2.setDer(t3.getIzq());
            t1.setIzq(t3.getDer());
            t3.setIzq(t2);
            t3.setDer(t1);
            return t3;
        }
    }
    private Nodo despDer(Nodo act){
        if(getFacEqu(act.getDer()) < 0){ // simple der
            Nodo t1 = act;
            Nodo t2 = act.getDer();
            t1.setDer(t2.getIzq());
            t2.setIzq(t1);
            return t2;
        }else{ //doble der
            Nodo t1 = act;
            Nodo t2 = act.getDer();
            Nodo t3 = act.getIzq();
            t1.setDer(t3.getIzq());
            t2.setIzq(t3.getDer());
            t3.setIzq(t1);
            t3.setDer(t2);
            return t3;
        }
    }
}