package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.dto.ContaDto;
import br.com.bdws.financeiro.entity.Conta;
import br.com.bdws.financeiro.repository.IContaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ModelMapper modelMapper;
    @Autowired
    private IContaRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public ContaDto salvar(String clienteId, Conta entity) {
        entity.setClienteSistema(clienteSistemaService.buscar(clienteId));
        Conta conta = repository.save(entity);
        return modelMapper.map(conta, ContaDto.class);
    }

    public ContaDto buscarPorIdEClienteId(String clienteId, String id) {
        Conta conta = repository.findByIdAndClienteSistemaId(id, clienteId).orElse(null);
        return modelMapper.map(conta, ContaDto.class);
    }

    public List<ContaDto> buscarTodosPorCliente(String clienteId) {
        List<ContaDto> contas = repository.findAllByClienteSistemaId(clienteId).stream()
                .map(livro -> modelMapper.map(livro, ContaDto.class)).collect(Collectors.toList());
        return contas;
    }
}