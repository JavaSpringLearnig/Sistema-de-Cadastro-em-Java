package br.com.scm.telas;

import br.com.scm.dao.ModuloConexao;
import java.awt.Dimension;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {

    Connection connection = null;

    public Principal() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        connection = ModuloConexao.conector();
    }

    //método para centralizar a tela no meio do desktopPanel
    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = desktopPanel.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        lbl_data = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menu_cad_usuario = new javax.swing.JMenuItem();
        menu_cad_cliente = new javax.swing.JMenuItem();
        menuUtilitario = new javax.swing.JMenu();
        menuPesquisarClientes = new javax.swing.JMenuItem();
        menuEditarCliente = new javax.swing.JMenuItem();
        menuEditarUsuario = new javax.swing.JMenuItem();
        menu_relatorio = new javax.swing.JMenu();
        menRelFisico = new javax.swing.JMenuItem();
        menRelJuridico = new javax.swing.JMenuItem();
        menu_sobre = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();
        menOpSair = new javax.swing.JMenu();
        menu_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Mega Celulares LTDA");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desktopPanel.setBackground(java.awt.Color.lightGray);
        desktopPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 637));

        lbl_data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_data.setText("Data");
        getContentPane().add(lbl_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 609, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 103, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/scm/icones/Logo.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_usuario.setText("Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 574, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 576, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Data:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 611, -1, -1));

        menuCadastro.setText("Cadastrar");

        menu_cad_usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menu_cad_usuario.setText("Usuário");
        menu_cad_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cad_usuarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menu_cad_usuario);

        menu_cad_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menu_cad_cliente.setText("Cliente");
        menu_cad_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cad_clienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menu_cad_cliente);

        jMenuBar1.add(menuCadastro);

        menuUtilitario.setText("Utilitarios");

        menuPesquisarClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuPesquisarClientes.setText("Pesquisar Clientes");
        menuPesquisarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarClientesActionPerformed(evt);
            }
        });
        menuUtilitario.add(menuPesquisarClientes);

        menuEditarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuEditarCliente.setText("Editar Clientes");
        menuEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarClienteActionPerformed(evt);
            }
        });
        menuUtilitario.add(menuEditarCliente);

        menuEditarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuEditarUsuario.setText("Editar Usuários");
        menuEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarUsuarioActionPerformed(evt);
            }
        });
        menuUtilitario.add(menuEditarUsuario);

        jMenuBar1.add(menuUtilitario);

        menu_relatorio.setText("Relatório");

        menRelFisico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        menRelFisico.setText("Clientes Físico");
        menRelFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelFisicoActionPerformed(evt);
            }
        });
        menu_relatorio.add(menRelFisico);

        menRelJuridico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_MASK));
        menRelJuridico.setText("Clientes Jurídico");
        menRelJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelJuridicoActionPerformed(evt);
            }
        });
        menu_relatorio.add(menRelJuridico);

        jMenuBar1.add(menu_relatorio);

        menu_sobre.setText("Sobre");

        menuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuSobre.setText("Sobre o Sistema");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menu_sobre.add(menuSobre);

        jMenuBar1.add(menu_sobre);

        menOpSair.setText("Sair");

        menu_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        menu_sair.setText("Sair");
        menu_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairActionPerformed(evt);
            }
        });
        menOpSair.add(menu_sair);

        jMenuBar1.add(menOpSair);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleDescription("Sistema Mega Celulares");
        getAccessibleContext().setAccessibleParent(this);

        setSize(new java.awt.Dimension(1004, 696));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_cad_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cad_clienteActionPerformed

        Cad_Cliente frmCliente = new Cad_Cliente();

        frmCliente.setVisible(true);
        centralizaForm(frmCliente);
        desktopPanel.add(frmCliente);
    }//GEN-LAST:event_menu_cad_clienteActionPerformed

    private void menu_cad_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cad_usuarioActionPerformed

        Cad_Usuario frmUsuario = new Cad_Usuario();

        frmUsuario.setVisible(true);
        centralizaForm(frmUsuario);
        desktopPanel.add(frmUsuario);
    }//GEN-LAST:event_menu_cad_usuarioActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lbl_data.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menuEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarClienteActionPerformed

        Editar_Clientes frmEditarCliente = new Editar_Clientes();

        frmEditarCliente.setVisible(true);
        centralizaForm(frmEditarCliente);
        desktopPanel.add(frmEditarCliente);
    }//GEN-LAST:event_menuEditarClienteActionPerformed

    private void menu_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Sair do sistema?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
     }//GEN-LAST:event_menu_sairActionPerformed

    private void menuPesquisarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarClientesActionPerformed

        Pesquisar_Clientes frmPesquisar = new Pesquisar_Clientes();

        frmPesquisar.setVisible(true);
        centralizaForm(frmPesquisar);
        desktopPanel.add(frmPesquisar);
    }//GEN-LAST:event_menuPesquisarClientesActionPerformed

    private void menuEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarUsuarioActionPerformed
        Editar_Usuarios frmEditUsuario = new Editar_Usuarios();
        frmEditUsuario.setVisible(true);
        centralizaForm(frmEditUsuario);
        desktopPanel.add(frmEditUsuario);
    }//GEN-LAST:event_menuEditarUsuarioActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed

        Sobre frmSobre = new Sobre();

        frmSobre.setVisible(true);
        centralizaForm(frmSobre);
        desktopPanel.add(frmSobre);


    }//GEN-LAST:event_menuSobreActionPerformed

    private void menRelJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelJuridicoActionPerformed

        int confirma = JOptionPane.showConfirmDialog(null, "Imprimir a Relação de Cliente Jurídco?", "Atenção", JOptionPane.YES_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {

            try {
                JasperPrint print = JasperFillManager.fillReport("C:/reports/Cliente Juridico.jasper", null, connection);
                
                JasperViewer.viewReport(print, false);
             
            } catch (JRException erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
              
        }
  
    }//GEN-LAST:event_menRelJuridicoActionPerformed

    private void menRelFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelFisicoActionPerformed
        
           int confirma = JOptionPane.showConfirmDialog(null, "Imprimir a Relação de Cliente Fisíco?", "Atenção", JOptionPane.YES_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {

            try {
                JasperPrint print = JasperFillManager.fillReport("C:/reports/Cliente Fisico.jasper", null, connection);
                
                JasperViewer.viewReport(print, false);
             
            } catch (JRException erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
              
        }
    }//GEN-LAST:event_menRelFisicoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JLabel lbl_data;
    public static javax.swing.JLabel lbl_usuario;
    private javax.swing.JMenu menOpSair;
    private javax.swing.JMenuItem menRelFisico;
    private javax.swing.JMenuItem menRelJuridico;
    private javax.swing.JMenu menuCadastro;
    public static javax.swing.JMenuItem menuEditarCliente;
    public static javax.swing.JMenuItem menuEditarUsuario;
    private javax.swing.JMenuItem menuPesquisarClientes;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JMenu menuUtilitario;
    private javax.swing.JMenuItem menu_cad_cliente;
    public static javax.swing.JMenuItem menu_cad_usuario;
    private javax.swing.JMenu menu_relatorio;
    private javax.swing.JMenuItem menu_sair;
    private javax.swing.JMenu menu_sobre;
    // End of variables declaration//GEN-END:variables
}
