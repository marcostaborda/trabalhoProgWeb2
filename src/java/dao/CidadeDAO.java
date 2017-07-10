/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cidade;
import classes.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author marcos
 */
public class CidadeDAO {
    private EntityManager em;
//    public List<Tarefa> pesquisarPorNome(String nome) {
//        em = JPAUtil.getEntityManager();
//        TypedQuery<Tarefa> query = em.createQuery(
//                "SELECT p FROM Tarefa p "
//                + "where lower(p.nome) like '%"
//                + nome.toLowerCase() + "%'",
//                Tarefa.class);
//        List<Tarefa> tarefas = query.getResultList();
//        em.close();
//        return tarefas;
//    }

    public boolean cadastrar(Cidade city) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
        return false;
    }

    public boolean remover(Cidade city) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Cidade entity = em.find(Cidade.class, city.getIdCidade());
        if (entity != null) {
            em.remove(entity);
        } else {
            System.out.println("Deu erro");
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    public boolean atualizar(Cidade city) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(city);
        em.getTransaction().commit();
        em.close();
        return false;
    }

    public  List<Cidade> getLista() {
        em = JPAUtil.getEntityManager();
        TypedQuery<Cidade> query;
        query = em.createQuery(
                "SELECT p FROM Cidade p",
                Cidade.class);
        List<Cidade> cidades = query.getResultList();
        em.close();
        return cidades;
    }
}
