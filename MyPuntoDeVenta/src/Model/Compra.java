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
public class Compra {
    
    
     private int ID_Compra;
    private String Id_Producto;
    private String NombreProducto;
    private String Descripcion;
    private double Precio;
    private int CantidadCompra;
    private double Importe;

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setId_Producto(String Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setCantidadCompra(int CantidadCompra) {
        this.CantidadCompra = CantidadCompra;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public String getId_Producto() {
        return Id_Producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getCantidadCompra() {
        return CantidadCompra;
    }

    public double getImporte() {
        return Importe;
    }

    
    
}
