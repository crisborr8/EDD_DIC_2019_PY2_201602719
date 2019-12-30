package EDD;

public class ArbolB {
    
    public class Nodo{
        private Integer[] num;
        private Nodo[] pagina;
        public void setNum(Integer[] num) { this.num = num; }
        public void setPagina(Nodo[] pagina) { this.pagina = pagina; }
        public Integer[] getNum() { return num; }
        public Nodo[] getPagina() { return pagina; }
        public Nodo(int orden){
            num = new Integer[orden - 1];
            pagina = new Nodo[orden];
        }
    }
    private int orden;
    private boolean romper;
    public ArbolB(){
        orden = 5;
    }
    
    public Nodo Insertar(Nodo raiz, int num){
        if(raiz == null){
            raiz = crearPagina();
            raiz.getNum()[0] = num;
        }
        else{
            romper = false;
            raiz = insertarDato(raiz, num);
        }
        return raiz;
    }
    
    private Nodo insertarDato(Nodo act, int num){
        if(tieneHijo(act)){
            int i;
            for(i = 0; i < act.getNum().length; i++){
                if(num < act.getNum()[i]) break;
                else if(num > act.getNum()[i] && i >= act.getNum().length - 1){
                    i++;
                    break;
                }
                else if(num > act.getNum()[i] && act.getNum()[i + 1] == null){
                    i++;
                    break;
                }
            }
            act.getPagina()[i] = insertarDato(act.getPagina()[i], num);
            if(romper == true){
                Nodo nodoAux = act.getPagina()[i];
                if(estaLleno(act)){
                    Nodo nIzq = crearPagina();
                    Nodo nDer = crearPagina();
                    Integer[] valor = getNum(act, nodoAux.getNum()[0], orden);
                    Nodo[] pagina = getPagina(act, nodoAux, orden + 1);
                    int j;
                    for(j = 0; j < orden/2; j++){
                        nIzq.getNum()[j] = valor[j];
                        nIzq.getPagina()[j] = pagina[j];
                    }
                    nIzq.getPagina()[j] = pagina[j];
                    for(j = orden/2 + 1; j < orden; j++){
                        nDer.getNum()[j - 1 - orden/2] = valor[j];
                        nDer.getPagina()[j - 1 - orden/2] = pagina[j];
                    }
                    nDer.getPagina()[j - 1 - orden/2] = pagina[j];
                    valor = new Integer[orden - 1];
                    pagina = new Nodo[orden];
                    valor[0] = act.getPagina()[i].getNum()[0];
                    pagina[0] = nIzq;
                    pagina[1] = nDer;
                    act.setNum(valor);
                    act.setPagina(pagina);
                }
                else{
                    Integer[] valor = getNum(act, nodoAux.getNum()[0], orden - 1);
                    Nodo[] pagina = getPagina(act, nodoAux, orden);
                    act.setNum(valor);
                    act.setPagina(pagina);
                    romper = false;
                }
            }
        }
        else{
            if(estaLleno(act)){
                act.getPagina()[0] = crearPagina();
                act.getPagina()[1] = crearPagina();
                Integer[] valor = getNum(act, num, orden);
                for(int i = 0; i < orden/2; i++){
                    act.getPagina()[0].getNum()[i] = valor[i];
                }
                for(int i = orden/2 + 1; i < orden; i++){
                    act.getPagina()[1].getNum()[i - 1 - orden/2] = valor[i];
                }
                num = valor[orden/2];
                valor = new Integer[orden - 1];
                valor[0] = num;
                act.setNum(valor);
                romper = true;
            }
            else{
                Integer[] valor = getNum(act, num, orden - 1);
                act.setNum(valor);
            }
        }
        return act;
    }
    private Nodo[] ordenarPagina(Nodo[] pagina){
        int i = 0;
        Nodo aux;
        while(pagina[i + 1] != null){
            if(pagina[i].getNum()[0] > pagina[i + 1].getNum()[0]){
                aux = pagina[i];
                pagina[i] = pagina[i + 1];
                pagina[i + 1] = aux;
                if(i > 0) i--;
            }
            else i++;
            if(i >= pagina.length - 1) break;
        }
        return pagina;
    }
    private Integer[] ordenarNum(Integer[] valor){
        int i = 0, aux;
        while(valor[i + 1] != null){
            if(valor[i] > valor[i + 1]){
                aux = valor[i];
                valor[i] = valor[i + 1];
                valor[i + 1] = aux;
                if(i > 0) i--;
            }
            else i++;
            if(i >= valor.length - 1) break;
        }
        return valor;
    }
    private boolean estaLleno(Nodo act){
        for(int i = 0; i < act.getNum().length; i++){
            if(act.getNum()[i] == null) return false;
        }
        return true;
    }
    private boolean tieneHijo(Nodo act){
        for(int i = 0; i < act.getPagina().length; i++){
            if(act.getPagina()[i] != null) return true;
        }
        return false;
    }
    private Nodo[] getPagina(Nodo act, Nodo nuevo, int t){
        Nodo pagina[] = new Nodo[t];
        int i;
        for(i = 0; i < act.getPagina().length; i++){
            if(act.getPagina()[i] == null) break;
            else if(act.getPagina()[i] == nuevo) pagina[i] = nuevo.getPagina()[0];
            else pagina[i] = act.getPagina()[i];
        }
        pagina[i] = nuevo.getPagina()[1];
        pagina = ordenarPagina(pagina);
        return pagina;
    }
    private Integer[] getNum(Nodo act, int num, int t){
        Integer valor[] = new Integer[t];
        int i;
        for(i = 0; i < act.getNum().length; i++){
            if(act.getNum()[i] == null) break;
            else valor[i] = act.getNum()[i];
        }
        valor[i] = num;
        valor = ordenarNum(valor);
        return valor;
    }
    private Nodo crearPagina(){
        Nodo nuevo = new Nodo(orden);
        return nuevo;
    }
    
}
