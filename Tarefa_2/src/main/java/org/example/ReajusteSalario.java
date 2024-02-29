package org.example;

public class ReajusteSalario {
    // Escreva um algoritmo para ler o salário mensal atual de um funcionário e o percentual de reajuste.
    // Calcular e escrever o valor do novo salário.
    private double salario;
    private double percentualReajuste;

    public ReajusteSalario(double salario, double percentualReajuste) {
        this.salario = salario;
        this.percentualReajuste = percentualReajuste;
    }

    void imprimeResultado(){
        double valorASerAdicionado = (percentualReajuste * salario) / 100;
        double novoSalario = salario + valorASerAdicionado;
        System.out.println("Salario antigo: R$"+salario+ ". Salario com reajuste de "+percentualReajuste+"%: "+"R$"+novoSalario);
    }

    public double calculaNovoSalario(){
        double valorASerAdicionado = (percentualReajuste * salario) / 100;
        double novoSalario = salario + valorASerAdicionado;
        return novoSalario;
    }
}
