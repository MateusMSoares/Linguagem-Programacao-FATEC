package org.example;

public class TransformaFahrenheitemCelcius {
    // Escreva um algoritmo para ler uma temperatura em graus Fahrenheit, calcular e escrever o valor
    // correspondente em graus Celsius. Observação: Para testar se a sua resposta está correta saiba
    // que 100°C = 212°F
    private double fahrenheit;

    public TransformaFahrenheitemCelcius(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    void imprimeResultado(){
        double resultado = ((fahrenheit - 32) * 5) / 9;
        System.out.printf("%.1f°F em Celsius correspondem a %.1f°C.", fahrenheit, resultado);
    }

    public double CalculaTransformaFahrenheitemCelcius(){
        double resultado = ((fahrenheit - 32) * 5) / 9;
        return resultado;
    }
}
