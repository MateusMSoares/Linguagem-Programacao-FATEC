package org.example;

public class Fruta {
    // Atributos
    private String nome;
    private String sabor;

    private String condicao;

    // Construtor
    public Fruta(String nome, String sabor, String condicao) {
        this.nome = nome;
        this.sabor = sabor;
        this.condicao = condicao;
    }

    // Métodos
    public void comerFruta() {
        System.out.println("A fruta \"" + nome + " é uma delicia.");
    }

    public void saborFruta() {
        System.out.println("A fruta " + nome + " tem sabor " + sabor);
    }

    public void exibirinfo() {
        System.out.println("A fruta " + nome + " tem sabor " + sabor + " e está em condicao " + condicao);
    }
}
