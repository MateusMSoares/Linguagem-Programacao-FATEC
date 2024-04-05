package com.example.model;

public class Computador extends Produto{
    private String processador;
    private String memoria;

    
    public Computador(String nome, double preco, String processador, String memoria) {
        super(nome, preco, "computador");
        this.processador = processador;
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }
    
    public void setProcessador(String processador) {
        this.processador = processador;
    }
    
    public String getMemoria() {
        return memoria;
    }
    
    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", processador = " + processador + ", memoria = " + memoria;
    }
}
