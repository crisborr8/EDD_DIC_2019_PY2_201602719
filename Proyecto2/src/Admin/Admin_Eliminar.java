package Admin;

import Frame.Frame;
import java.awt.Color;

public class Admin_Eliminar extends Frame{
    
    Admin_Inicio adIn;
    EDD.Hash hash;
    
    public Admin_Eliminar(Admin_Inicio adIn){
        this.adIn = adIn;
        hash = adIn.getHash();
        setAdminEliminar();
        cargarUsuarios();
    }
    private void cargarUsuarios(){
        EDD.Hash.Nodo tabla[] = hash.getTabla();
        for(int i = 0; i < tabla.length; i++){
            if(tabla[i] != null) cb0.addItem(tabla[i].getDatos()[0]);
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //COMPONENTES
    //ELIMINAR
    @Override
    protected void setBtn0(){
        lbl2.setForeground(Color.red);
        if(cb0.getSelectedItem() != null){
            try{
                int carnet = Integer.parseInt(cb0.getSelectedItem().toString());
                int disp = hash.getDisp(carnet);
                if(hash.eliminarUsuario(carnet, disp, 0)){
                    cb0.removeAllItems();
                    cargarUsuarios();
                    lbl2.setText("Eliminado con exito");
                    lbl2.setForeground(Color.blue);
                }else
                    lbl2.setText("Error al eliminar");
            }catch(Exception ex){
                lbl2.setText("Error al eliminar");
            }
        }else
            lbl2.setText("No existen usuarios a eliminar");
    }
    //REGRESAR
    @Override
    protected void setBtn1(){
       adIn.setHash(hash);
       adIn.setVisible();
       frame.setVisible(false);
    }
}
