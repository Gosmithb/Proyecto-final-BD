/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author flaco
 */
public class Prestamos_app extends javax.swing.JFrame {

    public Prestamos_app() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ventana_conectar = new javax.swing.JMenuItem();
        ventana_login = new javax.swing.JMenuItem();
        ventana_usuarios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setName("fds"); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        ventana_conectar.setText("Conectar a servidor");
        ventana_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana_conectarActionPerformed(evt);
            }
        });
        jMenu1.add(ventana_conectar);

        ventana_login.setText("Login");
        ventana_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana_loginActionPerformed(evt);
            }
        });
        jMenu1.add(ventana_login);

        ventana_usuarios.setText("Usuarios");
        ventana_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana_usuariosActionPerformed(evt);
            }
        });
        jMenu1.add(ventana_usuarios);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Ventana para conectar a la base de datos
    private void ventana_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventana_conectarActionPerformed
        ventanaConectar();
    }//GEN-LAST:event_ventana_conectarActionPerformed

    //Ventana para acceder con usuario de administrador
    private void ventana_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventana_loginActionPerformed
        ventanaLogin();
    }//GEN-LAST:event_ventana_loginActionPerformed

    //Ventana para altas y bajas de cuentas administrador
    private void ventana_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventana_usuariosActionPerformed
        ventanaUsuarios();
    }//GEN-LAST:event_ventana_usuariosActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamos_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos_app().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem ventana_conectar;
    private javax.swing.JMenuItem ventana_login;
    private javax.swing.JMenuItem ventana_usuarios;
    // End of variables declaration//GEN-END:variables

    private void ventanaLogin() {
        Login obj = new Login();
        escritorio.add(obj);
        obj.show();
    }

    private void ventanaUsuarios() {
        Usuarios obj = new Usuarios();
        escritorio.add(obj);
        obj.show();
    }

    private void ventanaConectar() {
        Conexion_a_servidor obj = new Conexion_a_servidor();
        escritorio.add(obj);
        obj.show();
    }

}
