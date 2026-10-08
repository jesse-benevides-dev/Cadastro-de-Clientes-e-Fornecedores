package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class FrmPrincipal extends javax.swing.JFrame {

    private FrmCadastroCliente frmClientes;
    private FrmCadastroFornecedor frmFornecedores;
    private FrmListagem frmListagem;

    public FrmPrincipal() {
        initComponents();
        frmClientes = new FrmCadastroCliente(this);
        frmFornecedores = new FrmCadastroFornecedor(this);
        frmListagem = new FrmListagem(this);
    }

    private void initComponents() {

        buClientes = new javax.swing.JButton();
        buFornecedores = new javax.swing.JButton();
        buListagem = new javax.swing.JButton();
        buSair = new javax.swing.JButton();

        setTitle("Sistema de Cadastros");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 40));

        buClientes.setText("Clientes");
        buClientes.addActionListener(evt -> buClientesActionPerformed(evt));
        getContentPane().add(buClientes);

        buFornecedores.setText("Fornecedores");
        buFornecedores.addActionListener(evt -> buFornecedoresActionPerformed(evt));
        getContentPane().add(buFornecedores);

        buListagem.setText("Listagem geral");
        buListagem.addActionListener(evt -> buListagemActionPerformed(evt));
        getContentPane().add(buListagem);

        buSair.setText("Sair");
        buSair.addActionListener(evt -> buSairActionPerformed(evt));
        getContentPane().add(buSair);

        pack();
    }

    private void buClientesActionPerformed(java.awt.event.ActionEvent evt) {
        frmClientes.setVisible(true);
    }

    private void buFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {
        frmFornecedores.setVisible(true);
    }

    private void buListagemActionPerformed(java.awt.event.ActionEvent evt) {
        frmListagem.carregar(frmClientes.obterModelo(), frmFornecedores.obterModelo());
        frmListagem.setVisible(true);
    }

    private void buSairActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private javax.swing.JButton buClientes;
    private javax.swing.JButton buFornecedores;
    private javax.swing.JButton buListagem;
    private javax.swing.JButton buSair;
}
