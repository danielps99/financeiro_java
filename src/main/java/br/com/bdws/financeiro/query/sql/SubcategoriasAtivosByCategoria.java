package br.com.bdws.financeiro.query.sql;

import org.springframework.stereotype.Component;

@Component("SubcategoriasAtivosByCategoria")
public class SubcategoriasAtivosByCategoria extends AbstractSqlQuery {

    public SubcategoriasAtivosByCategoria() {
        super("select id, descricao" +
                " from subcategoria" +
                " where cliente_sistema_id = :cliente" +
                " and ativo = true" +
                " and categoria_id = :categoria_id" +
                " order by descricao");
    }
}