package Admin;

import Frame.Frame;
import java.awt.Color;

public class Admin_Inicio extends Frame{
    
    Admin_Eliminar adEl;
    Admin_Editar adEd;
    Login.Login lg;
    EDD.Hash hash;
    
    public Admin_Inicio(Login.Login lg){
        this.lg = lg;
        hash = lg.getHash();
        frame.setVisible(false);
        setAdmin();
    }
    public void setHash(EDD.Hash hash) { this.hash = hash; }
    public EDD.Hash getHash() { return hash; }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //ABRIR
    @Override
    protected void setBtn0(){
        Json.Abrir abrir = new Json.Abrir();
        hash = abrir.abrirUsuario(hash);
        lbl2.setText("");
        lbl2.setForeground(Color.red);
        if(hash.getCant() <= 0) lbl2.setText("Error al abrir");
        else{
            lbl2.setForeground(Color.blue);
            lbl2.setText("Abierto con exito");
        }
    }
    //EDITAR
    @Override
    protected void setBtn1(){
        lbl2.setText("");
        adEd = new Admin_Editar(this);
        adEd.setVisible();
        frame.setVisible(false);
    }
    //ELIMINAR
    @Override
    protected void setBtn2(){
        lbl2.setText("");
        adEl = new Admin_Eliminar(this);
        adEl.setVisible();
        frame.setVisible(false);
    }
    //VER
    @Override
    protected void setBtn3(){
        lbl2.setText("");
        Graficar.Graficar graficar = new Graficar.Graficar();
        graficar.graficar_Hash(hash);
    }
    //SALIR
    @Override
    protected void setBtn4(){
        lg.setHash(hash);
        lg.setVisible();
        frame.setVisible(false);
    }
}
