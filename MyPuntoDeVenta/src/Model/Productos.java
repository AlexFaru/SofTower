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
public class Productos {
    
    String ID_Producto;
    String NombreProducto;
    String Descripcion;
    int ExistenciaProducto;
    String Categoria;
    String TipoProducto;
    String FechaCaducidad;
    double PrecioProducto;
    double PrecioVenta;

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }
    
    public Productos() {
    }

    public String getID_Producto() {
        return  ID_Producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getExistenciaProducto() {
        return ExistenciaProducto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getTipoProducto() {
        return TipoProducto;
    }

    public String getFechaCaducidad() {
        return FechaCaducidad;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setID_Producto(String ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setExistenciaProducto(int ExistenciaProducto) {
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setTipoProducto(String TipoProducto) {
        this.TipoProducto = TipoProducto;
    }

    public void setFechaCaducidad(String FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }

    public void setPrecioProducto(double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }
    
}
