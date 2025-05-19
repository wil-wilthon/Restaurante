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
    private UnidadesMedidas unidade;
    private double quantidade;
    private String dataValidade;

    public Produto(int id, String nome, UnidadesMedidas unidade, double quantidade, String dataValidade) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
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
    
    
}
