package com.mycompany.cadastro.de.clientes.e.fornecedores;

import javax.swing.JOptionPane;

public abstract class FrmCadastroPessoa extends javax.swing.JDialog {

    private ModeloTabelaPessoa modeloPessoa;

    public FrmCadastroPessoa(java.awt.Frame parent, String titulo, String rotuloDocumento) {
        super(parent, true);
        setTitle(titulo);
        initComponents();
        modeloPessoa = new ModeloTabelaPessoa(rotuloDocumento);
        tabelaPessoa.setModel(modeloPessoa);
    }

    public ModeloTabelaPessoa obterModelo() {
        return modeloPessoa;
    }

    // cada subclasse (Cliente / Fornecedor) diz qual objeto criar e qual formulário abrir
    protected abstract Pessoa novaPessoa();

    protected abstract boolean abrirFormulario(OperacaoCadastro operacao, Pessoa pessoa);

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPessoa = new javax.swing.JTable();
        buIncluir = new javax.swing.JButton();
        buAlterar = new javax.swing.JButton();
        buExcluir = new javax.swing.JButton();
        buConsultar = new javax.swing.JButton();
        buFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        jScrollPane1.setViewportView(tabelaPessoa);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(650, 300));
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        buIncluir.setText("Incluir");
        buIncluir.addActionListener(evt -> buIncluirActionPerformed(evt));
        buAlterar.setText("Alterar");
        buAlterar.addActionListener(evt -> buAlterarActionPerformed(evt));
        buExcluir.setText("Excluir");
        buExcluir.addActionListener(evt -> buExcluirActionPerformed(evt));
        buConsultar.setText("Consultar");
        buConsultar.addActionListener(evt -> buConsultarActionPerformed(evt));
        buFechar.setText("Fechar");
        buFechar.addActionListener(evt -> buFecharActionPerformed(evt));

        javax.swing.JPanel botoes = new javax.swing.JPanel(new java.awt.GridLayout(0, 1, 0, 10));
        botoes.add(buIncluir);
        botoes.add(buAlterar);
        botoes.add(buExcluir);
        botoes.add(buConsultar);
        botoes.add(buFechar);

        javax.swing.JPanel lateral = new javax.swing.JPanel(new java.awt.BorderLayout());
        lateral.add(botoes, java.awt.BorderLayout.NORTH);
        getContentPane().add(lateral, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }

    private void buIncluirActionPerformed(java.awt.event.ActionEvent evt) {
        Pessoa pessoa = novaPessoa();
        if (abrirFormulario(OperacaoCadastro.ocIncluir, pessoa)) {
            modeloPessoa.incluirPessoa(pessoa);
        }
    }

    private void buAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        int indicePessoa = tabelaPessoa.getSelectedRow();
        if (indicePessoa >= 0) {
            Pessoa pessoa = modeloPessoa.obterPessoa(indicePessoa);
            if (abrirFormulario(OperacaoCadastro.ocAlterar, pessoa)) {
                modeloPessoa.atualizarPessoa(indicePessoa, pessoa);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um registro.");
        }
    }

    private void buExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int indicePessoa = tabelaPessoa.getSelectedRow();
        if (indicePessoa >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão?") == JOptionPane.YES_OPTION) {
                modeloPessoa.excluirPessoa(indicePessoa);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um registro.");
        }
    }

    private void buConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        int indicePessoa = tabelaPessoa.getSelectedRow();
        if (indicePessoa >= 0) {
            abrirFormulario(OperacaoCadastro.ocConsultar, modeloPessoa.obterPessoa(indicePessoa));
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um registro.");
        }
    }

    private void buFecharActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private javax.swing.JButton buAlterar;
    private javax.swing.JButton buConsultar;
    private javax.swing.JButton buExcluir;
    private javax.swing.JButton buFechar;
    private javax.swing.JButton buIncluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPessoa;
}
