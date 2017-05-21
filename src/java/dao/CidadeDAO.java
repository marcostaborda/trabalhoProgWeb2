/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class CidadeDAO {
    public static boolean cadastrar(Cidade city) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(CidadeSQLs.INSERIR.getSql());) {
            stmt.setString(1, city.getNome());
            stmt.setString(2, city.getEstado());
            stmt.setDouble(3, city.getDistancia());
            System.out.println("Dados Gravados!");
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - cadastrar cliente");
        }
        return false;
    }

    public static boolean remover(Cidade city) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(CidadeSQLs.REMOVER.getSql());) {
            stmt.setInt(1, city.getIdCidade());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - remover");
        }
        return false;
    }

    public static boolean atualizar(Cidade city) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(CidadeSQLs.ATUALIZAR.getSql());) {
            System.out.println("SQL = " + CidadeSQLs.ATUALIZAR.getSql());
            System.out.println("Conexão aberta!");
            stmt.setString(1, city.getNome());
            stmt.setString(2, city.getEstado());
            stmt.setDouble(3, city.getDistancia());
            stmt.setInt(4, city.getIdCidade());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - atualizar cliente");
        }
        return false;
    }

    public static List<Cidade> getLista() {
        List<Cidade> lista = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(CidadeSQLs.LISTAR_TODOS.getSql());) {
            System.out.println("Conexão aberta!");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idCidade = rs.getInt("idCidade");
                String nome = rs.getString("nome");
                String estado = rs.getString("estado");
                Double distancia = rs.getDouble("distancia");
                lista.add(new Cidade(idCidade, nome, estado, distancia));
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
