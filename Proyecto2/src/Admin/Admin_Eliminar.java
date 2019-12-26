package Admin;

import java.awt.Color;

public class Admin_Eliminar extends Frame.Frame{
    
    Admin_Menu aM;
    Admin_Eliminar aEl;
    EDD.Hash hash;
    
    public Admin_Eliminar(EDD.Hash hash){
        this.hash = hash;
        setAdminEliminar();
        cargarUsuarios();
    }
    
    private void cargarUsuarios(){
        EDD.Hash.Usuario usuarios[] = hash.getTabla();
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i] != null){
                cb0.addItem(usuarios[i].getCarnet());
            }
        }
    }
    
    @Override
    protected void setBtn0(){
        lbl6.setForeground(Color.red);
        if(cb0.getSelectedItem() != null){
            try{
                int carnet = Integer.parseInt(cb0.getSelectedItem().toString());
                int dispercion = hash.getDispercion(carnet);
                if(hash.eliminarUsuario(carnet, dispercion, 0)){
                    cb0.removeAllItems();
                    cargarUsuarios();
                    lbl6.setText("Editado con exito");
                    lbl6.setForeground(Color.blue);
                }else
                    lbl2.setText("Error al eliminar");
            }catch(Exception ex){
                lbl2.setText("Error al eliminar");
            }
        }else
            lbl2.setText("No existen usuarios a eliminar");
    }
    protected void setBtn1(){
        clear();
        aM = new Admin_Menu(hash);
    }
}
