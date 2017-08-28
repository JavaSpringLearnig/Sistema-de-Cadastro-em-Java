package br.com.scm.telas;

import br.com.scm.domain.Cliente_Juridico;
import br.com.scm.domain.Cliente_Fisico;
import br.com.scm.bll.ClasseBLL_J;
import br.com.scm.bll.ClasseBLL_F;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cad_Cliente extends javax.swing.JInternalFrame {

    public Cad_Cliente() {
        initComponents();
    }

    // Método para salvar clientes
    private void salvarClienteJuridico(Cliente_Juridico cliente) {

        ClasseBLL_J bll = new ClasseBLL_J();

        cliente.setNome_cliente_J(txt_nome_cli.getText());
        cliente.setCnpj(txt_cnpj.getText());
        cliente.setTelefone(txt_tel.getText());
        cliente.setCelular(txt_cel.getText());
        cliente.setEmail(txt_email.getText());
        cliente.setEndereco(txt_end.getText());
        cliente.setNum_end(txt_num.getText());
        cliente.setBairro(txt_bairro.getText());
        cliente.setCidade(txt_cidade.getText());
        cliente.setEstado(txt_cidade.getText());
        cliente.setCategoria(rb_juridica.getText());

        if (txt_nome_cli.getText().equals("") || txt_cnpj.getText().equals("   .   .   /    -  ") || txt_cel.getText().equals("(  )      -    ")) {

            JOptionPane.showMessageDialog(null, "Os campos: Nome, CNPJ, Celular devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_nome_cli.setBackground(Color.cyan);
            txt_cnpj.setBackground(Color.cyan);
            txt_cel.setBackground(Color.cyan);
        } else {
            bll.cadastrarClienteJuridicoDAO(cliente);

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            limparCampo();
            limparRadio();
            txt_nome_cli.requestFocus();
        }

    }

    // Método para salvar cliente fisico
    private void salvarClienteFisico(Cliente_Fisico cliente) {

        ClasseBLL_F bll = new ClasseBLL_F();

        cliente.setNome_cliente_F(txt_nome_cli.getText());
        cliente.setCpf(txt_cpf.getText());
        cliente.setTelefone(txt_tel.getText());
        cliente.setCelular(txt_cel.getText());
        cliente.setEmail(txt_email.getText());
        cliente.setEndereco(txt_end.getText());
        cliente.setNum_end(txt_num.getText());
        cliente.setBairro(txt_bairro.getText());
        cliente.setCidade(txt_cidade.getText());
        cliente.setEstado(cb_uf.getSelectedItem().toString());
        cliente.setCategoria(rb_fisica.getText());

        if (txt_nome_cli.getText().equals("") || txt_cpf.getText().equals("   .   .   /    -  ") || txt_cel.getText().equals("(  )      -    ")) {

            JOptionPane.showMessageDialog(null, "Os campos: Nome, CPF, Celular devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_nome_cli.setBackground(Color.cyan);
            txt_cpf.setBackground(Color.cyan);
            txt_cel.setBackground(Color.cyan);
        } else {

            bll.cadastrarClienteFisicoDAO(cliente);

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            limparCampo();
            limparRadio();
        }
    }

   // Método para limpar os radiobutton
    private ButtonGroup[] limparRadio() {

        ButtonGroup[] campos = {buttonGroup1};

        for (ButtonGroup campo : campos) {
            campo.clearSelection();

        }

        return campos;
    }

    // método para limpar os campos
    private JTextField[] limparCampo() {

        JTextField[] campos = {txt_nome_cli, txt_cnpj, txt_cpf, txt_tel, txt_cel, txt_email, txt_end, txt_num, txt_bairro, txt_cidade};

        for (JTextField campo : campos) {
            campo.setText("");
            campo.setBackground(Color.WHITE);
        }

        return campos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbl_nome = new javax.swing.JLabel();
        txt_nome_cli = new javax.swing.JTextField();
        lbl_categoria = new javax.swing.JLabel();
        lbl_cpf = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        lbl_cnpj = new javax.swing.JLabel();
        txt_cnpj = new javax.swing.JFormattedTextField();
        lbl_tel = new javax.swing.JLabel();
        txt_tel = new javax.swing.JFormattedTextField();
        lbl_cel = new javax.swing.JLabel();
        txt_cel = new javax.swing.JFormattedTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_end = new javax.swing.JLabel();
        txt_end = new javax.swing.JTextField();
        lbl_numero = new javax.swing.JLabel();
        txt_num = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        txt_cidade = new javax.swing.JTextField();
        lbl_cidade = new javax.swing.JLabel();
        lbl_uf = new javax.swing.JLabel();
        cb_uf = new javax.swing.JComboBox<>();
        btn_salvar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_whatsapp = new javax.swing.JLabel();
        rb_fisica = new javax.swing.JRadioButton();
        rb_juridica = new javax.swing.JRadioButton();

        setTitle("Cadastro de Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lbl_nome.setText("Nome/Logradouro *");

        lbl_categoria.setText("Categoria *");

        lbl_cpf.setText("CPF *");

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_cnpj.setText("CNPJ *");

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_tel.setText("Tel. Fixo *");

        try {
            txt_tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_cel.setText("Celular *");

        try {
            txt_cel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_email.setText("E-mail");

        lbl_end.setText("Endereço");

        lbl_numero.setText("Número");

        lbl_bairro.setText("Bairro");

        lbl_cidade.setText("Cidade");

        lbl_uf.setText("UF");

        cb_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA) ", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));

        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/ok.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
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

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("* Campos obrigatórios");

        lbl_whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/whatsapp.png"))); // NOI18N

        buttonGroup1.add(rb_fisica);
        rb_fisica.setText("Fisica");
        rb_fisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_fisicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_juridica);
        rb_juridica.setText("Juridica");
        rb_juridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_juridicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_email)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_end)
                                    .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_numero)
                                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_bairro)
                                            .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_cidade)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(470, 470, 470)
                                        .addComponent(lbl_uf))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbl_cpf)
                                        .addGap(92, 92, 92)
                                        .addComponent(lbl_cnpj))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_tel)
                                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_cel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_whatsapp))
                                    .addComponent(txt_cel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_categoria)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rb_fisica)
                                .addGap(18, 18, 18)
                                .addComponent(rb_juridica)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nome)
                            .addComponent(txt_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_categoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rb_fisica)
                                    .addComponent(rb_juridica)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_nome)
                                .addGap(0, 0, 0)
                                .addComponent(txt_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_cpf)
                                    .addComponent(lbl_cnpj))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_whatsapp)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_tel)
                                        .addComponent(lbl_cel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_end)
                                    .addComponent(lbl_numero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_bairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cidade)
                            .addComponent(lbl_uf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_sair)
                    .addComponent(btn_salvar))
                .addGap(53, 53, 53))
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

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Botão salvar chamando o método salvarClienteJuridico()

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed

        if (rb_fisica.isSelected() != true && rb_juridica.isSelected() != true) {

            JOptionPane.showMessageDialog(null, "Selecione uma Categoria de cliente.", "Alerta", JOptionPane.ERROR_MESSAGE);

        } else if (rb_juridica.isSelected()) {

            Cliente_Juridico cliente = new Cliente_Juridico();
            salvarClienteJuridico(cliente);

        } else if (rb_fisica.isSelected()) {

            Cliente_Fisico clienteF = new Cliente_Fisico();
            salvarClienteFisico(clienteF);

        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    // Botão sair

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.hide();
    }//GEN-LAST:event_btn_sairActionPerformed

    // Botão Canelar chamando o método limparCampo();

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        limparCampo();
        limparCampo();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void rb_fisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_fisicaActionPerformed

        if (rb_fisica.isSelected()) {
            txt_cnpj.setEnabled(false);
            txt_cpf.setEnabled(true);
        }
    }//GEN-LAST:event_rb_fisicaActionPerformed

    private void rb_juridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_juridicaActionPerformed

        if (rb_juridica.isSelected()) {
            txt_cpf.setEnabled(false);
            txt_cnpj.setEnabled(true);

        }
    }//GEN-LAST:event_rb_juridicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_cel;
    private javax.swing.JLabel lbl_cidade;
    private javax.swing.JLabel lbl_cnpj;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_end;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_numero;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_uf;
    private javax.swing.JLabel lbl_whatsapp;
    private javax.swing.JRadioButton rb_fisica;
    private javax.swing.JRadioButton rb_juridica;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cel;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj;
    public static javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_end;
    private javax.swing.JTextField txt_nome_cli;
    private javax.swing.JTextField txt_num;
    private javax.swing.JFormattedTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
