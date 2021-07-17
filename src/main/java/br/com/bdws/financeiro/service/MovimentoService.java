package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.Movimento;
import br.com.bdws.financeiro.repository.IMovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentoService {

    @Autowired
    private IMovimentoRepository repository;

    public Movimento salvar(Movimento entity) {
        return repository.save(entity);
    }

    public void remover(String id) {
        repository.deleteById(id);
    }

    public Movimento buscar(String id) {
        return repository.findById(id).orElse(null);
    }
}