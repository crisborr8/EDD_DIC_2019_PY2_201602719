package Admin;

public class Admin_Ver extends Frame.Frame{
    
    Admin_Menu aM;
    EDD.Hash hash;
    Grafica.Graficar graficar;
    
    public Admin_Ver(EDD.Hash hash){
        this.hash = hash;
        setAdminVer();
    }
    
    @Override
    protected void setBtn0(){
        EDD.Hash.Usuario[] tablaHash = hash.getTabla();
        String codigo = "rankdir = LR;\n";
        codigo += "node [shape=box];\n";
        String label = "";
        int disp;
        for(int i = tablaHash.length - 1; i >= 0; i--){
            if(tablaHash[i] != null){
                label = "Nombre: " + tablaHash[i].getNombre() + "\\n";
                label += "Apellido: " + tablaHash[i].getApellido()+ "\\n";
                label += "Carnet: " + tablaHash[i].getCarnet()+ "\\n";
                label += "Contraseña: " + tablaHash[i].getContraseña()+ "\\n";
                codigo += "_" + tablaHash[i].getCarnet() + " [label=\"" + label + "\"];\n";
                disp = hash.getDispercion(tablaHash[i].getCarnet());
                disp = hash.getDispExacta(tablaHash[i].getCarnet(), disp, 0);
                label = "Clave: " + disp;
                codigo += disp + " [label=\"" + label + "\"];\n";
                codigo += disp + "->_" + tablaHash[i].getCarnet() + ";\n";
            }
        }
        graficar = new Grafica.Graficar();
        graficar.Mostrar(codigo);
    }
    protected void setBtn1(){
        clear();
        aM = new Admin_Menu(hash);
    }
    
}
