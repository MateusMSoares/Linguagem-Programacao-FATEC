package com.example.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.interfaces.UpdateProduto;

public class Livro extends Produto implements UpdateProduto{
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
    public String setUpdateSql() {
        return "UPDATE livro SET nome = ?, autor = ?, editora = ? WHERE id = ?";
    }

    @Override
    public void setUpdateParameters(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, getNome());
        pstmt.setString(2, getAutor());
        pstmt.setString(3, getEditora());
        pstmt.setInt(4, getId());
    }

}
