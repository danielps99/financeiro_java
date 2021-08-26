package br.com.bdws.financeiro.service;

import br.com.bdws.financeiro.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoadDadosIniciaisService {

    @Autowired
    private ClienteSistemaService clienteSistemaService;
    @Autowired
    private ContaService contaService;
    @Autowired
    private ContaSaldoService contaSaldoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private SubcategoriaService subCategoriaService;
    private ClienteSistema clienteSistema;
    private String clienteSistemaId;

    public void inserirDadosIniciais() {
        clienteSistema = buscarClienteSistemaExistente();
        if (clienteSistema == null) {
            clienteSistema = criarUsuarioSistema();
            clienteSistemaId = clienteSistema.getId();
            criarContas();
            criarCategoriasESubCategorias();
        }
        clienteSistemaId = clienteSistema.getId();
        System.out.println("Cliente Sistema id: " + clienteSistemaId);
    }

    private void criarContas() {
        criarESalvarContaComSaldo(clienteSistema, "Carteira");
        criarESalvarContaComSaldo(clienteSistema, "Banco 1");
        criarESalvarContaComSaldo(clienteSistema, "Cartao credito 1");
    }

    private void criarESalvarContaComSaldo(ClienteSistema clienteSistema, String descricaoConta) {
        BigDecimal saldoAtual = BigDecimal.valueOf(100);
        Conta conta = Conta.builder()
                .clienteSistema(clienteSistema)
                .ativo(true)
                .descricao(descricaoConta)
                .saldoAtual(saldoAtual)
                .build();
        ContaSaldo contaSaldo = ContaSaldo.builder()
                .conta(conta)
                .valor(saldoAtual)
                .build();
        contaService.salvar(clienteSistemaId, conta);
        contaSaldoService.salvar(contaSaldo);
    }

    private void criarCategoriasESubCategorias() {
        Categoria categoria = criarESalvarCategoria("Alimentação");
        criarSubCategoria(categoria, "Mercado");
        criarSubCategoria(categoria, "Açougue");
        criarSubCategoria(categoria, "Outros");
        categoria = criarESalvarCategoria("Saúde");
        criarSubCategoria(categoria, "Consulta");
        criarSubCategoria(categoria, "Exame");
        criarSubCategoria(categoria, "Remédio");
        categoria = criarESalvarCategoria("Salário");
        criarSubCategoria(categoria, "Fixo");
        criarSubCategoria(categoria, "Objetos vendidos");
        criarSubCategoria(categoria, "Free Lance");
        categoria = criarESalvarCategoria("Lazer");
        criarSubCategoria(categoria, "Viagem");
        criarSubCategoria(categoria, "Clube");
    }

    private void criarSubCategoria(Categoria categoria, String descricao) {
        Subcategoria subCategoria = Subcategoria.builder()
                .clienteSistema(clienteSistema)
                .categoria(categoria)
                .ativo(true)
                .descricao(descricao)
                .build();
        subCategoriaService.salvar(clienteSistemaId, subCategoria);
    }

    private Categoria criarESalvarCategoria(String descricaoCategoria) {
        Categoria categoria = Categoria.builder()
                .clienteSistema(clienteSistema)
                .ativo(true)
                .descricao(descricaoCategoria)
                .build();
        return categoriaService.salvarRetornandoEntity(clienteSistemaId, categoria);
    }

    private ClienteSistema buscarClienteSistemaExistente() {
        return clienteSistemaService.buscarTodos().stream().findFirst().orElse(null);
    }

    private ClienteSistema criarUsuarioSistema() {
        clienteSistema = ClienteSistema.builder()
                .nome("Daniel")
                .build();
        return clienteSistemaService.salvar(clienteSistema);
    }
}