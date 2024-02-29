package org.example;

public class SalarioFuncionario {
    //A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que trabalhar
    // mais de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular com um acréscimo
    // de 50%. Escreva um algoritmo que leia o número de horas trabalhadas em um mês, o salário por hora
    // e escreva o salário total do funcionário, que deverá ser acrescido das horas extras,
    // caso tenham sido trabalhadas (considere que o mês possua 4 semanas exatas).
    private double horasTrabalhadas;
    private double salarioPorHora;
    private final int HORAS_SEMANAIS = 40;
    private final double TAXA_EXTRA = 0.5;

    public SalarioFuncionario(double horasTrabalhadas, double salarioPorHora) {
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioPorHora = salarioPorHora;
    }

    void imprimeResultado(){
        double salarioTotal;
        if (horasTrabalhadas > HORAS_SEMANAIS) {
            double horasExtras = horasTrabalhadas - HORAS_SEMANAIS;
            salarioTotal = (HORAS_SEMANAIS * salarioPorHora) + (horasExtras * salarioPorHora * TAXA_EXTRA);
        } else {
            salarioTotal = horasTrabalhadas * salarioPorHora;
        }
        System.out.println("Salário total do funcionário: " + salarioTotal);
    }

    public double calculaSalario(){
        double salarioTotal;
        if (horasTrabalhadas > HORAS_SEMANAIS) {
            double horasExtras = horasTrabalhadas - HORAS_SEMANAIS;
            salarioTotal = (HORAS_SEMANAIS * salarioPorHora) + (horasExtras * salarioPorHora * TAXA_EXTRA);
        } else {
            salarioTotal = horasTrabalhadas * salarioPorHora;
        }
        return salarioTotal;
    }
}
