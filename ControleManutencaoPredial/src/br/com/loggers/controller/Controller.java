
package br.com.loggers.controller;

import br.com.loggers.model.Connect;
import br.com.loggers.model.DAO;
import br.com.loggers.view.View;
import br.com.loggers.controller.User;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Controller {
    
    private DAO theDAO;
    
    // Construtor da classe Controller, inicializa o DAO que fará o acesso ao banco de dados
    public Controller() {
        this.theDAO = new DAO();
    }

    // Cria um novo usuário no banco de dados
    public boolean createUser(User theUser) throws SQLException {
        return this.theDAO.createUser(theUser);
    }

    // Busca um usuário no banco com base nos dados fornecidos
    public User getUser(User theUser) throws SQLException {
        return this.theDAO.getUser(theUser);
    }

    // Retorna a quantidade de ordens de serviço com status "Pendente"
    public int countPendente() {
        return this.theDAO.countPendente();
    }

    // Retorna a quantidade de ordens de serviço com status "Em Andamento"
    public int countAndamento() {
        return this.theDAO.countAndamento();
    }

    // Retorna a quantidade de ordens de serviço com status "Finalizado"
    public int countFinalizado() {
        return this.theDAO.countFinalizado();
    }

    // Retorna a quantidade de ordens de serviço com status "Agendado"
    public int countAgendado() {
        return this.theDAO.countAgendado();
    }

    // Retorna a lista de nomes dos técnicos cadastrados
    public List<String> getTecnico() {
        return this.theDAO.getTecnico();
    }

    // Retorna a lista de locais cadastrados
    public List<String> getLocal() {
        return this.theDAO.getLocal();
    }

    // Retorna a lista de tipos de ativos cadastrados
    public List<String> getTipoAtivo() {
        return this.theDAO.getTipoAtivo();
    }

    // Retorna a lista de periodicidades cadastradas
    public List<String> getPeriodicidade() {
        return this.theDAO.getPeriodicidade();
    }

    // Retorna a lista de IDs das ordens de serviço
    public List<String> getOSID() {
        return this.theDAO.getOSID();
    }

    // Retorna o ID de um usuário a partir do nome
    public int getUserId(String nome) {
        return this.theDAO.getUserId(nome);
    }

    // Retorna o ID de um local a partir do nome
    public int getLocalId(String nome) {
        return this.theDAO.getLocalId(nome);
    }

    // Retorna o ID de um tipo de ativo a partir do nome
    public int getAtivoTipoID(String nome) {
        return this.theDAO.getAtivoTipoID(nome);
    }

    // Retorna o ID de uma periodicidade a partir do nome
    public int getPeriocididadeID(String nome) {
        return this.theDAO.getPeriocididadeID(nome);
    }
    
    public int getOSId(String nome){
        return this.theDAO.getOSId(nome);
    }

    // Insere uma nova ordem de serviço no banco de dados
    public boolean insertOS(OS ordem) {
        return this.theDAO.insertOS(ordem);
    }

    // Insere um novo ativo no banco de dados
    public boolean insertAtivo(Ativo ativo) {
        return this.theDAO.insertAtivo(ativo);
    }

    // Insere uma nova manutenção no banco de dados
    public boolean insertManutencao(Manutencao manutencao) {
        return this.theDAO.insertManutencao(manutencao);
    }

    // Insere um novo log genérico no banco de dados
    public boolean insertLog(Log log) {
        return this.theDAO.insertLog(log);
    }

    // Insere um novo log específico de ordem de serviço no banco
    public boolean insertLogOS(Log log) {
        return this.theDAO.insertLogOS(log);
    }

    // Insere um novo log específico de manutenção no banco
    public boolean insertLogManut(Log log) {
        return this.theDAO.insertLogManut(log);
    }

    // Retorna os dados das ordens de serviço em formato de tabela (DefaultTableModel)
    public DefaultTableModel getOSTable() {
        return this.theDAO.getOSTable();
    }

    // Retorna os dados das manutenções em formato de tabela
    public DefaultTableModel getManutencaoTable() {
        return this.theDAO.getManutencaoTable();
    }

    // Retorna os dados dos logs em formato de tabela
    public DefaultTableModel getLogsTable() {
        return this.theDAO.getLogsTable();
    }

    // Retorna os dados dos ativos em formato de tabela
    public DefaultTableModel getAtivoTable() {
        return this.theDAO.getAtivoTable();
    }
    
}