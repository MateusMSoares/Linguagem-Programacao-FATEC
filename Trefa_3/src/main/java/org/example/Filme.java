package org.example;

public class Filme {
    // Atributos
    private String titulo;
    private int ano;
    private String diretor;

    // Construtor
    public Filme(String titulo, int ano, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
    }

    // Métodos
    public void reproduzir() {
        System.out.println("Reproduzindo o filme " + titulo + ".Lançado em "+ ano);
    }

    public void pausar() {
        System.out.println("Filme "+ titulo + " foi pausado.");
    }

    public void exibirinfo() {
        System.out.println("Filme "+ titulo + " lançado em: " + ano + "Diretor: " + diretor);
    }

    // Getter e Setter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
