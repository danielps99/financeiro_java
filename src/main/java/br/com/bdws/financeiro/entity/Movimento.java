package br.com.bdws.financeiro.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Movimento extends AbstractEntity {

    @ManyToOne
    private Titulo titulo;
    @ManyToOne
    private Conta conta;
}
