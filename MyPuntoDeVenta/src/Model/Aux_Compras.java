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
public class Aux_Compras {
    
    private int IDAux_Compras;
    private String Id_Producto;
    private String NombreProducto;
    private String Descripcion;
    private double Precio;
    private int Cantidad;
    private double Importe;

    public int getIDAux_Compras() {
        return IDAux_Compras;
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

    public int getCantidad() {
        return Cantidad;
    }

    public double getImporte() {
        return Importe;
    }

    public void setIDAux_Compras(int IDAux_Compras) {
        this.IDAux_Compras = IDAux_Compras;
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

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }
    
    
    
}
