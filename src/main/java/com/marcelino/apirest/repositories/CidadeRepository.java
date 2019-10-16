package com.marcelino.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelino.apirest.models.Cidade;


	public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	/*
	 * Essa classe é a classe de persistencia do objeto, pode ser adicionados métodos personalizados
	 */
	
	public Cidade findById(long id);  // cria um método para buscar por id, usando o id definido na classe
}
