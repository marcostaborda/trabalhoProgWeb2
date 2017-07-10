/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.faces.context.Flash;

/**
 *
 * @author marcos
 */
@ManagedBean
@ViewScoped
public class ClienteBean {
    private static final long serialVersionUID = 1L;
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

    public void atualizar(Cliente client) {
        System.out.println("Entrou no atualizar!!");
        client.atualizar();
        client.listar();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente atualizado com sucesso", null));
    }

    public String cadastrar() {
        System.out.println("Entrou no cadastrar banco!!");
        client.cadastrar();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso", null));
        client.listar();
        return "listar-clientes?faces-redirect=true";
    }

    public void excluir(Cliente client) {
        System.out.println("Entrou no excluir!!");
        client.excluir();
        clients = client.listar();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluido com sucesso", null));
    }
}
