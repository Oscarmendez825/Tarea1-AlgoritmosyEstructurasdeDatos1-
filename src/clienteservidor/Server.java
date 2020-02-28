
package clienteservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Server extends javax.swing.JFrame {

    static ServerSocket puerto1;
    static Socket puerto2;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
     //Creacion de atributos y objetos para llamar a clase usuario
    String Nombre = JOptionPane.showInputDialog("Digite su Nombre: ");
    Usuario Nombre1 = new Usuario(Nombre);
        
    public Server() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuadropantalla = new javax.swing.JTextArea();
        cuadromensaje = new javax.swing.JTextField();
        botonenviar = new javax.swing.JButton();
        etiqueta1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        cuadropantalla.setColumns(20);
        cuadropantalla.setRows(5);
        jScrollPane1.setViewportView(cuadropantalla);

        cuadromensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadromensajeActionPerformed(evt);
            }
        });

        botonenviar.setText("SEND");
        botonenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonenviarActionPerformed(evt);
            }
        });

        etiqueta1.setAlignment(java.awt.Label.CENTER);
        etiqueta1.setBackground(new java.awt.Color(51, 184, 184));
        etiqueta1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        etiqueta1.setText("SERVMESS (MENSSENGER SERVICE)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cuadromensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonenviar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonenviar)
                    .addComponent(cuadromensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuadromensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadromensajeActionPerformed
        
    }//GEN-LAST:event_cuadromensajeActionPerformed

    private void botonenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonenviarActionPerformed
        try{
            String mensajesalida = "";
            mensajesalida = cuadromensaje.getText().trim();
            datossalida.writeUTF(Nombre1.getNombre()+": "+mensajesalida);//se envia el mensaje del server al cliente
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
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
                cuadropantalla.setText(cuadropantalla.getText().trim()+mensaje);//Desplegar o imprimir el mensaje en pantalla del cliente
            }
        
        }catch (Exception e){
        
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonenviar;
    private javax.swing.JTextField cuadromensaje;
    private static javax.swing.JTextArea cuadropantalla;
    private java.awt.Label etiqueta1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
