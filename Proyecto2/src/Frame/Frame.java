package Frame;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    
    
    //****************************************************************************
    //****************************************************************************
    //SETEO DE COMPONENTES A UTILIZAR
    protected JFrame frm = new JFrame();
    protected JPasswordField psw = new JPasswordField();
    protected JComboBox cb0 = new JComboBox();
    
    protected JLabel lbl0 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl1 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl2 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl3 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl4 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl5 = new JLabel("", SwingConstants.CENTER);
    protected JLabel lbl6 = new JLabel("", SwingConstants.CENTER);
    
    protected JTextField txt0 = new JTextField();
    protected JTextField txt1 = new JTextField();
    protected JTextField txt2 = new JTextField();
    protected JTextField txt3 = new JTextField();
    
    protected JButton btn0 = new JButton();
    protected JButton btn1 = new JButton();
    protected JButton btn2 = new JButton();
    protected JButton btn3 = new JButton();
    protected JButton btn4 = new JButton();
    
    
    //****************************************************************************
    //****************************************************************************
    //SETEO DEL FRAME (TAMAÑO, POSICION, LIMPIAR, ETC...
    public Frame(){
        frm.setLayout(null);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Comportamiento();
    }    
    protected void setFrame(int x, int y){
        frm.pack();
        frm.setSize(x + 16, y);
        frm.setLocationRelativeTo(null);
    }
    protected void clear(){
        frm.setVisible(false);
        frm.dispose();
    }
    private void clean(){
        frm.getContentPane().removeAll();
        frm.repaint();
    }
    
    
    //****************************************************************************
    //****************************************************************************
    //SETEO DE COMPONENTES EN FRAMES PARA OTRAS PESTAÑAS
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
        lbl3.setBounds(75, 230, 150, 20);
        btn0.setBounds(75, 275, 150, 20);
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(txt0);
        frm.add(lbl2);
        frm.add(psw);
        frm.add(lbl3);
        frm.add(btn0);
        
        setFrame(300,400);
    }
    //SETEO DE COMPONENTES PARA ADMINISTRADOR
    protected void setAdminMenu(){
        lbl0.setText("Administrador");
        lbl1.setText("Menu principal");
        btn0.setText("Cargar usuarios");
        btn1.setText("Editar usuarios");
        btn2.setText("Eliminar usuarios");
        btn3.setText("Ver usuarios");
        btn4.setText("Salir");
        
        lbl0.setBounds(200, 20, 100, 20);
        lbl1.setBounds(200, 50, 100, 20);
        btn0.setBounds(75, 75, 150, 20);
        btn1.setBounds(275, 75, 150, 20);
        btn2.setBounds(75, 120, 150, 20);
        btn3.setBounds(275, 120, 150, 20);
        btn4.setBounds(200, 175, 100, 20);
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(btn0);
        frm.add(btn1);
        frm.add(btn2);
        frm.add(btn3);
        frm.add(btn4);
        
        setFrame(500,250);
    }
    protected void setAdminCargar(){
        lbl0.setText("Administrador");
        lbl1.setText("Carga de usuarios");
        lbl2.setText("");
        btn0.setText("Cargar usuarios");
        btn1.setText("Regresar");
        
        lbl2.setForeground(Color.red);
        
        lbl0.setBounds(200, 20, 100, 20);
        lbl1.setBounds(175, 50, 150, 20);
        lbl2.setBounds(200, 80, 100, 20);
        btn0.setBounds(75, 110, 150, 20);
        btn1.setBounds(275, 110, 150, 20);
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(lbl2);
        frm.add(btn0);
        frm.add(btn1);
        
        setFrame(500,200);
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
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(cb0);
        frm.add(btn0);
        frm.add(lbl2);
        frm.add(lbl3);
        frm.add(txt0);
        frm.add(txt1);
        frm.add(lbl4);
        frm.add(lbl5);
        frm.add(txt2);
        frm.add(txt3);
        frm.add(lbl6);
        frm.add(btn1);
        frm.add(btn2);
        
        setFrame(500,350);
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
        lbl2.setBounds(150, 100, 200, 20);
        btn1.setBounds(200, 140, 100, 20);
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(cb0);
        frm.add(btn0);
        frm.add(lbl2);
        frm.add(btn1);
        
        setFrame(500,220);
    }
    protected void setAdminVer(){
        lbl0.setText("Administrador");
        lbl1.setText("Ver usuarios");
        btn0.setText("Ver usuarios");
        btn1.setText("Regresar");
        
        
        lbl0.setBounds(200, 20, 100, 20);
        lbl1.setBounds(200, 50, 100, 20);
        btn0.setBounds(75, 75, 150, 20);
        btn1.setBounds(275, 75, 150, 20);
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(btn0);
        frm.add(btn1);
        
        setFrame(500,200);
    }
    //SETEO DE COMPONENTES PARA USUARIO
    protected void setUserMenu(){
        lbl0.setText("Nombre:   ");
        lbl1.setText("Apellido: ");
        lbl2.setText("Usuario");
        lbl3.setText("Menu principal");
        btn0.setText("Learning Trees");
        btn1.setText("Learning Graphs");
        btn2.setText("Learning Sorting Algorithms");
        btn3.setText("Salir");
        
        lbl0.setBounds(1, 10, 200, 20);
        lbl1.setBounds(1, 40, 200, 20);
        lbl2.setBounds(200, 70, 100, 20);
        lbl3.setBounds(175, 100, 150, 20);
        btn0.setBounds(50, 150, 175, 20);
        btn1.setBounds(275, 150, 175, 20);
        btn2.setBounds(150, 200, 200, 20);
        btn3.setBounds(200, 250, 100, 20);
        
        frm.add(lbl0);
        frm.add(lbl1);
        frm.add(lbl2);
        frm.add(lbl3);
        frm.add(btn0);
        frm.add(btn1);
        frm.add(btn2);
        frm.add(btn3);
        
        setFrame(500,300);
    }
    
    
    //****************************************************************************
    //****************************************************************************
    //SETEO DEL COMPORTAMIENTO DE LOS BOTONES
    private void Comportamiento(){
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
    protected void setBtn0(){}
    protected void setBtn1(){}
    protected void setBtn2(){}
    protected void setBtn3(){}
    protected void setBtn4(){}
    
}
