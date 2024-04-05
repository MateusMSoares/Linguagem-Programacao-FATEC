package com.example.service;

import com.example.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private static ProdutoService instancia;
    private List<Produto> produtos;

    public ProdutoService() {
        this.produtos = new ArrayList<>();
    }

    public static ProdutoService obterInstancia() {
        if (instancia == null) {
            instancia = new ProdutoService();
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
