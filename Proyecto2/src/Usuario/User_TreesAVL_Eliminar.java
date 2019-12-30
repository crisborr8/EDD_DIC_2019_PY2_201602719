package Usuario;

import EDD.ArbolAVL;

public class User_TreesAVL_Eliminar extends Frame.Frame{
    
    User_TreesAVL uTA;
    EDD.Hash hash;
    ArbolAVL avl;
    ArbolAVL.Nodo raiz;
    Grafica.Graficar graficar;
    Json.Abrir aB;
    int carnet;
    int[] valores;
    
    public User_TreesAVL_Eliminar(EDD.Hash hash, int carnet){
        this.hash = hash;
        this.carnet = carnet;
        setUserTreesAVL_Eliminar();
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
        for(int i = 0; i < valores.length; i++){
            raiz = avl.Insertar(valores[i]);
        }
        avl.setTipo(1);
        if(raiz != null){
            graficar = new Grafica.Graficar();
            graficar.Mostrar(graficar.getCodigo_AVL(raiz));
        }
    }
    protected void setBtn1(){
        if(raiz != null){
            avl.setAutomatico(chb0.isSelected());
            if(!chb0.isSelected() && avl.isAlive() && !txt0.getText().trim().equals("")){
                avl.setNum(Integer.parseInt(txt0.getText().trim()));
                avl.setContinuar(true);
                raiz = avl.getRaiz();
            }
        }
    }
    protected void setBtn2(){
        if(raiz != null){
            avl.setAutomatico(chb0.isSelected());
            if(!txt0.getText().trim().equals("")){
                avl.setNum(Integer.parseInt(txt0.getText().trim()));
                if(!avl.isAlive()) avl.start();
                avl.setContinuar(true);
                raiz = avl.getRaiz();
            }
        }
    }
    protected void setBtn3(){
        clear();
        uTA = new User_TreesAVL(hash, carnet);
    }
    
}
