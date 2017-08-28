package br.com.scm.dao;

import br.com.scm.domain.Usuario;
import java.sql.*;

public class UsuarioDAO {

    // método para salvar um usuario
    
    public void cadastrarUsuario(Usuario usuario) throws SQLException{

        StringBuilder sql = new StringBuilder();

      
            sql.append("INSERT INTO tbl_usuario (nome_usuario, tipo, senha, login) VALUES (?, ?, ?, ?) ");
            
            Connection connection = ModuloConexao.conector();

            PreparedStatement comando = connection.prepareStatement(sql.toString());

            comando.setString(1, usuario.getNome_usuario());
            comando.setString(2, usuario.getTipo());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getLogin());

            comando.executeUpdate();

        
    }
    
    // Método para excluir usuario
    
    public void excluirUsuario(Usuario usuario) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("DELETE FROM tbl_usuario WHERE id_usuario = ? ");
        
        Connection connection = ModuloConexao.conector();
        
        PreparedStatement comando = connection.prepareStatement(sql.toString());
        
        comando.setString(1, usuario.getId_usuario().toString());
        
        comando.executeUpdate();
    }
    
    // Método para editar usuario
    
    public void editarUsuario(Usuario usuario) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("UPDATE tbl_usuario ");
        sql.append("SET nome_usuario = ?, login = ?, senha = ? ");
        sql.append("WHERE id_usuario = ? ");
        
        Connection connectio = ModuloConexao.conector();
        
        PreparedStatement comando = connectio.prepareStatement(sql.toString());
        
        comando.setString(1, usuario.getNome_usuario());
        comando.setString(2, usuario.getLogin());
        comando.setString(3, usuario.getSenha());
        comando.setLong(4, usuario.getId_usuario());
        
        comando.executeUpdate();
    }
    
  
}
