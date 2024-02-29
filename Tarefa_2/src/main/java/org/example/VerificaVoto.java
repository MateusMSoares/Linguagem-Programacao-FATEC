package org.example;

public class VerificaVoto {
    // Ler o ano atual e o ano de nascimento de uma pessoa. Escrever uma mensagem que diga
    // se ela poderá ou não votar este ano (não é necessário considerar o mês em que a pessoa nasceu).
    private int anoAtual;
    private int anoNascimento;

    public VerificaVoto(int anoAtual, int anoNascimento) {
        this.anoAtual = anoAtual;
        this.anoNascimento = anoNascimento;
    }

    void imprimeResultado(){
        int idade = anoAtual - anoNascimento;
        if (idade >= 16) {
            System.out.println("Pode votar este ano.");
        } else {
            System.out.println("Não pode votar este ano.");
        }
    }
    public boolean podeVotar(){
        int idade = anoAtual - anoNascimento;
        boolean resultado = idade >= 16;
        return resultado;
    }
}
