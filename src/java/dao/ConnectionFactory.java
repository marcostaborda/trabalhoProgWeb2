/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

/**
 *
 * @author marcos
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
           Class.forName("org.sqlite.JDBC");
           String urlBD="jdbc:sqlite:C:/db/BancoDeDados2.sqlite";
           System.out.println("Conexao estabelecida");
           return DriverManager.getConnection(urlBD);           
        } catch (SQLException e) {
            System.out.println("Exceção SQL - ConnectionFactory");
        } catch(ClassNotFoundException e){
            System.out.println("Exceção Classe não encontrada - ConnectionFactory");
        }
        return null;
    }
    
}
