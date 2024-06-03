package com.example.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Produto;

public interface ProdutoBanco {
    void atualizarProduto(Connection conn, Produto produto) throws SQLException;
    Produto criarProduto(ResultSet rs) throws SQLException;
    void criarProdutoBanco(Connection connection, Produto produto) throws SQLException;
    void deletarProduto(Connection conn, Produto produto) throws SQLException;
}
