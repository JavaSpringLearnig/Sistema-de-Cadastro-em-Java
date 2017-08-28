package br.com.scm.domain;

import java.util.Date;

public class Cliente_Juridico {

    private Long id_cliente;
    private String nome_cliente_J;
    private String cnpj;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String num_end;
    private String bairro;
    private String cidade;
    private String estado;
    private Date data_cad_j;
    private String categoria;

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente_J() {
        return nome_cliente_J;
    }

    public void setNome_cliente_J(String nome_cliente_J) {
        this.nome_cliente_J = nome_cliente_J;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNum_end() {
        return num_end;
    }

    public void setNum_end(String num_end) {
        this.num_end = num_end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getData_cad_j() {
        return data_cad_j;
    }

    public void setData_cad_j(Date data_cad_j) {
        this.data_cad_j = data_cad_j;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    

}
