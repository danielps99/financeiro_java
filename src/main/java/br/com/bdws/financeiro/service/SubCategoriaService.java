package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.dto.SubCategoriaDto;
import br.com.bdws.financeiro.entity.SubCategoria;
import br.com.bdws.financeiro.repository.ISubCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubCategoriaService {

    private final ModelMapper modelMapper;
    @Autowired
    private ISubCategoriaRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public SubCategoriaDto salvar(String clienteId, SubCategoria entity) {
        entity.setClienteSistema(clienteSistemaService.buscar(clienteId));
        entity = repository.save(entity);
        return modelMapper.map(entity, SubCategoriaDto.class);
    }

    public SubCategoriaDto buscarPorIdEClienteId(String id, String clienteId) {
        SubCategoria entity = repository.findByIdAndClienteSistemaId(id, clienteId).orElse(null);
        return modelMapper.map(entity, SubCategoriaDto.class);
    }

    public List<SubCategoriaDto> buscarTodosPorCliente(String clienteId) {
        List<SubCategoriaDto> subCategorias = repository.findAllByClienteSistemaId(clienteId).stream()
                .map(entity -> modelMapper.map(entity, SubCategoriaDto.class)).collect(Collectors.toList());
        return subCategorias;
    }
}