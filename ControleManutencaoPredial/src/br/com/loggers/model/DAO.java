/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.model;
import br.com.loggers.controller.Ativo;
import br.com.loggers.controller.Log;
import br.com.loggers.controller.Manutencao;
import br.com.loggers.controller.OS;
import br.com.loggers.controller.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.loggers.model.Connect;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
/**
 *
 * @author Aluno
 */
public class DAO {
    public boolean createUser(User theUser)  throws SQLException{
        //prepare the insert query
        Connection theConnection = new Connect().conectar();
        PreparedStatement theStatement = theConnection.prepareStatement("insert into usuario (nome, email, senha, tipo) values (?,?, ?, ?)");//attach the values to be inserted into the database through the query
        theStatement.setString(1, theUser.getNome());
        theStatement.setString(2, theUser.getEmail());
        theStatement.setString(3, theUser.getSenha());
        theStatement.setInt(4, theUser.getTipo());
        theStatement.execute();
        return true;
    }
    public User getUser(User theUser) throws SQLException{
            Connection theConnection = new Connect().conectar();
            //prepare the insert query
            PreparedStatement theStatement = theConnection.prepareStatement("select * from usuario where email = ? and senha = ?");
            //attach the values to be inserted into the database through the query
            theStatement.setString(1, theUser.getEmail());
            theStatement.setString(2, theUser.getSenha());//execute the query to get the record for the user
            ResultSet queryResult = theStatement.executeQuery();if (queryResult.next()) {
                //if query has results, return the user record 
                return new User(queryResult.getInt("id_usuario"), queryResult.getString("nome"), queryResult.getString("email"), queryResult.getString("senha"), queryResult.getInt("tipo"));
            } else {
                return null;
            }
    }   

     public int countPendente() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM ordem_servico WHERE status = 'pendente'";
        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }