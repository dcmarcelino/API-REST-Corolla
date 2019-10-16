package com.marcelino.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelino.apirest.models.Cliente;
import com.marcelino.apirest.repositories.ClienteRepository;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*") //define quais as origens podem acessar a api, caso tenha * qualquer url pode acessar
public class ClienteResource {
	
	@Autowired
	ClienteRepository ClienteRepository;
	
	@GetMapping("/clientes")  //diz qual o caminho que deverá ser acessado com o método get para executar
	public List<Cliente> listaCliente (){
		return ClienteRepository.findAll();
				
	}
	
	@GetMapping("/cliente/{id}")  
	public Cliente Cliente(@PathVariable(value = "id") long id) {
		return ClienteRepository.findById(id);

	}

	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return ClienteRepository.save(cliente);

	}

	@DeleteMapping("/cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		ClienteRepository.delete(cliente);
		
	}
	
	@PutMapping("/cliente")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return ClienteRepository.save(cliente);
		
	}

}
