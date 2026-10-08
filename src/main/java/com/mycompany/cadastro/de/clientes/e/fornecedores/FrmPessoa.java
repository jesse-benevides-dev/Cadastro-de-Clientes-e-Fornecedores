package com.mycompany.cadastro.de.clientes.e.fornecedores;

import javax.swing.JOptionPane;

public abstract class FrmPessoa extends javax.swing.JDialog {

    private OperacaoCadastro operacaoCadastro;
    private Pessoa pessoa;
    private boolean confirmado;

    public FrmPessoa(java.awt.Frame parent, OperacaoCadastro operacaoCadastro,
                     Pessoa pessoa, String titulo, String rotuloDocumento) {
        super(parent, true);
        confirmado = false;
        this.operacaoCadastro = operacaoCadastro;
        this.pessoa = pessoa;
        setTitle(titulo);

        initComponents(rotuloDocumento);

        if (operacaoCadastro != OperacaoCadastro.ocIncluir) {
            edNome.setText(pessoa.obterNome());
            edTelefone.setText(pessoa.obterTelefone());
            edEmail.setText(pessoa.obterEmail());
            edLogradouro.setText(pessoa.obterLogradouro());
            edNumero.setText(pessoa.obterNumero());
            edComplemento.setText(pessoa.obterComplemento());
            edBairro.setText(pessoa.obterBairro());
            edCidade.setText(pessoa.obterCidade());
            cbEstado.setSelectedItem(pessoa.obterEstado());
            edCep.setText(pessoa.obterCep());
            edDocumento.setText(pessoa.obterDocumento());
        }

        buCancelar.setVisible(operacaoCadastro != OperacaoCadastro.ocConsultar);
        for (java.awt.Component c : painelCampos.getComponents()) {
            if (!(c instanceof javax.swing.JLabel)) {
                c.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
            }
        }
    }

    public boolean operacaoConfirmada() {
        return confirmado;
    }

    private void addCampo(String rotulo, java.awt.Component campo) {
        painelCampos.add(new javax.swing.JLabel(rotulo));
        painelCampos.add(campo);
    }

    private void initComponents(String rotuloDocumento) {

        buOk = new javax.swing.JButton();
        buCancelar = new javax.swing.JButton();
        edNome = new javax.swing.JTextField(25);
        edTelefone = new javax.swing.JTextField();
        edEmail = new javax.swing.JTextField();
        edLogradouro = new javax.swing.JTextField();
        edNumero = new javax.swing.JTextField();
        edComplemento = new javax.swing.JTextField();
        edBairro = new javax.swing.JTextField();
        edCidade = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<String>(new String[]{"", "AC", "AL", "AP", "AM", "BA",
            "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ",
            "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});
        edCep = new javax.swing.JTextField();
        edDocumento = new javax.swing.JTextField();
        painelCampos = new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 8, 6));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelCampos.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addCampo("Nome:", edNome);
        addCampo("Telefone:", edTelefone);
        addCampo("E-mail:", edEmail);
        addCampo("Logradouro:", edLogradouro);
        addCampo("Número:", edNumero);
        addCampo("Complemento:", edComplemento);
        addCampo("Bairro:", edBairro);
        addCampo("Cidade:", edCidade);
        addCampo("Estado:", cbEstado);
        addCampo("CEP:", edCep);
        addCampo(rotuloDocumento + ":", edDocumento);

        buOk.setText("Ok");
        buOk.addActionListener(evt -> buOkActionPerformed(evt));
        buCancelar.setText("Cancelar");
        buCancelar.addActionListener(evt -> buCancelarActionPerformed(evt));

        javax.swing.JPanel botoes = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        botoes.add(buOk);
        botoes.add(buCancelar);

        getContentPane().add(painelCampos, java.awt.BorderLayout.CENTER);
        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);

        pack();
    }

    private void buOkActionPerformed(java.awt.event.ActionEvent evt) {
        if (operacaoCadastro != OperacaoCadastro.ocConsultar) {
            if (edNome.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome é obrigatório.");
                return;
            }
            pessoa.atualizarNome(edNome.getText());
            pessoa.atualizarTelefone(edTelefone.getText());
            pessoa.atualizarEmail(edEmail.getText());
            pessoa.atualizarLogradouro(edLogradouro.getText());
            pessoa.atualizarNumero(edNumero.getText());
            pessoa.atualizarComplemento(edComplemento.getText());
            pessoa.atualizarBairro(edBairro.getText());
            pessoa.atualizarCidade(edCidade.getText());
            pessoa.atualizarEstado((String) cbEstado.getSelectedItem());
            pessoa.atualizarCep(edCep.getText());
            pessoa.atualizarDocumento(edDocumento.getText());
            confirmado = true;
        }
        dispose();
    }

    private void buCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private javax.swing.JButton buCancelar;
    private javax.swing.JButton buOk;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JTextField edBairro;
    private javax.swing.JTextField edCep;
    private javax.swing.JTextField edCidade;
    private javax.swing.JTextField edComplemento;
    private javax.swing.JTextField edDocumento;
    private javax.swing.JTextField edEmail;
    private javax.swing.JTextField edLogradouro;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edNumero;
    private javax.swing.JTextField edTelefone;
    private javax.swing.JPanel painelCampos;
}
