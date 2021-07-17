package br.com.bdws.financeiro.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Titulo extends AbstractEntity {
    private String descricao;
    private BigDecimal valor;
    private Date data;
}
