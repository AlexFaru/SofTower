  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author JOSE
 */
public class TextFieldEvent {
    
    public void textKeyPress(KeyEvent evt, JTextField textField, int length){
        char car = evt.getKeyChar(); //Se almacena en car el carracter que involucra el evento 
        
        if((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') &&  //Se hace el flitro de los caracteres que seran consumidos
                (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)
                && (textField.getText().length()<=length)){
            evt.consume();
        }
    }
    
    public void nameKeyPress(KeyEvent evt, JTextField textField, int length){
        char car = evt.getKeyChar();
        //Contition that allows to input data of text type
        
        if(((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && //Se filtran caracteres que se consumiran
                (car != (char) KeyEvent.VK_BACK_SPACE)              // Los métodos dot() y spaces() son especiales 
                && (car != (char) KeyEvent.VK_SPACE)                //Aparecen en la parte inferior de la clase
                && (textField.getText().length()<=length) 
                && (textField.getText().contains("."))) || 
                (textField.getText().equals("")&& car == (char) KeyEvent.VK_SPACE )
                || (dot(textField) && car != (char) KeyEvent.VK_SPACE)){
            evt.consume();
        }else if((((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && 
                (car != (char) KeyEvent.VK_BACK_SPACE) 
                && (car != (char) KeyEvent.VK_SPACE)
                && (textField.getText().length()<=length) 
                && car != '.') 
                ||(textField.getText().equals("")&& car == (char) KeyEvent.VK_SPACE )
                ||(textField.getText().equals("")&& car == '.' )
                || (spaces(textField) && car == (char) KeyEvent.VK_SPACE) ))
        {
                evt.consume();
        }
    }
    
    
    
    public void name_numKeyPress(KeyEvent evt, JTextField textField, int length){
        char car = evt.getKeyChar();
        //Contition that allows to input data of text type
        
        if(((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && //Se filtran caracteres que se consumiran
                (car != (char) KeyEvent.VK_BACK_SPACE)              // Los métodos dot() y spaces() son especiales 
                && (car != (char) KeyEvent.VK_SPACE)                //Aparecen en la parte inferior de la clase
                && (car < '0' || car > '9')
                //&& (textField.getText().length()<=length) 
                && (textField.getText().contains("."))) || 
                (textField.getText().equals("")&& car == (char) KeyEvent.VK_SPACE )){
            evt.consume();
        }else if((((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && //Permite agregar un punto
                (car != (char) KeyEvent.VK_BACK_SPACE) 
                && (car != (char) KeyEvent.VK_SPACE)
                && (textField.getText().length()<=length) 
                && (car < '0' || car > '9')
                && car != '.') 
                ||(textField.getText().equals("")&& car == (char) KeyEvent.VK_SPACE )
                ||(textField.getText().equals("")&& car == '.' )
                || (spaces(textField) && car == (char) KeyEvent.VK_SPACE) )){
                evt.consume();
        }
    }
      
    public void text_numKeyPress(KeyEvent evt,JTextField textField,int length){
        char car = evt.getKeyChar();
        //Contition that allows to input data of text type
        if((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && 
                (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)
               && (car < '0' || car > '9') || (textField.getText().length()>length) ){
            evt.consume();
        }
    }
      
    public void numberKeyPress (KeyEvent evt, JTextField textField, int length) {
        //Declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        //Condicion que nos permite ingresar datos numéricos con su punto
        if((car< '0' || car > '9')&&(car != (char) KeyEvent.VK_BACK_SPACE) || textField.getText().length()>=length){
            evt.consume();
        }  
    }
    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField ){
        char car = evt.getKeyChar();
        
        if((car < '0' || car > '9') && textField.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)){
                evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)){
                    evt.consume();         
        }
    }
    
    public boolean spaces( JTextField textField){
        String word = textField.getText();
        if(word.equals(""))
            return false;
        char last = word.charAt(word.length()-1);
        return last == (char)32;
    }
    
    public boolean dot( JTextField textField){
        String word = textField.getText();
        if(word.equals(""))
            return false;
        char last = word.charAt(word.length()-1);
        return last == (char)46;
    }
    
}
