package br.com.bdws.financeiro.controller;

import br.com.bdws.financeiro.entity.SubCategoria;
import br.com.bdws.financeiro.service.SubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SubCategoriaController {

    @Autowired
    private SubCategoriaService service;

    @ResponseBody
    @PostMapping("/subcategoria")
    public SubCategoria criar(@RequestHeader String cliente, @RequestBody SubCategoria entity) {
        return service.salvar(cliente, entity);
    }

    @ResponseBody
    @GetMapping("/subcategoria")
    public List<SubCategoria> listar(@RequestHeader String cliente) {
        return service.buscarTodosPorCliente(cliente);
    }

    @ResponseBody
    @GetMapping("/subcategoria/{id}")
    public SubCategoria buscar(@RequestHeader String cliente, @PathVariable String id) {
        return service.buscarPorIdEClienteId(cliente, id);
    }
}