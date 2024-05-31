package com.example.db;

import com.example.model.Computador;
import com.example.model.Livro;
import com.example.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {
            String sql = "INSERT INTO produto (nome, preco, tipo) VALUES (?, ?, ?)";
            var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setString(3, produto.getTipoProduto());
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                System.out.println("ID gerado: " + idGerado);
                produto.setId(idGerado);
            }
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

    public Livro getLivro(Produto produtoSelecionado){
        Livro livroSelecionado = new Livro();
        try {
            String sql = "SELECT * FROM livro WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, produtoSelecionado.getId());
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                livroSelecionado.setId(rs.getInt("id"));
                livroSelecionado.setNome(rs.getString("nome"));
                livroSelecionado.setAutor(rs.getString("autor"));
                livroSelecionado.setEditora(rs.getString("editora"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livroSelecionado;
    }

    public void addLivro(Livro livro) {
        try {
            String sql = "INSERT INTO livro (id, nome, autor, editora) VALUES (?, ?, ?, ?)";
            var pstmt = conn.prepareStatement(sql);
            System.out.println("id: " +livro.getId());
            pstmt.setInt(1, livro.getId());
            pstmt.setString(2, livro.getNome());
            pstmt.setString(3, livro.getAutor());
            pstmt.setString(4, livro.getEditora());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Computador getComputador(Produto produtoSelecionado){
        Computador computadorSelecionado = new Computador();
        try {
            String sql = "SELECT * FROM computador WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, produtoSelecionado.getId());
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                computadorSelecionado.setId(rs.getInt("id"));
                computadorSelecionado.setNome(rs.getString("nome"));
                computadorSelecionado.setProcessador(rs.getString("processador"));
                computadorSelecionado.setMemoria(rs.getString("memoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computadorSelecionado;
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

    public void updateProduto(Produto produtoEditado){
        System.out.println("Produto editado: " + produtoEditado.getTipoProduto());
        try {
            String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produtoEditado.getNome());
            pstmt.setDouble(2, produtoEditado.getPreco());
            pstmt.setInt(3, produtoEditado.getId());
            pstmt.executeUpdate();

            if (produtoEditado.getTipoProduto() == "livro"){
                String sqlLivro = "UPDATE livro SET nome = ?, autor = ?, editora = ? WHERE id = ?";
                var pstmtLivro = conn.prepareStatement(sqlLivro);
                pstmtLivro.setString(1, ((Livro) produtoEditado).getNome());
                pstmtLivro.setString(2, ((Livro) produtoEditado).getAutor());
                pstmtLivro.setString(3, ((Livro) produtoEditado).getEditora());
                pstmtLivro.setInt(4, produtoEditado.getId());
                pstmtLivro.executeUpdate();
            } else{
                String sqlComputador = "UPDATE computador SET nome = ?, processador = ?, memoria = ? WHERE id = ?";
                var pstmtComputador = conn.prepareStatement(sqlComputador);
                pstmtComputador.setString(1, ((Computador) produtoEditado).getNome());
                pstmtComputador.setString(2, ((Computador) produtoEditado).getProcessador());
                pstmtComputador.setString(3, ((Computador) produtoEditado).getMemoria());
                pstmtComputador.setInt(4, produtoEditado.getId());
                pstmtComputador.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }          
}
