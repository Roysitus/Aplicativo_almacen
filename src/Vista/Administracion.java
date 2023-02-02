package Vista;

import Array.ArrayCuentas;
import User_Admin.*;
import dao.clases.administradorCAD;
import dao.clases.usuarioCAD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Administracion extends javax.swing.JFrame {

    ArrayCuentas ac = new ArrayCuentas();
    String clave;
    administradorCAD cad_administrador = new administradorCAD();
    usuarioCAD cad_usuario = new usuarioCAD();

    public Administracion() {
        initComponents();
        muestra_administradores();
        muestra_usuarios();
    }

    void muestra_usuarios() {
        DefaultTableModel dt = (DefaultTableModel) tablaUser.getModel();
        dt.setRowCount(0);
        for (Usuario p : cad_usuario.obtener()) {
            Object v[] = {p.getUser(), p.getContraseña(), p.getNombre(), p.getApellido()};
            dt.addRow(v);
        }
    }

    void muestra_administradores() {
        DefaultTableModel dt = (DefaultTableModel) tablaAdmin.getModel();
        dt.setRowCount(0);
        for (Administrador p : cad_administrador.obtener()) {
            Object v[] = {p.getAdmin(), p.getContraseña(), p.getNombre(), p.getApellido()};
            dt.addRow(v);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAdmin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUser = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administracion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        btnLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        tablaAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Admin", "Contraseña", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(tablaAdmin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 460, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Cuentas de Administradores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 450, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cuentas de Usuarios");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 450, -1));

        tablaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Contraseña", "Nombre", "Apellido"
            }
        ));
        jScrollPane2.setViewportView(tablaUser);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 460, 90));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RemoverUsuario.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 120, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RemoverAdministrador.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 120, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Administracion.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoMouseClicked
        Inicio i = new Inicio();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String clave = (tablaUser.getValueAt(tablaUser.getSelectedRow(), 0).toString());
        if ("".equals(clave)) {
            JOptionPane.showMessageDialog(null, "Seleccione el User");
        } else {
            Usuario bus = cad_usuario.buscar(clave);
            if (bus == null) {
                JOptionPane.showMessageDialog(null, "El username es incorrecto");
            } else {
                cad_usuario.borrar(clave);
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                muestra_usuarios();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String clave = (tablaAdmin.getValueAt(tablaAdmin.getSelectedRow(), 0).toString());
        if ("".equals(clave)) {
            JOptionPane.showMessageDialog(null, "Seleccione el Admin");
        } else {
            Administrador a = cad_administrador.buscar(clave);
            if (a == null) {
                JOptionPane.showMessageDialog(null, "El admin es incorrecto");
            } else {
                cad_administrador.borrar(clave);
                JOptionPane.showMessageDialog(null, "Administrador eliminado");
                muestra_administradores();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAdmin;
    private javax.swing.JTable tablaUser;
    // End of variables declaration//GEN-END:variables
}
