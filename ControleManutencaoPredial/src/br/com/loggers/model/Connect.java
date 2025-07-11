/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aluno
 */
public class Connect {
    private Connection con;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private String user = "root";
    private String password = "alunoifro";
    
    public Connection conectar(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
        return con;
    }
}
