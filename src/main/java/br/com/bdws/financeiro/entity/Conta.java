package br.com.bdws.financeiro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

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
    private BigDecimal saldoAtual;
}
