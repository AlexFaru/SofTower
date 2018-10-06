/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author JOSE
 */
public class detalleventa {
    
    private int ID_Venta;
    private int ID_Cliente;
    private int ID_Usuario;
    private String FechaVenta;
    private double TotalVenta;

    public int getID_Venta() {
        return ID_Venta;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public double getTotalVenta() {
        return TotalVenta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public void setTotalVenta(double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }
    
    
    
}
