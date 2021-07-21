package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.Categoria;
import br.com.bdws.financeiro.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public Categoria salvar(String clienteId, Categoria entity) {
        entity.setClienteSistema(clienteSistemaService.buscar(clienteId));
        return repository.save(entity);
    }

    public Categoria buscarPorIdEClienteId(String id, String clienteId) {
        return repository.findByIdAndClienteSistemaId(id, clienteId).orElse(null);
    }

    public List<Categoria> buscarTodosPorCliente(String clienteId) {
        return repository.findAllByClienteSistemaId(clienteId);
    }
}