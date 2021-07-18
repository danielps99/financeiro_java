package br.com.bdws.financeiro.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Builder
@Entity
public class Conta extends AbstractEntity {

    @ManyToOne
    private ClienteSistema clienteSistema;
    private String descricao;
    private boolean ativo;
    @ManyToOne(cascade = CascadeType.ALL)
    private ContaSaldo saldoAtual;
}
