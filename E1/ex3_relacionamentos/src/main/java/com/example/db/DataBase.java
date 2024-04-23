package com.example.db;

import com.example.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    //O estatico faz com que todos os objetos da classe DataBase compartilhem a mesma instancia
    //Dessa forma armazenando os produtos em uma unica instancia :)
    private static DataBase instancia;
    private List<Produto> produtos;

    public DataBase() {
        
        this.produtos = new ArrayList<>();
    }
    //Singleton
    public static DataBase obterInstancia() {
        if (instancia == null) {
            instancia = new DataBase();
        }
        return instancia;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }
}
