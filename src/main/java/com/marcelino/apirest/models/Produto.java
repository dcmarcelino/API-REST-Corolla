package com.marcelino.apirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private double valor;
	
	@OneToMany(mappedBy = "id.produto")
	private Set<Item_Venda> itens_venda = new HashSet<>();
	
	
	public Produto(long id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public Produto() {

	}
	
	public List<Venda> getVendas(){
		List<Venda> vendas = new ArrayList<>();
		for(Item_Venda item : itens_venda) {
			vendas.add(item.getVenda());
		}
		return vendas;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	public Set<Item_Venda> getItens_venda() {
		return itens_venda;
	}

	public void setItens_venda(Set<Item_Venda> itens_venda) {
		this.itens_venda = itens_venda;
	}

	@Override
	public String toString() {
		return "Produto [Id="+ id + " ,nome=" + nome + ", valor=" + valor + "]";
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
		