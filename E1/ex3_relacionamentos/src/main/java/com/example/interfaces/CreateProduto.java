package com.example.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Produto;

public interface CreateProduto {
    Produto criarProduto(ResultSet rs) throws SQLException;

}
