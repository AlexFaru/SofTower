/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;

import Connection.Consult;
import Graphics.RenderCelda;
import Model.Productos;
import Model.Proveedores;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mypuntodeventa.Panel_Ventas;

/**
 *
 * @author JOSE
 */
public class Compras extends Consult {
    
    private Object[] obect,obj;
    private String sql,sql2;
    private DefaultTableModel modelo1, modelo2;
    private double importe = 0, totalPagar = 0;
    private Panel_Ventas p_v;
    private Calendario cal;
    private String ID_Producto="";
    private ArrayList<Proveedores> cl = new ArrayList<>();
    private Format format;

    public Compras() {
        this.cal = new Calendario();
        format = new Format();
    }

    public ArrayList<Productos> searchProductos(String Id_Producto) {
        //System.out.println("Hola Multum");
        productos = productos();
        return (ArrayList) productos().stream() //Retorna el registro filtrado en un arreglo
                .filter(t -> t.getID_Producto().equals(Id_Producto)).collect(Collectors.toList());
    }

    public DefaultTableModel getModelo() {
        return modelo1;
    }

    public void saveAux_Compras(String Id_Producto, int funcion) { //Funcion que almacena Aux_Compras
        String importe, precios;
        int idTempo, cantidad, existencia;
        double descuento, precio, importes;

        Aux_Compras = (ArrayList) Aux_Compras().stream()
                .filter(t -> t.getId_Producto().equals(Id_Producto)).collect(Collectors.toList());
        productos = (ArrayList) productos().stream()
                .filter(t -> t.getID_Producto().equals(Id_Producto)).collect(Collectors.toList());
        
        precio = productos.get(0).getPrecioProducto();
      
        if (0 < Aux_Compras.size()) { // Aumenta en 1 la cantidad de producto en la compra (aux_compra)
            cantidad = Aux_Compras.get(0).getCantidad();
            if (funcion == 0) {
                cantidad++;     
            } else {
                cantidad--;
            }
            importes = precio * cantidad;
            sql = "UPDATE aux_compras SET Id_Producto = ?, NombreProducto=?, Descripcion = ?, Precio = ?,Cantidad = ?,"
                    + "Importe = ? WHERE IDAux_Compras =" + Aux_Compras.get(0).getIDAux_Compras();
            obect = new Object[]{
                productos.get(0).getID_Producto(),
                productos.get(0).getNombreProducto(),
                productos.get(0).getDescripcion(),
                precio,
                cantidad,
                importes,};
            update(sql, obect);
        } else { // Si el producto no existe en la compra es insertado. 
            sql = "INSERT INTO aux_compras(Id_Producto,NombreProducto,Descripcion,Precio,Cantidad,Importe)"
                    + "VALUES(?,?,?,?,?,?)";
            obect = new Object[]{
                productos.get(0).getID_Producto(),
                productos.get(0).getNombreProducto(),
                productos.get(0).getDescripcion(),
                precio,
                1,
                precio,};
            insert(sql, obect);
        }
        /*if (existencia >= 0 && funcion == 0){
                sql = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + productos.get(0).getID_Producto();
                obect = new Object[]{
                    existencia
                };
                update(sql, obect);
        }else if(funcion == 0){
                JOptionPane.showMessageDialog(null, "No existe más "+ productos.get(0).getNombreProducto()+ " en inventario");
        }*/
        
    }

    public void searchCompratemp(JTable table, int num_registro, int reg_por_pagina) {
        String[] registros = new String[7];
        String[] titulos = {"IdAux", "Id_Producto", "Nombre", "Descripcion", "Precio", "Cantidad", "Importe"};
        modelo1 = new DefaultTableModel(null, titulos);

        Aux_Compras = (ArrayList) Aux_Compras().stream()
                .skip(num_registro).limit(reg_por_pagina)
                .collect(Collectors.toList()); //Inserta en el vector los registros de la compra(aux_compras).
        if (0 < Aux_Compras.size()) { //Insertar en el modelo de tabla los datos consultados. 
            Aux_Compras.forEach(item -> {
                registros[0] = String.valueOf(item.getIDAux_Compras());
                registros[1] = item.getId_Producto();
                registros[2] = item.getNombreProducto();
                registros[3] = item.getDescripcion();
                registros[4] = String.format("%36s",String.valueOf(item.getPrecio()));
                registros[5] = String.format("%36s",String.valueOf(item.getCantidad()));
                registros[6] = String.format("%36s",String.valueOf(item.getImporte()));
                modelo1.addRow(registros);
            });
        }
        table.setModel(modelo1); //Ingresa en la tabla el modelo actualizado
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.setDefaultRenderer(Object.class, new RenderCelda(0)); 
    }

    public void importes(JLabel label, int Usuario) {
        importe = 0;
        Aux_Compras = (ArrayList) Aux_Compras();
        //Inserta los registros de compras en el vector. 
        if (0 < Aux_Compras.size()) { //Calcula el importe de la compra.
            Aux_Compras.forEach(item -> {
                importe += item.getImporte();
            });
            format.decimalFormat(importe);
            label.setText("" + importe); //Actualiza la etiqueta de importe. 
        } else {
            label.setText("0.00");
        }
    }

    public void deleteCompra(String codigo, int cant, int caja) {
        int cantidad, existencia;
        Aux_Compras = (ArrayList) Aux_Compras().stream().
                filter(t -> t.getId_Producto().equals(codigo)).collect(Collectors.toList());
        if (0 < Aux_Compras.size()) {
            cantidad = Aux_Compras.get(0).getCantidad();
            productos = (ArrayList) productos().stream()
                    .filter(t -> t.getID_Producto().equals(codigo)).collect(Collectors.toList());
            if (0 < productos.size()) {
                //existencia = productos.get(0).getExistenciaProducto();
                if (cant == 1) { //Si la cantidad es 1 en la compra, el producto es eliminado de tabla. 
                    //existencia += cantidad;
                    sql = "DELETE FROM aux_compras WHERE IDAux_Compras LIKE ?";
                    delete(sql, Aux_Compras.get(0).getIDAux_Compras());

                } else {
                    //existencia++;
                    saveAux_Compras(codigo, 9);//Se decrementa en 1 si la cantidad en la compra es mayor 1. 
                }
                   /* sql = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + productos.get(0).getID_Producto();
                    obect = new Object[]{
                        existencia
                    };
                    update(sql, obect);*/
            }
        }else{
            JOptionPane.showMessageDialog(null, "There is not data in deleteVentana");
        }
    }
    
    public void pagosCliente (JTextField textField, JLabel textField2, JLabel label2,JLabel label1, double saldoActual ){ 
        double pago, deuda;
       if(textField.getText().equals("")){
                label2.setText(("$0.00"));
       }else{
            pago = Double.valueOf(textField.getText());
            deuda = Double.valueOf(textField2.getText());
            if(deuda-pago<0){ 
                label2.setText(String.valueOf((deuda-pago)*-1));
                //Actualiza los campos relacionados a los pagos. 
                label1.setText(String.valueOf("Cambio"));
            }else{
                label1.setText(String.valueOf("Pago insuficiente"));
                label2.setText("$0.00");
            }
        }
    }
    
    public void searchCliente(JTextField txt, TextAutoCompleter match){
        match.removeAllItems();//Vaciar los registros.
        cl = proveedores(); //Consultar registros de proveedores.
        cl.forEach(item -> { //Ingresa en los registros los datos de losp proveedores
            match.addItem(item.getNombreProveedor()+ " " + String.valueOf(item.getID_Proveedor()));
            match.addItem(String.valueOf(item.getID_Proveedor()));//Se ingresa nombre mas ID para evitar ambigüedad.
        });
    }
    
    public void updateList(TextAutoCompleter autoCompleter){
        autoCompleter.removeAllItems();
        cl = proveedores();
        cl.forEach(item -> {
            autoCompleter.addItem(item.getNombreProveedor() + " " + String.valueOf(item.getID_Proveedor()));
            autoCompleter.addItem(String.valueOf(item.getID_Proveedor()));
        });
    }
    
    public void selectCliente(String nombre,JLabel lb,JLabel lb2,JLabel lb3){
        int dato;
        
        String str ="";
        if(nombre.charAt(0)>= '0' && nombre.charAt(0)<= '9'){
           dato = Integer.valueOf(nombre.substring(0,nombre.length()-1));
        }else{
            for(int i = 0;i<nombre.length();i++){ //Limpiar el dato del autocompletador(obtener Id Proveedor).
                if(nombre.charAt(i)>= '0' && nombre.charAt(i)<= '9')
                    str += nombre.charAt(i);
            }
            dato = Integer.valueOf(str);
        }
        cl = (ArrayList)proveedores.stream().//Filtra el proveedor por Id.
                filter(t -> t.getID_Proveedor() == dato).collect(Collectors.toList());
        
        if(0 < cl.size()){ //Establecer la etiquetas del "Panel crédito" con datos del proveedor.
            lb.setText(String.valueOf(cl.get(0).getID_Proveedor()));
            lb2.setText(cl.get(0).getNombreProveedor());
            lb3.setText(String.valueOf(cl.get(0).getDeuda()));
        }else{
            System.out.println("El usuario no existe");
        }
    }
    
    public void saveCompra (double totalCompra, int ID_Proveedor, int ID_Usuario){
        String fecha = cal.getFecha();
        detallecompra = (ArrayList)maxcompra().stream()
                .collect(Collectors.toList());
        sql = "INSERT INTO detallecompra (ID_Usuario, ID_Proveedor, FechaCompra, TotalCompra)"
            + "VALUES(?,?,?,?)";
        obect = new Object[] {
            ID_Usuario,
            ID_Proveedor,
            fecha,
            totalCompra,
        };
        if (insert(sql,obect)){ //Insertar el detalle de la compra. 
            JOptionPane.showMessageDialog(null,"Compra exitosa");
        }
        detallecompra = (ArrayList)maxcompra().stream()
                .collect(Collectors.toList());//Obtener el registro de la ultima venta.
        Aux_Compras = Aux_Compras();//Insertar en el vector todos los registros de la compra
        compras = (ArrayList)maxCompra().stream()
                .collect(Collectors.toList());
        sql = "INSERT INTO compra (ID_Compra,ID_Producto,NombreProducto,Descripcion,Precio,CantidadCompra,Importe)"
                    + "VALUES(?,?,?,?,?,?,?)";
        
        Aux_Compras.forEach( item ->{
            ID_Producto = item.getId_Producto(); 
            productos = (ArrayList) productos().stream(). //Inserta el registro del producto filtrado. 
                    filter(t -> t.getID_Producto().equals(ID_Producto)).collect(Collectors.toList());
           obect = new Object[]{
                        detallecompra.get(0).getID_Compra(),
                        item.getId_Producto(),
                        item.getNombreProducto(),
                        item.getDescripcion(),
                        item.getPrecio(),
                        item.getCantidad(),
                        item.getImporte(),
                    };
           obj = new Object[]{
               productos.get(0).getExistenciaProducto()+item.getCantidad() //Actualiza existencia del producto
           };
            update("UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + ID_Producto,obj);
            insert(sql,obect); // Insertar compra en la tabla compras de la BD. 
         });
        
        
        proveedores = (ArrayList) proveedores().stream().
                filter(t -> t.getID_Proveedor() == ID_Proveedor).collect(Collectors.toList());
        if(ID_Proveedor != 10){
             sql = "UPDATE proveedor SET  Deuda = ? WHERE ID_Proveedor = " + ID_Proveedor;
                    obect = new Object[]{
                        proveedores.get(0).getDeuda() + totalCompra,
                    };
                    update(sql, obect);
        }
    }
    
    public void cleanTable(){
        sql = "DELETE FROM aux_compras";//Eliminar todos los regsitros de la tabla
        delete(sql,0);
    }
    
    public int lastSale(){
        detalleventa = (ArrayList)maxcompra().stream()
                .collect(Collectors.toList());
        return detalleventa.get(0).getID_Venta();//Retorna Id de la última compra
    }
    
    public void updateProducto(String num,int venta){
        int CV;
        Aux_Compras = (ArrayList)Aux_Compras.stream().
                filter(t->t.getId_Producto().equals(num)).collect(Collectors.toList());
             
             CV=Aux_Compras.get(0).getCantidad();
             CV=CV+venta;//Agrega una cantidad a al ya existente en la compra 
             sql2  = "UPDATE aux_compras SET Cantidad = ? ,"
                    + "Importe = ? WHERE IDAux_Compras =" + Aux_Compras.get(0).getIDAux_Compras();
                obj = new Object[]{
                    CV, 
                    CV*Aux_Compras.get(0).getPrecio()//Actualiza el importe de la compra. 
                };
                
                update(sql2,obj);//Actualiza el importe de la venta. 
    }
    
    public void cancelCompra(String num,int venta){
        int CV;
        Aux_Compras = (ArrayList)Aux_Compras.stream().
                filter(t->t.getId_Producto().equals(num)).collect(Collectors.toList());
             
             CV=Aux_Compras.get(0).getCantidad();
             CV=CV+venta;
             sql2  = "UPDATE aux_compras SET Cantidad = ? ,"
                    + "Importe = ? WHERE IDAux_Compras =" + Aux_Compras.get(0).getIDAux_Compras();
                obj = new Object[]{
                    CV,
                    CV*Aux_Compras.get(0).getPrecio()
                };
                
                update(sql2,obj);
    }
    
    public void deleteProductos(String codigo){
        
        Aux_Compras= (ArrayList) Aux_Compras.stream().
                filter(t -> t.getId_Producto().equals(codigo)).collect(Collectors.toList());
        
            
            sql = "DELETE FROM aux_compras WHERE IDAux_Compras LIKE ?";
                    delete(sql, Aux_Compras.get(0).getIDAux_Compras());
        
    }
    
    public String clean(String str){
        int i = str.length()-1;
        StringBuilder nueva = new StringBuilder();
        while(str.charAt(i)<='9'&&str.charAt(i)>='1'){
            nueva.append(str.charAt(i));
            i--;
        }
        return nueva.reverse().toString();
    }
    
    
}
