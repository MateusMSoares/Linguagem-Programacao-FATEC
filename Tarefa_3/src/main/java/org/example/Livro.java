package org.example;

public class Livro {
    // Atributos
    private String titulo;
    private String autor;
    private String lancamento;

    // Construtor
    public Livro(String titulo, String autor, String lancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.lancamento = lancamento;
    }

    // Métodos
    public void abrir() {
        System.out.println("O livro \"" + titulo + "\" de " + autor + " foi aberto.");
    }

    public void fechar() {
        System.out.println("O livro \"" + titulo + "\" de " + autor + " foi fechado.");
    }

    public void exibirinfo() {
        System.out.println("O livro \"" + titulo + "\" de " + autor + " foi lançado em " + lancamento);
    }

    //Getter e Setter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
