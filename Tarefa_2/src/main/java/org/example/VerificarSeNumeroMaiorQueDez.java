package org.example;

public class VerificarSeNumeroMaiorQueDez {
    //Ler um valor e escrever a mensagem É MAIOR QUE 10! se o valor lido for maior que 10, caso contrário escrever
    // NÃO É MAIOR QUE 10!
    private double numero;

    public VerificarSeNumeroMaiorQueDez(double numero) {
        this.numero = numero;
    }

    void imprimeResultado(){
        if (numero > 10){
            System.out.println(numero +" É MAIOR QUE 10!");
        }else{
            System.out.println(numero +" NÃO É MAIOR QUE 10!");
        }
    }

    public boolean calculaSeNumeroMaiorQueDez(){
        return numero > 10;
    }
}
