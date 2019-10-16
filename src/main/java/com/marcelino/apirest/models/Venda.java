package com.marcelino.apirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "venda", targetEntity = Item_Venda.class, 
	        cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Item_Venda> itens = new ArrayList<>();

	
	
	public Venda(long id, Date data, List<Item_Venda> itens) {
		super();
		this.id = id;
		this.data = data;
		this.itens = itens;
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

	public List<Item_Venda> getItens() {
		return itens;
	}

	public void setItens(List<Item_Venda> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + ", itens=" + itens + "]";
	}
	
	
}
