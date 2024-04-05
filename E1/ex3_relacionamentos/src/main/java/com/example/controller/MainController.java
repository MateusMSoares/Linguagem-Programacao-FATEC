package com.example.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class MainController {
    @FXML
    private TabPane abas;

    @FXML
    private Tab tabCadastrarProduto;

    @FXML
    private Tab tabSomarProdutos;

    @FXML
    public void initialize() {
        abas.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            
            if (newTab == tabCadastrarProduto) {
                try {
                    Pane CadastroProdutoPane = FXMLLoader.load(getClass().getResource("/com/example/view/CadastroProduto.fxml"));
                    tabCadastrarProduto.setContent(CadastroProdutoPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (newTab == tabSomarProdutos) {
                try {
                    Pane SomarProdutosPane = FXMLLoader.load(getClass().getResource("/com/example/view/SomarProdutos.fxml"));
                    tabSomarProdutos.setContent(SomarProdutosPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
