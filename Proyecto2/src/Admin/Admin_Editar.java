package Admin;

import Frame.Frame;
import java.awt.Color;

public class Admin_Editar extends Frame{
    
    Admin_Inicio adIn;
    EDD.Hash hash;
    
    public Admin_Editar(Admin_Inicio adIn){
        this.adIn = adIn;
        hash = adIn.getHash();
        setAdminEditar();
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
    //EDITAR
    @Override
    protected void setBtn0(){
        lbl6.setForeground(Color.red);
        lbl6.setText("");
        if(cb0.getSelectedItem() != null){
            int carnet = Integer.parseInt(cb0.getSelectedItem().toString());
            int disp = hash.getDisp(carnet);
            EDD.Hash.Nodo usuario = hash.buscarUsuario(carnet, disp, 0);
            txt0.setText(usuario.getDatos()[1]);
            txt1.setText(usuario.getDatos()[2]);
            txt2.setText(usuario.getDatos()[0]);
            txt3.setText(usuario.getDatos()[3]);
        }else
            lbl6.setText("No existen usuarios a editar");
    }
    //ACEPTAR
    @Override
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
                    int disp = hash.getDisp(carnet);
                    if(carnet != Integer.parseInt(txt2.getText().trim())){
                        if(hash.eliminarUsuario(carnet, disp, 0)){
                            carnet = Integer.parseInt(txt2.getText().trim());
                            disp = hash.getDisp(carnet);
                            hash.buscarUsuario(carnet, disp, 0).getDatos()[0] = txt2.getText();
                            hash.buscarUsuario(carnet, disp, 0).getDatos()[1] = txt0.getText();
                            hash.buscarUsuario(carnet, disp, 0).getDatos()[2] = txt1.getText();
                            hash.buscarUsuario(carnet, disp, 0).getDatos()[3] = hash.getSha256(txt3.getText());
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
                        hash.buscarUsuario(carnet, disp, 0).getDatos()[1] = txt0.getText();
                        hash.buscarUsuario(carnet, disp, 0).getDatos()[2] = txt1.getText();
                        hash.buscarUsuario(carnet, disp, 0).getDatos()[3] = hash.getSha256(txt3.getText());
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
    //REGRESAR
    @Override
    protected void setBtn2(){
       adIn.setHash(hash);
       adIn.setVisible();
       frame.setVisible(false);
    }
}
