package com.example;

public class Pessoa {
    // Atributos
    private String nome;
    private int idade;
    private String estadoEmocional;

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
    public String getEstadoEmocional() {
        return estadoEmocional;
    }
    public void setEstadoEmocional(String estadoEmocional) {
        this.estadoEmocional = estadoEmocional;
    }
}
