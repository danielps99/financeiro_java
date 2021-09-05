package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.dto.TituloDto;
import br.com.bdws.financeiro.entity.Titulo;
import br.com.bdws.financeiro.repository.ITituloRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TituloService {

    private final ModelMapper modelMapper;
    @Autowired
    private ITituloRepository repository;
    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public Titulo agendar(String cliente, Titulo titulo) {
        titulo.setClienteSistema(clienteSistemaService.buscar(cliente));
        return repository.save(titulo);
    }

    public Titulo agendarParcelado(String cliente, Titulo titulo, Integer parcelas, String peridiocidade, String calculo) {
        titulo.setClienteSistema(clienteSistemaService.buscar(cliente));

        /*
            TODO
            - Implementar a divisão do valor em parcelas
            - Melhorar o acréscimo no vencimento em cada parcela de acordo com a periodicidade
         */
        GregorianCalendar gc = new GregorianCalendar();
        Titulo tituloSalvo = null;
        for (int i = 0; i < parcelas; i++) {
            gc.setTime(titulo.getVencimento());
            gc.add(gc.MONTH, i);
            titulo.setVencimento(gc.getTime());
            tituloSalvo = repository.save(titulo);
        }
        return tituloSalvo;
    }

    public List<TituloDto> buscarTodos() {
        List<TituloDto> titulos = repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, TituloDto.class)).collect(Collectors.toList());
        return titulos;
    }

    public void remover(String id) {
        repository.deleteById(id);
    }

    public Titulo buscar(String id) {
        return repository.findById(id).orElse(null);
    }
}