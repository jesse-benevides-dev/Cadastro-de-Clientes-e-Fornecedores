package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class FrmListagem extends javax.swing.JDialog {

    public FrmListagem(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    // monta a tabela com tudo que está cadastrado (clientes primeiro, depois fornecedores)
    public void carregar(ModeloTabelaPessoa clientes, ModeloTabelaPessoa fornecedores) {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new String[]{"Tipo", "Nome", "Telefone", "E-mail", "Logradouro", "Número",
                         "Complemento", "Bairro", "Cidade", "Estado", "CEP", "CPF / CNPJ"}, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };
        adicionar(modelo, clientes, "Cliente");
        adicionar(modelo, fornecedores, "Fornecedor");
        tabelaListagem.setModel(modelo);

        int larguras[] = {80, 150, 100, 170, 150, 60, 100, 110, 110, 50, 90, 120};
        for (int i = 0; i < larguras.length; i++) {
            tabelaListagem.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
        }
        setTitle("Listagem Geral - " + modelo.getRowCount() + " registro(s)");
    }

    private void adicionar(javax.swing.table.DefaultTableModel modelo,
                           ModeloTabelaPessoa origem, String tipo) {
        for (int i = 0; i < origem.getRowCount(); i++) {
            Pessoa p = origem.obterPessoa(i);
            modelo.addRow(new Object[]{tipo, p.obterNome(), p.obterTelefone(), p.obterEmail(),
                p.obterLogradouro(), p.obterNumero(), p.obterComplemento(), p.obterBairro(),
                p.obterCidade(), p.obterEstado(), p.obterCep(), p.obterDocumento()});
        }
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListagem = new javax.swing.JTable();
        buFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        tabelaListagem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabelaListagem);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 350));
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        buFechar.setText("Fechar");
        buFechar.addActionListener(evt -> buFecharActionPerformed(evt));
        javax.swing.JPanel rodape = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        rodape.add(buFechar);
        getContentPane().add(rodape, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void buFecharActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private javax.swing.JButton buFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaListagem;
}
