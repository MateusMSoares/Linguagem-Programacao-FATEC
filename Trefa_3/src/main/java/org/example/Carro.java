package org.example;

public class Carro {
    // Atributos
    private String marca;
    private String modelo;
    private int potencia;

    // Construtor
    public Carro(String marca, String modelo, int potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    // Métodos
    public void ligar() {
        System.out.println("O carro " + marca + " " + modelo + " foi ligado.");
    }

    public void desligar() {
        System.out.println("O carro " + marca + " " + modelo + " foi desligado.");
    }

    public void exibirinfo() {
        System.out.println("O carro " + marca + " " + modelo +  "Tem a potencia: " + potencia);
    }

    // Getter e Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
