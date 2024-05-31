package com.example.model;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String tipoProduto;
    
    public Produto(String nome, double preco, String tipoProduto) {
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }

    public Produto(int id, String nome, double preco, String tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }
    public Produto(){
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    @Override
    public String toString() {
        return "tipo = " + tipoProduto + " id = " + id + ", nome = " + nome + ", preco = " + preco;
    }

    
}
