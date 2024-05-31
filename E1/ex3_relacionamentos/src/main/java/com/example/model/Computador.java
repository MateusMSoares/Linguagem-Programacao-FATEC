package com.example.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.interfaces.UpdateProduto;

public class Computador extends Produto implements UpdateProduto{
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
    public String setUpdateSql() {
        return "UPDATE computador SET nome = ?, processador = ?, memoria = ? WHERE id = ?";
    }

    @Override
    public void setUpdateParameters(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, getNome());
        pstmt.setString(2, getProcessador());
        pstmt.setString(3, getMemoria());
        pstmt.setInt(4, getId());
    }
}
