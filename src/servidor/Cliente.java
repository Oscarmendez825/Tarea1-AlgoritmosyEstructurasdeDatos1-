
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class Cliente extends javax.swing.JFrame {
    static Socket puerto;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
    //Creacion de atributos y objetos para llamar a clase usuario
    String Nombre = JOptionPane.showInputDialog("Digite su Nombre: ");
    static String ip = JOptionPane.showInputDialog("Digite la ip del servidor: \n Si desea ejecutar todo desde una misma pc por favor digite 0: ");
    //Usuario Nombre1 = new Usuario(Nombre);
    Usuario direccion = new Usuario(Nombre,ip);
    
    
    public Cliente() {
        initComponents();
        ip = direccion.getIp();
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
        try{
            String mensajesalida = "";
            mensajesalida = cuadromensaje.getText().trim();
            cuadromensaje.setText("");
            cuadropantalla.setText("Me: " + mensajesalida);//Desplego en pantalla el mensaje que voy a enviar
            datossalida.writeUTF(direccion.getNombre()+": "+mensajesalida);//se envia el mensaje del server al cliente
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
           
            
            puerto = new Socket(ip,1201);//Se le pasa el parametro de ip ingresado
            
            datosentrada = new DataInputStream(puerto.getInputStream());
            datossalida = new DataOutputStream(puerto.getOutputStream());
            String mensajeentrada="";
            while(!mensajeentrada.equals("exit")){
                mensajeentrada = datosentrada.readUTF();
                cuadropantalla.setText("\n");
                cuadropantalla.setText(cuadropantalla.getText().trim()+mensajeentrada);
                
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
