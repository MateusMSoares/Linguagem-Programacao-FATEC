package org.example;

public class EscreveOrdemCrescente {
    // Ler dois valores (considere que não serão lidos valores iguais) e escrevê-los em ordem crescente.
    private double num1;
    private double num2;

    public EscreveOrdemCrescente(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    void imprimeResultado(){
        System.out.println("Os números em ordem crescente: " + Math.min(num1, num2) + " " + Math.max(num1, num2));
    }

    public String retornaOrdem(){
        String resultado = Math.min(num1, num2) + " " + Math.max(num1, num2);
        return resultado;
    }
}
