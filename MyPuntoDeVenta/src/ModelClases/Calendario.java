/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author JOSE
 */
public class Calendario {
    
    Calendar c = new GregorianCalendar();
    private String fecha, Dia, Mes, year, hora, minutos, segundos, am_pm;
    private int mes;
    
    public Calendario(){
        hora = Integer.toString(c.get(Calendar.HOUR));
        minutos = Integer.toString(c.get(Calendar.MINUTE));
        segundos = Integer.toString(c.get(Calendar.SECOND));
        
        switch(c.get(Calendar.AM_PM)){
            case 0:
                am_pm = "am";
                break;
            case 1:
                am_pm = "pm";
                break;
        }
        
        Dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        mes = c.get(Calendar.MONTH);
        mes++;
        Mes = Integer.toString(mes);
        year = Integer.toString(c.get(Calendar.YEAR));
        fecha = year + "/" + Mes + "/" + Dia;
        hora += ":"+ minutos + ":"+ segundos + " " + am_pm;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public String getHora(){
        return hora; 
    }

    public String getDia() {
        return Dia;
    }

    public String getMes() {
        return Mes;
    }

    public String getYear() {
        return year;
    }
    
    
}
