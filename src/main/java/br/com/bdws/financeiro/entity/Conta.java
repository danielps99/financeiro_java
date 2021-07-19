package br.com.bdws.financeiro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta extends AbstractEntity {

    @ManyToOne
    private ClienteSistema clienteSistema;
    private String descricao;
    private boolean ativo;
    @ManyToOne(cascade = CascadeType.ALL)
    private ContaSaldo saldoAtual;
}
