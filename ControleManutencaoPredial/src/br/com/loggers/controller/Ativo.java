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
public class Ativo {
    String modelo_ativo, descricao;
    LocalDate data_instalacao;
    LocalDate ultima_manutencao;
    int local_id_local;
    int tipo_ativo_id_tipo_ativo;
    int periodicidade_id_periodicidade;

    public Ativo(String modelo_ativo, String descricao, LocalDate data_instalacao, LocalDate ultima_manutencao, int local_id_local, int tipo_ativo_id_tipo_ativo, int periodicidade_id_periodicidade) {
        this.modelo_ativo = modelo_ativo;
        this.descricao = descricao;
        this.data_instalacao = data_instalacao;
        this.ultima_manutencao = ultima_manutencao;
        this.local_id_local = local_id_local;
        this.tipo_ativo_id_tipo_ativo = tipo_ativo_id_tipo_ativo;
        this.periodicidade_id_periodicidade = periodicidade_id_periodicidade;
    }

}
