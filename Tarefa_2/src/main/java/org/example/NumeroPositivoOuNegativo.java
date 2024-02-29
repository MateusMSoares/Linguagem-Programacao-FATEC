package org.example;

public class NumeroPositivoOuNegativo {
    // Ler um valor e escrever se é positivo ou negativo (considere o valor zero como positivo).

    private double numero;

    public NumeroPositivoOuNegativo(double numero) {
        this.numero = numero;
    }

    void imprimeResultado(){
        boolean resultado = numero >= 0;
        if (resultado) {
            System.out.println("O número "+numero+ " é positivo.");
        } else {
            System.out.println("O número " +numero+ " negativo.");
        }
    }

    public boolean calculaNumeroPositivoOuNegativo(){
        return numero >= 0;
    }
}
