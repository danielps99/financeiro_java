package br.com.bdws.financeiro.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
public class ContaSaldo extends AbstractEntity {

    @ManyToOne
    private Conta conta;
    @ManyToOne
    private Movimento movimento;
    private BigDecimal valor;
}
