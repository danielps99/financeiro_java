package br.com.bdws.financeiro.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaDto {
    private String id;
    private String descricao;
    private boolean ativo;
    private BigDecimal saldoAtual;
}