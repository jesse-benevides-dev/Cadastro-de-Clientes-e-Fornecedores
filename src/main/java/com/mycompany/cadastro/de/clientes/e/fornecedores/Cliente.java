package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class Cliente extends Pessoa {
    private String cpf = "";

    public String obterCpf() { return cpf; }
    public void atualizarCpf(String cpf) { this.cpf = cpf; }

    @Override
    public String obterDocumento() { return cpf; }

    @Override
    public void atualizarDocumento(String documento) { this.cpf = documento; }
}
