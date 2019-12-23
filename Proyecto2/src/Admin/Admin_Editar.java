package Admin;

import java.awt.Color;

public class Admin_Editar extends Frame.Frame{
    
    Admin_Menu aM;
    Admin_Editar aE;
    EDD.Hash hash;
    
    public Admin_Editar(EDD.Hash hash){
        this.hash = hash;
        setAdminEditar();
        cargarUsuarios();
    }
    
    private void cargarUsuarios(){
        EDD.Usuario usuarios[] = hash.getTabla();
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
            int carnet = Integer.parseInt(cb0.getSelectedItem().toString());
            int dispercion = hash.getDispercion(carnet);
            EDD.Usuario usuario = hash.getUsuario(carnet, dispercion);
            txt0.setText(usuario.getNombre());
            txt1.setText(usuario.getApellido());
            txt2.setText(Integer.toString(carnet));
            txt3.setText(usuario.getContraseña());
        }else
            lbl6.setText("No existen usuarios a editar");
    }
    protected void setBtn1(){
        lbl6.setForeground(Color.red);
        if(cb0.getSelectedItem() != null){            
            if(txt0.getText().trim().equals(""))
                lbl6.setText("Falta llenar el campo nombre");
            else if(txt1.getText().trim().equals(""))
                lbl6.setText("Falta llenar el campo apellido");
            else if(txt2.getText().trim().equals(""))
                lbl6.setText("Falta llenar el campo carnet");
            else if(txt3.getText().trim().equals(""))
                lbl6.setText("Falta llenar el campo contraseña");
            else{
                try{
                    int carnet = Integer.parseInt(cb0.getSelectedItem().toString());
                    int dispercion = hash.getDispercion(carnet);
                    if(carnet != Integer.parseInt(txt2.getText().trim())){
                        if(hash.eliminarUsuario(carnet, dispercion)){
                            carnet = Integer.parseInt(txt2.getText().trim());
                            dispercion = hash.getDispercion(carnet);
                            hash.ingresarUsuario(txt0.getText(), txt1.getText(), txt3.getText(), carnet, dispercion);
                            cb0.removeAllItems();
                            cargarUsuarios();
                            txt0.setText("");
                            txt1.setText("");
                            txt2.setText("");
                            txt3.setText("");
                            lbl6.setText("Editado con exito");
                            lbl6.setForeground(Color.blue);
                        }else{
                            lbl6.setText("Error al editar de la tabla");
                        }
                    }else{
                        EDD.Usuario usuario = hash.getUsuario(carnet, dispercion);
                        usuario.setUsuario(txt0.getText(), txt1.getText(), txt3.getText(), carnet);
                        cb0.removeAllItems();
                        cargarUsuarios();
                        txt0.setText("");
                        txt1.setText("");
                        txt2.setText("");
                        txt3.setText("");
                        lbl6.setText("Editado con exito");
                        lbl6.setForeground(Color.blue);
                    }
                }catch(NumberFormatException ex){
                    lbl6.setText("El carnet debe ser un dato numérico");
                }
            }
        }else
            lbl6.setText("No existe usuario a modificar");
    }
    protected void setBtn2(){
        clear();
        aM = new Admin_Menu(hash);
    }
    
}
