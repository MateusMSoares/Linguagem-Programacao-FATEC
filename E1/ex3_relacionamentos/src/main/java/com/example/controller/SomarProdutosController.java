package com.example.controller;

import java.util.List;

import com.example.db.DataBase;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class SomarProdutosController {

    @FXML
    private ListView<Produto> listaProdutos;

    @FXML
    private Label labelPrecoTotal;

    @FXML
    public void initialize() {
        listaProdutos.setCellFactory(param -> new ListCell<Produto>() {
        
        @Override
        protected void updateItem(Produto produto, boolean empty) {
            super.updateItem(produto, empty);

            if (empty || produto == null) {
                setText(null);
                setGraphic(null);
            } else {
                Button deleteButton = new Button("Deletar");
                setText(produto.toString());
                deleteButton.setOnAction(event -> {
                    DataBase dataBase = new DataBase();
                    dataBase.deletarProduto(produto);
                    listaProdutos.getItems().remove(produto);
                });
                setGraphic(deleteButton);
                }
            }
        });
        popularTabela();
    }

    public void popularTabela(){
        DataBase dataBase = new DataBase();
        List<Produto> produtosBanco = dataBase.getProdutos();
        dataBase.fechaConexao();
        listaProdutos.getItems().addAll(produtosBanco);
        listaProdutos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        System.out.println("Produtos: " + produtosBanco);
    }

    @FXML
    public void calcularPrecoTotal() {
        double precoTotal = 0.0;
        DataBase dataBase = new DataBase();
        List<Produto> produtosBanco =  dataBase.getProdutos();
        for(Produto produto : produtosBanco){
            System.out.println("Produto: " + produto);
            System.out.println("Preço: " + produto.getPreco());
            precoTotal += produto.getPreco();
        }
        labelPrecoTotal.setText("Preço Total: R$" + precoTotal);
    }
}
