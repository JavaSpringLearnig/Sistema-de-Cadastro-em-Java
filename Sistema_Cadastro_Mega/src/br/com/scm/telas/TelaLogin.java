package br.com.scm.telas;

import java.sql.*;
import br.com.scm.dao.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // abrindo a conexão com o banco de dados
    public TelaLogin() {
        initComponents();

        this.getRootPane().setDefaultButton(btn_logar); // aciona a tecla enter para loga

        conexao = ModuloConexao.conector();

        if (conexao != null) {
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/dbok.png")));
        } else {
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/dbnull.png")));
        }
    }

    // método para loga no sistema
    public void logar() {

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM tbl_usuario WHERE login = ? AND senha = ? ");

        try {
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, txt_login.getText());
            pst.setString(2, txt_senha.getText());

            rs = pst.executeQuery();

            // se exixtir um usuario e senha corespondente no banco, sera executado as linhas abaixo
            if (rs.next()) {

                //obtem o campo tipo na tabela usuario
                String tipo = rs.getString(5);

                if (tipo.equals("Comum")) {

                    Principal principal = new Principal();
                    principal.setVisible(true);

                    Principal.menu_cad_usuario.setEnabled(false);
                    Principal.menuEditarCliente.setEnabled(false);
                    Principal.menuEditarUsuario.setEnabled(false);
                    Principal.lbl_usuario.setText(rs.getString(2));

                    this.dispose();

                } else if (tipo.equals("Admin")) {

                    Principal principal = new Principal();
                    principal.setVisible(true);
                    Principal.lbl_usuario.setText(rs.getString(2));
                    Principal.lbl_usuario.setForeground(Color.red);
                    dispose();
                    conexao.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Inválido!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_login = new javax.swing.JLabel();
        lbl_senha = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        btn_logar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Mega Celulares LTDA");
        setResizable(false);

        lbl_login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_login.setText("Login");

        lbl_senha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_senha.setText("Senha");

        btn_logar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/ok.png"))); // NOI18N
        btn_logar.setText("Logar");
        btn_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/cancelar.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/cadeado.png"))); // NOI18N

        lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/dbnull.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_login)
                            .addComponent(lbl_senha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lbl_status)
                        .addGap(26, 26, 26)
                        .addComponent(btn_logar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_login)
                            .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_senha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_status)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_cancelar)
                                .addComponent(btn_logar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(502, 205));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // botão cancelar

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    // botão logar

    private void btn_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logarActionPerformed
        this.logar();
    }//GEN-LAST:event_btn_logarActionPerformed

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_logar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JTextField txt_login;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
