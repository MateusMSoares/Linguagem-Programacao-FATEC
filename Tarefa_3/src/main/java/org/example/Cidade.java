package org.example;

public class Cidade {
    // Atributos
    private String nome;
    private String estado;
    private int populacao;

    // Construtor
    public Cidade(String nome, String estado, int populacao) {
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
    }

    // Métodos
    public void exibirInformacoes() {
        System.out.println("Cidade: " + nome + ", Estado: " + estado);
    }

    public void alterarEstado(String novoEstado) {
        estado = novoEstado;
        System.out.println("Estado alterado para " + novoEstado);
    }

    public void exibirInfo () {
        System.out.println("A cidade: "+ nome + " do estado: " + estado+ " tem a população de: "+ populacao);
    }

    // Getter e Setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
