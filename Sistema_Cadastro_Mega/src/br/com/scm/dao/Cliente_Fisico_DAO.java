package br.com.scm.dao;

import br.com.scm.domain.Cliente_Fisico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente_Fisico_DAO {

    public void cadastro_cli_F(Cliente_Fisico cliente) throws SQLException {

        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO tbl_cliente_fisico ");
        sql.append("(nome_cliente, cpf, telefone, celular, email, endereco, num_end, bairro, cidade, estado, data_cad_F, categoria) ");
        sql.append("VALUES (?, ? ,? , ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

        Connection connection = ModuloConexao.conector();

        PreparedStatement comando = connection.prepareStatement(sql.toString());

        comando.setString(1, cliente.getNome_cliente_F());
        comando.setString(2, cliente.getCpf());
        comando.setString(3, cliente.getTelefone());
        comando.setString(4, cliente.getCelular());
        comando.setString(5, cliente.getEmail());
        comando.setString(6, cliente.getEndereco());
        comando.setString(7, cliente.getNum_end());
        comando.setString(8, cliente.getBairro());
        comando.setString(9, cliente.getCidade());
        comando.setString(10, cliente.getEstado());
        comando.setDate(11, (Date) cliente.getData_cad_F());
        comando.setString(12, cliente.getCategoria());

        comando.executeUpdate();
    }

    // Método para excluir cliente
    public void excluirClienteFisico(Cliente_Fisico cliente) throws SQLException {

        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM tbl_cliente_fisico WHERE id_cliente_F = ? ");

        Connection connection = ModuloConexao.conector();

        PreparedStatement comando = connection.prepareStatement(sql.toString());

        comando.setLong(1, cliente.getId_cliente_F());

        comando.executeUpdate();
    }

    // Método para editar cliente fisico
    
    public void editarClienteFisico(Cliente_Fisico cliente) throws SQLException{

        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE tbl_cliente_fisico ");
        sql.append("SET nome_cliente = ?, cpf = ?, telefone = ?, celular = ?, email = ?, endereco = ?, num_end = ?, bairro = ?, cidade = ?, estado = ? ");
        sql.append("WHERE id_cliente_F = ?");
        
        Connection connection = ModuloConexao.conector();
        
        PreparedStatement comando = connection.prepareStatement(sql.toString());
        
        comando.setString(1, cliente.getNome_cliente_F());
        comando.setString(2, cliente.getCpf());
        comando.setString(3, cliente.getTelefone());
        comando.setString(4, cliente.getCelular());
        comando.setString(5, cliente.getEmail());
        comando.setString(6, cliente.getEndereco());
        comando.setString(7, cliente.getNum_end());
        comando.setString(8, cliente.getBairro());
        comando.setString(9, cliente.getCidade());
        comando.setString(10, cliente.getEstado());
        comando.setLong(11, cliente.getId_cliente_F());
        
        comando.executeUpdate();
        
    }
}
