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

}