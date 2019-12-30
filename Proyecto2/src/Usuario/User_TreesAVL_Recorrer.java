package Usuario;

import EDD.ArbolAVL;

public class User_TreesAVL_Recorrer extends Frame.Frame{

    User_TreesAVL uTA;
    EDD.Hash hash;
    ArbolAVL avl;
    ArbolAVL.Nodo raiz;
    Grafica.Graficar graficar;
    Json.Abrir aB;
    int carnet;
    int[] valores;
    
    public User_TreesAVL_Recorrer(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL_Recorrer();
        int disp = hash.getDispercion(carnet);
        EDD.Hash.Usuario usuario = hash.getUsuario(carnet, disp, 0);
        lbl0.setText("Nombre:   " + usuario.getNombre());
        lbl1.setText("Apellido: " + usuario.getApellido());  
        rb0.setSelected(true);
    }
    
    @Override
    protected void setRb0(){
        if(rb0.isSelected()){
            rb1.setSelected(false);
            rb2.setSelected(false);
        }else{
            rb1.setSelected(true);
        }
    }
    protected void setRb1(){
        if(rb1.isSelected()){
            rb0.setSelected(false);
            rb2.setSelected(false);
        }else{
            rb2.setSelected(true);
        }
    }
    protected void setRb2(){
        if(rb2.isSelected()){
            rb0.setSelected(false);
            rb1.setSelected(false);
        }else{
            rb0.setSelected(true);
        }
    }
    protected void setBtn0(){
        aB = new Json.Abrir();
        avl = new ArbolAVL();
        valores = aB.abrirTreeAVL();
        raiz = null;
        avl.setRaiz(raiz);
        avl.setValores(valores);
        avl.setAutomatico(chb0.isSelected());
        for(int i = 0; i < valores.length; i++){
            raiz = avl.Insertar(valores[i]);
        }
        avl.setTipo(2);
        if(raiz != null){
            graficar = new Grafica.Graficar();
            graficar.Mostrar(graficar.getCodigo_AVL(raiz));
        }
    }
    protected void setBtn1(){
        if(raiz != null){
            avl.setAutomatico(chb0.isSelected());
            if(rb0.isSelected()) avl.setTipoRec(0);
            else if(rb1.isSelected()) avl.setTipoRec(1);
            else avl.setTipoRec(2);
            if(!chb0.isSelected() && avl.isAlive()){
                avl.setContinuar(true);
                raiz = avl.getRaiz();
            }
        }
    }
    protected void setBtn2(){
        if(raiz != null){
            avl.setAutomatico(chb0.isSelected());
            if(rb0.isSelected()) avl.setTipoRec(0);
            else if(rb1.isSelected()) avl.setTipoRec(1);
            else avl.setTipoRec(2);
            if(!avl.isAlive()) avl.start();
            avl.setContinuar(true);
            raiz = avl.getRaiz();
        }
    }
    protected void setBtn3(){
        clear();
        uTA = new User_TreesAVL(hash, carnet);
    }
    
}
