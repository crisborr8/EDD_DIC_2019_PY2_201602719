package EDD;

public class Hash {
    
    //**************************************************************************
    //**************************************************************************
    //NODO DE LA TABLA HASH
    public class Nodo{
        private String [] datos; 
        //  0.- Carnet
        //  1.- Nombre
        //  2.- Apellido
        //  3.- Contraseña
        
        //**********************************************************************
        //**********************************************************************
        //SETS DEL NODO
        public void setDatos(String[] datos) { this.datos = datos; }
        
        //**********************************************************************
        //**********************************************************************
        //GETS DEL NODO
        public String[] getDatos() { return datos; }
    }
    
    //**************************************************************************
    //**************************************************************************
    //ATRIBUTOS DE LA TABLA HASH
    Nodo tabla[];
    Nodo tablaAux[];
    private int cant;
    private int size;
    String log;
    
    //**************************************************************************
    //**************************************************************************
    //CONSTRUCTOR DE LA TABLA HASH
    public Hash(){
        tabla = new Nodo[37];
        log = "Errores al ingresar: ";
        log += "**************************************************\n";
        cant = 0;
        size = 37;
    }
    
    //**************************************************************************
    //**************************************************************************
    //GETS DE LA TABLA HASH
    public int getCant() { return cant; }
    public Nodo[] getTabla() { return tabla; }
    public int getDisp(int carnet) { return carnet % size; }
    public int getDisp(int carnet, int disp, int i){
        if(tabla[disp] == null){
            disp = getDispCol(carnet, disp, i);
            return getDisp(carnet, disp, ++i);
        }
        if(carnet == Integer.parseInt(tabla[disp].getDatos()[0])) return disp;
        else{
            disp = getDispCol(carnet, disp, i);
            return getDisp(carnet, disp, ++i);
        }
    }
    private int getDispCol(int carnet, int disp, int i){
        disp = (carnet % size + 1) * i;
        while(disp >= size) { disp -= size; }
        return disp;
    }
    private int getFactCarg() { return (100 * cant) / size; }
    
    //**************************************************************************
    //**************************************************************************
    //INSERTAR NUEVO USUARIO
    public void insertarUsuario(String[] datos, int disp, int i){
        if(tabla[disp] == null){
            if(caracteres8(datos[3])){
                cant++;
                tabla[disp] = new Nodo();
                tabla[disp].setDatos(datos);
                if(getFactCarg() >= 55) ordenarNuevaTabla();
            }
            else{
                log += "->Usuario: " + datos[1] + "\n";
                log += "  Carnet:  " + datos[0] + "\n";
                log += "  Problema: Contraseña posee menos de 8 caracteres\n";
                log += "            " + datos[3] + "\n";
                log += "**************************************************\n";
            }
        }
        else if(tabla[disp].getDatos()[0] == datos[0]){
            log += "->Usuario: " + datos[1] + "\n";
            log += "  Carnet:  " + datos[0] + "\n";
            log += "  Problema: Carnet repetido\n";
            log += "            " + datos[0] + " = " + datos[0] + "\n";
            log += "**************************************************\n";
        }
        else{
            disp = getDispCol(Integer.parseInt(datos[0]), disp, i);
            insertarUsuario(datos, disp, ++i);
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //BUSQUEDA DE USUARIO
    public Nodo buscarUsuario(int carnet, int disp, int i){
        if(tabla[disp] == null){
            if(i >= size - 1) return null;
            disp = getDispCol(carnet, disp, i);
            return buscarUsuario(carnet, disp, ++i);
        }
        else if(Integer.parseInt(tabla[disp].getDatos()[0]) == carnet) return tabla[disp];        
        else{
            disp = getDispCol(carnet, disp, i);
            return buscarUsuario(carnet, disp, ++i);
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //ELIMINACION DE USUARIO
    public boolean eliminarUsuario(int carnet, int disp, int i){
        if(tabla[disp] == null){
            if(i >= size - 1) return false;
            disp = getDispCol(carnet, disp, i);
            return eliminarUsuario(carnet, disp, ++i);
        }
        else if(Integer.parseInt(tabla[disp].getDatos()[0]) == carnet){
            tabla[disp] = null;
            cant--;
            return true;
        }
        else{
            disp = getDispCol(carnet, disp, i);
            return eliminarUsuario(carnet, disp, ++i);
        }
    }
    
    //**************************************************************************
    //**************************************************************************
    //EXTRAS
    private void ordenarNuevaTabla(){
        tablaAux = tabla;
        setNuevoPrimo();
        tabla = new Nodo[size];
        for(int i = 0; i < tablaAux.length; i++){
            if(tablaAux[i] != null){
                int disp = Integer.parseInt(tablaAux[i].getDatos()[0]);
                insertarUsuario(tablaAux[i].getDatos(), disp, 0);
            }
        }
    }
    private boolean caracteres8(String contraseña){
        char cadena[] = contraseña.toCharArray();
        if(cadena.length >= 8) return true;
        return false;
    }
    private void setNuevoPrimo(){
        int c;
        boolean primo = false;
        while(!primo){
            c = 2;
            ++size;
            while(c < size){
                primo = true;
                if(c % size == 0){
                    primo = false;
                    break;
                }
                else c++;
            }
        }
    }
}
