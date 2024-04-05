package com.example.dadosmeteorologicos;

import com.example.dadosmeteorologicos.Services.CSVService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrincipalController {
    @FXML
    private Button submitButton;
    @FXML
    private TextField nome;
    @FXML
    private PasswordField senha;

    public void PegaDados(@SuppressWarnings("exports") ActionEvent actionEvent) {
        System.out.println(nome.getText());
        System.out.println(senha.getText());
        CSVService leitor = new CSVService();
        leitor.validarCSV();

    }
}

