package com.example.controller;

import java.nio.file.Paths;

import com.example.model.Computador;
import com.example.model.Livro;
import com.example.model.Produto;
import com.example.service.ProdutoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

public class CadastroProdutoController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoPreco;
    @FXML
    private ComboBox<String> selecaoProduto;
    @FXML
    private TextField campoAutor;
    @FXML
    private TextField campoEditora;
    @FXML
    private TextField campoProcessador;
    @FXML
    private TextField campoMemoria;
    @FXML
    private Button cadastrar;
    @FXML
    private ImageView imagemView;

    private ProdutoService produtoService;
    

    @FXML
    public void initialize() {
        Image imagemLivro = new Image(getClass().getResourceAsStream("/com/example/imagens/livro.png"));
        Image imagemComputador = new Image(getClass().getResourceAsStream("/com/example/imagens/computador.png"));

        this.produtoService = ProdutoService.obterInstancia();
        selecaoProduto.getItems().addAll("Livro","Computador");
        cadastrar.setVisible(false);

        // Adicione um ouvinte de ação ao ComboBox
        selecaoProduto.setOnAction((event) -> {
        String produtoSelecionado = selecaoProduto.getValue();
        
        if (produtoSelecionado.equals("Livro")) {
            imagemView.setImage(imagemLivro);
            exibirCamposLivro();
        } else if (produtoSelecionado.equals("Computador")) {
            imagemView.setImage(imagemComputador);
            exibirCamposComputador();
        }
    });

    }

    @FXML
    public void cadastrarProduto(ActionEvent event) {
        String tipoProduto = selecaoProduto.getValue();
        System.out.println("Tipo de Produto: " + tipoProduto);

        if (tipoProduto == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Cadastro de Produto");
            alert.setHeaderText(null);
            alert.setContentText("Selecione um tipo de produto!");

            alert.showAndWait();
            return; 
        }

        Produto produto;

        if (tipoProduto.equals("Livro")){
           
            String nome = campoNome.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            String autor = campoAutor.getText();
            String editora = campoEditora.getText();
            
            produto = new Livro(nome, preco, autor, editora);
            produtoService.addProduto(produto);
            System.out.println("Nome: " + nome + " Preço: " + preco + " Tipo: " + tipoProduto);

        } else if (tipoProduto.equals("Computador")){
            
            String nome = campoNome.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            String processador = campoProcessador.getText();
            String memoria = campoMemoria.getText();
            produto = new Computador(nome, preco, processador, memoria);
            produtoService.addProduto(produto);
            System.out.println("Nome: " + nome + " Preço: " + preco + " Tipo: " + tipoProduto);
        }


        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Cadastro de Produto");
        alert.setHeaderText(null);
        alert.setContentText("Produto cadastrado com sucesso!");

        alert.showAndWait();

        campoNome.clear();
        campoPreco.clear();
        campoAutor.clear();
        campoEditora.clear();
        campoProcessador.clear();
        campoMemoria.clear();
    }

    private void exibirCamposLivro() {
        campoNome.setPromptText("Título do Livro");
        campoPreco.setPromptText("Preço do Livro");
        campoAutor.setPromptText("Autor do Livro");
        campoEditora.setPromptText("Editora do Livro");
        campoAutor.setVisible(true);
        campoEditora.setVisible(true);
        campoMemoria.setVisible(false);
        campoProcessador.setVisible(false);
        cadastrar.setVisible(true);

    }

    private void exibirCamposComputador(){
        campoNome.setPromptText("Nome do Computador");
        campoPreco.setPromptText("Preço do Computador");
        campoProcessador.setPromptText("Processador do Computador");
        campoMemoria.setPromptText("Memória do Computador");
        campoProcessador.setVisible(true);
        campoMemoria.setVisible(true);
        campoAutor.setVisible(false);
        campoEditora.setVisible(false);
        cadastrar.setVisible(true);
    }
}