package br.com.bdws.financeiro.enumerated;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OperacaoTitulo {

    @JsonProperty("Pagar")
    PAGAR("Pagar"),
    @JsonProperty("Transferência")
    TRANSFERENCIA("Transferência"),
    @JsonProperty("Receber")
    RECEBER("Receber");

    private String descricao;

    OperacaoTitulo(String descricao) {
        this.descricao = descricao;
    }
}
