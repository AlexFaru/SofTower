/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package ModelClases;

import Connection.Consult;
import Graphics.RenderCelda;
import Model.Cliente;
import Model.Productos;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
public class Ventas extends Consult {

    private Object[] obect,obj;
    private String sql,sql2;
    private DefaultTableModel modelo1, modelo2;
    private double importe = 0, totalPagar = 0;
    private Panel_Ventas p_v;
    Calendario cal = new Calendario(); //Clase Calendario de uso general. 
    Printy print = new Printy();//Clase Printy para imprimri recibos.

    private ArrayList<Cliente> cl = new ArrayList<>();

    public ArrayList<Productos> searchProductos(String Id_Producto) {
        //System.out.println("Hola Multum");
        productos = productos();//Inserta los registros de productos en el vector de tipo Productos
        return (ArrayList) productos().stream()//Filtra los productos de acuerdo al codigo ingresado
                .filter(t -> t.getID_Producto().equals(Id_Producto)).collect(Collectors.toList());
    }

    public DefaultTableModel getModelo() {
        return modelo1;
    }

    public void saveAux_Ventas(String Id_Producto, int funcion) {
        String importe, precios;
        int idTempo, cantidad, existencia;
        double descuento, precio, importes;

        Aux_Ventas = (ArrayList) Aux_Ventas().stream()
                .filter(t -> t.getId_Producto().equals(Id_Producto)).
                collect(Collectors.toList()); //Ingresa los registros de ventas en el vector
        productos = (ArrayList) productos().stream()
                .filter(t -> t.getID_Producto().equals(Id_Producto)).
                collect(Collectors.toList()); //Ingresa lso registros de productos en el vector
        
        precio = productos.get(0).getPrecioVenta();
        existencia = productos.get(0).getExistenciaProducto();
        if (0 < Aux_Ventas.size()) {
            cantidad = Aux_Ventas.get(0).getCantidad();
            System.out.println("Soy cantidad "+existencia);
            
            if (funcion == 0) {
                cantidad++;  //Aunmentan la cantidad de la venta
                existencia--; //Disminuyen el valor de la existencia para actaulaizar BD
                System.out.println("Menos "+ existencia);
            } else {
                cantidad--; //Disminuye la cantidad de la venta 
                existencia++; //Aunmenta el valor de la existencia para actualizar BD
                
            }
            importes = precio * cantidad-Aux_Ventas.get(0).getDescuento();
            sql = "UPDATE aux_ventas SET Id_Producto = ?, NombreProducto=?, Descripcion = ?, Precio = ?,CV = ?,"
                    + "Importe = ? WHERE IdAux =" + Aux_Ventas.get(0).getIdAux();
            obect = new Object[]{
                productos.get(0).getID_Producto(),
                productos.get(0).getNombreProducto(),
                productos.get(0).getDescripcion(),
                precio,
                cantidad,
                importes,};
            update(sql, obect); //Actualiza la cantidad del producto en la BD
        } else { //Si no existe el registro del producto en la tabla aux_ventas insertamos el producto nuevo.
            existencia--;
            sql = "INSERT INTO aux_ventas(Id_Producto,NombreProducto,Descripcion,Precio,CV,Importe)"
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
        if (existencia >= 0 && funcion == 0){ //Actualizar existencia del producto en BD
                sql = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + productos.get(0).getID_Producto();
                obect = new Object[]{
                    existencia   
                };
                update(sql, obect); //Actualiza informacion. 
        }else if(funcion == 0){
                JOptionPane.showMessageDialog(null, "No existe más "+ productos.get(0).getNombreProducto()+ " en inventario");
        }
        
    }

    public void searchVentatemp(JTable table, int num_registro, int reg_por_pagina) {
        String[] registros = new String[8];
        String[] titulos = {"IdAux", "Id_Producto", "Nombre", "Descripcion", "Precio", "Cantidad", "Importe","Descuento"};
        modelo1 = new DefaultTableModel(null, titulos);

        Aux_Ventas = (ArrayList) Aux_Ventas().stream()
                .skip(num_registro).limit(reg_por_pagina)
                .collect(Collectors.toList());//Consulta los productos en la tabla Aux_Ventas
        if (0 < Aux_Ventas.size()) {
            Aux_Ventas.forEach(item -> {
                registros[0] = String.valueOf(item.getIdAux());
                registros[1] = item.getId_Producto();
                registros[2] = item.getNombreProducto();
                registros[3] = item.getDescripcion();
                registros[4] = String.format("%32s",String.valueOf(item.getPrecio()));
                registros[5] = String.format("%32s",String.valueOf(item.getCantidad()));
                registros[6] = String.format("%32s",String.valueOf(item.getImporte()));
                registros[7] = String.format("%32s",String.valueOf(item.getDescuento()));
                modelo1.addRow(registros);
            });
        }
        table.setModel(modelo1); //Actaualiza el modelo d ela tabla.
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.setDefaultRenderer(Object.class, new RenderCelda(0));
    }

    public void importes(JLabel label, int Usuario) {
        importe = 0;
        Aux_Ventas = (ArrayList) Aux_Ventas(); //Consulta las ventas en la tabla aux_ventas.

        if (0 < Aux_Ventas.size()) {
            Aux_Ventas.forEach(item -> {
                importe += item.getImporte(); //Calcula importe total de la venta.
            });
            label.setText("" + importe); //Actualiza etiqueta con importe calculado
        } else {
            label.setText("0.00");
        }
    }

    public void deleteVenta(String codigo, int  cant, int caja) {
        int cantidad, existencia;
        Aux_Ventas = (ArrayList) Aux_Ventas().stream().
                filter(t -> t.getId_Producto().equals(codigo)).collect(Collectors.toList());
        if (0 < Aux_Ventas.size()) {
            cantidad = Aux_Ventas.get(0).getCV();
            productos = (ArrayList) productos().stream()
                    .filter(t -> t.getID_Producto().equals(codigo)).collect(Collectors.toList());
            if (0 < productos.size()) {
                existencia = productos.get(0).getExistenciaProducto();
                if (cant==1) {
                    existencia += cantidad;
                    sql = "DELETE FROM aux_ventas WHERE IdAux LIKE ?"; //Elimina el registro del producto de la tabal aux_ventas
                    delete(sql, Aux_Ventas.get(0).getIdAux());

                } else {
                    existencia++; //Aumenta en 1 la existencia del producto.
                    saveAux_Ventas(codigo, 1); // Solo decrementa en 1 la tabla aux_venta
                }
                    sql = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + 
                            productos.get(0).getID_Producto();
                    obect = new Object[]{
                        existencia
                    };
                    update(sql, obect);//Actualiza la catidad de productos. 
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is not data in deleteVentana");
        }
    }
    
    public void pagosCliente (JTextField textField, JLabel textField2, JLabel label2,JLabel label1, double saldoActual ){ 
        double pago, deuda;
       if(textField.getText().equals("")){
                label2.setText(("$0.00"));//Actualiza la eqtiqueta importe si no existe ingreso
       }else{
            pago = Double.valueOf(textField.getText());
            deuda = Double.valueOf(textField2.getText());
            if(deuda-pago<0){
                label2.setText(String.valueOf((deuda-pago)*-1));//Actualiza la etiqueta "Cambio"
                label1.setText(String.valueOf("Cambio"));
            }else
                label1.setText(String.valueOf("Pago insuficiente"));
        }
    }
    
    public void searchCliente(JTextField txt, TextAutoCompleter match){
        //TextAutoCompleter auto = new TextAutoCompleter(txt);
        //String datos [] = new String [6];
        match.removeAllItems(); // Remover todos los elementos del Autocompletador. 
        cl = clientes();//Inserta todos los clientes en el vector. 
        cl.forEach(item -> { //Agrega al autocompletador nombre e ID de los clientes 
            match.addItem(item.getNombreCliente()+ " " + item.getApellidoPaterno() + " " + String.valueOf(item.getID_Cliente()));
            match.addItem(String.valueOf(item.getID_Cliente()));
        });
    }
    
    public void updateList(TextAutoCompleter autoCompleter){
        autoCompleter.removeAllItems();//Eliminar 
        cl = clientes();//Consultar clientes.
        cl.forEach(item -> {//Agregar datos de clientes.
            autoCompleter.addItem(item.getNombreCliente() + " " + item.getApellidoPaterno() + " " + String.valueOf(item.getID_Cliente()));
            autoCompleter.addItem(String.valueOf(item.getID_Cliente()));
        });
    }
    
    public void selectCliente(String nombre,JLabel lb,JLabel lb2,JLabel lb3){
        int dato;
        
        String str ="";
        if(nombre.charAt(0)>= '0' && nombre.charAt(0)<= '9'){
           dato = Integer.valueOf(nombre.substring(0,nombre.length()-1));
        }else{
            for(int i = 0;i<nombre.length();i++){ //Limpiar el dato del autocompletador(obtener Id Cliente)
                if(nombre.charAt(i)>= '0' && nombre.charAt(i)<= '9')
                    str += nombre.charAt(i);
            }
            dato = Integer.valueOf(str);
        }
        cl = (ArrayList)clientes().stream().//Filtra el cliente por Id.
                filter(t -> t.getID_Cliente() == dato).collect(Collectors.toList());
        
        if(0 < cl.size()){ //Establecer la etiquetas del "Panel credito" con datos del cliente.
            lb.setText(String.valueOf(cl.get(0).getID_Cliente()));
            lb2.setText(cl.get(0).getNombreCliente());
            lb3.setText(String.valueOf(cl.get(0).getSaldo()));
        }else{
            System.out.println("El usuario no existe");
        }
    }
    
    public void saveVentas (double totalVenta, int ID_Cliente, int ID_Usuario){
        String fecha = cal.getFecha();
        sql = "INSERT INTO detalleVenta (ID_Cliente, ID_Usuario, FechaVenta, TotalVenta)"
            + "VALUES(?,?,?,?)"; //Comando para insertar una nueva venta. 
        obect = new Object[] {
            ID_Cliente,
            ID_Usuario,
            fecha,
            totalVenta,
        };
        if (insert(sql,obect)){ 
            JOptionPane.showMessageDialog(null,"Venta exitosa");
        }
        detalleventa = (ArrayList)maxventa().stream()
                .collect(Collectors.toList()); //Obtener el ultimo registro insertado previamente. 
        Aux_Ventas = Aux_Ventas();
        sql = "INSERT INTO venta (ID_Venta,ID_Producto,Descripcion,Precio,CantidadVenta,Importe,NombreProducto,Descuento)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
        Aux_Ventas.forEach( item ->{
           obect = new Object[]{
                        detalleventa.get(0).getID_Venta(),
                        item.getId_Producto(),
                        item.getDescripcion(),
                        item.getPrecio(),
                        item.getCantidad(),
                        item.getImporte(),
                        item.getNombreProducto(),
                        item.getDescuento(),
                    };
            insert(sql,obect); //Insertar todos los productos de Aux_ventas en ventas. 
         });
        
        
        cliente = (ArrayList) clientes().stream().
                filter(t -> t.getID_Cliente() == ID_Cliente).collect(Collectors.toList());
        if(ID_Cliente != 2){ //Actualiza el saldo del cliente si fue autorizado un credito. 
             sql = "UPDATE cliente SET  Saldo = ? WHERE ID_Cliente = " + ID_Cliente;
                    obect = new Object[]{
                        cliente.get(0).getSaldo()+totalVenta
                    };
                    update(sql, obect);
        }
    }
    
    public void cleanTable(){
        sql = "DELETE FROM aux_ventas";
        delete(sql,0);
    }
    
    public int lastSale(){
        detalleventa = (ArrayList)maxventa().stream()
                .collect(Collectors.toList());//Retorna el número de la ultima venta realizada. 
        return detalleventa.get(0).getID_Venta();
    }
    public void updateLabel(JLabel label){
        label.setText(" "+(lastSale()+1));
    }
    
    public void makeNote(String Datos[]){
        Aux_Ventas =(ArrayList) Aux_Ventas().stream().collect(Collectors.toList());
        PrinterJob pj = PrinterJob.getPrinterJob();  
        pj.setPrintable(new BillPrintable(Aux_Ventas,null,Datos,0),print.getPageFormat(pj));
        try {
             pj.print();
        }
         catch (PrinterException ex) {
        }
    }
    
    public void updateProducto(String num,int venta){
        int existencia;
        int CV;
        productos = (ArrayList)productos().stream().
                filter(t -> t.getID_Producto().equals(num)).collect(Collectors.toList());
        Aux_Ventas = (ArrayList)Aux_Ventas.stream().
                filter(t->t.getId_Producto().equals(num)).collect(Collectors.toList());
        existencia = productos.get(0).getExistenciaProducto();
        if(venta > existencia){ //Si la cantidad a aumentar en la venta es mayor que el inventario
             int response = JOptionPane.showConfirmDialog(null, "El numero ingresado es mayor que el inventario \n" +" ¿Desea continuar? \n", "Confirm",
                                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                 if(response == JOptionPane.YES_OPTION){
                     sql = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + productos.get(0).getID_Producto();
                    obect = new Object[]{
                        0
                    };
                    update(sql, obect);
                 }
        }else{ //Si la canatidad de producto a aagregar es menor que la existencia, se reliza la actualización 
             existencia = existencia-venta;
             CV=Aux_Ventas.get(0).getCV();
             CV=CV+venta;
             sql2 = sql = "UPDATE aux_ventas SET CV = ? ,"
                    + "Importe = ? WHERE IdAux =" + Aux_Ventas.get(0).getIdAux();
             sql = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " + productos.get(0).getID_Producto();
                obect = new Object[]{
                    existencia
                };
                obj = new Object[]{
                    CV,
                    CV*Aux_Ventas.get(0).getPrecio()
                };
                update(sql, obect);
                update(sql2,obj);
        }
    }
    
    public void deleteProductos(String codigo){
        int existencia;
        productos = (ArrayList)productos().stream().
                filter(t -> t.getID_Producto().equals(codigo)).collect(Collectors.toList());
        Aux_Ventas= (ArrayList) Aux_Ventas.stream().
                filter(t -> t.getId_Producto().equals(codigo)).collect(Collectors.toList());
        if(Aux_Ventas.size()>0){
            existencia = Aux_Ventas.get(0).getCV() + productos.get(0).getExistenciaProducto();
            obect = new Object[]{
                    existencia
            };
            sql2 = "UPDATE producto SET  ExistenciaProducto = ? WHERE ID_Producto = " //Comando para agregar a al existencia 
                    + productos.get(0).getID_Producto();  //los productos eliminados de la venta
            sql = "DELETE FROM aux_ventas WHERE IdAux LIKE ?";
                    update(sql2,obect); //actualiza la existencia de los productos. 
                    delete(sql, Aux_Ventas.get(0).getIdAux());//Borra los elementos de la venta. 
        }
    }
    
    public void setDescuento(String codigo,double descuento){
        Aux_Ventas= (ArrayList) Aux_Ventas.stream().
                filter(t -> t.getId_Producto().equals(codigo)).collect(Collectors.toList());
        if(Aux_Ventas.size()>0){
            sql = "UPDATE aux_ventas SET Importe = ?, Descuento = ? WHERE Id_Producto ="+codigo;
              obect = new Object[]{
                 Aux_Ventas.get(0).getImporte()-descuento,
                 descuento
            };
            update(sql,obect);
        }
        
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
