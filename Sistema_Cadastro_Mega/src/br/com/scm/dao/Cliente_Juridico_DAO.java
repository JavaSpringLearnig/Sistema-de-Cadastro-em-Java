package br.com.scm.dao;

import java.sql.*;
import br.com.scm.domain.Cliente_Juridico;

public class Cliente_Juridico_DAO {

    // Método para cadastrar um cliente
    public void cadastro_cli_J(Cliente_Juridico cliente) throws SQLException{

        StringBuilder sql = new StringBuilder();

       
            sql.append("INSERT INTO tbl_cliente_juridico ");
            sql.append("(nome_cliente_J, cnpj, telefone, celular, email, endereco, num_end, bairro, cidade, estado, data_cad_J, categoria) ");
            sql.append("VALUES (?, ? ,? , ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

            Connection conection = ModuloConexao.conector();

            PreparedStatement comando = conection.prepareStatement(sql.toString());

           
            comando.setString(1, cliente.getNome_cliente_J());
            comando.setString(2, cliente.getCnpj());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getCelular());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getEndereco());
            comando.setString(7, cliente.getNum_end());
            comando.setString(8, cliente.getBairro());
            comando.setString(9, cliente.getCidade());
            comando.setString(10, cliente.getEstado());
            comando.setDate(11, (Date) cliente.getData_cad_j());
            comando.setString(12, cliente.getCategoria());

            comando.executeUpdate();

        
    }

    // método para excluir 
    public void excluirClientes(Cliente_Juridico cliente) {

        StringBuilder sql = new StringBuilder();

        try {

            sql.append("DELETE FROM tbl_cliente_juridico WHERE id_cliente_J = ? ");

            Connection connection = ModuloConexao.conector();

            PreparedStatement comando = connection.prepareStatement(sql.toString());

            comando.setLong(1, cliente.getId_cliente());

            comando.executeUpdate();

        } catch (SQLException erro) {

        }

    }
    
    public void editarCliente(Cliente_Juridico cliente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("UPDATE tbl_cliente_juridico ");
        sql.append("SET nome_cliente_J = ?, cnpj = ?, telefone = ?, celular = ?, email = ?, endereco = ?, num_end = ?, bairro = ?, cidade = ?, estado = ? ");
        sql.append("WHERE id_cliente_J = ? ");
        
        Connection connection = ModuloConexao.conector();
        PreparedStatement comando = connection.prepareStatement(sql.toString());
        
        comando.setString(1, cliente.getNome_cliente_J());
        comando.setString(2, cliente.getCnpj());
        comando.setString(3, cliente.getTelefone());
        comando.setString(4, cliente.getCelular());
        comando.setString(5, cliente.getEmail());
        comando.setString(6, cliente.getEndereco());
        comando.setString(7, cliente.getNum_end());
        comando.setString(8, cliente.getBairro());
        comando.setString(9, cliente.getCidade());
        comando.setString(10, cliente.getEstado());
        comando.setLong(11, cliente.getId_cliente());
        
        comando.executeUpdate();
        
    }
    
     public void pesquisar() throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT * FROM tbl_cliente_juridico ORDER BY nome_cliente_J");
        
         Connection connection = ModuloConexao.conector();
         
         PreparedStatement comando = connection.prepareStatement(sql.toString());
         
         
         
    }

}
