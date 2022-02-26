
package com.Class;

import javax.swing.*;
import java.awt.*;

class NRZI extends JFrame{

    private String numero;
    
    public NRZI(String numero){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(1100,500);
        JLabel label1 = new JLabel("Codificación NRZI");
        label1.setBounds(200, 50, 100, 100);
        label1.setForeground(Color.BLACK);
        panel.add(label1);
        this.numero = numero;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g.drawLine(100, 150, 100, 400);
        g.drawLine(100, 400, 1000, 400);
        int cont = 0;
        for(int i = 100; i < 1050; i+=75){
            g.drawString("t" + cont, i, 415);
            cont++;
        }
        
        char[] nrzi = new char[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            nrzi[i] = numero.charAt(i);
        }
        int corX = 100;
        boolean bajo = true;
        for(char c : nrzi){
            switch(c){
                case '1':
                    if (bajo == true){
                        g.drawLine(corX, 200, corX, 400);
                        g.drawLine(corX, 200, corX + 75, 200);
                        bajo = false;
                        corX += 75;
                        break;
                    }else{
                        g.drawLine(corX, 200, corX, 400);
                        g.drawLine(corX, 400, corX + 75, 400);
                        bajo = true;
                        corX += 75;
                        break;
                    }
                case '0':
                    if (bajo == true){
                        g.drawLine(corX, 400, corX + 75, 400);
                        corX += 75;
                        break;
                    }else{
                        g.drawLine(corX, 200, corX + 75, 200);
                        corX += 75;
                        break;
                    }
            }
        }
    }

    public static void main(String []args){
        NRZI s = new NRZI("011000110100");
        s.setVisible(true);
    }
}
