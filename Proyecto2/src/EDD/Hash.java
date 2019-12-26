package EDD;

public class Hash {
    
    public class Usuario{
        private String nombre;
        private String apellido;
        private String contraseña;
        private int carnet;

        //**************************************************************************
        //**************************************************************************
        //SET DEL USUARIO
        public void setUsuario(String nombre, String apellido, String contraseña, int carnet){
            this.nombre = nombre;
            this.apellido = apellido;
            this.contraseña = contraseña;
            this.carnet = carnet;
        }

        //**************************************************************************
        //**************************************************************************
        //GETS DEL USUARIO
        public String getNombre(){ return nombre;}
        public String getApellido() { return apellido;}
        public String getContraseña() { return contraseña;}
        public int getCarnet() { return carnet;}
    }
    
    Usuario tablaHash[];
    Usuario tablaAux[];
    private int cantidad;
    private int size;
    String log;
    
    public Hash(){
        size = 37;
        tablaHash = new Usuario[size];
        log = "";
    }
    
    
    public int getSize() { return size;}
    //**************************************************************************
    //**************************************************************************
    //SETEO DE LA FUNCION HASH Y LA MODIFICACION DEL SIZE A MAYOR PRIMO
    public int getDispercion(int carnet){
        if(getFactorCarga() > 55){
            setNewSize();
            re_Ingreso();
        }
        return carnet % size;
    }
    private int getFactorCarga(){
        return 100*cantidad/size;
    }
    private void setNewSize(){
        while(true){
            if(esPrimo(++size)) break;
        }
    }
    private boolean esPrimo(int numero){
        int contador = 2;
        while(contador < numero){
            if(numero % contador == 0) return false;
            contador++;
        }
        return true;
    }
    
    
    //**************************************************************************
    //**************************************************************************
    //REINGRESO DE LA TABLA HASH POR EL CAMBIO DEL SIZE
    private void re_Ingreso(){
        tablaAux = tablaHash;
        tablaHash = null;
        int dispercion;
        tablaHash = new Usuario[size];
        for(int i = 0; i < tablaAux.length; i++){
            if(tablaAux[i] != null){
                dispercion = getDispercion(tablaAux[i].getCarnet());
                ingresarUsuario(tablaAux[i].getNombre(), tablaAux[i].getApellido(),
                            tablaAux[i].getContraseña(), tablaAux[i].getCarnet(),
                            dispercion, 0);
            }
        }
        tablaAux = null;
    }
    
    
    //**************************************************************************
    //**************************************************************************
    //INGRESO DE LA TABLA HASH
    public void ingresarUsuario(String nombre, String apellido, String contraseña, int carnet, int dispercion, int i){
        if(tablaHash[dispercion] == null){
            tablaHash[dispercion] = new Usuario();
            tablaHash[dispercion].setUsuario(nombre, apellido, contraseña, carnet);
            cantidad++;
        }
        else if(tablaHash[dispercion].getCarnet() == carnet)
            log += "-->Usuario no ingresado:\n"
                    + "\t-->" + carnet + " -- " + nombre + " " + apellido + "\n"
                    + "\t-->Contraseña: " + contraseña + "\n"
                    + "\t\t-->Razon: Carnet repetido...";
        else if(!ochoCaracteres(contraseña))
            log += "-->Usuario no ingresado:\n"
                    + "\t-->" + carnet + " -- " + nombre + " " + apellido + "\n"
                    + "\t-->Contraseña: " + contraseña + "\n"
                    + "\t\t-->Razon: Contraseña contiene menos de 8 caracteres...";
        else{
            dispercion = (carnet % 7 + 1) * i;
            while(dispercion >= tablaHash.length){
                dispercion -= tablaHash.length;
            }
            ingresarUsuario(nombre, apellido, contraseña, carnet, dispercion, ++i);
        }
            
    }
    private boolean ochoCaracteres(String contraseña){
        char cadena[] = contraseña.toCharArray();
        if(cadena.length >= 8) return true;
        return false;
    }
    
    
    //**************************************************************************
    //**************************************************************************
    //BUSQUEDA DE LA TABLA HASH
    public Usuario getUsuario(int carnet, int dispercion, int i){
        if(tablaHash[dispercion] == null) return null;
        else if(tablaHash[dispercion].getCarnet() == carnet) return tablaHash[dispercion];
        else{
            dispercion = (carnet % 7 + 1) * i;    
            while(dispercion >= tablaHash.length){
                dispercion -= tablaHash.length;
            }
            return getUsuario(carnet, dispercion, ++i);
        }
    }
    public Usuario[] getTabla() { return tablaHash; }
    
    
    //**************************************************************************
    //**************************************************************************
    //ELIMINAR DE LA TABLA HASH
    public boolean eliminarUsuario(int carnet, int dispercion, int i){
        if(tablaHash[dispercion] == null) return false;
        else if(tablaHash[dispercion].getCarnet() == carnet){
            tablaHash[dispercion] = null;
            cantidad--;
            re_Ingreso();
            return true;
        }
        else{
            dispercion = (carnet % 7 + 1) * i;    
            while(dispercion >= tablaHash.length){
                dispercion -= tablaHash.length;
            }
            return eliminarUsuario(carnet, dispercion, ++i);
        }
    }
}
