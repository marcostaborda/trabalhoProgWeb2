/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.CidadeDAO;
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
public class Cidade implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @Column (name="idCidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCidade;
    private String nome;
    private String estado;
    private Double distancia;

    public Cidade(int idCidade, String nome, String estado, Double distancia) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.estado = estado;
        this.distancia = distancia;
    }

    public Cidade() {
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    
    public List<Cidade> listar(){
        return new CidadeDAO().getLista();
    }
    
    public boolean cadastrar() {
        return new CidadeDAO().cadastrar(this);
    }
        
    public boolean excluir(){
        return new CidadeDAO().remover(this);
    }
    
    public boolean atualizar(){
        return new CidadeDAO().atualizar(this);
    }


}
