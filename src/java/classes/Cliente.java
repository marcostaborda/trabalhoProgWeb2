/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.ClienteDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marcos
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
    @Column (name="idCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        return new ClienteDAO().getLista();
    }
    
    public boolean cadastrar() {
        return new ClienteDAO().cadastrar(this);
    }
        
    public boolean excluir(){
        return new ClienteDAO().remover(this);
    }
    
    public boolean atualizar(){
        return new ClienteDAO().atualizar(this);
    }

}
