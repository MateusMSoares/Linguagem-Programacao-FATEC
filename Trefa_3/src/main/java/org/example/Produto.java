package org.example;

public class Produto {
    // Atributos
    private String nome;
    private double preco;

    private boolean validade;

    // Construtor
    public Produto(String nome, double preco, boolean validade) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }

    // Métodos
    public void exibirDetalhes() {
        System.out.println("Produto: " + nome + ", Preço: R$" + preco);
    }

    public void aplicarDesconto(double desconto) {
        preco -= desconto;
        System.out.println("Desconto aplicado! Novo preço: R$" + preco);
    }

    public void verificarValidade() {
        if (validade) {
            System.out.println("O produto " + nome + " está dentro do prazo de validade.");
        } else {
            System.out.println("Atenção: o produto " + nome + " está vencido!");
        }
    }

    // Getter e Setter

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
}
