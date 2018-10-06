/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;

import Connection.Consult;
import Model.Aux_Ventas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.util.ArrayList;

/**
 *
 * @author JOSE
 */
public class BillPrintable extends Consult implements Printable {
    
   int flag;
   ArrayList<Aux_Ventas> ventas;
   //Consult consult = new Consult();
   Graphics2D g2d;
    Calendario calendar = new Calendario();
    int y=20;
    int yShift = 10;
    int headerRectHeight=15;
    int headerRectHeighta=40;
    double sum=0;
    double Pagos[];
    String Datos[];
    double DeudaActual;
    String Deuda,PagoCliente,DeudaA;
    String nam;
    String id_cliente;
  public BillPrintable(ArrayList Aux_Ventas,double [] Pagos,String Datos[],int flag){
         ventas = Aux_Ventas;
         this.flag= flag;
         this.Pagos = Pagos;
          id_cliente = String.format("%-20s","Id_Cliente: "+Datos[0]);
          nam = String.format("%-30s","Cliente: "+Datos[1]);
  } 
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      //Aux_Ventas = (ArrayList<Aux_Ventas>) Aux_Ventas.stream().collect(Collectors.toList());
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
             g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            y=20; 
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("------------------------------------",12,y);y+=yShift;
            g2d.drawString("       Vinos y Licores MEMO         ",12,y);y+=yShift;
            g2d.drawString("        Tel. 341 156 82 11          ",12,y);y+=yShift;
            g2d.drawString("        RFC: 122HDHFDSJDJ           ",12,y);y+=yShift;
            String fecha = String.format("%-10s",calendar.getFecha());
            String hora =  String.format("%-7s",calendar.getHora());
            g2d.drawString("Fecha:" + fecha+ "      Hora:"+hora,12,y);y+=yShift;
            g2d.drawString("------------------------------------",12,y);y+=headerRectHeight;
            switch(flag){
                case 0: 
                    g2d.drawString(id_cliente,10,y);y+=yShift;
                    g2d.drawString(nam,10,y);y+=yShift;
                    g2d.drawString("------------------------------------",10,y);y+=yShift;
                    g2d.drawString("Product          Cant.       Precio ",10,y);y+=yShift;
                    g2d.drawString("------------------------------------",10,y);y+=headerRectHeight;
                    sum = 0;
                    for(int i=0;i<ventas.size();i++){
                        System.out.println(sum + "Imprimir la suma");
                        sum = sum + ventas.get(i).getImporte();
                        String name = String.format("%-15s", ventas.get(i).getNombreProducto());
                        String cant = String.format("%5d", ventas.get(i).getCantidad());
                        String importe = String.format("%14.2f", ventas.get(i).getImporte());
                        name = name + cant + importe;
                        g2d.drawString(name,10,y);
                        y+=yShift;
                    }
                    g2d.drawString("------------------------------------",10,y);y+=yShift;
                    String pago = String.format("%34.2f",sum);
                    g2d.drawString(pago,10,y);y+=yShift;
                    break;
                case 1:
                    g2d.drawString("------------------------------------",10,y);y+=yShift; //Se pueden colocar 38 caracteres 
                    g2d.drawString(" "+nam,10,y);y+=yShift;
                    g2d.drawString(" "+id_cliente,10,y);y+=yShift;
                    g2d.drawString("------------------------------------",10,y);y+=yShift;
                    g2d.drawString("         Pago Realizado             ",10,y);y+=yShift;
                    Deuda = String.format("%10.2f",Pagos[0]);
                    g2d.drawString("Deuda Anterior............."+Deuda,10,y);y+=yShift;
                    PagoCliente = String.format("%10.2f",Pagos[1]); 
                    g2d.drawString("Pago......................."+PagoCliente,10,y);y+=yShift;
                    if(Pagos[1]>Pagos[0])
                        DeudaActual = 0;
                    else 
                        DeudaActual = Pagos[0]-Pagos[1];
                    DeudaA = String.format("%10.2f",DeudaActual);
                    g2d.drawString("Deuda Actual..............."+DeudaA,10,y);y+=yShift;
                    break;
            }
                
            
            g2d.drawString("------------------------------------",10,y);y+=yShift;
            g2d.drawString("          Entrega a domicilio       ",10,y);y+=yShift;
            g2d.drawString("             03111111111            ",10,y);y+=yShift;
            g2d.drawString("************************************",10,y);y+=yShift;
            g2d.drawString("    Gracias por tu preferencia      ",10,y);y+=yShift;
            g2d.drawString("************************************",10,y);y+=yShift;
    }
    catch(Exception r){
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }