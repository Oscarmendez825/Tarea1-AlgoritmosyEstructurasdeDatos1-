
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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Cliente extends javax.swing.JFrame {
    //Variables estaticas para poder hacer la conexion cliente-servidor
    static Socket puerto;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
    //Creacion de variables y objetos para llamar a clase usuario y para indicar cuales el tipo de usuario inicializado
    //si es cliente o servidor
    String Nombre = JOptionPane.showInputDialog("Digite su Nombre: ");//Valor que brinda el valor a la clase Usuario del nombre
    static String ip = JOptionPane.showInputDialog("Digite la ip del servidor: \n Si desea ejecutar todo desde una misma pc por favor digite 0: ");//Variable estatica que permite pasar como parametro la ip a la clase Usuario
    AsignarIpNombre Nombre1 = new AsignarIpNombre(Nombre);//Creo un objeto de la clase AsignarIpNombre y le paso el nombre
    AsignarIpNombre direccion = new AsignarIpNombre(Nombre,ip);//Creo un objeto de la clase AsignarIpNombre y le paso el nombre junto con la Ip
    UsuarioClienteServidor2 tipo = new UsuarioClienteServidor2();//Objeto de la clase TipodeUsuario que indica si el inicializado es cliente o servidor
    //Variable del tipo string que almacena el chat
    static String historial = "";
    
    public Cliente() {
        initComponents();


        ip = direccion.getIp();//Se le da el valor a la variable de la nueva y corregida ip
        tipo.TipodeUsuario();//Se le pide a la Clase UsuarioClienteServidor que indique qué tipo de usuario acaba de arrancar
        cuadropantalla.setEditable(false);//Aqui se restringe el no poder editar el cuadro en el que se desplegan los mensajes
        JOptionPane.showMessageDialog(null, "Usuario correctamente guardado.\nBienvenido: "+Nombre1.getNombre());//Despliega una ventana con mensaje de buen inicio
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuadropantalla = new javax.swing.JTextArea();
        cuadromensaje = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonenviar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 150));
        setMinimumSize(new java.awt.Dimension(935, 580));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Orbitron", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ServMess(Messenger Service)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 870, 40);

        cuadropantalla.setColumns(20);
        cuadropantalla.setRows(5);
        jScrollPane1.setViewportView(cuadropantalla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 900, 250);
        getContentPane().add(cuadromensaje);
        cuadromensaje.setBounds(20, 370, 650, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(550, 320, 280, 200);

        botonenviar.setText("SEND");
        botonenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonenviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonenviar);
        botonenviar.setBounds(830, 370, 80, 40);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Write your message here.....");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 330, 610, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/30413hd.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 930, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonenviarActionPerformed
        //ENVIO DEL MENSAJE AL SERVIDOR
        try{
            String mensajesalida = "";//Declaracion de la variable que almacena el mensaje que será enviado
            mensajesalida = cuadromensaje.getText().trim();//Se toma el texto ingresado para almacenarlo en mensaje salida
            cuadromensaje.setText("");//Se reinicia el contenido del cuadro en el que se escribe mensaje
            historial+="Me: " + mensajesalida+"\n";//Se almacena el mensaje tambien en el historial
            cuadropantalla.setText(historial);//Muestro en pantalla el mensaje que envié
            datossalida.writeUTF(direccion.getNombre()+": "+mensajesalida);//se envia el mensaje del cliente al server codificado
            
        }catch (Exception e){

        }

    }//GEN-LAST:event_botonenviarActionPerformed


    public static void main(String args[]) {



        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  


        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
                
            }
        });
        try{
           
            
            puerto = new Socket(ip,1201);//Se recibe el valor de la ip y se inicializa el puerto
            //Puerto por donde entran y salen los datos
            datosentrada = new DataInputStream(puerto.getInputStream());
            datossalida = new DataOutputStream(puerto.getOutputStream());
            
            String mensajeentrada="";//Declaracion de la variable en la que se va a almacenar el mensaje
            while(!mensajeentrada.equals("exit")){
                mensajeentrada = datosentrada.readUTF();//Lee y decodifica el mensaje que le ha sido enviado
                cuadropantalla.setText("\n");
                historial += (cuadropantalla.getText().trim()+mensajeentrada);//Se almacena el mensaje recibido en el historial
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
