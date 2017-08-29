package br.com.scm.dal;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.scm.domain.Usuario;
import br.com.scm.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UsuarioDALTest {
    
    public UsuarioDALTest() {
    }

    @Test
    public void inserirUsuario() {
        
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        user.setNome_usuario("Aecio");
        user.setLogin("aecio");
        user.setSenha("3103");
        user.setTipo("Admin");
        
        try {
            dao.cadastrarUsuario(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
 
    
}
