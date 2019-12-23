package Frame;

public class Login extends Frame{

    Admin.Admin_Menu aM;
    Usuario.User_Menu uM;
    EDD.Hash hash;
    
    public Login(EDD.Hash hash){
        this.hash = hash;
        setLogin();
    }
    
    @Override
    protected void setBtn0(){
        lbl3.setText("");
        String usr = txt0.getText().trim();
        String cnt = psw.getText().trim();
        if(usr.equals("") || cnt.equals(""))
            lbl3.setText("Faltan campos por llenar");
        else if(usr.equals("Admin") && cnt.equals("1234")){
            clear();
            aM = new Admin.Admin_Menu(hash);
        }
        else{
            try{
                int carnet = Integer.parseInt(usr);
                int dispercion = hash.getDispercion(carnet);
                EDD.Usuario usuario = hash.getUsuario(carnet, dispercion);
                if(usuario == null)
                    lbl3.setText("Datos incorrectos");
                else
                    clear();
                    uM = new Usuario.User_Menu(hash, usr, cnt);
            }catch(Exception ex){
                lbl3.setText("El usuario debe ser un numero");
            }
        }
    }
    
}
