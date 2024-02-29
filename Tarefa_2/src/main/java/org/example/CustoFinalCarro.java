package org.example;

public class CustoFinalCarro {
    // O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do distribuidor e dos
    // impostos (aplicados ao custo de fábrica). Supondo que o percentual do distribuidor seja de 28% e os
    // impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro, calcular e escrever o custo
    // final ao consumidor.

    private double percentagemDistribuidor = 0.28;
    private double percentagemImpostos = 0.45;

    private double precoCarro;

    public CustoFinalCarro(int precoCarro){
        this.precoCarro = precoCarro;
    }

    void imprimeResultado(){
        double custoDistribuidor = (precoCarro*percentagemDistribuidor);
        double custoImpostos = (precoCarro*percentagemImpostos);
        double custoFabricacao = precoCarro - custoDistribuidor - custoImpostos;
        System.out.println("Custo de fabricacao: R$"+ custoFabricacao+". Custo de distribuição: R$"+custoDistribuidor+". Custo de impostos: R$"+custoImpostos+". Preço final: R$"+precoCarro);
    }
    public double calculaCustoDistribuidor(){
        double custoDistribuidor = (precoCarro*percentagemDistribuidor);
        return custoDistribuidor;
    }
    public double calculaCustoImpostos(){
        double custoImpostos = (precoCarro*percentagemImpostos);
        return custoImpostos;
    }
    public double calculaCustoFabricacao(){
        double custoDistribuidor = (precoCarro*percentagemDistribuidor);
        double custoImpostos = (precoCarro*percentagemImpostos);
        double custoFabricacao = precoCarro - custoDistribuidor - custoImpostos;
        return custoFabricacao;
    }
}
