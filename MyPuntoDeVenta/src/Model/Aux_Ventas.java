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
public class Aux_Ventas {
    private int IdAux;
    private String Id_Producto;
    private String NombreProducto;
    private String Descripcion;
    private double Precio;
    private int CV;
    private double Importe;
    private double descuento; 

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public int getCV() {
        return CV;
    }
  

    public Aux_Ventas() {
    }

    
    public int getIdAux() {
        return IdAux;
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

    public int getCantidad() {
        return CV;
    }

    public double getImporte() {
        return Importe;
    }
    
    public void setIdAux(int IdAux) {
        this.IdAux = IdAux;
    }

    public void setId_Producto(String Codigo) {
        Id_Producto = Codigo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setCV(int CV) {
        this.CV = CV;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }
    
    
}
