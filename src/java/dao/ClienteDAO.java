/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import classes.Cliente;
import classes.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author marcos
 */
public class ClienteDAO {
    private EntityManager em;
    public boolean cadastrar(Cliente client) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
        return false;
    }

    public boolean remover(Cliente client) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Cliente entity = em.find(Cliente.class, client.getIdCliente());
        if (entity != null) {
            em.remove(entity);
        } else {
            System.out.println("Deu erro");
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    public boolean atualizar(Cliente client) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
        em.close();
        return false;
    }

    public List<Cliente> getLista() {
        em = JPAUtil.getEntityManager();
        TypedQuery<Cliente> query;
        query = em.createQuery(
                "SELECT p FROM Cliente p",
                Cliente.class);
        List<Cliente> clientes = query.getResultList();
        em.close();
        return clientes;
    }

}
