package br.com.scm.bll;

import br.com.scm.dao.UsuarioDAO;
import br.com.scm.domain.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClasseBLL {

    // Método para cadastrar usuario
    public void cadastrarUsuarioDAO(Usuario usuario) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        try {
            dao.cadastrarUsuario(usuario);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    // Método para excluir usuario
    public void excluirUsuarioDAO(Usuario usuario) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        try {
            dao.excluirUsuario(usuario);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    // Método para editar usuario
    public void editarUsuarioDAO(Usuario usuario) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        try {
            dao.editarUsuario(usuario);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    
}
