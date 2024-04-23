package com.example.controller;

import java.util.List;

import com.example.db.DataBase;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class SomarProdutosController {

    @FXML
    private ListView<Produto> listaProdutos;

    @FXML
    private Label labelPrecoTotal;

    @FXML
    public void initialize() {

        listaProdutos.getItems().addAll(DataBase.getProdutos());
        listaProdutos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        System.out.println("Produtos: " + DataBase.getProdutos());
    }

    @FXML
    public void calcularPrecoTotal() {
        double precoTotal = 0.0;
        List<Produto> produtos =  DataBase.getProdutos();
        for(Produto produto : produtos){
            precoTotal += produto.getPreco();
        }
        labelPrecoTotal.setText("Preço Total: R$" + precoTotal);
    }
}
