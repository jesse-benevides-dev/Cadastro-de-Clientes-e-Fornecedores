package com.mycompany.cadastro.de.clientes.e.fornecedores;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaPessoa extends AbstractTableModel {

    private String colunas[];
    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public ModeloTabelaPessoa(String rotuloDocumento) {
        colunas = new String[]{"Nome", "Telefone", "E-mail", "Cidade", "Estado", rotuloDocumento};
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        Pessoa p = pessoas.get(indiceLinha);
        String valores[] = {p.obterNome(), p.obterTelefone(), p.obterEmail(),
                            p.obterCidade(), p.obterEstado(), p.obterDocumento()};
        return valores[indiceColuna];
    }

    public Pessoa obterPessoa(int indicePessoa) {
        return pessoas.get(indicePessoa);
    }

    public void incluirPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        int ultimo = getRowCount() - 1;
        fireTableRowsInserted(ultimo, ultimo);
    }

    public void atualizarPessoa(int indicePessoa, Pessoa pessoa) {
        pessoas.set(indicePessoa, pessoa);
        fireTableRowsUpdated(indicePessoa, indicePessoa);
    }

    public void excluirPessoa(int indicePessoa) {
        pessoas.remove(indicePessoa);
        fireTableRowsDeleted(indicePessoa, indicePessoa);
    }
}
