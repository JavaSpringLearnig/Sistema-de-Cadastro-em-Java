package br.com.scm.dao;

import java.sql.*;

public class ModuloConexao {

    // Método para conectar com o banco
    public static Connection conector() {

        Connection conexao = null;
        // chamando o driver de conexão
        String driver = "com.mysql.jdbc.Driver";

        // informações do banco
        String url = "jdbc:mysql://localhost:3306/db_mega_celular";
        String user = "root";
        String password = "3103";
        
        //conectando com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception erro) {
            System.out.println(erro);
            return null;
        }
    }

}
