package com.marcelino.apirest.models;

import javax.persistence.Entity;

import com.marcelino.apirest.models.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	private long parcelas;

	public PagamentoCartao() {

	}

	public PagamentoCartao(long id, EstadoPagamento estado, Venda venda, Long parcelas) {
		super(id, estado, venda);
		this.parcelas = parcelas;
	}

	public long getParcelas() {
		return parcelas;
	}

	public void setParcelas(long parcelas) {
		this.parcelas = parcelas;
	}

}
