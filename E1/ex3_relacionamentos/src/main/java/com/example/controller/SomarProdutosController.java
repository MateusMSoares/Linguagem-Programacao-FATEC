package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.db.DataBase;
import com.example.model.Computador;
import com.example.model.Livro;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
                HBox hbox = new HBox(10);

                Button editButton = new Button("Editar");
                editButton.setOnAction(event -> {
                    Produto produtoSelecionado = getItem();
                    editarProduto(produtoSelecionado);
                });

                Button deleteButton = new Button("Deletar");
                deleteButton.setOnAction(event -> {
                    DataBase dataBase = new DataBase();
                    dataBase.deletarProduto(produto);
                    listaProdutos.getItems().remove(produto);
                });

                hbox.getChildren().addAll(editButton, deleteButton); 
                setText(produto.toString());
                setGraphic(hbox);
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

    public void editarProduto(Produto produtoSelecionado){
        DataBase dataBase = new DataBase();
        Dialog<Produto> dialog = new Dialog<>();
        dialog.setTitle("Editar Produto");
        if (produtoSelecionado.getTipoProduto().equals("livro")){
            criaDialogoLivro(dialog, (Livro)produtoSelecionado);
        }else if ((produtoSelecionado.getTipoProduto().equals("computador"))) {
            criarDialogoComputador(dialog, (Computador)produtoSelecionado);
        }
        dataBase.fechaConexao();
    }

    public void criaDialogoLivro(Dialog<Produto> dialog, Livro livroSelecionado){
        Label labelNome = new Label("Nome do livro: ");
        TextField campoNome = new TextField(livroSelecionado.getNome());
        HBox hboxNome = new HBox(labelNome, campoNome);
        
        Label labelAutor = new Label("Autor do livro: ");
        TextField campoAutor = new TextField(livroSelecionado.getAutor());
        HBox hboxAutor = new HBox(labelAutor, campoAutor);
        
        Label labelEditora = new Label("Editora do livro: ");
        TextField campoEditora = new TextField(livroSelecionado.getEditora());
        HBox hboxEditora = new HBox(labelEditora, campoEditora);
        
        Label labelPreco = new Label("Preço do livro: ");
        TextField campoPreco = new TextField(String.valueOf(livroSelecionado.getPreco()));
        HBox hboxPreco = new HBox(labelPreco, campoPreco);
        
        dialog.getDialogPane().setContent(new VBox(8, hboxNome, hboxAutor, hboxEditora, hboxPreco));
    
        ButtonType confirmButtonType = new ButtonType("Confirmar", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirmButtonType, ButtonType.CANCEL);

        // Define o resultado do diálogo para um novo Produto com as informações editadas
        dialog.setResultConverter(button -> {
            if (button == confirmButtonType) {
                livroSelecionado.setNome(campoNome.getText());
                livroSelecionado.setAutor(campoAutor.getText());
                livroSelecionado.setEditora(campoEditora.getText());
                livroSelecionado.setPreco(Double.parseDouble(campoPreco.getText()));
                return livroSelecionado;
            }
            return null;
        });
            Optional<Produto> result = dialog.showAndWait();
            result.ifPresent(livroEditado ->
                realizarUpdate(livroEditado));
    }

    public void criarDialogoComputador(Dialog<Produto> dialog, Computador computadorSelecionado){
        Label labelNome = new Label("Nome do computador: ");
        TextField campoNome = new TextField(computadorSelecionado.getNome());
        HBox hboxNome = new HBox(labelNome, campoNome);
        
        Label labelProcessador = new Label("Processador do computador: ");
        TextField campoProcessador = new TextField(computadorSelecionado.getProcessador());
        HBox hboxProcessador = new HBox(labelProcessador, campoProcessador);
        
        Label labelMemoria = new Label("Memória do computador: ");
        TextField campoMemoria = new TextField(computadorSelecionado.getMemoria());
        HBox hboxMemoria = new HBox(labelMemoria, campoMemoria);
        
        Label labelPreco = new Label("Preço do computador: ");
        TextField campoPreco = new TextField(String.valueOf(computadorSelecionado.getPreco()));
        HBox hboxPreco = new HBox(labelPreco, campoPreco);
        
        dialog.getDialogPane().setContent(new VBox(8, hboxNome, hboxProcessador, hboxMemoria, hboxPreco));
    
        ButtonType confirmButtonType = new ButtonType("Confirmar", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirmButtonType, ButtonType.CANCEL);

        // Define o resultado do diálogo para um novo Produto com as informações editadas
        dialog.setResultConverter(button -> {
            if (button == confirmButtonType) {
                computadorSelecionado.setNome(campoNome.getText());
                computadorSelecionado.setProcessador(campoProcessador.getText());
                computadorSelecionado.setMemoria(campoMemoria.getText());
                computadorSelecionado.setPreco(Double.parseDouble(campoPreco.getText()));
                return computadorSelecionado;
            }
            return null;
        });
            Optional<Produto> result = dialog.showAndWait();
            result.ifPresent(computadorEditado ->
                realizarUpdate(computadorEditado));
    }

    public void realizarUpdate(Produto produtoEditado){
        System.out.println("Produto editado: " + produtoEditado.toString());
        DataBase dataBase = new DataBase();
        dataBase.updateProduto(produtoEditado);
        dataBase.fechaConexao();
        listaProdutos.getItems().clear();
        popularTabela();
    }

}
