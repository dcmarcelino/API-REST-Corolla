package com.marcelino.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelino.apirest.models.Cliente;

	public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	/*
	 * Essa classe é a classe de persistencia do objeto, pode ser adicionados métodos personalizados
	 */
	
	public Cliente findById(long id);  // cria um método para buscar por id, usando o id definido na classe
}
