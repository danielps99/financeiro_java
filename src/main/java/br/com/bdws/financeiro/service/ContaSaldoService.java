package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.ContaSaldo;
import br.com.bdws.financeiro.repository.IContaSaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaSaldoService {

    @Autowired
    private IContaSaldoRepository repository;

    public ContaSaldo salvar(ContaSaldo entity) {
        return repository.save(entity);
    }
}