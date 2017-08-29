package br.com.scm.telas;

import br.com.scm.bll.ClasseBLL_J;
import br.com.scm.bll.ClasseBLL_F;
import br.com.scm.domain.Cliente_Fisico;
import java.sql.*;
import br.com.scm.dao.ModuloConexao;
import br.com.scm.domain.Cliente_Juridico;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Editar_Clientes extends javax.swing.JInternalFrame {

    public Editar_Clientes() {
        initComponents();
    }

    /* Inicio dos métodos do Cliente Juridico*/
    // método para pesquisar e fazer alterações dos clientes juridico. somento para o Admin
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

    // Método para setar os campos do jtable nos jtextfield
    private void setarCampos() {

        int setar = tbl_clientes.getSelectedRow();

        txt_cod_edit.setText(tbl_clientes.getModel().getValueAt(setar, 0).toString());
        txt_nome_edit.setText(tbl_clientes.getModel().getValueAt(setar, 1).toString());
        txt_cpf_edit.setText(tbl_clientes.getModel().getValueAt(setar, 2).toString());
        txt_fixo_edit.setText(tbl_clientes.getModel().getValueAt(setar, 3).toString());
        txt_cel_edit.setText(tbl_clientes.getModel().getValueAt(setar, 4).toString());
        txt_email_edit.setText(tbl_clientes.getModel().getValueAt(setar, 5).toString());
        txt_end_edit.setText(tbl_clientes.getModel().getValueAt(setar, 6).toString());
        txt_num_edit.setText(tbl_clientes.getModel().getValueAt(setar, 7).toString());
        txt_bairro_edit.setText(tbl_clientes.getModel().getValueAt(setar, 8).toString());
        txt_cidade_edit.setText(tbl_clientes.getModel().getValueAt(setar, 9).toString());
        cb_uf_edit.setSelectedItem(tbl_clientes.getModel().getValueAt(setar, 10).toString());
        txt_data_cadastro.setText(tbl_clientes.getModel().getValueAt(setar, 11).toString());
        txt_tipo.setText(tbl_clientes.getModel().getValueAt(setar, 12).toString());
        txt_cnpj.setText(tbl_clientes.getModel().getValueAt(setar, 2).toString());

    }

    // Método para excluir clientes
    private void excluirClienteJuridico(Cliente_Juridico cliente) {

        ClasseBLL_J bll = new ClasseBLL_J();

        cliente.setId_cliente(Long.parseLong(txt_cod_edit.getText()));

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esse cliente?\nTodos os dados do cliente seram perdidos.", "Alerta", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            bll.excluirClienteDAO(cliente);

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            limparCampo();
            pesquisarClienteJuridico();
        }
    }

    // Método para atualizar clientes
    private void editarClienteJuridico(Cliente_Juridico cliente) {

        ClasseBLL_J bll = new ClasseBLL_J();

        cliente.setNome_cliente_J(txt_nome_edit.getText());
        cliente.setCnpj(txt_cnpj.getText());
        cliente.setTelefone(txt_fixo_edit.getText());
        cliente.setCelular(txt_cel_edit.getText());
        cliente.setEmail(txt_email_edit.getText());
        cliente.setEndereco(txt_end_edit.getText());
        cliente.setNum_end(txt_num_edit.getText());
        cliente.setBairro(txt_bairro_edit.getText());
        cliente.setCidade(txt_cidade_edit.getText());
        cliente.setEstado(cb_uf_edit.getSelectedItem().toString());
        cliente.setId_cliente(Long.parseLong(txt_cod_edit.getText()));

        if (txt_nome_edit.getText().equals("") || txt_cel_edit.getText().equals("") || txt_cnpj.getText().trim().length() <= 14) {

            JOptionPane.showMessageDialog(null, "Os campos: Nome, CNPJ, Celular devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_nome_edit.setBackground(Color.cyan);
            txt_cnpj.setBackground(Color.cyan);
            txt_cel_edit.setBackground(Color.cyan);

        } else {

            bll.editarClienteDAO(cliente);

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampo();
            pesquisarClienteJuridico();
        }

    }

    // Método para limpar os campos
    private JTextField[] limparCampo() {

        JTextField[] campos = {txt_nome_edit, txt_cnpj, txt_cpf_edit, txt_fixo_edit, txt_cel_edit, txt_email_edit, txt_end_edit, txt_num_edit, txt_bairro_edit, txt_cidade_edit, txt_cod_edit, txt_pesquisar, txt_tipo, txt_data_cadastro};

        for (JTextField campo : campos) {
            campo.setText("");
            campo.setBackground(Color.WHITE);
        }

        return campos;
    }

    // Método para limpar os radiobutton
    private ButtonGroup[] limparRadio() {

        ButtonGroup[] campos = {buttonGroup1};

        for (ButtonGroup campo : campos) {
            campo.clearSelection();

        }

        return campos;
    }

    private void limparTabela() {
        DefaultTableModel tbl = (DefaultTableModel) tbl_clientes.getModel();
        while (tbl.getRowCount() > 0) {
            tbl.removeRow(0);
        }
    }

    /* Fim dos métodos do Cliente Juridico*/
 /*-------------------------------------------------------------------------*/
 /* Inicio dos métodos do Cliente Fisico*/
    // Método para editar cliente fisico
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
        }

    }

    // Método para excluir cliente
    private void excluirClienteFisico(Cliente_Fisico cliente) {

        ClasseBLL_F bll = new ClasseBLL_F();

        cliente.setId_cliente_F(Long.parseLong(txt_cod_edit.getText()));

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esse cliente?\nTodos os dados do cliente seram pedidos.", "Alerta", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            bll.excluirClienteFisicoDAO(cliente);

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            limparCampo();
            pesquisarClienteFisico();
        }
    }

    // Método para editar cliente
    private void editarClienteFisico(Cliente_Fisico cliente) {

        ClasseBLL_F bll = new ClasseBLL_F();

        cliente.setNome_cliente_F(txt_nome_edit.getText());
        cliente.setCpf(txt_cpf_edit.getText());
        cliente.setTelefone(txt_fixo_edit.getText());
        cliente.setCelular(txt_cel_edit.getText());
        cliente.setEmail(txt_email_edit.getText());
        cliente.setEndereco(txt_end_edit.getText());
        cliente.setNum_end(txt_num_edit.getText());
        cliente.setBairro(txt_bairro_edit.getText());
        cliente.setCidade(txt_cidade_edit.getText());
        cliente.setEstado(cb_uf_edit.getSelectedItem().toString());
        cliente.setId_cliente_F(Long.parseLong(txt_cod_edit.getText()));

        if (txt_nome_edit.getText().equals("") || txt_cpf_edit.getText().trim().length() < 12 || txt_cel_edit.getText().equals("(  )      -    ")) {

            JOptionPane.showMessageDialog(null, "Os campos: Nome, CPF, Celular devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_nome_edit.setBackground(Color.cyan);
            txt_cpf_edit.setBackground(Color.cyan);
            txt_cel_edit.setBackground(Color.cyan);
        } else {

            bll.editarClienteFisicoDAO(cliente);

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            limparCampo();
            pesquisarClienteFisico();
        }
    }

    /* Fim dos métodos do Cliente Fisico*/
 /*-------------------------------------------------------------------------*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_clientes = new javax.swing.JTable();
        txt_pesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_cod_edit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nome_edit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cpf_edit = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fixo_edit = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_cel_edit = new javax.swing.JFormattedTextField();
        lbl_whatsapp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email_edit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_end_edit = new javax.swing.JTextField();
        txt_num_edit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_bairro_edit = new javax.swing.JTextField();
        txt_cidade_edit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cb_uf_edit = new javax.swing.JComboBox<>();
        btn_editar_cli = new javax.swing.JButton();
        btn_excluir_cli = new javax.swing.JButton();
        btn_canelar_cli = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_data_cadastro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();
        rb_fisico = new javax.swing.JRadioButton();
        rb_juridico = new javax.swing.JRadioButton();
        txt_cnpj = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("Pesquisar e alterar cliente");
        setPreferredSize(new java.awt.Dimension(811, 636));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

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

        jLabel1.setText("Código");

        txt_cod_edit.setEditable(false);
        txt_cod_edit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cod_edit.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setText("Nome/Logradouro *");

        jLabel3.setText("CPF *");

        try {
            txt_cpf_edit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("CNPJ *");

        jLabel5.setText("Tel. Fixo");

        try {
            txt_fixo_edit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Celular *");

        try {
            txt_cel_edit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/whatsapp.png"))); // NOI18N

        jLabel7.setText("E-mail");

        jLabel8.setText("Endereço");

        jLabel9.setText("Número");

        jLabel10.setText("Bairro");

        jLabel11.setText("Cidade");

        jLabel12.setText("UF");

        cb_uf_edit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA) ", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));

        btn_editar_cli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/edit.png"))); // NOI18N
        btn_editar_cli.setText("Editar");
        btn_editar_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_cliActionPerformed(evt);
            }
        });

        btn_excluir_cli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/lixo.png"))); // NOI18N
        btn_excluir_cli.setText("Excluir");
        btn_excluir_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_cliActionPerformed(evt);
            }
        });

        btn_canelar_cli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/cancel.png"))); // NOI18N
        btn_canelar_cli.setText("Cancelar");
        btn_canelar_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_canelar_cliActionPerformed(evt);
            }
        });

        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/sair.png"))); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        jLabel13.setText("Deta de cadastro");

        txt_data_cadastro.setEditable(false);
        txt_data_cadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_data_cadastro.setForeground(new java.awt.Color(204, 0, 0));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/lupa.png"))); // NOI18N

        jLabel15.setText("Tipo");

        txt_tipo.setEditable(false);
        txt_tipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_tipo.setForeground(new java.awt.Color(204, 0, 0));

        buttonGroup1.add(rb_fisico);
        rb_fisico.setText("Físico");
        rb_fisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_fisicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_juridico);
        rb_juridico.setText("Jurídico");
        rb_juridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_juridicoActionPerformed(evt);
            }
        });

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("* Campos obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txt_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 557, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_fixo_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_cel_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_whatsapp)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_email_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_end_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(txt_num_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btn_editar_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_excluir_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_canelar_cli)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_bairro_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_cidade_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(cb_uf_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rb_fisico)
                                .addGap(18, 18, 18)
                                .addComponent(rb_juridico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_cod_edit, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nome_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_cpf_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt_cnpj))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rb_fisico)
                        .addComponent(rb_juridico)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpf_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel6)
                    .addComponent(lbl_whatsapp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fixo_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cel_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_end_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_num_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bairro_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cidade_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_uf_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sair)
                    .addComponent(btn_canelar_cli)
                    .addComponent(btn_excluir_cli)
                    .addComponent(btn_editar_cli))
                .addGap(62, 62, 62))
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

        setBounds(0, 0, 805, 640);
    }// </editor-fold>//GEN-END:initComponents

    // txt pesquisar com o método pesquisarClientes() 

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased

        if (rb_juridico.isSelected()) {
            pesquisarClienteJuridico();
        } else if (rb_fisico.isSelected()) {
            pesquisarClienteFisico();
        }

    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void btn_canelar_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_canelar_cliActionPerformed
        limparCampo();
        limparRadio();
        limparTabela();

    }//GEN-LAST:event_btn_canelar_cliActionPerformed

    // Botão sair

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.hide();

    }//GEN-LAST:event_btn_sairActionPerformed

    // Método que aciona o clique duplo do mouse na tabel\

    private void tbl_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientesMouseClicked

        setarCampos();
    }//GEN-LAST:event_tbl_clientesMouseClicked

    private void btn_editar_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_cliActionPerformed

        if (rb_fisico.isSelected() != true && rb_juridico.isSelected() != true) {

            JOptionPane.showMessageDialog(null, "Selecione uma Categoria de cliente.", "Alerta", JOptionPane.ERROR_MESSAGE);

        } else if (rb_juridico.isSelected()) {
            Cliente_Juridico clienteJ = new Cliente_Juridico();
            editarClienteJuridico(clienteJ);

        } else if (rb_fisico.isSelected()) {
            Cliente_Fisico clienteF = new Cliente_Fisico();
            editarClienteFisico(clienteF);
        }


    }//GEN-LAST:event_btn_editar_cliActionPerformed

    // Botão excluir chamando o método excluirCliente()

    private void btn_excluir_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_cliActionPerformed

        if (rb_juridico.isSelected()) {
            Cliente_Juridico cliente = new Cliente_Juridico();
            this.excluirClienteJuridico(cliente);
        } else if (rb_fisico.isSelected()) {
            Cliente_Fisico clienteF = new Cliente_Fisico();
            excluirClienteFisico(clienteF);
        }
    }//GEN-LAST:event_btn_excluir_cliActionPerformed

    private void rb_fisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_fisicoActionPerformed
        if (rb_fisico.isSelected()) {
            txt_cnpj.setEnabled(false);
            txt_cpf_edit.setEnabled(true);
            pesquisarClienteFisico();
            limparCampo();
        }
    }//GEN-LAST:event_rb_fisicoActionPerformed

    private void rb_juridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_juridicoActionPerformed
        if (rb_juridico.isSelected()) {
            txt_cpf_edit.setEnabled(false);
            txt_cnpj.setEnabled(true);
            pesquisarClienteJuridico();
            limparCampo();
        }
    }//GEN-LAST:event_rb_juridicoActionPerformed

    private void tbl_clientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clientesKeyReleased
        setarCampos();
    }//GEN-LAST:event_tbl_clientesKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_canelar_cli;
    private javax.swing.JButton btn_editar_cli;
    private javax.swing.JButton btn_excluir_cli;
    private javax.swing.JButton btn_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_uf_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_whatsapp;
    private javax.swing.JRadioButton rb_fisico;
    private javax.swing.JRadioButton rb_juridico;
    private javax.swing.JTable tbl_clientes;
    private javax.swing.JTextField txt_bairro_edit;
    private javax.swing.JFormattedTextField txt_cel_edit;
    private javax.swing.JTextField txt_cidade_edit;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JTextField txt_cod_edit;
    private javax.swing.JFormattedTextField txt_cpf_edit;
    private javax.swing.JTextField txt_data_cadastro;
    private javax.swing.JTextField txt_email_edit;
    private javax.swing.JTextField txt_end_edit;
    private javax.swing.JFormattedTextField txt_fixo_edit;
    private javax.swing.JTextField txt_nome_edit;
    private javax.swing.JTextField txt_num_edit;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
