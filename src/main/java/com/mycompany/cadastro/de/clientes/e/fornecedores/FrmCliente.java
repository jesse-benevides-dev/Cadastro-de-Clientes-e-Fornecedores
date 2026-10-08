package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class FrmCliente extends FrmPessoa {

    public static boolean executar(java.awt.Frame parent,
                                   OperacaoCadastro operacaoCadastro,
                                   Cliente cliente) {
        FrmCliente frmCliente = new FrmCliente(parent, operacaoCadastro, cliente);
        frmCliente.setLocationRelativeTo(null);
        frmCliente.setVisible(true);
        return frmCliente.operacaoConfirmada();
    }

    public FrmCliente(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, Cliente cliente) {
        super(parent, operacaoCadastro, cliente, "Cliente", "CPF");
    }
}
