package Login;

import Frame.Frame;

public class Login extends Frame{
    
    Usuario.Usuario_Inicio usIn;
    Admin.Admin_Inicio admin;
    EDD.Hash hash;
    
    public Login(){
        hash = new EDD.Hash();
        admin = new Admin.Admin_Inicio(this);
        usIn = new Usuario.Usuario_Inicio(this);
        setLogin();
    }
    public EDD.Hash getHash() { return hash; }
    public void setHash(EDD.Hash hash) { this.hash = hash; }
    public void setVisible() { frame.setVisible(true); }
    
    //**************************************************************************
    //**************************************************************************
    //BOTONES
    //INGRESAR
    @Override
    protected void setBtn0(){
        lbl3.setText("");
        String usuario = txt0.getText();
        String contra = psw.getText();
        if(usuario.trim().equals("") || contra.trim().equals(""))
            lbl3.setText("Faltan campos por llenar");
        else if(usuario.equals("Admin")){
            if(contra.equals("123")){
                frame.setVisible(false);
                admin.setVisible();
                txt0.setText("");
                psw.setText("");
            }
            else lbl3.setText("Contraseña incorrecta");
        }
        else{
            try{
                int disp = hash.getDisp(Integer.parseInt(usuario.trim()));
                EDD.Hash.Nodo nodo = hash.buscarUsuario(Integer.parseInt(usuario.trim()), disp, 0);
                if(nodo != null){
                    if(nodo.getDatos()[3].equals(hash.getSha256(contra))){
                        usIn.setDatos(nodo.getDatos());
                        frame.setVisible(false);
                        usIn.setVisible();
                        txt0.setText("");
                        psw.setText("");
                    }
                    else lbl3.setText("Contraseña incorrecta");
                }
                else lbl3.setText("Usuario no existe");
            }catch(Exception ex){
                lbl3.setText("Usuario incorrecto");
            }
        }
    }
}
