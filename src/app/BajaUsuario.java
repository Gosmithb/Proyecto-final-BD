/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        btn_mostrar_todo = new javax.swing.JButton();

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

            },
            new String [] {

            }
        ));
        tabla_de_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_de_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_de_usuarios);

        btn_eliminar_usuario.setText("Eliminar Usuario");
        btn_eliminar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_usuarioActionPerformed(evt);
            }
        });

        btn_mostrar_todo.setText("Mostrar Usuarios");
        btn_mostrar_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrar_todoActionPerformed(evt);
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
                        .addComponent(btn_mostrar_todo)
                        .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar_usuario)
                    .addComponent(btn_buscar_usuario)
                    .addComponent(btn_mostrar_todo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_usuarioActionPerformed

        if (txt_nombre_usuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todas las casillas por favor");
        } else {
            mostrarUsuarios("SELECT * FROM administrador WHERE nombre_admin LIKE '%" + txt_nombre_usuario.getText() + "%'");
        }

    }//GEN-LAST:event_btn_buscar_usuarioActionPerformed

    private void btn_eliminar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_usuarioActionPerformed
        eliminarUsuario();


    }//GEN-LAST:event_btn_eliminar_usuarioActionPerformed

    //No se como quitar esto
    private void tabla_de_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_de_usuariosMouseClicked
//        int fila = tabla_de_usuarios.getSelectedRow();
//        if (fila == -1) {
//            JOptionPane.showMessageDialog(null, "Seleccione una fila");
//        }else {
//            int id = (Integer)tabla_de_usuarios.getValueAt(fila, 1);
//        }
    }//GEN-LAST:event_tabla_de_usuariosMouseClicked

    //Pendiente boton mostrar todos los usuarios registrados
    private void btn_mostrar_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrar_todoActionPerformed
        mostrarUsuarios("SELECT * FROM administrador");
    }//GEN-LAST:event_btn_mostrar_todoActionPerformed

    public void mostrarUsuarios(String SQL) {

        //Definir columnas en tabla "tabla_de_usuarios"
        String[] nombresColumnas = {"ID", "Nombre", "Telefono"};
        String[] datos = new String[3];
        DefaultTableModel tabla_usuarios = new DefaultTableModel(null, nombresColumnas);
        tabla_de_usuarios.setModel(tabla_usuarios);

        try {

            ps = connect.prepareStatement(SQL);
            rs = ps.executeQuery();

            //Crea columnas en la tabla para mostrar usuarios
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                tabla_usuarios.addRow(datos);
            }

            tabla_de_usuarios.setModel(tabla_usuarios);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta" + e);
        }

    }

    private void eliminarUsuario() {
        int fila = tabla_de_usuarios.getSelectedRow();
        int id = Integer.parseInt((String) tabla_de_usuarios.getValueAt(fila, 0));
        String nombre = (String) tabla_de_usuarios.getValueAt(fila, 1);
        String telefono = (String) tabla_de_usuarios.getValueAt(fila, 2);

        try {
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            } else {
                String SQL = "DELETE FROM administrador WHERE id_admin = ?";

                ps = connect.prepareStatement(SQL);
                ps.setInt(1, id);
                int res = ps.executeUpdate();
            }

            mostrarMensajeExito(id, nombre, telefono);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario " + e.getMessage());
            System.out.println(e);
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
    private javax.swing.JButton btn_mostrar_todo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_de_usuarios;
    private javax.swing.JTextField txt_nombre_usuario;
    // End of variables declaration//GEN-END:variables

    private void mostrarMensajeExito(int _id, String _nombre, String _telefono) {
        JOptionPane.showMessageDialog(null,
                "Usuario Eliminado\n"
                + "ID:" + _id + "\n"
                + "Usuario:" + _nombre + "\n"
                + "Contraseña:" + _telefono + "\n");
    }
}
