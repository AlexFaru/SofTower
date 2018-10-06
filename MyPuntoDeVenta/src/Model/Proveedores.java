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
public class Proveedores {
    
    private int ID_Proveedor;
    private String NombreProveedor;
    private String TelefonoProveedor;
    private String DirecionProveedor;
    private String EmailProveedor;
    private double deuda;

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public String getTelefonoProveedor() {
        return TelefonoProveedor;
    }

    public String getDirecionProveedor() {
        return DirecionProveedor;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public void setTelefonoProveedor(String TelefonoProveedor) {
        this.TelefonoProveedor = TelefonoProveedor;
    }

    public void setDirecionProveedor(String DirecionProveedor) {
        this.DirecionProveedor = DirecionProveedor;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }
    
    
}
