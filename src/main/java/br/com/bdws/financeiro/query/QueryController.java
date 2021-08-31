package br.com.bdws.financeiro.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/query")
public class QueryController {

    @Autowired
    private QueryService service;

    @ResponseBody
    @PostMapping("/{queryName}/{pageNumber}")
    public Result executeQuery(
            @RequestHeader String cliente,
            @PathVariable String queryName,
            @PathVariable int pageNumber,
            @RequestBody Map<String, Object> arguments,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        arguments.put("cliente", cliente);
        return service.executeQuery(queryName, pageNumber, pageSize, arguments);
    }
}