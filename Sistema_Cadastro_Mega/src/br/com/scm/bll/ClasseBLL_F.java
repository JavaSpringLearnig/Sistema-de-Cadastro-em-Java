package br.com.scm.bll;

import br.com.scm.dao.Cliente_Fisico_DAO;
import br.com.scm.domain.Cliente_Fisico;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClasseBLL_F {

    // Método para cadastrar cliente fisico
    
    public void cadastrarClienteFisicoDAO(Cliente_Fisico cliente){
        
        Cliente_Fisico_DAO dao = new Cliente_Fisico_DAO();
        
        try{
            dao.cadastro_cli_F(cliente);
        }catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    
    // Método para excluir cliente fisico
    
    public void excluirClienteFisicoDAO(Cliente_Fisico cliente){
        
        Cliente_Fisico_DAO dao = new Cliente_Fisico_DAO();
        
        try {
            dao.excluirClienteFisico(cliente);
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    
    // Método para editar cliente fisico
    
    public void editarClienteFisicoDAO(Cliente_Fisico cliente){
        
        Cliente_Fisico_DAO dao = new Cliente_Fisico_DAO();
        
        try {
            dao.editarClienteFisico(cliente);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
}
