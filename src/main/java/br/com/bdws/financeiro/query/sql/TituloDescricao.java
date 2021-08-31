package br.com.bdws.financeiro.query.sql;

import org.springframework.stereotype.Component;

@Component("TituloDescricao")
public class TituloDescricao extends AbstractSqlQuery {

    public TituloDescricao() {
        super("select id as tituloid, descricao as desc from titulo");
    }
}