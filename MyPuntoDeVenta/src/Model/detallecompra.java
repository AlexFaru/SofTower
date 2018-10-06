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
public class detallecompra {
    
    private int ID_Compra;
    private int ID_Usuario;
    private int ID_Proveedor;
    private String FechaCompra;
    private double TotalCompra;

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public void setTotalCompra(double TotalCompra) {
        this.TotalCompra = TotalCompra;
    }
    
    
    public int getID_Compra() {
        return ID_Compra;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public double getTotalCompra() {
        return TotalCompra;
    }
    
    
    
}
