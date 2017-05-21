/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author marcos
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    private Cliente client = new Cliente();
    private List<Cliente> clients;

    private Cliente clienteSelecionado;

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public void limparSelecao() {
        this.setClienteSelecionado(null);
    }

    @PostConstruct
    public void construct() {
        clients = client.listar();
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Cliente> getClients() {
        if (clients == null) {
            return client.listar();
        }
        return clients;
    }

    public String atualizar(Cliente client) {
        System.out.println("Entrou no atualizar!!");
        client.atualizar();
        client.listar();
        return "listar-clientes";
    }

    public String cadastrar() {
        System.out.println("Entrou no cadastrar banco!!");
        client.cadastrar();
        client.listar();
        return "listar-clientes";
    }

    public String excluir(Cliente client) {
        System.out.println("Entrou no excluir!!");
        client.excluir();
        clients = client.listar();
        return "listar-clientes";
    }
}
