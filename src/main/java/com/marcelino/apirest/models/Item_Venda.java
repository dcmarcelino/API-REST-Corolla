package com.marcelino.apirest.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Item_Venda implements Serializable{
private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Item_VendaPK id = new Item_VendaPK();
	
	private long quantidade;
	
	private double preco;
	
	private double desconto;

	public Item_Venda(Produto produto, Venda venda, long quantidade, double preco, double desconto) {
		super();
		id.setProduto(produto);
		id.setVenda(venda);
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public Item_Venda() {
		
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public Venda getVenda() {
		return id.getVenda();
	}

	public Item_VendaPK getId() {
		return id;
	}

	public void setId(Item_VendaPK id) {
		this.id = id;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Item_Venda other = (Item_Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
}
