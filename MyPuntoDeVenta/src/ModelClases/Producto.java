/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;

import Connection.Consult;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE
 */
public class Producto extends Consult{
    String sql;
    Object [] obj;
   
    public void updateProducto(String id_Producto, String NombreProducto, String Descripcion, 
            int Existencia, String Categoria,String tipo, String Fecha,double PrecioProducto, double PrecioVenta){
        
        sql =" INSERT INTO producto (ID_Producto, NombreProducto, Descripcion,ExistenciaProducto,Categoria,TipoProducto,FechaCaducidad,PrecioProducto, PrecioVenta)"+
                "VALUES(?,?,?,?,?,?,?,?,?)";
        obj = new Object[]{id_Producto, NombreProducto, Descripcion , Existencia, Categoria, tipo , Fecha,
        PrecioProducto, PrecioVenta};
        boolean flag = insert(sql,obj);
        if(flag){
            JOptionPane.showMessageDialog(null,"Producto Agregado");
        }
    }
}
