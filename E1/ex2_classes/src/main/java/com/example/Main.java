package com.example;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Livro livro1 = new Livro();
        Cidade cidade1 = new Cidade();

        pessoa1.setNome("Regina");
        pessoa1.setIdade(65);
        pessoa1.setEstadoEmocional("feliz");

        livro1.setTitulo("Dom Quixote");
        livro1.setAutor("Miguel de Cervantes");
        livro1.setLancamento("1605");

        cidade1.setNome("São Paulo");
        cidade1.setEstado("São Paulo");
        cidade1.setPopulacao(17688);

    }
}