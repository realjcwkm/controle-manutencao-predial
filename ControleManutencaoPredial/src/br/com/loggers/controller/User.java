/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.controller;

/**
 *
 * @author Aluno
 */
public class User {
    String nome, email, senha;
    int id_usuario, tipo;

    public User(int id_usuario, String nome, String email, String senha, int tipo){
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getTipo() {
        return tipo;
    }

    
    
    
}
