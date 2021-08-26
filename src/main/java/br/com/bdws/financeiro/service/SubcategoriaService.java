package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.dto.SubcategoriaDto;
import br.com.bdws.financeiro.entity.Subcategoria;
import br.com.bdws.financeiro.repository.ISubcategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubcategoriaService {

    private final ModelMapper modelMapper;
    @Autowired
    private ISubcategoriaRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public SubcategoriaDto salvar(String clienteId, Subcategoria entity) {
        entity.setClienteSistema(clienteSistemaService.buscar(clienteId));
        entity = repository.save(entity);
        return modelMapper.map(entity, SubcategoriaDto.class);
    }

    public SubcategoriaDto buscarPorIdEClienteId(String id, String clienteId) {
        Subcategoria entity = repository.findByIdAndClienteSistemaId(id, clienteId).orElse(null);
        return modelMapper.map(entity, SubcategoriaDto.class);
    }

    public List<SubcategoriaDto> buscarTodosPorCliente(String clienteId) {
        List<SubcategoriaDto> subCategorias = repository.findAllByClienteSistemaId(clienteId).stream()
                .map(entity -> modelMapper.map(entity, SubcategoriaDto.class)).collect(Collectors.toList());
        return subCategorias;
    }
}