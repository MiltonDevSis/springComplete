package com.filho.milton.springcomplete.domain;

import com.filho.milton.springcomplete.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroDePArcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDePArcelas = numeroDeParcelas;
    }

    public Integer getNumeroDePArcelas() {
        return numeroDePArcelas;
    }

    public void setNumeroDePArcelas(Integer numeroDePArcelas) {
        this.numeroDePArcelas = numeroDePArcelas;
    }
}
