package br.com.scm.telas;

import br.com.scm.dao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class Pesquisar_Clientes extends javax.swing.JInternalFrame {

    public Pesquisar_Clientes() {
        initComponents();

    }

    // método para pesquisar os clientes, liberado para usuario comum e admin
    private void pesquisarClienteJuridico() {

        StringBuilder sql = new StringBuilder();

        ResultSet resultado;

        sql.append("SELECT id_cliente_J as Cód, nome_cliente_J as Nome, cnpj as CNPJ, telefone as Fixo, celular as Celular, email as Email, endereco as Endereço, num_end as Nº, bairro as Bairro, cidade as Cidade, estado as UF, data_cad_J as 'Dt Cadastro', categoria as Categoria FROM tbl_cliente_juridico WHERE nome_cliente_J LIKE ? ORDER BY nome_cliente_J");

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

        sql.append("SELECT id_cliente_F as Cód, nome_cliente as Nome, cpf as CPF, telefone as Fixo, celular as Celular, email as Email, endereco as Endereço, num_end as Nº, bairro as Bairro, cidade as Cidade, estado as UF, data_cad_F as 'Dt Cadastro', categoria as Categoria FROM tbl_cliente_fisico WHERE nome_cliente LIKE ? ORDER BY nome_cliente");

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

    private void setarCampos() {

        int setar = tbl_clientes.getSelectedRow();

        txt_cod.setText(tbl_clientes.getModel().getValueAt(setar, 0).toString());
        txt_nome.setText(tbl_clientes.getModel().getValueAt(setar, 1).toString());
        txt_cpf_cnpj.setText(tbl_clientes.getModel().getValueAt(setar, 2).toString());
        txt_tel.setText(tbl_clientes.getModel().getValueAt(setar, 3).toString());
        txt_celular.setText(tbl_clientes.getModel().getValueAt(setar, 4).toString());
        txt_email.setText(tbl_clientes.getModel().getValueAt(setar, 5).toString());
        txt_end.setText(tbl_clientes.getModel().getValueAt(setar, 6).toString());
        txt_num.setText(tbl_clientes.getModel().getValueAt(setar, 7).toString());
        txt_bairro.setText(tbl_clientes.getModel().getValueAt(setar, 8).toString());
        txt_cidade.setText(tbl_clientes.getModel().getValueAt(setar, 9).toString());
        txt_estado.setText(tbl_clientes.getModel().getValueAt(setar, 10).toString());
        txt_cadastro.setText(tbl_clientes.getModel().getValueAt(setar, 11).toString());
        txt_categoria.setText(tbl_clientes.getModel().getValueAt(setar, 12).toString());

    }

    private JTextField[] limparCampo() {

        JTextField[] campos = {txt_nome, txt_cpf_cnpj, txt_tel, txt_celular, txt_email, txt_end, txt_num, txt_bairro, txt_cidade, txt_cod, txt_pesquisar, txt_categoria, txt_cadastro, txt_estado};
        
        for (JTextField campo : campos) {
            campo.setText("");
        }

        return campos;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_cod = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_cpf_cnpj = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_end = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_num = new javax.swing.JTextField();
        txt_cidade = new javax.swing.JTextField();
        txt_cadastro = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        txt_categoria = new javax.swing.JTextField();

        setIconifiable(true);
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
                "", "", "", ""
            }
        ));
        tbl_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientesMouseClicked(evt);
            }
        });
        tbl_clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_clientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_clientes);

        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/lupa.png"))); // NOI18N

        buttonGroup1.add(rb_fisico);
        rb_fisico.setText("Fisíco");
        rb_fisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_fisicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_juridico);
        rb_juridico.setText("Juridíco");
        rb_juridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_juridicoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("CÓD:");

        jLabel3.setText("NOME:");

        jLabel4.setText("CPF/CNPJ:");

        jLabel5.setText("TELEFONE:");

        jLabel6.setText("CELULAR:");

        jLabel7.setText("E-MAIL:");

        jLabel8.setText("ENDEREÇO:");

        jLabel10.setText("BAIRRO:");

        jLabel11.setText("CIDADE:");

        jLabel12.setText("ESTADO:");

        jLabel13.setText("Dt. CADASTRO:");

        jLabel14.setText("CATEGORIA:");

        txt_nome.setEditable(false);

        txt_cod.setEditable(false);

        txt_tel.setEditable(false);

        txt_celular.setEditable(false);

        txt_cpf_cnpj.setEditable(false);

        txt_email.setEditable(false);

        txt_end.setEditable(false);

        txt_bairro.setEditable(false);

        jLabel15.setText("Nº");

        txt_num.setEditable(false);

        txt_cidade.setEditable(false);

        txt_cadastro.setEditable(false);

        txt_estado.setEditable(false);

        txt_categoria.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_email))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_cpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_estado)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(205, 205, 205))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sair)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(315, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Pesquisar Clientes");

        setBounds(0, 0, 812, 636);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.hide();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased

        if (rb_juridico.isSelected()) {
            pesquisarClienteJuridico();
        } else if (rb_fisico.isSelected()) {
            pesquisarClienteFisico();
        }
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void tbl_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientesMouseClicked
        setarCampos();

    }//GEN-LAST:event_tbl_clientesMouseClicked

    private void tbl_clientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clientesKeyReleased
        setarCampos();
    }//GEN-LAST:event_tbl_clientesKeyReleased

    private void rb_fisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_fisicoActionPerformed
        if (rb_fisico.isSelected()) {
            pesquisarClienteFisico();
            limparCampo();
        }
    }//GEN-LAST:event_rb_fisicoActionPerformed

    private void rb_juridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_juridicoActionPerformed
        if (rb_juridico.isSelected()) {
            pesquisarClienteJuridico();
            limparCampo();
        }
    }//GEN-LAST:event_rb_juridicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_fisico;
    private javax.swing.JRadioButton rb_juridico;
    public static javax.swing.JTable tbl_clientes;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cadastro;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_cpf_cnpj;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_end;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_num;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
