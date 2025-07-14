/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.controller;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Pichau
 */
public class Log {
    LocalDate data;
    LocalTime hora;
    int tipo, tipo_log_id_tipo_log, usuario_id_usuario, ordem_servico_id_ordem_servico, manutencao_id_manutencao;
    String descricao;

    public Log(LocalDate data, LocalTime hora, int tipo, int tipo_log_id_tipo_log, int usuario_id_usuario, int ordem_servico_id_ordem_servico, int manutencao_id_manutencao, String descricao) {
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.tipo_log_id_tipo_log = tipo_log_id_tipo_log;
        this.usuario_id_usuario = usuario_id_usuario;
        this.ordem_servico_id_ordem_servico = ordem_servico_id_ordem_servico;
        this.manutencao_id_manutencao = manutencao_id_manutencao;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getTipo() {
        return tipo;
    }

    public int getTipo_log_id_tipo_log() {
        return tipo_log_id_tipo_log;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public int getOrdem_servico_id_ordem_servico() {
        return ordem_servico_id_ordem_servico;
    }

    public int getManutencao_id_manutencao() {
        return manutencao_id_manutencao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
