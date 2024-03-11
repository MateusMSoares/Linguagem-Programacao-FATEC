package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestaClasse {
    public static void main(String[] args) {
    Aluno aluno1 = new Aluno("João", 20, "12334");

        Animal animal1 = new Animal("Leão", "Carnívoro", 15);

        Arma arma1 = new Arma("AK-47", 89, 2);

        Carro carro1 = new Carro("Toyota", "Corolla", 280);

        Cidade cidade1 = new Cidade("São Paulo", "São Paulo", 17688);

        Filme filme1 = new Filme("Matrix", 1999, "Lilly e Lana Wachowski");

        Fruta fruta1 = new Fruta("Maçã", "Doce", "boa");

        Livro livro1 = new Livro("Dom Quixote", "Miguel de Cervantes", "1605");

        Pessoa pessoa1 = new Pessoa("Regina", 65, "feliz");

        Produto produto1 = new Produto("Computador", 1500.0, true);

        aluno1.estudar();
        aluno1.exibirInformacao();

        animal1.emitirSom();
        animal1.dormir();

        arma1.atirar();
        arma1.recarregar();

        carro1.ligar();
        carro1.desligar();


        cidade1.exibirInformacoes();
        cidade1.alterarEstado("Alagoas");

        filme1.reproduzir();
        filme1.exibirinfo();

        fruta1.comerFruta();
        fruta1.exibirinfo();

        livro1.abrir();
        livro1.fechar();

        pessoa1.cumprimentar();
        pessoa1.despedir();

        produto1.exibirDetalhes();
        produto1.aplicarDesconto(99);
        produto1.verificarValidade();

        Matemagica fracao1 = new Matemagica(2, 5);
        Matemagica fracao2 = new Matemagica(3, 7);
        Matemagica fracao3 = new Matemagica(4, 3);
        Matemagica fracao4 = new Matemagica(2, 7);
        Matemagica fracao5 = new Matemagica(5, 3);
        Matemagica fracao6 = new Matemagica(7, 4);
        Matemagica fracao7 = new Matemagica(5, 4);
        Matemagica fracao8 = new Matemagica(7, 2);

        fracao1.soma(fracao2);
        fracao3.subtracao(fracao4);
        fracao5.multiplicacao(fracao6);
        fracao7.divisao(fracao8);

    }
}