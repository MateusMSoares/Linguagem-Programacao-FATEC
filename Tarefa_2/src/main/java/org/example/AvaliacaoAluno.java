package org.example;

public class AvaliacaoAluno {
    // Ler as notas da 1a. e 2a. avaliações de um aluno. Calcular a média aritmética simples e escrever
    // uma mensagem que diga se o aluno foi ou não aprovado (considerar que nota igual ou maior que 6 o
    // aluno é aprovado). Escrever também a média calculada.
    private double nota1;
    private double nota2;

    public AvaliacaoAluno(double nota1, double nota2) {
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    void imprimeResultado(){
        double media = (nota1 + nota2) / 2;
        System.out.println("Média aritmética: " + media);
        if (media >= 6) {
            System.out.println("Aluno aprovado.");
        } else {
            System.out.println("Aluno reprovado.");
        }
    }
    public double calculaMedia(){
        double media = (nota1 + nota2) / 2;
        return media;
    }
    public boolean verificaAprovacao(){
        double media = (nota1 + nota2) / 2;
        boolean resultado = media >= 6;
        return resultado;
    }
}
