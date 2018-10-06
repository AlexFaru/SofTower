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
public class Cliente {
    private int ID_Cliente;
    private String NombreCliente;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String TelefonoCliente;
    private String Celular;
    private String Telefono2;
    private double Saldo; 
    private String RFC;
    private String CP;
    private String Ciudad;
    private String Colonia;
    private String Calle;
    private String Numero_Dom;

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public void setNumero_Dom(String Numero_Dom) {
        this.Numero_Dom = Numero_Dom;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public String getRFC() {
        return RFC;
    }

    public String getCP() {
        return CP;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getColonia() {
        return Colonia;
    }

    public String getCalle() {
        return Calle;
    }

    public String getNumero_Dom() {
        return Numero_Dom;
    }
    

    public Cliente() {
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public String getCelular() {
        return Celular;
    }

    public String getTelefono2() {
        return Telefono2;
    }

    

    public double getSaldo() {
        return Saldo;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public void setTelefonoCliente(String TelefonoCliente) {
        this.TelefonoCliente = TelefonoCliente;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public void setTelefono2(String Telefono2) {
        this.Telefono2 = Telefono2;
    }
    
    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
}
