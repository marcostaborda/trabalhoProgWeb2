/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.ClienteDAO;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Cliente {

    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;

      
    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String endereco, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    public List<Cliente> listar(){
        return ClienteDAO.getLista();
    }
    
    public boolean cadastrar() {
        return ClienteDAO.cadastrar(this);
    }
        
    public boolean excluir(){
        return ClienteDAO.remover(this);
    }
    
    public boolean atualizar(){
        return ClienteDAO.atualizar(this);
    }

}
