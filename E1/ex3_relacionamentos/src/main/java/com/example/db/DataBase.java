package com.example.db;

import com.example.model.Computador;
import com.example.model.Livro;
import com.example.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private String nomeDB = "exerciciofatec";
    private String url = "jdbc:postgresql://localhost/" + nomeDB;
    private String user = "postgres";
    private String password = "root";
    private Connection conn;

    public DataBase() {
        this.conn = conectarBanco();
    }

     public Connection conectarBanco() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
            } else {
                System.out.println("falha ao conectar no PostgreSQL");
            }
        } catch (SQLException e) {
            System.err.format("inicia banco SQL Stateee: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    public void criarTabelas(){
        criarTabelaProduto();
        criarTabelaLivro();
        criarTabelaComputador();
    }

    public void criarTabelaProduto() {
        System.out.println("Criando tabela produto");
        try {
            String sql = "CREATE TABLE IF NOT EXISTS produto (id INTEGER, " +
            "nome VARCHAR(255), preco DOUBLE PRECISION, tipo VARCHAR(255))";
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM produto";
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTipoProduto(rs.getString("tipo"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void addProduto(Produto produto) {
        System.out.println(produto.getTipoProduto());
        try {
            String sql = "INSERT INTO produto (id, nome, preco, tipo) VALUES (?, ?, ?, ?)";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, produto.getId());
            pstmt.setString(2, produto.getNome());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setString(4, produto.getTipoProduto());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarProduto(Produto produto) {
        try {
            int id = produto.getId();
            String sqlProduto = "DELETE FROM produto WHERE id = ?";
            PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto);
            stmtProduto.setInt(1, id);
            stmtProduto.executeUpdate();

            String sqlLivro = "DELETE FROM livro WHERE id = ?";
            PreparedStatement stmtLivro = conn.prepareStatement(sqlLivro);
            stmtLivro.setInt(1, id);
            stmtLivro.executeUpdate();

            String sqlComputador = "DELETE FROM computador WHERE id = ?";
            PreparedStatement stmtComputador = conn.prepareStatement(sqlComputador);
            stmtComputador.setInt(1, id);
            stmtComputador.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLivro(Livro livro) {
        try {
            String sql = "INSERT INTO livro (id, nome, autor, editora) VALUES (?, ?, ?, ?)";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, livro.getId());
            pstmt.setString(2, livro.getNome());
            pstmt.setString(3, livro.getAutor());
            pstmt.setString(4, livro.getEditora());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addComputador(Computador computador){
        try {
            String sql = "INSERT INTO computador (id, nome, processador, memoria) VALUES (?, ?, ?, ?)";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, computador.getId());
            pstmt.setString(2, computador.getNome());
            pstmt.setString(3, computador.getProcessador());
            pstmt.setString(4, computador.getMemoria());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaLivro() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS livro (id INTEGER, " +
            "nome VARCHAR(255), autor VARCHAR(255), editora VARCHAR(255))";
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaComputador() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS computador (id INTEGER, " +
            "nome VARCHAR(255), processador VARCHAR(255), memoria VARCHAR(255))";
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
            
}
