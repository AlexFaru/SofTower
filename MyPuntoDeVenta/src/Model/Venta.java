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
public class Venta {
    private int ID_Venta;
    private String Id_Producto;
    private String Descripcion;
    private double Precio;
    private int CantidadVenta;
    private double Importe;
    private String NombreProducto;
    private double Descuento; 

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public void setId_Producto(String Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setCantidadVenta(int CantidadVenta) {
        this.CantidadVenta = CantidadVenta;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public int getID_Venta() {
        return ID_Venta;
    }

    public String getId_Producto() {
        return Id_Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getCantidadVenta() {
        return CantidadVenta;
    }

    public double getImporte() {
        return Importe;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public double getDescuento() {
        return Descuento;
    }
    
    
    
}
