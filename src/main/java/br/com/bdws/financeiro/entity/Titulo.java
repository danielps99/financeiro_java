package br.com.bdws.financeiro.entity;

import br.com.bdws.financeiro.enumerated.OperacaoTitulo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Titulo extends AbstractEntity {

    @ManyToOne
    private ClienteSistema clienteSistema;
    private String descricao;
    private BigDecimal valor;
    private Date vencimento;
    @Enumerated(EnumType.STRING)
    private OperacaoTitulo operacao;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private SubCategoria subCategoria;
}
