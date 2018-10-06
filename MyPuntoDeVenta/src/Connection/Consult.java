/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Model.Aux_Compras;
import Model.Aux_Ventas;
import Model.Cliente;
import Model.Compra;
import Model.Productos;
import Model.Proveedores;
import Model.Venta;
import Model.detallecompra;
import Model.detalleventa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author JOSE
 */
public class Consult extends Conexion {
    private QueryRunner QR = new QueryRunner();
    public ArrayList<Cliente> cliente,conCliente;
    public ArrayList<Aux_Ventas> Aux_Ventas = new ArrayList<>();
    public ArrayList<Productos> productos = new ArrayList<>();
    public ArrayList<Aux_Compras> Aux_Compras = new ArrayList<>();
    public ArrayList<Venta> Ventas = new ArrayList<>();
    public ArrayList<detalleventa> detalleventa = new ArrayList<>();
    public ArrayList<Proveedores> proveedores = new ArrayList<>();
    public ArrayList<detallecompra> detallecompra = new ArrayList<>();
    public ArrayList<Compra> compras = new ArrayList<>();
  
    
    public ArrayList<Cliente> clientes(){
        try {
            cliente = (ArrayList<Cliente>) QR.query(getConn(),"SELECT * FROM cliente",
                    new BeanListHandler(Cliente.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error : " +ex);
        }
        return cliente;
    }
    public boolean insert(String sql,Object[] data){
        boolean flag=false;
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.insert(getConn(),sql,new ColumnListHandler(),data);
            flag=true;
        } catch (SQLException ex) {
             flag = false;
             JOptionPane.showMessageDialog(null,"Error.."+ex);
        }
        return flag;
    }
    
    public ArrayList<Cliente> conCliente(int ID_Cliente){
        try {
            conCliente = (ArrayList<Cliente>) QR.query(getConn(),
                    "SELECT * FROM cliente WHERE cliente.ID_Cliente =" + ID_Cliente,
                    new BeanListHandler(Cliente.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error : " +ex);
        }
        return conCliente;
    }
    
    public void update(String sql, Object[] data){
        
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.update(getConn(),sql,data);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
    }
    
    public void delete(String sql, int Id_Cosa){
        final QueryRunner qr = new QueryRunner(true);
        try {
            if(0 < Id_Cosa)
                qr.update(getConn(),sql,"%"+Id_Cosa+"%");
            else
                qr.update(getConn(), sql);
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTable(String sql, String tabla){
        final QueryRunner qr = new QueryRunner(true);
        try{
            qr.update(getConn(),sql,"%"+tabla+"%");
        }catch(SQLException ex){
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList <Aux_Ventas> Aux_Ventas(){
        try {
            Aux_Ventas = (ArrayList<Aux_Ventas>) QR.query(getConn(), "SELECT * FROM aux_ventas",
                    new BeanListHandler(Aux_Ventas.class)); //Hace la consulta de todos los elementos de la tabla aux_ventas
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return Aux_Ventas; 
    }
    
    public ArrayList<Aux_Compras> Aux_Compras(){
        
        try {
            Aux_Compras = (ArrayList<Aux_Compras>) QR.query(getConn(), "SELECT * FROM aux_compras",
                    new BeanListHandler(Aux_Compras.class)); //Consulta todos los datos de la tabal aux_compras
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return Aux_Compras; //Retorna los datos como un arreglo 
    
    }
    
    public ArrayList<Productos> productos(){
        try {
            productos= (ArrayList<Productos>) QR.query(getConn(), "SELECT * FROM producto",
                    new BeanListHandler(Productos.class)); //Consulta todos los registros de productos
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
          return productos; //Retorna los datos como un arreglo 
    }
    
    public ArrayList<Venta> ventas(){
        try {
            Ventas = (ArrayList<Venta>) QR.query(getConn(), "SELECT * FROM venta",
                    new BeanListHandler(Venta.class)); //Consulta todos los regsitros de producto
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
          return Ventas; //Retorna registros como arreglo         
    }
    
      public ArrayList<detalleventa> detalleventa(){
        try {
          detalleventa   = (ArrayList<detalleventa>) QR.query(getConn(), "SELECT * FROM detalleventa",
                    new BeanListHandler(detalleventa.class));//Consulta todos los registros de la tabla detalleventa
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
          return detalleventa;//Retorna datos como un arreglo       
     }
      
     public ArrayList<detalleventa> maxventa(){
         try{
             detalleventa = (ArrayList<detalleventa>) QR.query(getConn(), "SELECT * FROM multum.detalleventa where ID_Venta  =  (SELECT max(ID_Venta) FROM multum.detalleventa)",
                     new BeanListHandler(detalleventa.class));
         }catch(SQLException ex){
             Logger.getLogger(Consult.class.getName()).log(Level.SEVERE,null,ex);
         }
         return detalleventa;
     }
     public ArrayList<detallecompra> maxcompra(){
         try{
             detallecompra = (ArrayList<detallecompra>) QR.query(getConn(), "SELECT * FROM multum.detallecompra where ID_Compra  =  (SELECT max(ID_Compra) FROM multum.detallecompra)",
                     new BeanListHandler(detallecompra.class));
         }catch(SQLException ex){ // Consulta el registro de compra con el mayor número. 
             Logger.getLogger(Consult.class.getName()).log(Level.SEVERE,null,ex);
         }
         return detallecompra; // Retorna el registro. 
     }
     public ArrayList<Proveedores> proveedores(){
         try{
             proveedores = (ArrayList<Proveedores>) QR.query(getConn(), "SELECT * FROM proveedor",
                     new BeanListHandler(Proveedores.class));//Consulta todos los registros de la tabla proveedor
         }catch(SQLException ex){
             Logger.getLogger(Consult.class.getName()).log(Level.SEVERE,null,ex);
         }
         return proveedores;// Retornar estos registros en un vector.
     }
     
      public ArrayList<Compra> compras(){
         try{
             compras = (ArrayList<Compra>) QR.query(getConn(), "SELECT * FROM compra",
                     new BeanListHandler(Compra.class));//Consulta todos los registros de la tabla compra. 
         }catch(SQLException ex){
             Logger.getLogger(Consult.class.getName()).log(Level.SEVERE,null,ex);
         }
         return compras;//Retorna los registros como un vector. 
     }
      
      public ArrayList<Compra> maxCompra(){
         try{
             compras = (ArrayList<Compra>) QR.query(getConn(), "SELECT * FROM multum.compra where ID_Compra  =  (SELECT max(ID_Compra) FROM multum.compra)",
                     new BeanListHandler(Compra.class));//Consulta el registro de la tabla compra con el mayor número de registro 
         }catch(SQLException ex){
             Logger.getLogger(Consult.class.getName()).log(Level.SEVERE,null,ex);
         }
         return compras; //Retorna el registro como un vector. 
     }
     
    
}
