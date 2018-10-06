/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.util.regex.Pattern;

/**
 *
 * @author dario
 */
public class Validacion {
    public final static String EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+"
            + "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
            + "\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f"
            + "])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*["
            + "a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-"
            + "5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b"
            + "\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e"
            + "-\\x7f])+)\\])";
    public final static String ENTERO = "[0-9]+?";
    public final static String REAL = "([\\d]+?)|([\\d]+?\\.[\\d]+?)";
    public final static String ALFA_ESPACIO = "[a-zA-Z\\s\\á\\é\\í\\ó\\ú\\ñ"
            + "\\Á\\É\\Í\\Ó\\Ú\\Ñ]+?";
    public final static String ALFANUMERICO = "[\\w\\s\\.\\á\\é\\í\\ó\\ú\\ñ"
                    + "\\Á\\É\\Í\\Ó\\Ú\\Ñ]+?";
    public final static String PASSWORD = "[a-zA-Z\\d\\:\\;\\#\\$\\-\\_]+?";
    public final static String DOMICILIO = "[a-zA-Z\\d\\.\\á\\é\\í\\ó\\ú\\ñ"
            + "\\Á\\É\\Í\\Ó\\Ú\\Ñ\\,\\#\\s]+?";
    public final static String FECHA = "\\d{1,2}[\\\\|\\/]\\d{1,2}[\\\\|\\/]\\d{2,4}";
    public final static String NUM_DOMICILIO = "[a-zA-Z\\d\\s\\á\\é\\í\\ó\\ú\\ñ"
            + "\\Á\\É\\Í\\Ó\\Ú\\Ñ\\#\\-]+?";
    public final static String LOGIN = "[a-zA-Z\\d\\á\\é\\í\\ó\\ú\\ñ\\"
            + "Á\\É\\Í\\Ó\\Ú\\Ñ\\#\\,\\.]";
    
    static javax.swing.border.Border error = javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 3);
    static javax.swing.border.Border excedido = javax.swing.BorderFactory.createLineBorder(java.awt.Color.YELLOW, 3);
    
    public static boolean validar(String regex, String cad) {
        return Pattern.matches(regex, cad);
    }
    
    public static boolean hayExcedido(javax.swing.JTextField tf[]) {
        for(int i=0; i<tf.length; i++) {
            if(tf[i].getBorder().equals(excedido)) return true;
        }
        return false;
    }
    
    public static boolean hayError(javax.swing.JTextField tf[]) {
        for(int i=0; i<tf.length; i++) {
            if(tf[i].getBorder().equals(error)) return true;
        }
        return false;
    }
    
    public static void validarTF(javax.swing.JTextField tf, String regex, int lon) {       
        javax.swing.border.Border defaul;
        defaul = new javax.swing.JTextField().getBorder();
        
        tf.setBorder(defaul);
        
        if("".equals(tf.getText())) return;
        if(tf.getText().length()>lon) tf.setBorder(excedido);
        if(!validar(regex, tf.getText())) tf.setBorder(error); 
    }
}
