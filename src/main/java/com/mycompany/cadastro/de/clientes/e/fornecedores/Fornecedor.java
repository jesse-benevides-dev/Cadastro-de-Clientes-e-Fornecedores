package com.mycompany.cadastro.de.clientes.e.fornecedores;

public class Fornecedor extends Pessoa {
    private String cnpj = "";

    public String obterCnpj() { return cnpj; }
    public void atualizarCnpj(String cnpj) { this.cnpj = cnpj; }

    @Override
    public String obterDocumento() { return cnpj; }

    @Override
    public void atualizarDocumento(String documento) { this.cnpj = documento; }
}
