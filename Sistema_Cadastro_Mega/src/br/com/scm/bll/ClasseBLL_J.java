package br.com.scm.bll;

import br.com.scm.dao.Cliente_Juridico_DAO;
import br.com.scm.domain.Cliente_Juridico;
import java.sql.SQLException;

public class ClasseBLL_J {

    // método pata cadastrar clientes
    public void cadastrarClienteJuridicoDAO(Cliente_Juridico cliente) {

        Cliente_Juridico_DAO dao = new Cliente_Juridico_DAO();
        try {
            dao.cadastro_cli_J(cliente);

        } catch (SQLException erro) {

        }
    }

    public void excluirClienteDAO(Cliente_Juridico cliente) {

        Cliente_Juridico_DAO dao = new Cliente_Juridico_DAO();
        dao.excluirClientes(cliente);
    }

    public void editarClienteDAO(Cliente_Juridico cliente) {

        Cliente_Juridico_DAO dao = new Cliente_Juridico_DAO();

        try {
            dao.editarCliente(cliente);
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }

}
