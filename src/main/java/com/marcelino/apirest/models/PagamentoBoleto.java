package com.marcelino.apirest.models;


import java.util.Date;

import javax.persistence.Entity;

import com.marcelino.apirest.models.enums.EstadoPagamento;

@Entity
public class PagamentoBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	private Date vencimento;
	private Date dataPagamento;
	
	public PagamentoBoleto() {
		
	}

	public PagamentoBoleto(long id, EstadoPagamento estado, Venda venda, Date vencimento, Date dataPagamento) {
		super(id, estado, venda);
		this.vencimento = vencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	
}
