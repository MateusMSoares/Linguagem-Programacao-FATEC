package org.example;

public class VerificaMaior {
    // Ler dois valores (considere que não serão lidos valores iguais) e escrever o maior deles.
    private double valor1;
    private double valor2;

    public VerificaMaior(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    void imprimeResultado(){
        double maior = Math.max(valor1, valor2);
        System.out.println("O maior valor é: " + maior);
    }

    public double retornaMaior(){
        double maior = Math.max(valor1, valor2);
        return maior;
    }
}
