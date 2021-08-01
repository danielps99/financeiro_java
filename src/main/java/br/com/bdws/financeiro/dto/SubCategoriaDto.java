package br.com.bdws.financeiro.dto;

import lombok.Data;

@Data
public class SubCategoriaDto {
    private String id;
    private String descricao;
    private boolean ativo;
    private CategoriaDto categoria;
}