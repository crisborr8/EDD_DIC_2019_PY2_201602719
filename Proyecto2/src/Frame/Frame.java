package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame {
    
    //**************************************************************************
    //**************************************************************************
    //COMPONENTES A UTILIZAR
    protected JFrame frame = new JFrame();
    protected JComboBox cb0 = new JComboBox();
    protected JCheckBox chb0 = new JCheckBox();
    protected JPasswordField psw = new JPasswordField();
    
    protected JLabel lbl0 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl1 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl2 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl3 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl4 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl5 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl6 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl7 = new JLabel("", SwingConstants.CENTER);
    
    protected JTextField txt0 = new JTextField();
    protected JTextField txt1 = new JTextField();
    protected JTextField txt2 = new JTextField();
    protected JTextField txt3 = new JTextField();
    
    protected JButton btn0 = new JButton();
    protected JButton btn1 = new JButton();
    protected JButton btn2 = new JButton();
    protected JButton btn3 = new JButton();
    protected JButton btn4 = new JButton();
    
    protected JRadioButton rb0 = new JRadioButton();
    protected JRadioButton rb1 = new JRadioButton();
    protected JRadioButton rb2 = new JRadioButton();
    
    protected String[] datos;
    //**************************************************************************
    //**************************************************************************
    //FRAME-----
    public Frame(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Comportamiento();
    }
    public void setVisible() { frame.setVisible(true); }
    public void setDatos(String[] datos){ 
        this.datos = datos;
        lbl0.setText("Nombre:    " + datos[1]);
        lbl1.setText("Apellidos: " + datos[2]);
    }
    private void setPosicion(int x, int y){
        frame.pack();
        frame.setSize(x + 16, y + 60);
        frame.setLocationRelativeTo(null);
    }
    
    //**************************************************************************
    //**************************************************************************
    //LOGIN
    protected void setLogin(){
        lbl0.setText("Bienvenido");
        lbl1.setText("Usuario");
        txt0.setText("");
        lbl2.setText("Contraseña");
        psw.setText("");
        lbl3.setText("");
        btn0.setText("Ingresar");
        
        lbl3.setForeground(Color.red);
        
        lbl0.setBounds(75,  20, 150, 20);
        lbl1.setBounds(75,  70, 150, 20);
        txt0.setBounds(75, 100, 150, 20);
        lbl2.setBounds(75, 170, 150, 20);
        psw.setBounds (75, 200, 150, 20);
        lbl3.setBounds( 0, 230, 300, 20);
        btn0.setBounds(75, 275, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(txt0);
        frame.add(lbl2);
        frame.add(psw);
        frame.add(lbl3);
        frame.add(btn0);
        
        setPosicion(300,300);
    }
       
    //**************************************************************************
    //**************************************************************************
    //ADMIN
    protected void setAdmin(){
        lbl0.setText("Administrador");
        lbl1.setText("Menu principal");
        lbl2.setText("");
        btn0.setText("Cargar usuarios");
        btn1.setText("Editar usuarios");
        btn2.setText("Eliminar usuarios");
        btn3.setText("Ver usuarios");
        btn4.setText("Salir");
        
        lbl2.setForeground(Color.red);
        
        lbl0.setBounds(200, 20, 100, 20);
        lbl1.setBounds(200, 50, 100, 20);
        lbl2.setBounds(200, 80, 100, 20);
        btn0.setBounds(75, 105, 150, 20);
        btn1.setBounds(275, 105, 150, 20);
        btn2.setBounds(75, 150, 150, 20);
        btn3.setBounds(275, 150, 150, 20);
        btn4.setBounds(200, 205, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        
        setPosicion(500,225);
    }
    protected void setAdminEditar(){
        lbl0.setText("Administrador");
        lbl1.setText("Editar usuarios");
        btn0.setText("Editar");
        lbl2.setText("Nombre");
        txt0.setText("");
        lbl3.setText("Apellido");
        txt1.setText("");
        lbl4.setText("Carnet");
        txt2.setText("");
        lbl5.setText("Contraseña");
        txt3.setText("");
        lbl6.setText("");
        btn1.setText("Aceptar");
        btn2.setText("Regresar");
        
        lbl6.setForeground(Color.red);
        
        lbl0.setBounds(200, 20, 100, 20);
        lbl1.setBounds(200, 50, 100, 20);
        cb0.setBounds(50, 80, 200, 20);
        btn0.setBounds(300, 80, 100, 20);
        lbl2.setBounds(50, 110, 100, 20);
        lbl3.setBounds(350,110,100,20);
        txt0.setBounds(50, 140, 150, 20);
        txt1.setBounds(300, 140, 150, 20);
        lbl4.setBounds(50, 180, 100, 20);
        lbl5.setBounds(350,180,100,20);
        txt2.setBounds(50, 210, 150, 20);
        txt3.setBounds(300, 210, 150, 20);
        lbl6.setBounds(150, 240, 200, 20);
        btn1.setBounds(100, 270, 100, 20);
        btn2.setBounds(300, 270, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(cb0);
        frame.add(btn0);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(txt0);
        frame.add(txt1);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(txt2);
        frame.add(txt3);
        frame.add(lbl6);
        frame.add(btn1);
        frame.add(btn2);
        
        setPosicion(500,310);
    }
    protected void setAdminEliminar(){
        lbl0.setText("Administrador");
        lbl1.setText("Eliminar usuarios");
        lbl2.setText("");
        btn0.setText("Eliminar");
        btn1.setText("Regresar");
        
        lbl2.setForeground(Color.red);
        
        lbl0.setBounds(200, 20, 100, 20);
        lbl1.setBounds(200, 50, 100, 20);
        cb0.setBounds(50, 80, 200, 20);
        btn0.setBounds(300, 80, 100, 20);
        lbl2.setBounds(150, 110, 200, 20);
        btn1.setBounds(200, 140, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(cb0);
        frame.add(btn0);
        frame.add(lbl2);
        frame.add(btn1);
        
        setPosicion(500,160);
    }
    
    //**************************************************************************
    //**************************************************************************
    //USUARIO
    protected void setUserInicio(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Menu principal");
        btn0.setText("Learning Trees");
        btn1.setText("Learning Graphs");
        btn2.setText("Learning Sorting Algorithms");
        btn3.setText("Salir");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        btn0.setBounds(50, 150, 175, 20);
        btn1.setBounds(275, 150, 175, 20);
        btn2.setBounds(150, 200, 200, 20);
        btn3.setBounds(200, 250, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500,300);
    }
    protected void setUserArbol(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees");
        btn0.setText("AVL");
        btn1.setText("B");
        btn2.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        btn0.setBounds(100, 130, 100, 20);
        btn1.setBounds(300, 130, 100, 20);
        btn2.setBounds(200, 160, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        
        setPosicion(500, 200);
    }
    protected void setUserOrdenamiento(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Ordenamiento");
        btn0.setText("Burbuja");
        btn1.setText("Inserción");
        btn2.setText("Quicksort");
        btn3.setText("Salir");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        btn0.setBounds(50, 150, 175, 20);
        btn1.setBounds(275, 150, 175, 20);
        btn2.setBounds(150, 200, 200, 20);
        btn3.setBounds(200, 250, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500,300);
    }
    protected void setUserMatriz(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Matriz");
        btn0.setText("Adyacencia");
        btn1.setText("Rec. por Anchura");
        btn2.setText("Rec. por Profundidad");
        btn3.setText("Salir");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        btn0.setBounds(50, 150, 175, 20);
        btn1.setBounds(275, 150, 175, 20);
        btn2.setBounds(150, 200, 200, 20);
        btn3.setBounds(200, 250, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500,300);
    }
    
    //**************************************************************************
    //**************************************************************************
    //ARBOL AVL
    protected void setAVL(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - AVL");
        btn0.setText("Insertar");
        btn1.setText("Eliminar");
        btn2.setText("Recorrer");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(150, 100, 200, 20);
        btn0.setBounds(100, 130, 100, 20);
        btn1.setBounds(300, 130, 100, 20);
        btn2.setBounds(200, 160, 100, 20);
        btn3.setBounds(200, 190, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 220);
    }
    protected void setAVL_Insertar(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - AVL");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arbol");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar arbol");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setAVL_Eliminar(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - AVL");
        lbl4.setText("Eliminar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arbol");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        txt0.setText("");
        btn2.setText("Eliminar nodo");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        txt0.setBounds(225 ,220, 50, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(txt0);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setAVL_Recorrer(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - AVL");
        lbl4.setText("Recorrer");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arbol");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar arbol");
        btn3.setText("Regresar");
        rb0.setText("Preorden");
        rb1.setText("Inorden");
        rb2.setText("Postorden");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        rb0.setBounds(200, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        rb1.setBounds(200, 180, 100, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        rb2.setBounds(200, 200, 100, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(rb0);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(rb1);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(rb2);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    
    //**************************************************************************
    //**************************************************************************
    //ARBOL B
    protected void setB(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - B");
        btn0.setText("Insertar");
        btn1.setText("Eliminar");
        btn2.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(150, 100, 200, 20);
        btn0.setBounds(100, 130, 100, 20);
        btn1.setBounds(300, 130, 100, 20);
        btn2.setBounds(200, 160, 100, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        
        setPosicion(500, 190);
    }
    protected void setB_Insertar(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - B");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arbol");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar arbol");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setB_Eliminar(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Learning Trees - B");
        lbl4.setText("Eliminar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arbol");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        txt0.setText("");
        btn2.setText("Eliminar nodo");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        txt0.setBounds(225 ,220, 50, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(txt0);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    
    //**************************************************************************
    //**************************************************************************
    //ORDENAMIENTO
    protected void setOrd_Burbuja(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Ordenamiento - Burbuja");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arreglo");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar arreglo");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setOrd_Insercion(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Ordenamiento - Insercion");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arreglo");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar arreglo");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setOrd_Quicksort(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Ordenamiento - Quicksort");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe arreglo");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar arreglo");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    
    //**************************************************************************
    //**************************************************************************
    //MATRIZ
    protected void setMat_Adyacencia(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Matriz - Adyacencia");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe matriz");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar matriz");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setMat_Profundidad(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Matriz - Profundidad");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe matriz");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar recorrido");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    protected void setMat_Anchura(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Matriz - Anchura");
        lbl4.setText("Insertar");
        lbl5.setText("Automatico");
        lbl6.setText("No existe matriz");
        btn0.setText("Abrir .json");
        btn1.setText("Siguiente paso");
        btn2.setText("Iniciar recorrido");
        btn3.setText("Regresar");
        
        lbl0.setBounds(0, 10, 200, 20);
        lbl1.setBounds(0, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        lbl4.setBounds(175, 130, 150, 20);
        lbl5.setBounds(50, 160, 100, 20);
        lbl6.setBounds(350, 160, 100, 20);
        chb0.setBounds(90, 180, 20, 20);
        btn0.setBounds(325, 190, 150, 20);
        btn1.setBounds(25, 220, 150, 20);
        btn2.setBounds(325, 220, 150, 20);
        btn3.setBounds(175, 250, 150, 20);
        
        frame.add(lbl0);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);
        frame.add(lbl5);
        frame.add(lbl6);
        frame.add(chb0);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        
        setPosicion(500, 280);
    }
    
    //**************************************************************************
    //**************************************************************************
    //SETEO DEL COMPORTAMIENTO DE LOS BOTONES
    private void Comportamiento(){
        rb0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setRb0();
            }
        });
        rb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setRb1();
            }
        });
        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setRb2();
            }
        });
        btn0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setBtn0();
            }
        });
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setBtn1();
            }
        });
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setBtn2();
            }
        });
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setBtn3();
            }
        });
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setBtn4();
            }
        });
    }
    protected void setRb0() {}
    protected void setRb1() {}
    protected void setRb2() {}
    protected void setBtn0(){}
    protected void setBtn1(){}
    protected void setBtn2(){}
    protected void setBtn3(){}
    protected void setBtn4(){}
}
