import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

class Acceso extends JFrame{

    JLabel crearUsuario;
    JPanel panelLogin;
    JPanel panelSignin;

    public Acceso(){
        crearVentana();
        login();
    }    

    public void crearVentana(){
        setTitle("Login");
        setResizable(false);
        setLayout(null);
        setSize(400,300);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void login(){

        // Tamaño de la ventana
        setSize(400,300);
        setLocationRelativeTo(null);

        // Panel
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBounds(0,0,400,300);

        // Titulo
        JLabel titulo = new JLabel("Online Hero");
        titulo.setBounds(150,10,150,50);

        panelLogin.add(titulo);

        // Campos de llenado
        JLabel usuario = new JLabel("Nombre de usuario");
        usuario.setBounds(20,50,200,50);
        JTextField contenidoUsuario = new JTextField();
        contenidoUsuario.setBounds(150,65,200,20);
        
        JLabel password = new JLabel("Contraseña");
        password.setBounds(20,80,200,50);
        JPasswordField contenidoPassword = new JPasswordField();
        contenidoPassword.setBounds(150,95,200,20);

        panelLogin.add(usuario);
        panelLogin.add(contenidoUsuario);
        panelLogin.add(password);
        panelLogin.add(contenidoPassword);
        
        // Botones
        JButton ingresar = new JButton("Ingresar");
        ingresar.setBounds(125,135,150,50);
        crearUsuario = new JLabel("Crear nuevo usuario");
        crearUsuario.setBounds(135,185,150,50);
        
        ingresar.addActionListener(new IngresarButton());
        crearUsuario.addMouseListener(new CrearMouse());

        panelLogin.add(ingresar);
        panelLogin.add(crearUsuario);
        
        add(panelLogin);

    }

    public void signin(){

        // Tamaño de ventana
        setSize(450,400);
        setLocationRelativeTo(null);

        //Panel
        panelSignin = new JPanel();
        panelSignin.setLayout(null);
        panelSignin.setBounds(0,0,400,400);

        //Titulo
        JLabel titulo = new JLabel("Online Hero");
        titulo.setBounds(175,10,150,50);

        // Nombre de usuario
        JLabel usuario = new JLabel("Usuario:");
        usuario.setBounds(20,50,250,50);
        JTextField contenidoUsuario = new JTextField();
        contenidoUsuario.setBounds(150,65,250,20);

        // Contraseña
        JLabel contraseña = new JLabel("Contraseña");
        contraseña.setBounds(20,80,250,50);
        JPasswordField contenidoContraseña = new JPasswordField();
        contenidoContraseña.setBounds(150,95,250,20);

        // Correo
        JLabel correo = new JLabel("Correo");
        correo.setBounds(20,110,250,50);
        JTextField contenidoCorreo = new JTextField();
        contenidoCorreo.setBounds(150,125,250,20);

        // Fecha de nacimiento
        JLabel nacimiento = new JLabel("Fecha de nac.");
        nacimiento.setBounds(20,140,250,50);
        
        // Dia
        JComboBox <String> dia = new JComboBox<>();
        for(int i= 0; i<30; i++){
            dia.addItem(String.valueOf(i+1));
        }
        dia.setBounds(150,155,70,20);

        // Mes
        JComboBox <String> mes = new JComboBox<>();
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        for(int i = 0; i<meses.length; i++){
            mes.addItem(meses[i]);
        }
        mes.setBounds(215,155,100,20);

        // Año
        JComboBox <String> año = new JComboBox<>();
        String[] años = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002"};
        for(int i=0; i<años.length; i++){
            año.addItem(años[i]);
        }
        año.setBounds(310,155,95,20);
        
        // Confirmación
        JCheckBox terminos = new JCheckBox("Aceptos los términos.");
        terminos.setBounds(20,190,400,50);

        // Boton
        JButton buttonSignin = new JButton("Guardar");
        buttonSignin.setBounds(125,250,200,50);

        buttonSignin.addActionListener(new SignButton());

        panelSignin.add(titulo);
        panelSignin.add(usuario);
        panelSignin.add(contraseña);
        panelSignin.add(correo);
        panelSignin.add(nacimiento);
        panelSignin.add(terminos);

        panelSignin.add(contenidoUsuario);
        panelSignin.add(contenidoContraseña);
        panelSignin.add(contenidoCorreo);
        panelSignin.add(dia);
        panelSignin.add(mes);
        panelSignin.add(año);
        panelSignin.add(buttonSignin);

        add(panelSignin);

    }

    public class IngresarButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Ingresar");
        }
    }

    public class SignButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            panelSignin.setVisible(false);
            login();
            remove(panelSignin);
        }
    }

    public class CrearMouse implements MouseListener{
        @Override
        public void mouseReleased(MouseEvent e){

        }
        @Override
        public void mousePressed(MouseEvent e){

        }
        @Override
        public void mouseExited(MouseEvent e){
            crearUsuario.setForeground(Color.BLACK);
            Font sin_subrayado = crearUsuario.getFont();
            Map attributes = sin_subrayado.getAttributes();
            attributes.put(TextAttribute.UNDERLINE,-1);
            crearUsuario.setFont(sin_subrayado.deriveFont(attributes));
        }
        @Override
        public void mouseEntered(MouseEvent e){
            crearUsuario.setForeground(Color.BLUE);
            Font subrayado = crearUsuario.getFont();
            Map attributes = subrayado.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            crearUsuario.setFont(subrayado.deriveFont(attributes));
        }
        @Override
        public void mouseClicked(MouseEvent e){
            panelLogin.setVisible(false);
            signin();
            remove(panelLogin);
        }
    }

    public static void main(String[] args){
        Acceso acceso = new Acceso();
        acceso.setVisible(true);
    }
}