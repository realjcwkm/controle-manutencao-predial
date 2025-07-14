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
        return count;
    }
    public int countAndamento() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM ordem_servico WHERE status = 'em andamento'";
        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    
    public int countFinalizado() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM ordem_servico WHERE status = 'finalizado'";
        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public int countAgendado() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM ordem_servico WHERE status = 'agendado'";
        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public List<String> getTecnico() {
        List<String> categories = new ArrayList<>();

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT nome FROM usuario");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return categories;
    }
    
    public List<String> getLocal() {
        List<String> categories = new ArrayList<>();

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT nome FROM local");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return categories;
    }
    
    public List<String> getTipoAtivo() {
        List<String> categories = new ArrayList<>();

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT nome_tipo_ativo FROM tipo_ativo");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("nome_tipo_ativo"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return categories;
    }
    
    public List<String> getPeriodicidade() {
        List<String> categories = new ArrayList<>();

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT tipo_periodicidade FROM periodicidade");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("tipo_periodicidade"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return categories;
    }
    
    public List<String> getOSID() {
        List<String> categories = new ArrayList<>();

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_ordem_servico FROM ordem_servico");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("id_ordem_servico"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return categories;
    }
    
    public int getUserId(String nome){
        int id_usuario = 0;

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_usuario FROM usuario WHERE nome = ?");) {

            stmt.setString(1, nome); 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id_usuario = rs.getInt("id_usuario");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return id_usuario;
    }
    
    public int getLocalId(String nome){
        int id_local = 0;

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_local FROM local WHERE nome = ?");) {

            stmt.setString(1, nome); 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id_local = rs.getInt("id_local");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return id_local;
    }
    
    public int getAtivoTipoID(String nome){
        int id_local = 0;

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_tipo_ativo FROM tipo_ativo WHERE nome_tipo_ativo = ?");) {

            stmt.setString(1, nome); 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id_local = rs.getInt("id_tipo_ativo");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return id_local;
    }
    
    public int getPeriocididadeID(String nome){
        int id_local = 0;

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_periodicidade FROM periodicidade WHERE tipo_periodicidade = ?");) {

            stmt.setString(1, nome); 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id_local = rs.getInt("id_periodicidade");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return id_local;
    }
    
    public int getOSId(String nome){
        int idOS = 0;

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_ordem_servico FROM ordem_servico WHERE titulo = ?");) {

            stmt.setString(1, nome); 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idOS = rs.getInt("id_ordem_servico");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or use logging
        }

        return idOS;
    }
    
    
    public boolean insertOS(OS ordem) {
        String sql = "insert into ordem_servico(titulo, tecnico, prazo, urgencia, status, descricao, local_id_local) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ordem.getTitulo());
            stmt.setInt(2, ordem.getTecnico());
            stmt.setDate(3, Date.valueOf(ordem.getPrazo()));
            stmt.setString(4, ordem.getUrgencia());
            stmt.setString(5, ordem.getStatus());
            stmt.setString(6, ordem.getDescricao());
            stmt.setInt(7, ordem.getLocal_id_local());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertAtivo(Ativo ativo) {
        String sql = "insert into ativos (modelo_ativo, ultima_manutencao, data_instalacao, descricao, local_id_local, tipo_ativo_id_tipo_ativo, periodicidade_id_periodicidade) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ativo.getModelo_ativo());
            stmt.setDate(2, Date.valueOf(ativo.getUltima_manutencao()));
            stmt.setDate(3, Date.valueOf(ativo.getData_instalacao()));
            stmt.setString(4, ativo.getDescricao());
            stmt.setInt(5, ativo.getLocal_id_local());
            stmt.setInt(6, ativo.getTipo_ativo_id_tipo_ativo());
            stmt.setInt(7, ativo.getPeriodicidade_id_periodicidade());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertManutencao(Manutencao manutencao) {
        String sql = "insert into manutencao(tipo_manutencao, ordem_servico_id_ordem_servico, local_id_local, periodicidade_id_periodicidade) values (?, ?, ?, ?)";

        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, manutencao.getTipo_manutencao());
            stmt.setInt(2, manutencao.getOrdem_servico_id_ordem_servico());
            stmt.setInt(3, manutencao.getLocal_id_local());
            stmt.setInt(4, manutencao.getPeriodicidade_id_periodicidade());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean insertLog(Log log) {
        String sql = "insert into log(data, hora, tipo, descricao, tipo_log_id_tipo_log, usuario_id_usuario) values (?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(log.getData()));
            stmt.setTime(2, java.sql.Time.valueOf(log.getHora()));
            stmt.setInt(3, log.getTipo());
            stmt.setString(4, log.getDescricao());
            stmt.setInt(5, log.getTipo_log_id_tipo_log());
            stmt.setInt(6, log.getUsuario_id_usuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertLogOS(Log log) {
        String sql = "insert into log(data, hora, tipo, descricao, tipo_log_id_tipo_log, usuario_id_usuario, ordem_servico_id_ordem_servico) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(log.getData()));
            stmt.setTime(2, java.sql.Time.valueOf(log.getHora()));
            stmt.setInt(3, log.getTipo());
            stmt.setString(4, log.getDescricao());
            stmt.setInt(5, log.getTipo_log_id_tipo_log());
            stmt.setInt(6, log.getUsuario_id_usuario());
            stmt.setInt(7, log.getOrdem_servico_id_ordem_servico());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertLogManut(Log log) {
        String sql = "insert into log(data, hora, tipo, descricao, tipo_log_id_tipo_log, usuario_id_usuario, manutencao_id_manutencao) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Connect().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(log.getData()));
            stmt.setTime(2, java.sql.Time.valueOf(log.getHora()));
            stmt.setInt(3, log.getTipo());
            stmt.setString(4, log.getDescricao());
            stmt.setInt(5, log.getTipo_log_id_tipo_log());
            stmt.setInt(6, log.getUsuario_id_usuario());
            stmt.setInt(7, log.getManutencao_id_manutencao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public DefaultTableModel getOSTable() {
        DefaultTableModel model = new DefaultTableModel();

        String sql = "SELECT os.id_ordem_servico AS Ordem, os.titulo AS Título, u.nome AS Técnico, os.status as Status, l.nome AS Local, os.prazo as Prazo FROM ordem_servico os JOIN usuario u ON os.tecnico = u.id_usuario JOIN local l ON os.local_id_local = l.id_local ORDER BY os.id_ordem_servico DESC LIMIT 10;";

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Get column names
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(meta.getColumnLabel(i));
            }

            // Get rows
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
    
    public DefaultTableModel getManutencaoTable() {
        DefaultTableModel model = new DefaultTableModel();

        String sql = "SELECT m.id_manutencao AS Ordem, os.titulo AS Título, os.prazo AS Data, l.nome AS Local, m.tipo_manutencao AS Tipo FROM manutencao m JOIN ordem_servico os ON m.ordem_servico_id_ordem_servico = os.id_ordem_servico JOIN local l ON m.local_id_local = l.id_local ORDER BY m.id_manutencao DESC LIMIT 10;";

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Get column names
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(meta.getColumnLabel(i));
            }

            // Get rows
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
    
    public DefaultTableModel getLogsTable() {
        DefaultTableModel model = new DefaultTableModel();

        String sql = "SELECT l.data as Data, l.hora as Hora, u.nome AS Usuário, l.descricao as Descrição, tl.descricao AS Tipo FROM log l JOIN usuario u ON l.usuario_id_usuario = u.id_usuario JOIN tipo_log tl ON l.tipo_log_id_tipo_log = tl.id_tipo_log ORDER BY l.data DESC, l.hora DESC LIMIT 10;";

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Get column names
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(meta.getColumnLabel(i));
            }

            // Get rows
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
    
    public DefaultTableModel getAtivoTable() {
        DefaultTableModel model = new DefaultTableModel();

        String sql = "SELECT a.id_ativos AS ID, a.modelo_ativo AS Nome, ta.nome_tipo_ativo AS Tipo, l.nome AS Localização, a.ultima_manutencao AS \"Última manut.\" FROM ativos a JOIN tipo_ativo ta ON a.tipo_ativo_id_tipo_ativo = ta.id_tipo_ativo JOIN local l ON a.local_id_local = l.id_local ORDER BY a.id_ativos DESC LIMIT 10;";

        try (Connection conn = new Connect().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Get column names
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(meta.getColumnLabel(i));
            }

            // Get rows
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

}
