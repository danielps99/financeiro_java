package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.ClienteSistema;
import br.com.bdws.financeiro.repository.IClienteSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteSistemaService {

    @Autowired
    private IClienteSistemaRepository repository;

    public ClienteSistema salvar(ClienteSistema entity) {
        return repository.save(entity);
    }

    public List<ClienteSistema> buscarTodos() {
        return repository.findAll();
    }
}