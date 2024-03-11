package org.example;

public class Pessoa {
    // Atributos
    private String nome;
    private int idade;
    private String estadoEmocional;

    // Construtor
    public Pessoa(String nome, int idade, String estadoEmocional) {
        this.nome = nome;
        this.idade = idade;
        this.estadoEmocional = estadoEmocional;

    }

    // Métodos
    public void cumprimentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }

    public void despedir() {
        System.out.println("Até logo!");
    }

    public void exibirinfo() {
        System.out.println("A pessoa" + nome + " tem " + idade +" anos e está "+ estadoEmocional );
    }

    // Getter e Setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
