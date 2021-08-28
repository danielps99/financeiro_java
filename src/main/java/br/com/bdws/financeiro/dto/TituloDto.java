package br.com.bdws.financeiro.dto;

import br.com.bdws.financeiro.enumerated.OperacaoTitulo;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TituloDto {
    private String id;
    private String descricao;

    private BigDecimal valor;
    private Date vencimento;
    //    @Enumerated(EnumType.STRING)
    private OperacaoTitulo operacao;
    @ManyToOne
    private CategoriaDto categoria;
    @ManyToOne
    private SubcategoriaDto subcategoria;
}