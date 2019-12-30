package Usuario;

import EDD.ArbolAVL;

public class User_TreesAVL_Insertar extends Frame.Frame{
    
    User_TreesAVL uTA;
    EDD.Hash hash;
    ArbolAVL avl;
    ArbolAVL.Nodo raiz;
    Json.Abrir aB;
    int carnet;
    int[] valores;
    
    public User_TreesAVL_Insertar(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL_Insertar();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
    }
    
    @Override
    protected void setBtn0(){
        aB = new Json.Abrir();
        avl = new ArbolAVL();
        valores = aB.abrirTreeAVL();
        raiz = null;
        avl.setRaiz(raiz);
        avl.setValores(valores);
        avl.setAutomatico(chb0.isSelected());
        avl.setTipo(0);
    }
    protected void setBtn1(){
        avl.setAutomatico(chb0.isSelected());
        if(!chb0.isSelected() && valores != null && avl.isAlive()){
            avl.setContinuar(true);
            raiz = avl.getRaiz();
        }
    }
    protected void setBtn2(){
        avl.setAutomatico(chb0.isSelected());
        if(valores != null){
            if(!avl.isAlive()) avl.start();
            else avl.setContinuar(true);
            raiz = avl.getRaiz();
        }
    }
    protected void setBtn3(){
        clear();
        uTA = new User_TreesAVL(hash, carnet);
    }
    
}
