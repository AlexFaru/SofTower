/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;

/**
 *
 * @author JOSE
 */
public class Format {
    
    
    public double decimalFormat(double number){
        String aux = String.format("%.2f", number);
        return Double.parseDouble(aux);
    }
    
}
