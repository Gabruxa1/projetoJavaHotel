package views;

import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

public class viewLogin extends javax.swing.JFrame {

    /**
     * Creates new form viewLogin
     */
    public viewLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/do-utilizador (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Login");

        txtLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLogin.setAutoscrolls(false);
        txtLogin.setCaretColor(new java.awt.Color(0, 0, 153));
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Senha");

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(66, 141, 255));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txtLogin)
                            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel2)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        String nomeUsuario = txtLogin.getText();
        char[] senhaUsuario = txtSenha.getPassword();
        String senha = String.valueOf(senhaUsuario);

        FuncionarioDAO dao = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = dao.read();

        boolean credenciaisValidas = false;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] senhaHash = md.digest(senha.getBytes());

            String senhaHashMD5 = new BigInteger(1, senhaHash).toString(16);

            for (Funcionario f : funcionarios) {
                if (f.getUsuario().equals(nomeUsuario) && f.getSenha().equals(senhaHashMD5)) {
                    credenciaisValidas = true;
                    break;
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            // Tratar a exceção, se necessário
            System.out.println("Erro ao criptografar a senha: " + ex);
        }

        if (credenciaisValidas) {
            TelaPrincipal tp = new TelaPrincipal();
            tp.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Credenciais inválidas. Acesso negado!");
        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nomeUsuario = txtLogin.getText();
            char[] senhaUsuario = txtSenha.getPassword();
            String senha = String.valueOf(senhaUsuario);

            FuncionarioDAO dao = new FuncionarioDAO();
            ArrayList<Funcionario> funcionarios = dao.read();

            boolean credenciaisValidas = false;

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] senhaHash = md.digest(senha.getBytes());

                String senhaHashMD5 = new BigInteger(1, senhaHash).toString(16);

                for (Funcionario f : funcionarios) {
                    if (f.getUsuario().equals(nomeUsuario) && f.getSenha().equals(senhaHashMD5)) {
                        credenciaisValidas = true;
                        break;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                // Tratar a exceção, se necessário
                System.out.println("Erro ao criptografar a senha: " + ex);
            }

            if (credenciaisValidas) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Acesso negado!");
            }
        }
    }//GEN-LAST:event_btnEntrarKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nomeUsuario = txtLogin.getText();
            char[] senhaUsuario = txtSenha.getPassword();
            String senha = String.valueOf(senhaUsuario);

            FuncionarioDAO dao = new FuncionarioDAO();
            ArrayList<Funcionario> funcionarios = dao.read();

            boolean credenciaisValidas = false;

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] senhaHash = md.digest(senha.getBytes());

                String senhaHashMD5 = new BigInteger(1, senhaHash).toString(16);

                for (Funcionario f : funcionarios) {
                    if (f.getUsuario().equals(nomeUsuario) && f.getSenha().equals(senhaHashMD5)) {
                        credenciaisValidas = true;
                        break;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                // Tratar a exceção, se necessário
                System.out.println("Erro ao criptografar a senha: " + ex);
            }

            if (credenciaisValidas) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Acesso negado!");
            }
        }

    }//GEN-LAST:event_jPanel1KeyPressed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nomeUsuario = txtLogin.getText();
            char[] senhaUsuario = txtSenha.getPassword();
            String senha = String.valueOf(senhaUsuario);

            FuncionarioDAO dao = new FuncionarioDAO();
            ArrayList<Funcionario> funcionarios = dao.read();

            boolean credenciaisValidas = false;

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] senhaHash = md.digest(senha.getBytes());

                String senhaHashMD5 = new BigInteger(1, senhaHash).toString(16);

                for (Funcionario f : funcionarios) {
                    if (f.getUsuario().equals(nomeUsuario) && f.getSenha().equals(senhaHashMD5)) {
                        credenciaisValidas = true;
                        break;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                // Tratar a exceção, se necessário
                System.out.println("Erro ao criptografar a senha: " + ex);
            }

            if (credenciaisValidas) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Acesso negado!");
            }
        }

    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nomeUsuario = txtLogin.getText();
            char[] senhaUsuario = txtSenha.getPassword();
            String senha = String.valueOf(senhaUsuario);

            FuncionarioDAO dao = new FuncionarioDAO();
            ArrayList<Funcionario> funcionarios = dao.read();

            boolean credenciaisValidas = false;

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] senhaHash = md.digest(senha.getBytes());

                String senhaHashMD5 = new BigInteger(1, senhaHash).toString(16);

                for (Funcionario f : funcionarios) {
                    if (f.getUsuario().equals(nomeUsuario) && f.getSenha().equals(senhaHashMD5)) {
                        credenciaisValidas = true;
                        break;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                // Tratar a exceção, se necessário
                System.out.println("Erro ao criptografar a senha: " + ex);
            }

            if (credenciaisValidas) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Acesso negado!");
            }
        }

    }//GEN-LAST:event_txtSenhaKeyPressed

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
            java.util.logging.Logger.getLogger(viewLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
