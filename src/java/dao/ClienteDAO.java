/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author marcos
 */
public class ClienteDAO {

    public static boolean cadastrar(Cliente client) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClientSQLs.INSERIR.getSql());) {
            stmt.setString(1, client.getNome());
            stmt.setString(2, client.getEndereco());
            stmt.setString(3, client.getTelefone());
            System.out.println("Dados Gravados!");
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - cadastrar cliente");
        }
        return false;
    }

    public static boolean remover(Cliente client) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClientSQLs.REMOVER.getSql());) {
            stmt.setInt(1, client.getIdCliente());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - remover");
        }
        return false;
    }

    public static boolean atualizar(Cliente client) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClientSQLs.ATUALIZAR.getSql());) {
            System.out.println("SQL = " + ClientSQLs.ATUALIZAR.getSql());
            System.out.println("Conexão aberta!");
            stmt.setString(1, client.getNome());
            stmt.setString(2, client.getEndereco());
            stmt.setString(3, client.getTelefone());
            stmt.setInt(4, client.getIdCliente());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - atualizar cliente");
        }
        return false;
    }

    public static List<Cliente> getLista() {
        List<Cliente> lista = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClientSQLs.LISTAR_TODOS.getSql());) {
            System.out.println("Conexão aberta!");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                lista.add(new Cliente(idCliente, nome, endereco, telefone));
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Exceção SQL - Listar Excessão");
        } catch (Exception e) {
            System.out.println("Exceção no código!");
        }
        return null;
    }

}
