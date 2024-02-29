package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       // 1)
        System.out.println("\n--------------------EX01--------------------\n");
        IdadeEmDIas idadeEmDIas = new IdadeEmDIas(27, 5, 15);
        idadeEmDIas.imprimeResultado();


        // 2)
        System.out.println("\n--------------------EX02--------------------\n");
        PercentualEleitores percentualEleitores = new PercentualEleitores(1024, 524, 128);
        percentualEleitores.imprimeResultado();

        // 3)
        System.out.println("\n--------------------EX03--------------------\n");
        ReajusteSalario reajusteSalario = new ReajusteSalario(5000, 5);
        reajusteSalario.imprimeResultado();

        // 4)
        System.out.println("\n--------------------EX04--------------------\n");
        CustoFinalCarro custoFinalCarro = new CustoFinalCarro(150000);
        custoFinalCarro.imprimeResultado();

        // 5)
        System.out.println("\n--------------------EX05--------------------\n");
        SalarioVendedorCarros salarioVendedorCarros = new SalarioVendedorCarros(2000, 5,
                0.02,300000);
        salarioVendedorCarros.imprimeResultado();

        // 6)
        System.out.println("\n--------------------EX06--------------------\n");
        TransformaFahrenheitemCelcius transformaFahrenheitemCelcius = new TransformaFahrenheitemCelcius(190);
        transformaFahrenheitemCelcius.imprimeResultado();

        // 7)
        System.out.println("\n--------------------EX07--------------------\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número para verificar se é maior do que 10: ");
        double numero = scanner.nextDouble();
        VerificarSeNumeroMaiorQueDez verificarSeNumeroMaiorQueDez = new VerificarSeNumeroMaiorQueDez(numero);
        verificarSeNumeroMaiorQueDez.imprimeResultado();

        // 8)
        // Ler um valor e escrever se é positivo ou negativo (considere o valor zero como positivo).
        System.out.println("\n--------------------EX08--------------------\n");
        System.out.println("Digite um número para verificar se é positivo ou negativo (0 é positivo): ");
        numero = scanner.nextDouble();
        NumeroPositivoOuNegativo numeroPositivoOuNegativo = new NumeroPositivoOuNegativo(numero);
        numeroPositivoOuNegativo.imprimeResultado();

        // 09)
        System.out.println("\n--------------------EX09--------------------\n");
        System.out.println("Digite a quatidade de maças compradas(>=12 custam R$1.00, do contrário custam R$1.30): ");
        int qtdMacas = scanner.nextInt();
        CustoMacas custoMacas = new CustoMacas(qtdMacas);
        custoMacas.imprimeResultado();

        // 10)
        System.out.println("\n--------------------EX10--------------------\n");
        System.out.println("Digite a nota da 1ª avaliação: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a nota da 2ª avaliação: ");
        double nota2 = scanner.nextDouble();
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno(nota1, nota2);
        avaliacaoAluno.imprimeResultado();

        // 11)
        System.out.println("\n--------------------EX11--------------------\n");
        System.out.println("Digite o ano atual: ");
        int anoAtual = scanner.nextInt();
        System.out.println("Digite o ano de nascimento: ");
        int anoNascimento = scanner.nextInt();
        VerificaVoto verificaVoto = new VerificaVoto(anoAtual, anoNascimento);
        verificaVoto.imprimeResultado();

        // 12)
        System.out.println("\n--------------------EX12--------------------\n");
        System.out.println("Digite dois valores diferentes: ");
        double valor1 = scanner.nextDouble();
        double valor2 = scanner.nextDouble();
        VerificaMaior verificaMaior = new VerificaMaior(valor1, valor2);
        verificaMaior.imprimeResultado();


        // 13)
        System.out.println("\n--------------------EX13--------------------\n");
        System.out.println("Digite dois valores diferentes: ");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        EscreveOrdemCrescente escreveOrdemCrescente = new EscreveOrdemCrescente(num1, num2);
        escreveOrdemCrescente.imprimeResultado();

        // 14)
        System.out.println("\n--------------------EX14--------------------\n");
        System.out.println("Digite a hora de início e a hora de fim do jogo de Xadrez: ");
        int horaInicio = scanner.nextInt();
        int horaFim = scanner.nextInt();
        DuracaoJogoXadrez duracaoJogoXadrez = new DuracaoJogoXadrez(horaInicio, horaFim);
        duracaoJogoXadrez.imprimeResultado();

        // 15)
        System.out.println("\n--------------------EX15--------------------\n");
        System.out.println("Digite o número de horas trabalhadas no mês(mês de 4 semanas com carga de 40 semanais): ");
        double horasTrabalhadas = scanner.nextDouble();
        System.out.println("Digite o salário por hora: ");
        double salarioPorHora = scanner.nextDouble();
        SalarioFuncionario salarioFuncionario = new SalarioFuncionario(horasTrabalhadas, salarioPorHora);
        salarioFuncionario.imprimeResultado();
        scanner.close();
    }

}