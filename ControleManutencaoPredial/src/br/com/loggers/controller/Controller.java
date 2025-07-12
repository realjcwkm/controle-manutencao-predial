
package br.com.loggers.controller;

// Importações das classes e bibliotecas necessárias
import br.com.loggers.model.Connect;
import br.com.loggers.model.DAO;

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

}