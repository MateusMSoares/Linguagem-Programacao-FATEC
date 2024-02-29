package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Começando as aulas de Java");
        System.out.println("Vamos dominar o Java");
        System.out.print("Imprimindo na linha de cima\nImprimindo na Linha de baixo\n");

        Exercicios resolucao = new Exercicios();
        // Calcular gasto total do trimestre e a media de gasto
        // Janeiro = 15k
        // Fevereiro = 23k
        // Março = 17k
        int totalTrimestral = resolucao.gastoTotal(15000,23000,17000);
        double gastoMedio = resolucao.gastoMedio(15000,23000,17000);
        System.out.println("Gasto total Trimestral: R$"+ totalTrimestral);
        System.out.println("Gasto médio Trimestral: R$"+ gastoMedio);

        resolucao.calculaMedia(0, 2, 8, 6, 6, 6, "Mateus");
        resolucao.calculaMedia(9, 1, 9, 5, 6, 6, "Gabriela");
        resolucao.calculaMedia(7, 0, 6, 6, 6, 6, "Amanda");
        resolucao.calculaMedia(0, 1, 8, 7, 6, 6, "Laira");
        // a sub nao deve aumentar a nota caso a media >=6
        // x sao pontos extras no maximo até 2 pontos
    }
}