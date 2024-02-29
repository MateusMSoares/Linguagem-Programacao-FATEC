package org.example;

public class SalarioVendedorCarros {
    // Uma revendedora de carros usados paga a seus funcionários vendedores um salário fixo por mês,
    // mais uma comissão também fixa para cada carro vendido e mais 5% do valor das vendas por ele efetuadas.
    // Escrever um algoritmo que leia o número de carros por ele vendidos, o valor total de suas vendas,
    // o salário fixo e o valor que ele recebe por carro vendido. Calcule e escreva o salário final do vendedor.
    private double salario;
    private int quantidadeCarrosVendidos;
    private double comissaoPorCarro;
    private double valorTotalVendido;
    private double percentagemPorTotaldeVendas = 0.05;

    public SalarioVendedorCarros(double salario, int quantidadeCarrosVendidos, double comissaoPorCarro, double valorTotalVendido) {
        this.salario = salario;
        this.quantidadeCarrosVendidos = quantidadeCarrosVendidos;
        this.comissaoPorCarro = comissaoPorCarro;
        this.valorTotalVendido = valorTotalVendido;
    }

    void imprimeResultado(){
        double comissaoTotalPorCarroVendido = (valorTotalVendido * comissaoPorCarro);
        double comissaoPorCarro = comissaoTotalPorCarroVendido / quantidadeCarrosVendidos;
        double comissaoPorValorVendido = (valorTotalVendido *percentagemPorTotaldeVendas);
        double salarioTotal = salario + comissaoTotalPorCarroVendido + comissaoPorValorVendido;

        System.out.println("Salário base: " + salario);
        System.out.println("Comissão por carro vendido: " + comissaoPorCarro);
        System.out.println("Comissão total por carro vendido: " + comissaoTotalPorCarroVendido);
        System.out.println("Comissão por valor vendido: " + comissaoPorValorVendido);
        System.out.println("Salário total: " + salarioTotal);
    }

    public double calculaComissaoPorCarroVendido() {
        double comissaoTotalPorCarroVendido = (valorTotalVendido * comissaoPorCarro);
        double comissaoPorCarro = comissaoTotalPorCarroVendido / quantidadeCarrosVendidos;
        return comissaoPorCarro;
    }

    public double calculaComissaoTotalPorCarroVendido(){
        double comissaoTotalPorCarroVendido = (valorTotalVendido * comissaoPorCarro);
        return comissaoTotalPorCarroVendido;
    }
    public double calculaComissaoPorValorVendido(){
        double comissaoPorValorVendido = (valorTotalVendido *percentagemPorTotaldeVendas);
        return comissaoPorValorVendido;
    }
    public double calculaSalarioFinal(){
        double comissaoTotalPorCarroVendido = (valorTotalVendido * comissaoPorCarro);
        double comissaoPorCarro = comissaoTotalPorCarroVendido / quantidadeCarrosVendidos;
        double comissaoPorValorVendido = (valorTotalVendido *percentagemPorTotaldeVendas);
        double salarioTotal = salario + comissaoTotalPorCarroVendido + comissaoPorValorVendido;
        return salarioTotal;
    }
}
