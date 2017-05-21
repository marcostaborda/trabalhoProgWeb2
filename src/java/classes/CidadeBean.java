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
public class CidadeBean {
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    private Cidade cidadeSelecionado;

    public Cidade getCidadeSelecionado() {
        return cidadeSelecionado;
    }

    public void setCidadeSelecionado(Cidade clienteSelecionado) {
        this.cidadeSelecionado = clienteSelecionado;
    }

    public void limparSelecao() {
        this.setCidadeSelecionado(null);
    }

    @PostConstruct
    public void construct() {
        cidades = cidade.listar();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        if (cidades == null) {
            return cidade.listar();
        }
        return cidades;
    }

    public String atualizar(Cidade cidade) {
        System.out.println("Entrou no atualizar!!");
        cidade.atualizar();
        cidade.listar();
        return "listar-cidades";
    }

    public String cadastrar() {
        System.out.println("Entrou no cadastrar banco!!");
        cidade.cadastrar();
        cidade.listar();
        return "listar-cidades";
    }

    public String excluir(Cidade cidade) {
        System.out.println("Entrou no excluir!!");
        cidade.excluir();
        cidades = cidade.listar();
        return "listar-cidades";
    }
}
