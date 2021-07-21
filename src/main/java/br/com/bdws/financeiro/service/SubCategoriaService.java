package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.SubCategoria;
import br.com.bdws.financeiro.repository.ISubCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoriaService {

    @Autowired
    private ISubCategoriaRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public SubCategoria salvar(String clienteId, SubCategoria entity) {
        entity.setClienteSistema(clienteSistemaService.buscar(clienteId));
        return repository.save(entity);
    }

    public SubCategoria buscarPorIdEClienteId(String id, String clienteId) {
        return repository.findByIdAndClienteSistemaId(id, clienteId).orElse(null);
    }

    public List<SubCategoria> buscarTodosPorCliente(String clienteId) {
        return repository.findAllByClienteSistemaId(clienteId);
    }
}