package org.example;

public class Arma {
    // Atributos
    private String nome;
    private int poder;
    private int mira;

    // Construtor
    public Arma(String nome, int poder, int mira) {
        this.nome = nome;
        this.poder = poder;
        this.mira = mira;
    }

    // Métodos
    public void atirar() {
        System.out.println("A arma " + nome + " está atirando com poder " + poder);
    }

    public void recarregar() {
        System.out.println("Recarregando a arma " + nome);
    }

    public void mirar() {
        System.out.println("A arma está com a mira " + mira + "x.");
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
}
