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

import com.marcelino.apirest.models.Item_Venda;
import com.marcelino.apirest.models.Venda;
import com.marcelino.apirest.repositories.Item_VendaRepository;
import com.marcelino.apirest.repositories.VendaRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*") // define quais as origens podem acessar a api, caso tenha * qualquer url pode
							// acessar
public class VendaResource {

	@Autowired
	VendaRepository VendaRepository;
	Item_VendaRepository item_VendaRepository;

	@GetMapping("/vendas") // diz qual o caminho que deverá ser acessado com o método get para executar
	public List<Venda> listaVenda() {
		return VendaRepository.findAll();

	}

	@GetMapping("/venda/{id}")
	public Venda Venda(@PathVariable(value = "id") long id) {
		return VendaRepository.findById(id);

	}

	@PostMapping("/venda")
	public Venda salvaVenda(@RequestBody Venda venda) {
		return VendaRepository.save(venda);
	}

	@DeleteMapping("/venda")
	public void deletaVenda(@RequestBody Venda venda) {
		VendaRepository.delete(venda);

	}

	@PutMapping("/venda")
	public Venda atualizaVenda(@RequestBody Venda venda) {
		return VendaRepository.save(venda);

	}

}
