package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Computador extends Produto {
    private String processador;
    private String memoria;

    
    public Computador(String nome, double preco, String processador, String memoria) {
        super(nome, preco, "computador");
        this.processador = processador;
        this.memoria = memoria;
    }

    public Computador(int id, String nome, double preco, String processador, String memoria){
        super(id, nome, preco, "computador");
        this.processador = processador;
        this.memoria = memoria;
    }

    public Computador(){
    }

    public String getProcessador() {
        return processador;
    }
    
    public void setProcessador(String processador) {
        this.processador = processador;
    }
    
    public String getMemoria() {
        return memoria;
    }
    
    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", processador = " + processador + ", memoria = " + memoria;
    }

    @Override
    public void atualizarProduto(Connection conn, Produto produto) throws SQLException {
        try{
            String sql = "UPDATE computador SET nome = ?, processador = ?, memoria = ? WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, getNome());
            pstmt.setString(2, getProcessador());
            pstmt.setString(3, getMemoria());
            pstmt.setInt(4, getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Computador criarProduto(ResultSet rs) throws SQLException {
        Computador computador = new Computador();
        computador.setId(rs.getInt("id"));
        computador.setNome(rs.getString("nome"));
        computador.setPreco(rs.getDouble("preco"));
        computador.setTipoProduto(rs.getString("tipo"));
        computador.setProcessador(rs.getString("computador_processador"));
        computador.setMemoria(rs.getString("computador_memoria"));
        return computador;  
    }

    @Override
    public void criarProdutoBanco(Connection connection, Produto produto) throws SQLException {
        Computador computador = (Computador) produto;
        try{
            String sql = "INSERT INTO computador (id, nome, processador, memoria) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, computador.getId());
            pstmt.setString(2, computador.getNome());
            pstmt.setString(3, computador.getProcessador());
            pstmt.setString(4, computador.getMemoria());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarProduto(Connection conn, Produto produto) throws SQLException {
        try{
            String sql = "DELETE FROM computador WHERE id = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, produto.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
