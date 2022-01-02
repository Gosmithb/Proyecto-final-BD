/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author flaco
 */
public class BajaUsuario extends javax.swing.JFrame {

    Conexion_a_servidor enlace = new Conexion_a_servidor();
    Connection connect = enlace.getConection();
    ResultSet rs;
    PreparedStatement ps;

    public BajaUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_buscar_usuario = new javax.swing.JButton();
        txt_nombre_usuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_de_usuarios = new javax.swing.JTable();
        btn_eliminar_usuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Usuario");

        jLabel1.setText("Nombre de Usuario");

        btn_buscar_usuario.setText("Buscar Usuario");
        btn_buscar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_usuarioActionPerformed(evt);
            }
        });

        tabla_de_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_de_usuarios);

        btn_eliminar_usuario.setText("Eliminar Usuario");
        btn_eliminar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_buscar_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar_usuario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(txt_nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar_usuario)
                    .addComponent(btn_buscar_usuario))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_usuarioActionPerformed
//        String SQL = "delete * from administrador where nombre_admin="+"?"; 


        if (txt_nombre_usuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todas las casillas por favor");
        } else {
            mostrarUsuarios();
            

        }

    }//GEN-LAST:event_btn_buscar_usuarioActionPerformed

    private void btn_eliminar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_usuarioActionPerformed
        int res = 0;
        String SQL = "delete * from administrador where nombre=?";
        
        try{
            ps = connect.prepareStatement(SQL);
            res = ps.executeUpdate();
            if (res>0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
            }
            
            ps=null;
            connect.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro");
        }
    }//GEN-LAST:event_btn_eliminar_usuarioActionPerformed

    public void mostrarUsuarios(){
        DefaultTableModel tabla_usuarios = new DefaultTableModel();
        //Definir columnas en tabla "tabla_de_usuarios"
        tabla_usuarios.addColumn("ID");
        tabla_usuarios.addColumn("Nombre");
        tabla_usuarios.addColumn("Telefono");
        tabla_de_usuarios.setModel(tabla_usuarios);
        
        String[] datos = new String[3];
        
        String SQL = "select * from administrador where nombre_admin=?";
            
            try {
                ps = connect.prepareStatement(SQL);
                ps.setString(1, txt_nombre_usuario.getText());
                rs = ps.executeQuery();

                //Crea columnas en la tabla para mostrar usuarios
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    tabla_usuarios.addRow(datos);
                }
                
                tabla_de_usuarios.setModel(tabla_usuarios);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la consulta" + e);
            }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(BajaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar_usuario;
    private javax.swing.JButton btn_eliminar_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_de_usuarios;
    private javax.swing.JTextField txt_nombre_usuario;
    // End of variables declaration//GEN-END:variables
}
