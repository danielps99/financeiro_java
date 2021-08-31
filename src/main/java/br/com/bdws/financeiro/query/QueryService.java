package br.com.bdws.financeiro.query;

import br.com.bdws.financeiro.query.sql.AbstractSqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("QueryService")
public class QueryService {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Result executeQuery(String queryName, int pageNumber, int pageSize, Map<String, Object> arguments) {
        try {
            AbstractSqlQuery q = (AbstractSqlQuery) context.getBean(queryName);
            return executeQuery(q, pageNumber, pageSize, arguments);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultError(e.getMessage());
        }
    }

    public ResultPage executeQuery(AbstractSqlQuery q, int pageNumber, long pageSize, Map<String, Object> arguments) {
        long elapsedTime = System.currentTimeMillis();
        MapSqlParameterSource mapParamSource = new MapSqlParameterSource(arguments);
        Long recordCount = contarRegistros(q, mapParamSource);
        if (pageSize == 0) {
            pageSize = recordCount;
        }
        List<Map<String, Object>> registros = buscarRegistros(q, pageNumber, pageSize, mapParamSource);
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return new ResultPage(pageNumber, pageSize, recordCount, elapsedTime, registros);
    }

    private List<Map<String, Object>> buscarRegistros(AbstractSqlQuery q, int pageNumber, long pageSize, MapSqlParameterSource mapParamSource) {
        String sqlPage = q.sql + " LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNumber - 1));
        return jdbcTemplate.query(sqlPage, mapParamSource, new DefaultRowMapper());
    }

    private Long contarRegistros(AbstractSqlQuery q, MapSqlParameterSource mapParamSource) {
        String sqlCount = "select count(*) from (" + q.sql + ")";
        return jdbcTemplate.queryForObject(sqlCount, mapParamSource, Long.class);
    }
}