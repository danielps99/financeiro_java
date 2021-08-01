package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.dto.CategoriaDto;
import br.com.bdws.financeiro.entity.Categoria;
import br.com.bdws.financeiro.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final ModelMapper modelMapper;
    @Autowired
    private ICategoriaRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public Categoria salvarRetornandoEntity(String clienteId, Categoria entity) {
        entity.setClienteSistema(clienteSistemaService.buscar(clienteId));
        return repository.save(entity);
    }

    public CategoriaDto salvar(String clienteId, Categoria entity) {
        entity = salvarRetornandoEntity(clienteId, entity);
        return modelMapper.map(entity, CategoriaDto.class);
    }

    public CategoriaDto buscarPorIdEClienteId(String id, String clienteId) {
        Categoria entity = repository.findByIdAndClienteSistemaId(id, clienteId).orElse(null);
        return modelMapper.map(entity, CategoriaDto.class);
    }

    public List<CategoriaDto> buscarTodosPorCliente(String clienteId) {
        List<CategoriaDto> categorias = repository.findAllByClienteSistemaId(clienteId).stream()
                .map(entity -> modelMapper.map(entity, CategoriaDto.class)).collect(Collectors.toList());
        return categorias;
    }
}