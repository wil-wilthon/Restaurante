/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.rules;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L; // Para compatibilidade de versões
    private int id;
    private String nome;
    private String ean;
    private UnidadesMedidas unidade;
    private int lote;
    private double quantidade;
    private String dataValidade;
    private double preco;
    private double custo;
    private double custoMedio;

    public Produto(int id, String nome, String ean, int lote, UnidadesMedidas unidade, double quantidade, String dataValidade, double preco, double custo, double custoMedio) {
        this.id = id;
        this.nome = nome;
        this.ean = ean;
        this.lote = lote;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.preco = preco;
        this.custo = custo;
        this.custoMedio = custoMedio;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public UnidadesMedidas getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadesMedidas unidade) {
        this.unidade = unidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(double custoMedio) {
        this.custoMedio = custoMedio;
    }
    
    
}
