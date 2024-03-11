package org.example;

public class Matemagica {
    private int numerador;
    private int denominador;

    public Matemagica(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void soma(Matemagica outraFracao){
        int novoNumerador = this.numerador * outraFracao.denominador + this.denominador * outraFracao.numerador;
        int novoDenominador = this.denominador * outraFracao.denominador;
        System.out.println("Resultado da soma: " + novoNumerador + "/" + novoDenominador);
    }

    public void subtracao(Matemagica outraFracao) {
        int novoNumerador = this.numerador * outraFracao.denominador - this.denominador * outraFracao.numerador;
        int novoDenominador = this.denominador * outraFracao.denominador;
        System.out.println("Resultado da subtração: " + novoNumerador + "/" + novoDenominador);
    }

    public void multiplicacao(Matemagica outraFracao) {
        int novoNumerador = this.numerador * outraFracao.numerador;
        int novoDenominador = this.denominador * outraFracao.denominador;
        System.out.println("Resultado da multiplicação: " + novoNumerador + "/" + novoDenominador);
    }

    public void divisao(Matemagica outraFracao) {
        int novoNumerador = this.numerador * outraFracao.denominador;
        int novoDenominador = this.denominador * outraFracao.numerador;
        System.out.println("Resultado da divisão: " + novoNumerador + "/" + novoDenominador);
    }
}
