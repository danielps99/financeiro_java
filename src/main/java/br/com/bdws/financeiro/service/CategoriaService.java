package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.Categoria;
import br.com.bdws.financeiro.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repository;

    public Categoria salvar(Categoria entity) {
        return repository.save(entity);
    }

    public Categoria buscar(String id) {
        return repository.findById(id).orElse(null);
    }
}