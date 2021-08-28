package br.com.bdws.financeiro.controller;

import br.com.bdws.financeiro.dto.TituloDto;
import br.com.bdws.financeiro.entity.Titulo;
import br.com.bdws.financeiro.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TituloController {

    @Autowired
    private TituloService service;

    @ResponseBody
    @PostMapping("/titulo")
    public Titulo criar(@RequestHeader String cliente, @RequestBody Titulo entity) {
        return service.salvar(cliente, entity);
    }

    @ResponseBody
    @GetMapping("/titulo")
    public List<TituloDto> listar(@RequestHeader String cliente) {
        return service.buscarTodos();
    }

    @ResponseBody
    @GetMapping("/titulo/{id}")
    public Titulo buscar(@PathVariable String id) {
        return service.buscar(id);
    }

    @DeleteMapping("/titulo/{id}")
    public void remover(@PathVariable String id) {
        service.remover(id);
    }
}
