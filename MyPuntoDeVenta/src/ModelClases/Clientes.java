/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClases;
import Model.Cliente;
import Connection.Consult;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSE
 */
public class Clientes extends Consult {
    //private Consult consult = new Consult();
    private DefaultTableModel modelo;
    private ArrayList<Cliente> cliente,clienteFilter,consultCliente;
    private int IdCliente;
    private String Id;
    private String sql;
    private Object[] obj;
    Printy print = new Printy();
    public Clientes() {
        print = new Printy();
    }
    
    public void insertCliente(String NombreCliente, String ApellidoPaterno,String ApellidoMaterno,  String TelefonoCliente,
                    String Celular,String Telefono2, double Saldo,String RFC, String CP, String Ciudad,String Colonia,String Calle, String Numero_Dom ){
        sql = "INSERT INTO cliente(NombreCliente,ApellidoPaterno,ApellidoMaterno,TelefonoCliente,Celular,Telefono2,Saldo,RFC,CP,Ciudad,Colonia,Calle,Numero_Dom)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Comando para insertar en BD variable ingresadas por parametro
        obj = new Object[]{NombreCliente, ApellidoPaterno, ApellidoMaterno, TelefonoCliente, Celular, Telefono2, Saldo,
        RFC, CP, Ciudad, Colonia, Calle, Numero_Dom}; //Datos insertatdos 
        cliente = clientes(); //Se almacena en el arreglo clientes todos los clientes en la BD 
        insert(sql,obj); //Funcion que inserta en la BD. 
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes();
    }
    public void searchCliente(JTable table, String campo, int num_registro,int reg_por_pagina){
        String[] registros =new String[4];
        String[] titulos ={"Id_Cliente","Nombre","ApellidoPaterno","Saldo"};
        modelo = new DefaultTableModel (null, titulos);
        cliente = clientes();
        if(campo.equals("")){
            clienteFilter = (ArrayList)cliente.stream()
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }else{
            clienteFilter = (ArrayList)cliente.stream()
                    .filter(C -> C.getNombreCliente().startsWith(campo) || 
                            C.getApellidoPaterno().startsWith(campo))
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }
        
        clienteFilter.forEach(item ->{
                registros[0] = String.valueOf(item.getID_Cliente());
                registros[1] = item.getNombreCliente();
                registros[2] = item.getApellidoPaterno();
                registros[3] = String.valueOf(item.getSaldo());
                modelo.addRow(registros);
        });
        table.setModel(modelo);
        table.setRowHeight(50);
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
    
    
    public String[] consultCliente(int ID_Cliente){
        String [] consulta = new String[14]; 
        consultCliente = conCliente(ID_Cliente);
        consultCliente.forEach(item ->{
            consulta[0] = String.valueOf(item.getID_Cliente());
            consulta[1] = item.getNombreCliente();
            consulta[2] = item.getApellidoPaterno();
            consulta[3] = item.getApellidoMaterno();
            consulta[4] = item.getTelefonoCliente();
            consulta[5] = item.getCelular();
            consulta[6] = item.getTelefono2();
            consulta[7] = String.valueOf(item.getSaldo());
            consulta[8] = item.getRFC();
            consulta[9] = item.getCP();
            consulta[10] = item.getCiudad();
            consulta[11] = item.getColonia();
            consulta[12] = item.getCalle();
            consulta[13] = item.getNumero_Dom();
        });
        
        return consulta;
    }
    
    public void updateCliente(int ID_Cliente, String NombreCliente, String ApellidoPaterno,
            String ApellidoMaterno, String Telefono, String Celular, String Telfono2,
            String RFC, String CP, String Ciudad,String Colonia,String Calle,String Numero){
        sql = "UPDATE cliente SET NombreCliente = ?,ApellidoPaterno = ?,ApellidoMaterno = ?,TelefonoCliente = ?,"
                + "Celular = ?,Telefono2 = ?,RFC = ?,CP = ?,Ciudad = ?,Colonia = ?,Calle = ?,Numero_Dom = ?"
                + "WHERE ID_Cliente = " + ID_Cliente;
        Object[] cliente = new Object [] {NombreCliente, ApellidoPaterno, ApellidoMaterno,
        Telefono, Celular,Telefono, RFC, CP, Ciudad, Colonia, Calle, Numero};
        update(sql, cliente);
    }
    public void deleteCliente(int idCliente){
        sql = "DELETE FROM cliente WHERE ID_Cliente LIKE ?";
        delete(sql, idCliente);
    }
    
    public void updateReportes(int ID_Cliente, int Id_Usuario, String fecha,double pago, double DeudaAnterior, double DeudaActual ){
        sql = "INSERT INTO pago (ID_Cliente, ID_Usuario,"
                + "FechaPago,Monto,SaldoAnterior, SaldoActual) "
                + "VALUES(?,?,?,?,?,?)";
         Object[] obj = new Object[]{ID_Cliente,Id_Usuario,fecha, pago,DeudaAnterior,DeudaActual};
        insert(sql,obj);
    }
    public void updatePago(double deudaFinal, int ID_Cliente){
        sql = "UPDATE cliente SET Saldo = ? WHERE ID_Cliente =" + ID_Cliente;
        Object[] obj = new Object[]{deudaFinal};
        update(sql,obj);
    }
    
    public void makeNote(double[] Pagos,String [] Datos){
        PrinterJob pj = PrinterJob.getPrinterJob();  
        pj.setPrintable(new BillPrintable(Aux_Ventas,Pagos,Datos,1),print.getPageFormat(pj));
        try {
             pj.print();
        }
         catch (PrinterException ex) {
             ex.printStackTrace();
        }
    }
    
}
