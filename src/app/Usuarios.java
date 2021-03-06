
package app;

public class Usuarios extends javax.swing.JInternalFrame {

    public Usuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btn_ventana_crear_usuario = new javax.swing.JButton();
        btn_ventana_eliminar_usuario = new javax.swing.JButton();

        setClosable(true);
        setTitle("Usuarios");

        btn_ventana_crear_usuario.setText("Crear Usuario");
        btn_ventana_crear_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventana_crear_usuarioActionPerformed(evt);
            }
        });

        btn_ventana_eliminar_usuario.setText("Eliminar Usuario");
        btn_ventana_eliminar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventana_eliminar_usuarioActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btn_ventana_crear_usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_ventana_eliminar_usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ventana_eliminar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ventana_crear_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btn_ventana_crear_usuario)
                .addGap(35, 35, 35)
                .addComponent(btn_ventana_eliminar_usuario)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ventana_crear_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventana_crear_usuarioActionPerformed
        ventanaCrear();
    }//GEN-LAST:event_btn_ventana_crear_usuarioActionPerformed

    private void btn_ventana_eliminar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventana_eliminar_usuarioActionPerformed
        ventanaEliminar();
    }//GEN-LAST:event_btn_ventana_eliminar_usuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ventana_crear_usuario;
    private javax.swing.JButton btn_ventana_eliminar_usuario;
    private javax.swing.JDesktopPane jDesktopPane1;
    // End of variables declaration//GEN-END:variables

    private void ventanaEliminar() {
        BajaUsuario obj = new BajaUsuario();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        this.dispose();
    }

    private void ventanaCrear() {
        AltaUsuario obj = new AltaUsuario();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        this.dispose();
    }

}
