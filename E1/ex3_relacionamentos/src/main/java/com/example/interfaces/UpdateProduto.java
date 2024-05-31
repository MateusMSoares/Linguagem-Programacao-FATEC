package com.example.interfaces;

import java.sql.PreparedStatement;

public interface UpdateProduto {
    String setUpdateSql();
    void setUpdateParameters(PreparedStatement pstmt) throws Exception;
}
