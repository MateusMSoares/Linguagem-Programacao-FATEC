package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Livro extends Produto {
    private String autor;
    private String editora;
    
    public Livro(String nome, double preco, String autor, String editora) {
        super(nome, preco, "livro");
        this.autor = autor;
        this.editora = editora;
    }

    public Livro(int id, String nome, double preco, String autor, String editora){
        super(id, nome, preco, "livro");
        this.autor = autor;
        this.editora = editora;
    }

    public Livro(){
    }

    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }    

    @Override
    public String toString() {
        return super.toString() + ", autor = " + autor + ", editora = " + editora;
    }

    @Override
    public void atualizarProduto(Connection conn, Produto produto) throws SQLException {
        try{
            System.out.println("Produto editado (livro): " + produto.toString());
            String sql = "UPDATE livro SET nome = ?, autor = ?, editora = ? WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, getNome());
            pstmt.setString(2, getAutor());
            pstmt.setString(3, getEditora());
            pstmt.setInt(4, getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livro criarProduto(ResultSet rs) throws SQLException {
        Livro livro = new Livro();
        livro.setId(rs.getInt("id"));
        livro.setNome(rs.getString("nome"));
        livro.setPreco(rs.getDouble("preco"));
        livro.setTipoProduto(rs.getString("tipo"));
        livro.setAutor(rs.getString("livro_autor"));
        livro.setEditora(rs.getString("livro_editora"));
        return livro;
    }

    @Override
    public void criarProdutoBanco(Connection conn, Produto produto) throws SQLException {
        System.out.println("Criando livro");
        Livro livro = (Livro) produto;
        try {
            String sql = "INSERT INTO livro (id, nome, autor, editora) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, livro.getId());
            pstmt.setString(2, livro.getNome());
            pstmt.setString(3, livro.getAutor());
            pstmt.setString(4, livro.getEditora());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarProduto(Connection conn, Produto produto) throws SQLException {
        try {
            String sql = "DELETE FROM livro WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, produto.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
