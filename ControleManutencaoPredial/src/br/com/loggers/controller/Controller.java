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
}