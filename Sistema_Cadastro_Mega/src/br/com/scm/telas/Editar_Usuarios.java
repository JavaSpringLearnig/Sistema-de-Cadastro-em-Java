package br.com.scm.telas;

import br.com.scm.bll.ClasseBLL;
import br.com.scm.dao.ModuloConexao;
import br.com.scm.domain.Usuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class Editar_Usuarios extends javax.swing.JInternalFrame {

    public Editar_Usuarios() {
        initComponents();
        pesquisarUsuario();
    }

    // Método para pesquisar Usuario
    private void pesquisarUsuario() {

        StringBuilder sql = new StringBuilder();

        ResultSet resultado;

        sql.append("SELECT id_usuario as Cód, nome_usuario as Nome, login as Login, senha as Senha, tipo as Tipo FROM  tbl_usuario WHERE nome_usuario LIKE ?ORDER BY nome_usuario ");

        try {

            Connection connection = ModuloConexao.conector();

            PreparedStatement comando = connection.prepareStatement(sql.toString());

            comando.setString(1, txt_pesquisar.getText() + "%");

            resultado = comando.executeQuery();

            tbl_usuarios.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    // Método para setar os campos da tabela nos textBox
    private void setarCampos() {

        int setar = tbl_usuarios.getSelectedRow();

        txt_cod.setText(tbl_usuarios.getModel().getValueAt(setar, 0).toString());
        txt_nome.setText(tbl_usuarios.getModel().getValueAt(setar, 1).toString());
        txt_login.setText(tbl_usuarios.getModel().getValueAt(setar, 2).toString());
        txt_senha.setText(tbl_usuarios.getModel().getValueAt(setar, 3).toString());
    }

    // Método para editar usuario
    private void editarUsuarios(Usuario usuario) {

        ClasseBLL bll = new ClasseBLL();

        usuario.setNome_usuario(txt_nome.getText());
        usuario.setLogin(txt_login.getText());
        usuario.setSenha(txt_senha.getText());
        usuario.setId_usuario(Long.parseLong(txt_cod.getText()));

        if (txt_nome.getText().trim().equals("") || txt_login.getText().trim().equals("") || txt_senha.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, "OS campos Nome, Login, Senha devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);

            txt_nome.setBackground(Color.cyan);
            txt_login.setBackground(Color.cyan);
            txt_senha.setBackground(Color.cyan);
        } else {

            bll.editarUsuarioDAO(usuario);

            JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampo();
            pesquisarUsuario();
        }

    }
    
    // Método para excluir usuario
    private void excluirUsuario(Usuario usuario){
        
        ClasseBLL bll = new ClasseBLL();
        
        usuario.setId_usuario(Long.parseLong(txt_cod.getText()));
        
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esse usuário?\n Todos os dados do usuário seram excluidos", "Alerta", JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            
            bll.excluirUsuarioDAO(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampo();
            pesquisarUsuario();
        }   
        
    }

    // Método para limpar campos
    private JTextField[] limparCampo() {

        JTextField[] campos = {txt_cod, txt_nome, txt_login, txt_senha, txt_pesquisar};

        for (JTextField campo : campos) {
            campo.setText("");
            campo.setBackground(Color.WHITE);
        }

        return campos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_pesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JTextField();

        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(759, 491));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Usuários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        tbl_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuariosMouseClicked(evt);
            }
        });
        tbl_usuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_usuariosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuarios);

        jLabel1.setText("Código");

        jLabel2.setText("Nome *");

        jLabel3.setText("Login *");

        jLabel4.setText("Senha *");

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/edit.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/lixo.png"))); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/cancel.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/sair.png"))); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/seacher.png"))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("* Campos obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(162, 162, 162)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_cod, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_pesquisar)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_sair))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Editar Usuários");

        setBounds(0, 0, 786, 537);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        this.pesquisarUsuario();
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.hide();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void tbl_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuariosMouseClicked

        setarCampos();
    }//GEN-LAST:event_tbl_usuariosMouseClicked

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
       limparCampo();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        Usuario usuario = new Usuario();
        editarUsuarios(usuario);
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
       Usuario usuario = new Usuario();
        excluirUsuario(usuario);
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void tbl_usuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_usuariosKeyReleased
        setarCampos();
    }//GEN-LAST:event_tbl_usuariosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_usuarios;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_senha;
    // End of variables declaration//GEN-END:variables
}
