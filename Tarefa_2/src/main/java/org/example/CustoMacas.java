package org.example;

public class CustoMacas {
    // As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 se forem
    // compradas pelo menos 12. Escreva um programa que leia o número de maçãs compradas,
    // calcule e escreva o custo total da compra.
    private int qtdmacas;

    private final double duzia = 1.00;
    private final double menosUmaDuzia = 1.30;

    public CustoMacas(int qtdmacas) {
        this.qtdmacas = qtdmacas;
    }

    void imprimeResultado(){
        double resultado = 0;
        if (qtdmacas >= 12){
            resultado = qtdmacas * duzia;
        } else {
            resultado = qtdmacas * menosUmaDuzia;
        }
        System.out.println("Maças compradas  " + qtdmacas + ". Preço: R$"+resultado);
    }

    public double calculaPrecoCompra(){
        double resultado = 0;
        if (qtdmacas >= 12){
            resultado = qtdmacas * duzia;
        } else {
            resultado = qtdmacas * menosUmaDuzia;
        }
        return resultado;
    }
}
