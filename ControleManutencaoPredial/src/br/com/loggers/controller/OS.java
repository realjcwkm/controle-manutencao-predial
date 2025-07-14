/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.controller;

import java.time.LocalDate;

/**
 *
 * @author Pichau
 */
public class OS {

    String titulo, urgencia, status, descricao;
    LocalDate prazo;
    int tecnico, local_id_local;
    
    public OS(String titulo, String urgencia, String status, String descricao, LocalDate prazo, int tecnico, int local_id_local) {
        this.titulo = titulo;
        this.urgencia = urgencia;
        this.status = status;
        this.descricao = descricao;
        this.prazo = prazo;
        this.tecnico = tecnico;
        this.local_id_local = local_id_local;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public int getTecnico() {
        return tecnico;
    }

    public int getLocal_id_local() {
        return local_id_local;
    }
    
    
    
}
