package br.com.loggers.controller;

// Importações das classes e bibliotecas necessárias
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
    
    // Objeto que gerencia as operações com o banco de dados
    private DAO theDAO;

    // Construtor da classe Controller
    // Responsável por inicializar a instância do DAO
    public Controller() {
        System.out.println("[Controller] Inicializando instância do Controller...");
        this.theDAO = new DAO();
        System.out.println("[Controller] DAO instanciado com sucesso.");
    }

    // Método responsável por criar um novo usuário no sistema
    public boolean createUser(User theUser) throws SQLException {
        System.out.println("[createUser] Iniciando processo de criação de usuário...");

        // Verifica se o usuário fornecido é válido
        if (theUser == null) {
            System.err.println("[createUser] Objeto User é nulo. Encerrando operação.");
            return false;
        }

        // Exibe os dados do usuário para fins de verificação
        System.out.println("[createUser] Nome: " + theUser.getNome());
        System.out.println("[createUser] Email: " + theUser.getEmail());

        // Chama o método DAO para inserir o usuário
        boolean sucesso = this.theDAO.createUser(theUser);

        // Exibe o resultado da operação
        System.out.println("[createUser] Resultado da operação: " + sucesso);
        return sucesso;
    }

    // Método responsável por buscar um usuário a partir de suas credenciais
    public User getUser(User theUser) throws SQLException {
        System.out.println("[getUser] Iniciando busca de usuário...");

        // Verifica se o objeto User é válido
        if (theUser == null) {
            System.err.println("[getUser] Objeto User fornecido é nulo.");
            return null;
        }

        // Mostra os dados fornecidos para depuração
        System.out.println("[getUser] Dados fornecidos - Email: " + theUser.getEmail());

        // Realiza a busca no banco de dados
        User encontrado = this.theDAO.getUser(theUser);

        // Verifica se o usuário foi localizado
        if (encontrado != null) {
            System.out.println("[getUser] Usuário localizado: " + encontrado.getNome());
        } else {
            System.out.println("[getUser] Nenhum usuário encontrado com os dados informados.");
        }

        return encontrado;
    }

    // Conta quantas ordens de serviço estão com o status "Pendente"
    public int countPendente() {
        System.out.println("[countPendente] Contando ordens de serviço com status 'Pendente'...");
        int quantidade = this.theDAO.countPendente();
        System.out.println("[countPendente] Total encontrado: " + quantidade);
        return quantidade;
    }

    // Conta quantas ordens estão em andamento
    public int countAndamento() {
        System.out.println("[countAndamento] Contando ordens com status 'Em Andamento'...");
        int quantidade = this.theDAO.countAndamento();
        System.out.println("[countAndamento] Total: " + quantidade);
        return quantidade;
    }

     // Conta quantas ordens já foram finalizadas
    public int countFinalizado() {
        System.out.println("[countFinalizado] Contando ordens com status 'Finalizado'...");
        int quantidade = this.theDAO.countFinalizado();
        System.out.println("[countFinalizado] Total: " + quantidade);
        return quantidade;
    }

    // Conta quantas ordens estão agendadas
    public int countAgendado() {
        System.out.println("[countAgendado] Contando ordens com status 'Agendado'...");
        int quantidade = this.theDAO.countAgendado();
        System.out.println("[countAgendado] Total: " + quantidade);
        return quantidade;
    }

    // Retorna uma lista com os nomes dos técnicos cadastrados
    public List<String> getTecnico() {
        System.out.println("[getTecnico] Recuperando nomes dos técnicos cadastrados...");
        List<String> tecnicos = this.theDAO.getTecnico();
        System.out.println("[getTecnico] Total de técnicos encontrados: " + tecnicos.size());
        return tecnicos;
    }

    // Retorna uma lista com os nomes dos locais cadastrados
    public List<String> getLocal() {
        System.out.println("[getLocal] Obtendo lista de locais cadastrados...");
        List<String> locais = this.theDAO.getLocal();
        System.out.println("[getLocal] Total de locais: " + locais.size());
        return locais;
    }

    // Retorna os tipos de ativos cadastrados
    public List<String> getTipoAtivo() {
        System.out.println("[getTipoAtivo] Buscando tipos de ativos...");
        List<String> tipos = this.theDAO.getTipoAtivo();
        System.out.println("[getTipoAtivo] Total encontrados: " + tipos.size());
        return tipos;
    }

    // Retorna as periodicidades cadastradas
    public List<String> getPeriodicidade() {
        System.out.println("[getPeriodicidade] Buscando periodicidades disponíveis...");
        List<String> periodicidades = this.theDAO.getPeriodicidade();
        System.out.println("[getPeriodicidade] Total: " + periodicidades.size());
        return periodicidades;
    }

    // Retorna os IDs de todas as ordens de serviço
    public List<String> getOSID() {
        System.out.println("[getOSID] Buscando IDs de ordens de serviço...");
        List<String> osIds = this.theDAO.getOSID();
        System.out.println("[getOSID] Total de IDs obtidos: " + osIds.size());
        return osIds;
    }

    // Busca o ID de um usuário a partir de seu nome
    public int getUserId(String nome) {
        System.out.println("[getUserId] Buscando ID do usuário: " + nome);
        int id = this.theDAO.getUserId(nome);
        System.out.println("[getUserId] ID encontrado: " + id);
        return id;
    }

    // Busca o ID de um local a partir de seu nome
    public int getLocalId(String nome) {
        System.out.println("[getLocalId] Buscando ID do local: " + nome);
        int id = this.theDAO.getLocalId(nome);
        System.out.println("[getLocalId] ID encontrado: " + id);
        return id;
    }

    // Busca o ID de um tipo de ativo
    public int getAtivoTipoID(String nome) {
        System.out.println("[getAtivoTipoID] Buscando ID para o tipo de ativo: " + nome);
        int id = this.theDAO.getAtivoTipoID(nome);
        System.out.println("[getAtivoTipoID] ID localizado: " + id);
        return id;
    }

    // Busca o ID de uma periodicidade
    public int getPeriocididadeID(String nome) {
        System.out.println("[getPeriocididadeID] Buscando ID da periodicidade: " + nome);
        int id = this.theDAO.getPeriocididadeID(nome);
        System.out.println("[getPeriocididadeID] ID: " + id);
        return id;
    }

    // Busca o ID de uma ordem de serviço
    public int getOSId(String nome) {
        System.out.println("[getOSId] Buscando ID da OS com nome: " + nome);
        int id = this.theDAO.getOSId(nome);
        System.out.println("[getOSId] ID retornado: " + id);
        return id;
    }
}