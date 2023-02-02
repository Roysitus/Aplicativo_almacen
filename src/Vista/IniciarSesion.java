
package Vista;

import Array.ArrayCuentas;
import User_Admin.*;
import dao.clases.administradorCAD;
import dao.clases.usuarioCAD;
import javax.swing.JOptionPane;

public class IniciarSesion extends javax.swing.JFrame {
    
    ArrayCuentas ac = new ArrayCuentas();
    administradorCAD cad_administrador = new administradorCAD();
    usuarioCAD cad_usuario = new usuarioCAD();
    public IniciarSesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserName.setBorder(null);
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 20));

        txtPassword.setBorder(null);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 300, 20));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3.png"))); // NOI18N
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 120, 40));

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        btnIniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 120, 40));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.png"))); // NOI18N
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Registrarse r = new Registrarse();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        Usuario u = cad_usuario.buscar(username);
        Administrador a = cad_administrador.buscar(username);
        if(u==null && a==null){
            JOptionPane.showMessageDialog(null, "El username o password son incorrectos");
        }else{
            if(u!=null){
                if(u.getHabilitado().equals("True")){
                    if(u.getContraseña().equals(password)){
                        JOptionPane.showMessageDialog(null, "Bienvenido: " + u.getNombre() + " " + u.getApellido());
                        Panel_Productos panel_Productos = new Panel_Productos();
                        panel_Productos.setVisible(true);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Contraseña erronea intentos restantes: " + (u.getPeticiones()-1));
                        u.setPeticiones(u.getPeticiones()-1);
                        cad_usuario.actualizar(u);
                        if(u.getPeticiones()==0){
                            JOptionPane.showMessageDialog(null, "Su cuenta ha sido bloqueada");
                            u.setHabilitado("False");
                            cad_usuario.actualizar(u);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su cuenta se encuentra bloqueada");
                }
            }
            if(a!=null){
                if(a.getHabilitado().equals("True")){
                    if(a.getContraseña().equals(password)){
                        JOptionPane.showMessageDialog(null, "Bienvenido: " + a.getNombre() + " " + a.getApellido());
                        Panel_Productos panel_Productos = new Panel_Productos();
                        panel_Productos.setVisible(true);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Contraseña erronea intentos restantes: " + (a.getPeticiones()-1));
                        a.setPeticiones(a.getPeticiones()-1);
                        cad_administrador.actualizar(a);
                        if(a.getPeticiones()==0){
                            JOptionPane.showMessageDialog(null, "Su cuenta ha sido bloqueada");
                            a.setHabilitado("False");
                            cad_administrador.actualizar(a);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su cuenta se encuentra bloqueada");
                }
            }
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
