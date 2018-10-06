/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE
 */
public class Conexion {
    private String db = "multum";
    private String user = "root";
    private String password = "Combinatoria7";
    private String extra = "?autoReconnect=true&useSSL=false";
    private String url ="jdbc:mysql://localhost:3306/"+db+extra;
    private Connection conn = null;

    public Conexion() {
        try {
            //Obtener el driver de para mySQL
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexion
            conn = DriverManager.getConnection(this.url, this.user,this.password);
            if(conn != null){
                System.out.println("Conexion con base de datos"+ db + "...Listo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar a la base de datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public Connection getConn(){
       return conn;
    }

    
    
    
    
    /**
     * Regresa:
     * 0 -> El login ha sido correcto
     * 1 -> No se ha encontrado al usuario en la BD
     * 2 -> Falló BD
     */ 
    public int login(String user, String password) {
        String qu = "SELECT * FROM usuario WHERE Login = '"+user+
                    "' AND Contrasena = '"+password+"'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qu);
            
            return rs.next()?0:1;
            
        } catch(SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return 2;
        } finally {
            try {
                conn.close();
            } catch(SQLException e){
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }            
        }
    }
    
    /**
     * Regresa:
     * 0 -> Operación correctamente
     * 1 -> No se ha podido completar operación
     * 2 -> Falló BD
     */ 
    public int execute(String query) {
        Statement st;
        try {
            st = conn.createStatement();
        } catch(SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return 2;
        }
        
        try {            
            st.executeUpdate(query);
            return 0;
        } catch(SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        } finally {
            try {
                conn.close();
            } catch(SQLException e){
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }  
        }     
    }
    
    public String[][] select(String query) {
        Statement st;
        
        try {
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                               ResultSet.CONCUR_READ_ONLY);
        }catch(SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        try {     
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.last();
            
            String data[][] = new String[rs.getRow()][rsmd.getColumnCount()];
            
            rs.beforeFirst();
            for (int i = 0; i < data.length; i++) {
                rs.next();
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = rs.getString(j+1);
                }
            }
            
            for (int i=0; i<data.length; i++) {
                for (int j=0; j<data[i].length; j++) {
                    System.out.print(data[i][j]+" ");
                }
                System.out.println();
            }
            
            return data;
        }catch(SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
     
    
    
}











