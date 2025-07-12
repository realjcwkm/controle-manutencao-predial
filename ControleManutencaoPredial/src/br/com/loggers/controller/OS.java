/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.controller;

import java.time.LocalDate;

/**
 *
 * @author Matheus
 */
public class OS {

    String titulo;
    String urgencia;
    String status;
    String descricao;
    LocalDate prazo;
    int tecnico;
    int local_id_local;
    
    public OS(String titulo, String urgencia, String status, String descricao, LocalDate prazo, int tecnico, int local_id_local) {
        this.titulo = titulo;
        this.urgencia = urgencia;
        this.status = status;
        this.descricao = descricao;
        this.prazo = prazo;
        this.tecnico = tecnico;
        this.local_id_local = local_id_local;
    }

    
}
