package com.mycompany.cadastro.de.clientes.e.fornecedores;

/** Classe base: todos os dados comuns a Cliente e Fornecedor. */
public abstract class Pessoa {
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private String logradouro = "";
    private String numero = "";
    private String complemento = "";
    private String bairro = "";
    private String cidade = "";
    private String estado = "";
    private String cep = "";

    /** CPF (Cliente) ou CNPJ (Fornecedor). */
    public abstract String obterDocumento();
    public abstract void atualizarDocumento(String documento);

    public String obterNome() { return nome; }
    public void atualizarNome(String nome) { this.nome = nome; }

    public String obterTelefone() { return telefone; }
    public void atualizarTelefone(String telefone) { this.telefone = telefone; }

    public String obterEmail() { return email; }
    public void atualizarEmail(String email) { this.email = email; }

    public String obterLogradouro() { return logradouro; }
    public void atualizarLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String obterNumero() { return numero; }
    public void atualizarNumero(String numero) { this.numero = numero; }

    public String obterComplemento() { return complemento; }
    public void atualizarComplemento(String complemento) { this.complemento = complemento; }

    public String obterBairro() { return bairro; }
    public void atualizarBairro(String bairro) { this.bairro = bairro; }

    public String obterCidade() { return cidade; }
    public void atualizarCidade(String cidade) { this.cidade = cidade; }

    public String obterEstado() { return estado; }
    public void atualizarEstado(String estado) { this.estado = estado; }

    public String obterCep() { return cep; }
    public void atualizarCep(String cep) { this.cep = cep; }
}
