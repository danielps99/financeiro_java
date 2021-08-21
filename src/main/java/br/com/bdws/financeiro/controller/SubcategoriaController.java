package br.com.bdws.financeiro.controller;

import br.com.bdws.financeiro.dto.SubCategoriaDto;
import br.com.bdws.financeiro.entity.Subcategoria;
import br.com.bdws.financeiro.service.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService service;

    @ResponseBody
    @PostMapping("/subcategoria")
    public SubCategoriaDto criar(@RequestHeader String cliente, @RequestBody Subcategoria entity) {
        return service.salvar(cliente, entity);
    }

    @ResponseBody
    @GetMapping("/subcategoria")
    public List<SubCategoriaDto> listar(@RequestHeader String cliente) {
        return service.buscarTodosPorCliente(cliente);
    }

    @ResponseBody
    @GetMapping("/subcategoria/{id}")
    public SubCategoriaDto buscar(@RequestHeader String cliente, @PathVariable String id) {
        return service.buscarPorIdEClienteId(cliente, id);
    }
}