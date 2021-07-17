package br.com.bdws.financeiro.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Conta extends AbstractEntity {

    @ManyToOne
    private ClienteSistema clienteSistema;
    private String descricao;
    private boolean ativo;
    @ManyToOne
    private ContaSaldo saldoAtual;
}
