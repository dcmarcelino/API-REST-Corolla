package com.marcelino.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelino.apirest.models.Item_Venda;


	public interface Item_VendaRepository extends JpaRepository<Item_Venda, Long> {
	/*
	 * Essa classe é a classe de persistencia do objeto, pode ser adicionados métodos personalizados
	 */
	
	public Item_Venda findById(long id);  // cria um método para buscar por id, usando o id definido na classe
}
