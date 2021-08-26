package br.com.bdws.financeiro.dto;

import lombok.Data;

@Data
public class SubcategoriaDto {
    private String id;
    private String descricao;
    private boolean ativo;
    private CategoriaDto categoria;
}