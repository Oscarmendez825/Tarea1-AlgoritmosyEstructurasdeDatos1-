
package com.Class;

import javax.swing.JOptionPane;

public class Conversiones {
    private String numero;
    private int decimal;
    private String octal = "";
    private String binario = "";

    public Conversiones(String numero) {
        this.numero = numero;
    }
    
    public int getDecimal() {
        converToDecimal();
        return decimal;
    }

    public String getOctal() {
        converToOctal();
        return octal;
    }

    public String getBinario() {
        converToBinario();
        return binario;
    }
    
    private void converToDecimal(){
        char[] hex = new char[numero.length()];

        for (int i = 0; i < numero.length(); i++) {
            hex[i] = numero.charAt(i);
        }
        int i = 2;
        for(char c : hex){
            switch(c){
                case 'A':
                    decimal += (int) (10 * Math.pow(16, i));
                    i--;
                    break;
                case 'B':
                    decimal += (int) (11 * Math.pow(16, i));
                    i--;
                    break;
                case 'C':
                    decimal += (int) (12 * Math.pow(16, i));
                    i--;
                    break;
                case 'D':
                    decimal += (int) (13 * Math.pow(16, i));
                    i--;
                    break;
                case 'E':
                    decimal += (int) (14 * Math.pow(16, i));
                    i--;
                    break;
                case 'F':
                    decimal += (int) (15 * Math.pow(16, i));
                    i--;
                    break;
                default:
                    try{
                        String a = String.valueOf(c); 
                        int temp = Integer.parseInt(a);
                        decimal += (int) (temp * Math.pow(16, i));
                        i--;
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "El número ingresado no es hexadecimal"); 
                    }
                    break;
            }
        }
    }

    private void converToBinario() {
        int tempDec = decimal;
        int[] binaryNum = new int[32];
        int i = 0;
        while (tempDec > 0) {
            binaryNum[i] = tempDec % 2;
            tempDec = tempDec / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            binario += binaryNum[j];
    }

    private void converToOctal() {
        int tempDec = decimal;
        int[] octalNum = new int[32];
        int i = 0;
        while (tempDec > 0) {
            octalNum[i] = tempDec % 8;
            tempDec = tempDec / 8;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            octal += octalNum[j];
    }
    
    
   
}
