package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.Conta;
import br.com.bdws.financeiro.repository.IContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private IContaRepository repository;

    public Conta salvar(Conta entity) {
        return repository.save(entity);
    }

    public Conta buscar(String id) {
        return repository.findById(id).orElse(null);
    }
}