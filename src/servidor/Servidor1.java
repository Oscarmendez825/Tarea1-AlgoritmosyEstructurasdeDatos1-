
package servidor;



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
    //Creacion de atributos y objetos para llamar a clase usuario y para indicar cuales el tipo de usuario inicializado
    //si es cliente o servidor
    String Nombre = JOptionPane.showInputDialog("Digite su Nombre: ");
    AsignarIpNombre Nombre1 = new AsignarIpNombre(Nombre);
    UsuarioClienteServidor1 tipo = new UsuarioClienteServidor1();
    
    
    public Servidor1() {
        initComponents();
        tipo.TipodeUsuario();//Llamada a la clase que indica si es Cliente o Servidor
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
            String mensajesalida = "";
            mensajesalida = cuadromensaje.getText().trim();
            cuadromensaje.setText("");
            cuadropantalla.setText("Me: " + mensajesalida);//Desplego en pantalla el mensaje que voy a enviar
            datossalida.writeUTF(Nombre1.getNombre()+": "+mensajesalida);//se envia el mensaje del server al cliente
            
        }catch (Exception e){

        }
    }//GEN-LAST:event_botonenviarActionPerformed

    private void cuadromensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadromensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadromensajeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor1().setVisible(true);
            }
        });
        String mensaje = "";
        try{
            puerto1 = new ServerSocket(1201);//el server se inicializa en el puerto 1201
            puerto2 = puerto1.accept();//Se le dice al server que acepte la conexion
            
            datosentrada = new DataInputStream(puerto2.getInputStream());
            datossalida = new DataOutputStream(puerto2.getOutputStream());
            
            while(!mensaje.equals("exit")){
                mensaje = datosentrada.readUTF();
                

                cuadropantalla.setText("\n");
                cuadropantalla.setText(cuadropantalla.getText().trim()+mensaje);//Desplegar o imprimir el mensaje en pantalla del cliente
                
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
