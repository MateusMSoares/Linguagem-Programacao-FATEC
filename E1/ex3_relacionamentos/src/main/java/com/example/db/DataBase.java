package com.example.db;

import com.example.model.Computador;
import com.example.model.Livro;
import com.example.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    //Informações para conectar ao banco
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
            String sql = "CREATE TABLE IF NOT EXISTS produto (id SERIAL PRIMARY KEY, " +
            "nome VARCHAR(255), preco DOUBLE PRECISION, tipo VARCHAR(255))";
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaLivro() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS livro (id INTEGER, " +
            "nome VARCHAR(255), autor VARCHAR(255), editora VARCHAR(255), " +
            "FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaComputador() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS computador (id INTEGER, " +
            "nome VARCHAR(255), processador VARCHAR(255), memoria VARCHAR(255), " + 
            "FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getProdutos() {
        List<Produto> produtosBanco = new ArrayList<>();
        try {
            String sql = "SELECT " +
                        "produto.id, " +
                        "produto.nome, " +
                        "produto.preco, " +
                        "produto.tipo, " +
                        "livro.autor AS livro_autor, " +
                        "livro.editora AS livro_editora, " +
                        "computador.processador AS computador_processador, " +
                        "computador.memoria AS computador_memoria " +
                    "FROM " +
                        "produto " +
                    "LEFT JOIN " +
                        "livro ON produto.id = livro.id " +
                    "LEFT JOIN " +
                        "computador ON produto.id = computador.id";
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                switch(rs.getString("tipo")) {
                    case "livro":
                        Produto produto = new Livro().criarProduto(rs);
                        produtosBanco.add(produto);
                        break;
                    case "computador":
                        Produto produtoComputador = new Computador().criarProduto(rs);
                        produtosBanco.add(produtoComputador);
                        break;
                    default:
                        Produto produtoPadrao = new Produto();
                        produtoPadrao.setId(rs.getInt("id"));
                        produtoPadrao.setTipoProduto(rs.getString("tipo"));
                        produtoPadrao.setNome(rs.getString("nome"));
                        produtoPadrao.setPreco(rs.getDouble("preco"));
                        produtoPadrao.setTipoProduto(rs.getString("tipo"));
                        produtosBanco.add(produtoPadrao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtosBanco;
    }

    public void addProduto(Produto produto) {
        try {
            String sql = "INSERT INTO produto (nome, preco, tipo) VALUES (?, ?, ?)";
            var pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setString(3, produto.getTipoProduto());
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                produto.setId(idGerado);
                produto.criarProdutoBanco(conn, produto);
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduto(Produto produtoEditado){
        System.out.println("Produto editado: " + produtoEditado.getTipoProduto());
        try {
            System.out.println("Produto editado (produto): " + produtoEditado.toString());
            String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produtoEditado.getNome());
            pstmt.setDouble(2, produtoEditado.getPreco());
            pstmt.setInt(3, produtoEditado.getId());
            pstmt.executeUpdate();
            produtoEditado.atualizarProduto(conn, produtoEditado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletarProduto(Produto produto){
        try {
            int id = produto.getId();
            String sqlProduto = "DELETE FROM produto WHERE id = ?";
            PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto);
            stmtProduto.setInt(1, id);
            stmtProduto.executeUpdate();
            produto.deletarProduto(conn, produto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
