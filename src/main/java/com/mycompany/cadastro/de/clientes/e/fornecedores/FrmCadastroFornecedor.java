package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class FrmCadastroFornecedor extends FrmCadastroPessoa {

    public FrmCadastroFornecedor(java.awt.Frame parent) {
        super(parent, "Cadastro de Fornecedores", "CNPJ");
    }

    @Override
    protected Pessoa novaPessoa() {
        return new Fornecedor();
    }

    @Override
    protected boolean abrirFormulario(OperacaoCadastro operacao, Pessoa pessoa) {
        return FrmFornecedor.executar(null, operacao, (Fornecedor) pessoa);
    }
}
