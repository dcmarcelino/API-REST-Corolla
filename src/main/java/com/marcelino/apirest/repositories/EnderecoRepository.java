package com.marcelino.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelino.apirest.models.Endereco;


	public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	/*
	 * Essa classe é a classe de persistencia do objeto, pode ser adicionados métodos personalizados
	 */
	
	public Endereco findById(long id);  // cria um método para buscar por id, usando o id definido na classe
}
