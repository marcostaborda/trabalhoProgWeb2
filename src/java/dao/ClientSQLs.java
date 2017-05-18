/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author marcos
 */
public enum ClientSQLs {
    INSERIR("insert into Cliente(nome, endereco, telefone) values (?, ?, ?)"),    
    LISTAR_TODOS("select * from Cliente"),
    REMOVER("delete from Cliente where idCliente=?"),
    ATUALIZAR("update Cliente set nome=?, endereco=?,telefone=? where idCliente=?");
        
    private final String sql;
    ClientSQLs(String sql){
        this.sql = sql; 
    }

    public String getSql() {
        return sql;
    }    
}
