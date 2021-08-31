package br.com.bdws.financeiro.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultError implements Result {
    private final String erro;
}