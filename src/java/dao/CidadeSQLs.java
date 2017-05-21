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
public enum CidadeSQLs {
    INSERIR("insert into Cidade(nome, estado, distancia) values (?, ?, ?)"),    
    LISTAR_TODOS("select * from Cidade"),
    REMOVER("delete from Cidade where idCidade=?"),
    ATUALIZAR("update Cidade set nome=?, estado=?,distancia=? where idCidade=?");
        
    private final String sql;
    CidadeSQLs(String sql){
        this.sql = sql; 
    }

    public String getSql() {
        return sql;
    }    
}
