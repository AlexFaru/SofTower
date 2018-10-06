/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameAux;

import ModelClases.Producto;
import ModelClases.TextFieldEvent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    TextFieldEvent eve;
    Producto pro;
    public Product() {
        initComponents();
        eve = new TextFieldEvent();
        pro = new Producto();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void setFields(){
        jTextField_IdProducto.setText("");
        jTextField_NombreProducto.setText("");
        jTextField_Descripcion.setText("");
        jTextField_Cantidad.setText("");
        jTextField_Venta.setText("");
        jTextField_Compra.setText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_IdProducto = new javax.swing.JTextField();
        jTextField_NombreProducto = new javax.swing.JTextField();
        jTextField_Descripcion = new javax.swing.JTextField();
        jTextField_Cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JComboBoxTipo = new javax.swing.JComboBox<>();
        JComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel_Tipo = new javax.swing.JLabel();
        jLabel_Categoria = new javax.swing.JLabel();
        jComboBox_Dia = new javax.swing.JComboBox<>();
        jComboBox_Ano = new javax.swing.JComboBox<>();
        jComboBox_Mes = new javax.swing.JComboBox<>();
        jLabel_Fecha = new javax.swing.JLabel();
        jTextField_Venta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_Compra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Id_Producto");

        jTextField_IdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IdProductoKeyTyped(evt);
            }
        });

        jTextField_NombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NombreProductoKeyTyped(evt);
            }
        });

        jTextField_Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DescripcionKeyTyped(evt);
            }
        });

        jTextField_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CantidadActionPerformed(evt);
            }
        });
        jTextField_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CantidadKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Descripción");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad");

        JComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo1 ", "Tipo2", "Tipo3" }));
        JComboBoxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JComboBoxTipoItemStateChanged(evt);
            }
        });
        JComboBoxTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JComboBoxTipoMouseClicked(evt);
            }
        });
        JComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxTipoActionPerformed(evt);
            }
        });
        JComboBoxTipo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JComboBoxTipoPropertyChange(evt);
            }
        });

        JComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comestible ", "Vinos ", " ", " " }));
        JComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JComboBoxCategoriaItemStateChanged(evt);
            }
        });
        JComboBoxCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JComboBoxCategoriaMouseClicked(evt);
            }
        });
        JComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxCategoriaActionPerformed(evt);
            }
        });
        JComboBoxCategoria.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JComboBoxCategoriaPropertyChange(evt);
            }
        });

        jLabel_Tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Tipo.setText("Tipo");

        jLabel_Categoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Categoria.setText("Categoria");

        jComboBox_Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));

        jComboBox_Ano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));

        jComboBox_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel_Fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Fecha.setText("Fecha de caducidad: ");

        jTextField_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_VentaActionPerformed(evt);
            }
        });
        jTextField_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_VentaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Precio venta:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Precio compra:");

        jTextField_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CompraActionPerformed(evt);
            }
        });
        jTextField_Compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CompraKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Tipo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_Mes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jTextField_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_Categoria)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel6)
                                                .addComponent(jTextField_NombreProducto)
                                                .addComponent(jLabel4)
                                                .addComponent(jTextField_Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jTextField_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(JComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jComboBox_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel_Fecha)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_NombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Tipo)
                    .addComponent(jLabel_Categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel_Fecha)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CantidadActionPerformed

    private void JComboBoxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JComboBoxTipoItemStateChanged
        // TODO add your handling code here:
        if(JComboBoxTipo.getSelectedItem()!=null) {
            if(JComboBoxTipo.getSelectedItem().equals("Agregar tipo...")) {
                String aux = JOptionPane.showInputDialog("Nuevo tipo:");
                String tipo = "Agregar tipo...";
                JComboBoxTipo.removeItem(tipo);
                JComboBoxTipo.addItem(aux);
                JComboBoxTipo.addItem(tipo);
                JComboBoxTipo.setSelectedItem(aux);
            }
        }
    }//GEN-LAST:event_JComboBoxTipoItemStateChanged

    private void JComboBoxTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JComboBoxTipoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxTipoMouseClicked

    private void JComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxTipoActionPerformed

    private void JComboBoxTipoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JComboBoxTipoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxTipoPropertyChange

    private void JComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JComboBoxCategoriaItemStateChanged
        // TODO add your handling code here
        if(JComboBoxCategoria.getSelectedItem()!=null) {
            if(JComboBoxCategoria.getSelectedItem().equals("Agregar categoria...")) {
                String aux = JOptionPane.showInputDialog("Nuevo categoria:");
                String tipo = "Agregar categoria...";
                JComboBoxCategoria.removeItem(tipo);
                JComboBoxCategoria.addItem(aux);
                JComboBoxCategoria.addItem(tipo);
                JComboBoxCategoria.setSelectedItem(aux);
            }
        }
    }//GEN-LAST:event_JComboBoxCategoriaItemStateChanged

    private void JComboBoxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JComboBoxCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxCategoriaMouseClicked

    private void JComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxCategoriaActionPerformed

    private void JComboBoxCategoriaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JComboBoxCategoriaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxCategoriaPropertyChange

    private void jTextField_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_VentaActionPerformed

    private void jTextField_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CompraActionPerformed

    private void jTextField_IdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IdProductoKeyTyped
        eve.numberKeyPress(evt, jTextField_IdProducto,12);
    }//GEN-LAST:event_jTextField_IdProductoKeyTyped

    private void jTextField_NombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NombreProductoKeyTyped
        eve.nameKeyPress(evt, jTextField_NombreProducto,20);
    }//GEN-LAST:event_jTextField_NombreProductoKeyTyped

    private void jTextField_DescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescripcionKeyTyped
        eve.name_numKeyPress(evt, jTextField_Descripcion,30);
    }//GEN-LAST:event_jTextField_DescripcionKeyTyped

    private void jTextField_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadKeyTyped
        eve.numberKeyPress(evt,jTextField_Cantidad,10);
    }//GEN-LAST:event_jTextField_CantidadKeyTyped

    private void jTextField_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_VentaKeyTyped
        eve.numberDecimalKeyPress(evt,jTextField_Venta);
    }//GEN-LAST:event_jTextField_VentaKeyTyped

    private void jTextField_CompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CompraKeyTyped
        eve.numberDecimalKeyPress(evt, jTextField_Compra);
    }//GEN-LAST:event_jTextField_CompraKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        saveInfo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void saveInfo(){
        if(jTextField_IdProducto.getText().equals("") || jTextField_IdProducto.getText().length()<12){
                jTextField_IdProducto.requestFocus();
        }else{
            if(jTextField_NombreProducto.getText().equals("")){
                jTextField_NombreProducto.requestFocus();
            }else{
                if(jTextField_Descripcion.getText().equals("")){
                    jTextField_Descripcion.requestFocus();
                }else{
                    if(jTextField_Cantidad.getText().equals("")){
                    
                    }else{
                        if(JComboBoxCategoria.getSelectedItem()==null){
                            jLabel_Tipo.setText("Seleccione");
                            jLabel_Tipo.setForeground(Color.RED);
                        }else{
                            if(JComboBoxCategoria.getSelectedItem()==null){
                                jLabel_Categoria.setText("Seleccione");
                                jLabel_Categoria.setForeground(Color.red);
                            }else{
                                if(jComboBox_Dia.getSelectedItem()==null){
                                    jLabel_Fecha.setText("Selecciona un dia");
                                    jLabel_Fecha.setForeground(Color.red);
                                }else{
                                    if(jComboBox_Mes.getSelectedItem()==null){
                                        jLabel_Fecha.setText("Selecciona el mes");
                                        jLabel_Fecha.setForeground(Color.red);
                                    }else{
                                        if(jComboBox_Ano.getSelectedItem()==null){
                                            jLabel_Fecha.setText("Seleccione el año");
                                            jLabel_Fecha.setForeground(Color.red);
                                        }else{
                                           if(jTextField_Venta.getText().equals("")){
                                               jTextField_Venta.requestFocus();
                                           }else{
                                               if(jTextField_Compra.getText().equals("")){
                                                   jTextField_Venta.requestFocus();
                                               }else{
                                                   String Fecha = (String) jComboBox_Ano.getSelectedItem()+"/" +jComboBox_Mes.getSelectedItem() +"/"+jComboBox_Dia.getSelectedItem();
                                                   pro.updateProducto(jTextField_IdProducto.getText(), jTextField_NombreProducto.getText(), jTextField_Descripcion.getText(), 
                                                           Integer.valueOf(jTextField_Cantidad.getText()),(String)JComboBoxCategoria.getSelectedItem() , (String)JComboBoxCategoria.getSelectedItem(),
                                                           Fecha, Double.valueOf(jTextField_Venta.getText()), Double.valueOf(jTextField_Compra.getText()));
                                               }
                                           }
                                        }  
                                    }
                                }  
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBoxCategoria;
    private javax.swing.JComboBox<String> JComboBoxTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_Ano;
    private javax.swing.JComboBox<String> jComboBox_Dia;
    private javax.swing.JComboBox<String> jComboBox_Mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Categoria;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_Tipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_Cantidad;
    private javax.swing.JTextField jTextField_Compra;
    private javax.swing.JTextField jTextField_Descripcion;
    private javax.swing.JTextField jTextField_IdProducto;
    private javax.swing.JTextField jTextField_NombreProducto;
    private javax.swing.JTextField jTextField_Venta;
    // End of variables declaration//GEN-END:variables
}