package org.example;

public class Animal {
    // Atributos
    private String especie;
    private String nome;
    private int idade;

    // Construtor
    public Animal(String especie, String nome, int idade) {
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos
    public void emitirSom() {
        System.out.println("O " + especie + " " + nome + " emite um som.");
    }

    public void dormir() {
        System.out.println("O " + especie + " " + nome + " está dormindo.");
    }

    public void crescer() {
        idade += 1;
        System.out.println("O " + especie + " " + nome + " está crescendo." + " Idade:" + idade);
    }

    // Getter e Setter

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
