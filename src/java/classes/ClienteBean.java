/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author marcos
 */
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

    private Cliente client = new Cliente();
    private List<Cliente> clients;

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Cliente> getClients() {
         if(clients == null)
           return client.listar();
        return clients;
    }

     public String atualizar(Cliente client){
        System.out.println("Entrou no atualizar!!");
        client.atualizar();
        client.listar();
        return "listar";
    }
    
    public String cadastrar() {
        System.out.println("Entrou no cadastrar!!");
        client.cadastrar();
        client.listar();
        return "listar";
    }
    public String excluir(Cliente client){
        System.out.println("Entrou no excluir!!");
        client.excluir();
        clients = client.listar();
        return "listar";
    }
    
    public String editar(Cliente client){
         System.out.println("Entrou no editar!!");
        this.client = client;
        return "editar";
    }
}
