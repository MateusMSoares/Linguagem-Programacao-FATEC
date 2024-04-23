package com.example.db;

import com.example.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    // Tornando essa lista estatica faz com que ela se torne uma variavel da 
    // classe e nao de uma instancia da classe
    private static List<Produto> produtos = new ArrayList<>();

    public static void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }
}
