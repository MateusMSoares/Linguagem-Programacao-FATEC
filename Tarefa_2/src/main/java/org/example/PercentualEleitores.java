package org.example;

public class PercentualEleitores {
    // Escreva um algoritmo para ler o número total de eleitores de um município,
    // o número de votos brancos, nulos e válidos. Calcular e escrever o percentual
    // que cada um representa em relação ao total de eleitores.

    private int brancos;
    private int nulos;
    private int validos;

    public PercentualEleitores(int brancos, int nulos, int validos) {
        this.brancos = brancos;
        this.nulos = nulos;
        this.validos = validos;
    }

    void imprimeResultado(){
        int total = brancos + nulos + validos;
        double porcentagemBrancos = (brancos * 100) / total;
        double porcentagemNulos = (nulos * 100) / total;
        double porcentagemValidos =(validos * 100) / total;

        System.out.println("Com o total de " + total + " votos. A porcentagem entre os votos, brancos: "+porcentagemBrancos+"%. nulos: "+porcentagemNulos+"%. validos: "+porcentagemValidos+"%.");
    }

    public double calculaPercentualVotosBrancos(){
        int total = brancos + nulos + validos;
        double porcentagemBrancos = (brancos * 100) / total;
        return porcentagemBrancos;
    }
    public double calculaPercentualVotosNulos(){
        int total = brancos + nulos + validos;
        double porcentagemNulos = (nulos * 100) / total;
        return porcentagemNulos;
    }
    public double calculaPercentualVotosValidos(){
        int total = brancos + nulos + validos;
        double porcentagemValidos = (validos * 100) / total;
        return porcentagemValidos;
    }

}
