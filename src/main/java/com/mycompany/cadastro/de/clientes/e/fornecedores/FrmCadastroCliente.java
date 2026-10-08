package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class FrmCadastroCliente extends FrmCadastroPessoa {

    public FrmCadastroCliente(java.awt.Frame parent) {
        super(parent, "Cadastro de Clientes", "CPF");
    }

    @Override
    protected Pessoa novaPessoa() {
        return new Cliente();
    }

    @Override
    protected boolean abrirFormulario(OperacaoCadastro operacao, Pessoa pessoa) {
        return FrmCliente.executar(null, operacao, (Cliente) pessoa);
    }
}
