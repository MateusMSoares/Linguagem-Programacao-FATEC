package org.example;

public class Aluno {
    // Atributos
    private String nome;
    private int idade;
    private String matricula;

    // Construtor
    public Aluno(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Métodos
    public void estudar() {
        System.out.println(nome + " está estudando.");
    }

    public void fazerProva() {
        System.out.println(nome + " está fazendo a prova.");
    }

    public void exibirInformacao() {
        System.out.println("Nome aluno: "+ nome + ". Número Matricula:" + matricula);
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
