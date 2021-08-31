package br.com.bdws.financeiro.query.sql;

import org.springframework.stereotype.Component;

@Component("ContasAtivos")
public class ContasAtivos extends AbstractSqlQuery {

    public ContasAtivos() {
        super("select id, descricao, saldo_atual" +
                " from conta" +
                " where cliente_sistema_id = :cliente" +
                " and ativo = true" +
                " order by descricao");
    }
}