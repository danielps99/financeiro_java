package br.com.bdws.financeiro.controller;

import br.com.bdws.financeiro.entity.Categoria;
import br.com.bdws.financeiro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @ResponseBody
    @PostMapping("/categoria")
    public Categoria criar(@RequestHeader String cliente, @RequestBody Categoria entity) {
        return service.salvar(cliente, entity);
    }

    @ResponseBody
    @GetMapping("/categoria")
    public List<Categoria> listar(@RequestHeader String cliente) {
        return service.buscarTodosPorCliente(cliente);
    }

    @ResponseBody
    @GetMapping("/categoria/{id}")
    public Categoria buscar(@RequestHeader String cliente, @PathVariable String id) {
        return service.buscarPorIdEClienteId(id, cliente);
    }
}