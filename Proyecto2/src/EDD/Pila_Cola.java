package EDD;

public class Pila_Cola {
    
    public class Nodo{
        private int num;
        private Nodo sig;
        public Nodo(int num) { this.num = num; }
        public void setSig(Nodo sig) { this.sig = sig; }
        public int getNum() { return num; }
        public Nodo getSig() { return sig; }
    }
    
    public class Pila{
        public Nodo top;
        public Pila(){
            top = null;
        }
        public Nodo Push(int num){
            Nodo nuevo = new Nodo(num);
            nuevo.setSig(top);
            top = nuevo;
            return top;
        }
        public Nodo Pop(){
            Nodo aux = top;
            if(top != null) top = top.getSig();
            return aux;
        }
    }
    public class Cola{
        public Nodo cabeza;
        public Nodo cola;
        public Cola(){
            cabeza = null;
        }
        public Nodo Enqueue(int num){
            Nodo nuevo = new Nodo(num);
            nuevo.setSig(cola);
            cola = nuevo;
            return cola;
        }
        public Nodo Dequeue(){
            Nodo auxNum = null;
            if(cola != cabeza){
                Nodo aux = cola;
                while(aux.getSig() != null)
                    aux = aux.getSig();
                auxNum = aux.getSig();
                aux.setSig(null);
                cabeza = aux;
            }
            else{
                auxNum = cola;
                cola = cabeza = null;
            }
            return auxNum;
        }
    }
    
}
