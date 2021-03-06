package br.com.bdws.financeiro.enumerated;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OperacaoTitulo {

    @JsonProperty("Pagar")
    PAGAR("Pagar"),
    @JsonProperty("TransferĂȘncia")
    TRANSFERENCIA("TransferĂȘncia"),
    @JsonProperty("Receber")
    RECEBER("Receber");

    private String descricao;

    OperacaoTitulo(String descricao) {
        this.descricao = descricao;
    }
}
