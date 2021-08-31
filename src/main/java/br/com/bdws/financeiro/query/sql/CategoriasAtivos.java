package br.com.bdws.financeiro.query.sql;

import org.springframework.stereotype.Component;

@Component("CategoriasAtivos")
public class CategoriasAtivos extends AbstractSqlQuery {

    public CategoriasAtivos() {
        super("select id, descricao" +
                " from categoria" +
                " where cliente_sistema_id = :cliente" +
                " and ativo = true" +
                " order by descricao");
    }
}