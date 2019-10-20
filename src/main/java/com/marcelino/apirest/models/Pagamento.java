package com.marcelino.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.marcelino.apirest.models.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) // mapear a herança das subclasses ou em uma tabela única SINGLE_TABLE ou fazendo join JOINED
public abstract class Pagamento implements Serializable {   // classe abstrata garante que ela não será instanciada, serão sempre as subclasses

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name="venda_id")
	@MapsId                       //garante que o id do pagamento seja o mesmo do pedido
	private Venda venda;

	public Pagamento() {
	}

	public Pagamento(long id, EstadoPagamento estado, Venda venda) {
		super();
		this.id = id;
		this.estado = estado.getCodigo();
		this.venda = venda;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCodigo();
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
