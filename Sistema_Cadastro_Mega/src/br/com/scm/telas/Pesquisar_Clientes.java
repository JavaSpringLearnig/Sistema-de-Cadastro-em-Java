package br.com.scm.telas;

import br.com.scm.dao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import br.com.scm.domain.Cliente_Fisico;

public class Pesquisar_Clientes extends javax.swing.JInternalFrame {

    public Pesquisar_Clientes() {
        initComponents();
    }

    // método para pesquisar os clientes, liberado para usuario comum e admin
    private void pesquisarClienteJuridico() {

        StringBuilder sql = new StringBuilder();

        ResultSet resultado;

        sql.append("SELECT * FROM tbl_cliente_juridico WHERE nome_cliente_J LIKE ? ORDER BY nome_cliente_J");

        try {

            Connection connection = ModuloConexao.conector();

            PreparedStatement comando = connection.prepareStatement(sql.toString());

            comando.setString(1, txt_pesquisar.getText() + "%");

            resultado = comando.executeQuery();

            tbl_clientes.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    // Método para pesquisar clientes fisico
    private void pesquisarClienteFisico() {

        StringBuilder sql = new StringBuilder();

        ResultSet resultado;

        sql.append("SELECT * FROM tbl_cliente_fisico WHERE nome_cliente LIKE ? ORDER BY nome_cliente");

        try {

            Connection connection = ModuloConexao.conector();

            PreparedStatement comando = connection.prepareStatement(sql.toString());

            comando.setString(1, txt_pesquisar.getText() + "%");

            resultado = comando.executeQuery();

            tbl_clientes.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn_sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_clientes = new javax.swing.JTable();
        txt_pesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rb_fisico = new javax.swing.JRadioButton();
        rb_juridico = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(811, 636));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/sair.png"))); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        tbl_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_clientes);

        txt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisarActionPerformed(evt);
            }
        });
        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/lupa.png"))); // NOI18N

        buttonGroup1.add(rb_fisico);
        rb_fisico.setText("Fisíco");

        buttonGroup1.add(rb_juridico);
        rb_juridico.setText("Juridíco");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rb_fisico)
                        .addGap(18, 18, 18)
                        .addComponent(rb_juridico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(rb_fisico)
                    .addComponent(rb_juridico))
                .addGap(417, 417, 417)
                .addComponent(btn_sair)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.hide();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void txt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased

        if (rb_juridico.isSelected()) {
            pesquisarClienteJuridico();
        } else if (rb_fisico.isSelected()) {
            pesquisarClienteFisico();
        }
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void tbl_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientesMouseClicked

        Exibir_Pesquisa pesquisa = new Exibir_Pesquisa(null, false);
        pesquisa.setVisible(true);
     //   int linha = tbl_clientes.getSelectedRow();
        //antes de abrir a tela deve haver alguma linha selecionada
       
        
//        if (linha > -1) {
//
//            Exibir_Pesquisa pesquisa = new Exibir_Pesquisa(null, true);//ou use set, como a seguir
//            pesquisa.(tbl_clientes.getValueAt(linha, 0));
//            pesquisa.setNomeCliente(tbl_clientes.getValueAt(linha, 1));
//            pesquisa.setCPFCliente(tbl_clientes.getValueAt(linha, 2));
//            //demais sets que necessitar, caso não queira alterar o construtor
//            pesquisa.setVisible(true);
//        }


    }//GEN-LAST:event_tbl_clientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_fisico;
    private javax.swing.JRadioButton rb_juridico;
    public static javax.swing.JTable tbl_clientes;
    private javax.swing.JTextField txt_pesquisar;
    // End of variables declaration//GEN-END:variables
}
