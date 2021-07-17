package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.ClienteSistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoadDadosIniciaisService {

    @Autowired
    private ClienteSistemaService clienteSistemaService;

    public void inserirDadosIniciais() {
        ClienteSistema clienteSistema = buscarClienteSistemaExistente();
        if (clienteSistema == null) {
            clienteSistema = criarUsuarioSistema();
        }
        System.out.println("Cliente Sistema id: " + clienteSistema.getId());
    }

    private ClienteSistema buscarClienteSistemaExistente() {
        return clienteSistemaService.buscarTodos().stream().findFirst().orElse(null);
    }

    private ClienteSistema criarUsuarioSistema() {
        ClienteSistema clienteSistema = ClienteSistema.builder()
                .criadoEm(new Date())
                .atualizadoEm(new Date())
                .nome("Daniel")
                .build();
        return clienteSistemaService.salvar(clienteSistema);
    }
}