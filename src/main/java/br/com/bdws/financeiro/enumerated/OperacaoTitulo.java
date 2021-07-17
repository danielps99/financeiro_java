package br.com.bdws.financeiro.enumerated;

public enum OperacaoTitulo {
    PAGAR("Pagar"),
    TRANSFERENCIA("Transferência"),
    RECEBER("Receber");
    private String descricao;

    OperacaoTitulo(String descricao) {
        this.descricao = descricao;
    }
}
