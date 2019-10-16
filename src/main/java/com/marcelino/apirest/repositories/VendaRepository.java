package com.marcelino.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.marcelino.apirest.models.Venda;

	public interface VendaRepository extends JpaRepository<Venda, Long> {
	/*
	 * Essa classe é a classe de persistencia do objeto, pode ser adicionados métodos personalizados
	 */
	
	public Venda findById(long id);  // cria um método para buscar por id, usando o id definido na classe
}
