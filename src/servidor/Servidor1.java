
package servidor;
/*INSTIUTO TECNOLÓGICO DE COSTA RICA
Área Académica Ingeniería en Computadores
I Semestre 2020/Algoritmos y Estructura de Datos I
Tarea Extraclase 1

Estudiante: Oscar Méndez Granados
Carné: 2019150432
Versión: 1.1
Lenguaje: Java
IDE: NetBeans 8.2*/


import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class Servidor1 extends javax.swing.JFrame {
    //Variables estaticas para poder hacer la conexion cliente-servidor
    static ServerSocket puerto1;
    static Socket puerto2;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
    //Creacion de variables y objetos para llamar a clase usuario y para indicar cuales el tipo de usuario inicializado
    //si es cliente o servidor
    String Nombre = JOptionPane.showInputDialog("Digite su Nombre: ");
    AsignarIpNombre Nombre1 = new AsignarIpNombre(Nombre);
    UsuarioServidor tipo = new UsuarioServidor();

    //Variable del tipo string que almacena el chat
    static String historial = "";
    
    public Servidor1() {
        initComponents();
        tipo.TipodeUsuario();//Llamada a la clase que indica si es Cliente o Servidor
        cuadropantalla.setEditable(false);//Aqui se restringe el no poder editar el cuadro en el que se desplegan los mensajes
        JOptionPane.showMessageDialog(null, "Usuario correctamente guardado.\nBienvenido: "+Nombre1.getNombre());//Despliega una ventana con mensaje de buen inicio

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cuadropantalla = new javax.swing.JTextArea();
        botonenviar = new javax.swing.JButton();
        cuadromensaje = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 150));
        setMaximumSize(new java.awt.Dimension(935, 570));
        setMinimumSize(new java.awt.Dimension(935, 570));
        getContentPane().setLayout(null);

        cuadropantalla.setColumns(20);
        cuadropantalla.setRows(5);
        jScrollPane1.setViewportView(cuadropantalla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 890, 260);

        botonenviar.setText("SEND");
        botonenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonenviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonenviar);
        botonenviar.setBounds(830, 405, 80, 40);

        cuadromensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadromensajeActionPerformed(evt);
            }
        });
        cuadromensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuadromensajeKeyTyped(evt);
            }
        });
        getContentPane().add(cuadromensaje);
        cuadromensaje.setBounds(20, 390, 650, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(570, 340, 280, 200);

        jLabel2.setFont(new java.awt.Font("Orbitron", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ServMess(Messenger Service)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 30, 870, 40);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Write your message here.....");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 350, 610, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/30413hd.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 930, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonenviarActionPerformed
        //ENVIO DEL MENSAJE AL CLIENTE

        
        try{
            String mensajesalida = "";//Declaracion de la variable que almacena el mensaje que será enviado
            mensajesalida = cuadromensaje.getText().trim();//Se toma el texto ingresado para almacenarlo en mensaje salida
            cuadromensaje.setText("");//Se reinicia el contenido del cuadro en el que se escribe mensaje
            historial+="Me: " + mensajesalida+"\n";//Se almacena el mensaje tambien en el historial
            cuadropantalla.setText(historial);//Muestro en pantalla el mensaje que envié
            datossalida.writeUTF(Nombre1.getNombre()+": "+mensajesalida);//se envia el mensaje del server al cliente codificado

        }catch (Exception e){

        }
    }//GEN-LAST:event_botonenviarActionPerformed

    private void cuadromensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadromensajeActionPerformed
        
    }//GEN-LAST:event_cuadromensajeActionPerformed

    private void cuadromensajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuadromensajeKeyTyped
        char teclaenter = evt.getKeyChar();
        if (teclaenter==KeyEvent.VK_ENTER){
            botonenviar.doClick();
        }
    }//GEN-LAST:event_cuadromensajeKeyTyped


    public static void main(String args[]) {


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor1().setVisible(true);
            }
        });
        String mensaje = "";//Declaracion de la variable en la que se va a almacenar el mensaje
        try{
            puerto1 = new ServerSocket(1201);//el server se inicializa en el puerto 1201
            puerto2 = puerto1.accept();//Se le dice al server que acepte la conexion
            //Puerto por donde entran y salen los datos
            datosentrada = new DataInputStream(puerto2.getInputStream());
            datossalida = new DataOutputStream(puerto2.getOutputStream());
            
            while(!mensaje.equals("exit")){
                mensaje = datosentrada.readUTF();//Lee y decodifica el mensaje que le ha sido enviado
                cuadropantalla.setText("\n");
                historial += (cuadropantalla.getText().trim()+mensaje);//Se almacena el mensaje recibido en el historial
                historial+="\n";
                cuadropantalla.setText(historial);//Se muestra el mensaje recibido en pantalla
                
            }
        
        }catch (Exception e){
        
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonenviar;
    private javax.swing.JTextField cuadromensaje;
    private static javax.swing.JTextArea cuadropantalla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
