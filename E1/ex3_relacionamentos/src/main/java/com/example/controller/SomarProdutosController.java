package com.example.controller;

import com.example.model.Produto;
import com.example.service.ProdutoService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class SomarProdutosController {

    @FXML
    private ListView<Produto> listaProdutos;

    @FXML
    private Label labelPrecoTotal;

    private ProdutoService produtoService;

    @FXML
    public void initialize() {
        this.produtoService = ProdutoService.obterInstancia();
        listaProdutos.getItems().addAll(produtoService.getProdutos());
        listaProdutos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        System.out.println("Produtos: " + produtoService.getProdutos());
    }

    @FXML
    public void calcularPrecoTotal() {
        double precoTotal = listaProdutos.getSelectionModel().getSelectedItems().stream()
            .mapToDouble(Produto::getPreco)
            .sum();
        labelPrecoTotal.setText("Preço Total: " + precoTotal);
    }
}
