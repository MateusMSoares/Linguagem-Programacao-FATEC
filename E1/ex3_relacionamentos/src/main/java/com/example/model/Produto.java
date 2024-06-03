package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.interfaces.ProdutoBanco;

public class Produto implements ProdutoBanco{
    private int id;
    private String nome;
    private double preco;
    private String tipoProduto;
    
    public Produto(String nome, double preco, String tipoProduto) {
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }

    public Produto(int id, String nome, double preco, String tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }
    public Produto(){
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    @Override
    public String toString() {
        return "tipo = " + tipoProduto + " id = " + id + ", nome = " + nome + ", preco = " + preco;
    }

    @Override
    public void atualizarProduto(Connection conn, Produto produto) throws SQLException {
        try{
            System.out.println("Produto editado (produto): " + produto.toString());
            String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, getNome());
            pstmt.setDouble(2, getPreco());
            pstmt.setInt(3, getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto criarProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setTipoProduto(rs.getString("tipo"));
        produto.setNome(rs.getString("nome"));
        produto.setPreco(rs.getDouble("preco"));
        return produto;
    }
    @Override
    public void criarProdutoBanco(Connection conn, Produto produto) throws SQLException {
        try {
            String sql = "INSERT INTO produto (nome, preco, tipo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getTipoProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarProduto(Connection conn, Produto produto) throws SQLException {
        try {
            int id = produto.getId();
            String sqlProduto = "DELETE FROM produto WHERE id = ?";
            PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto);
            stmtProduto.setInt(1, id);
            stmtProduto.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
