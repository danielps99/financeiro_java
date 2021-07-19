package br.com.bdws.financeiro.controller;

import br.com.bdws.financeiro.dto.ContaDto;
import br.com.bdws.financeiro.entity.Conta;
import br.com.bdws.financeiro.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ContaController {

    @Autowired
    private ContaService service;

    @ResponseBody
    @PostMapping("/conta")
    public ContaDto criar(@RequestHeader String cliente, @RequestBody Conta entity) {
        return service.salvar(cliente, entity);
    }

    @ResponseBody
    @GetMapping("/conta")
    public List<ContaDto> listar(@RequestHeader String cliente) {
        return service.buscarTodosPorCliente(cliente);
    }

    @ResponseBody
    @GetMapping("/conta/{id}")
    public ContaDto buscar(@RequestHeader String cliente, @PathVariable String id) {
        return service.buscarPorIdEClienteId(cliente, id);
    }
}
