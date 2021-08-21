package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.Titulo;
import br.com.bdws.financeiro.repository.ITituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloService {

    @Autowired
    private ITituloRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public Titulo salvar(String cliente, Titulo titulo) {
        titulo.setClienteSistema(clienteSistemaService.buscar(cliente));
        return repository.save(titulo);
    }

    public List<Titulo> buscarTodos() {
        return repository.findAll();
    }

    public void remover(String id) {
        repository.deleteById(id);
    }

    public Titulo buscar(String id) {
        return repository.findById(id).orElse(null);
    }
}