package br.com.scm.dal;

import br.com.scm.dao.Cliente_Juridico_DAO;
import org.junit.Test;
import br.com.scm.domain.Cliente_Juridico;
import org.junit.Ignore;

public class Cliente_Juridico_DALTest {

    public Cliente_Juridico_DALTest() {
    }

    @Test
    
    public void cadastroJuridico() {

        Cliente_Juridico_DAO dao = new Cliente_Juridico_DAO();
        Cliente_Juridico cli_juri = new Cliente_Juridico();

        cli_juri.setNome_cliente_J("Victor Rabelo");
        cli_juri.setCnpj("18.879.234/0001-78");
        cli_juri.setTelefone("(31) 3461-0089");
        cli_juri.setCelular("(31) 98850-3335");
        cli_juri.setEmail("victor@hotmail.com");
        cli_juri.setEndereco("Rua Engenheiro Odilon Fernandes 65");
        cli_juri.setNum_end("65");
        cli_juri.setBairro("Horto Florestal");
        cli_juri.setCidade("Belo Horizonte");
        cli_juri.setEstado("Minas Gerais(MG)");

        dao.cadastro_cli_J(cli_juri);
    }


}
