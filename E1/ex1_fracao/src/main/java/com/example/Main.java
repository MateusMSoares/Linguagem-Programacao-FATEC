package com.example;

public class Main {
    public static void main(String[] args) {
        Matemagica fracao1 = new Matemagica(2, 5);
        Matemagica fracao2 = new Matemagica(3, 7);
        Matemagica fracao3 = new Matemagica(4, 3);
        Matemagica fracao4 = new Matemagica(2, 7);
        Matemagica fracao5 = new Matemagica(5, 3);
        Matemagica fracao6 = new Matemagica(7, 4);
        Matemagica fracao7 = new Matemagica(5, 4);
        Matemagica fracao8 = new Matemagica(7, 2);

        fracao1.soma(fracao2);
        fracao3.subtracao(fracao4);
        fracao5.multiplicacao(fracao6);
        fracao7.divisao(fracao8);
    }
}