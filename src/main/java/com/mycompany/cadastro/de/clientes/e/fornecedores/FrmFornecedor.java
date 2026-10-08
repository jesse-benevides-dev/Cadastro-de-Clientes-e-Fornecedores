package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class FrmFornecedor extends FrmPessoa {

    public static boolean executar(java.awt.Frame parent,
                                   OperacaoCadastro operacaoCadastro,
                                   Fornecedor fornecedor) {
        FrmFornecedor frmFornecedor = new FrmFornecedor(parent, operacaoCadastro, fornecedor);
        frmFornecedor.setLocationRelativeTo(null);
        frmFornecedor.setVisible(true);
        return frmFornecedor.operacaoConfirmada();
    }

    public FrmFornecedor(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, Fornecedor fornecedor) {
        super(parent, operacaoCadastro, fornecedor, "Fornecedor", "CNPJ");
    }
}
