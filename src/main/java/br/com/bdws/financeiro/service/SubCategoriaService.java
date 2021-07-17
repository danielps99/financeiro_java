package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.SubCategoria;
import br.com.bdws.financeiro.repository.ISubCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoriaService {

    @Autowired
    private ISubCategoriaRepository repository;

    public SubCategoria salvar(SubCategoria entity) {
        return repository.save(entity);
    }

    public SubCategoria buscar(String id) {
        return repository.findById(id).orElse(null);
    }
}