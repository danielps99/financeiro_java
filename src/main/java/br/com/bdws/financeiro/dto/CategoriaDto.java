package br.com.bdws.financeiro.dto;

import lombok.Data;

@Data
public class CategoriaDto {
    private String id;
    private String descricao;
    private boolean ativo;
}