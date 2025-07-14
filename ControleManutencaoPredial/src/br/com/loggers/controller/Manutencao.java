/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.loggers.controller;

/**
 *
 * @author Pichau
 */
public class Manutencao {
    String tipo_manutencao;
    int ordem_servico_id_ordem_servico, local_id_local, periodicidade_id_periodicidade;

    public Manutencao(String tipo_manutencao, int ordem_servico_id_ordem_servico, int local_id_local, int periodicidade_id_periodicidade) {
        this.tipo_manutencao = tipo_manutencao;
        this.ordem_servico_id_ordem_servico = ordem_servico_id_ordem_servico;
        this.local_id_local = local_id_local;
        this.periodicidade_id_periodicidade = periodicidade_id_periodicidade;
    }

    public String getTipo_manutencao() {
        return tipo_manutencao;
    }

    public int getOrdem_servico_id_ordem_servico() {
        return ordem_servico_id_ordem_servico;
    }

    public int getLocal_id_local() {
        return local_id_local;
    }

    public int getPeriodicidade_id_periodicidade() {
        return periodicidade_id_periodicidade;
    }
    
    
}
