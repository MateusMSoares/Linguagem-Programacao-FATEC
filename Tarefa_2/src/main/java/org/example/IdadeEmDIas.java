package org.example;

public class IdadeEmDIas {
    //Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e
    // escreva a idade dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e
    // mês com 30 dias.

    private int anos;
    private int meses;
    private int dias;

    public IdadeEmDIas(int anos, int meses, int dias) {
        this.anos = anos;
        this.meses = meses;
        this.dias = dias;
    }

    void imprimeResultado(){
        int ano = 365;
        int mes = 30;
        int resultado = (ano*anos) + (mes*meses) + dias;
        System.out.println("A idade em dias é: " + resultado);
    }

    public int calculaIdadeEmDias(){
        int ano = 365;
        int mes = 30;
        int resultado = (ano*anos) + (mes*meses) + dias;
        return resultado;
    }
}
