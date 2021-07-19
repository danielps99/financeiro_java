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
    public Conta criar(@RequestBody Conta entity) {
        return service.salvar(entity);
    }

    @ResponseBody
    @GetMapping("/conta")
    public List<ContaDto> listar(@RequestHeader String cliente) {
        return service.buscarTodosPorCliente(cliente);
    }

    @ResponseBody
    @GetMapping("/conta/{id}")
    public ContaDto buscar(@PathVariable String id) {
        return service.buscar(id);
    }

    @DeleteMapping("/conta/{id}")
    public void remover(@PathVariable String id) {
//        service.remover(id);
    }


}
