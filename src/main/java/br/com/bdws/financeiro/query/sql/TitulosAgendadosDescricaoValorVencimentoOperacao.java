package br.com.bdws.financeiro.query.sql;

import org.springframework.stereotype.Component;

@Component("TitulosAgendadosDescricaoValorVencimentoOperacao")
public class TitulosAgendadosDescricaoValorVencimentoOperacao extends AbstractSqlQuery {

    public TitulosAgendadosDescricaoValorVencimentoOperacao() {
        super("select id, descricao, valor, vencimento, operacao from titulo order by vencimento asc");
    }
}