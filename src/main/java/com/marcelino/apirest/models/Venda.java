package com.marcelino.apirest.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Temporal (value = TemporalType.DATE)
	private Date data;

	@OneToOne(mappedBy = "venda", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="entrega_id")
	private Endereco entrega;
	
	@OneToMany(mappedBy = "id.venda")
	private Set<Item_Venda> itens_venda = new HashSet<>();
	
	public Venda(long id, Date data, Cliente cliente, Endereco entrega) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.entrega = entrega;
	}

	public Venda() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<Item_Venda> getItens() {
		return itens_venda;
	}

	public void setItens(Set<Item_Venda> itens_venda) {
		this.itens_venda = itens_venda;
	}

	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEntrega() {
		return entrega;
	}

	public void setEntrega(Endereco entrega) {
		this.entrega = entrega;
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
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + "]";
	}
	
	
}
