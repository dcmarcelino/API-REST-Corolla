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

import com.marcelino.apirest.models.Produto;
import com.marcelino.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos") // Diz o nome da API no Swagger
@CrossOrigin(origins="*") //define quais as origens podem acessar a api, caso tenha * qualquer url pode acessar
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")  //diz qual o caminho que deverá ser acessado com o método get para executar
	@ApiOperation(value="Lista os Produtos")	//aponta no Swagger o que esse metodo faz
	public List<Produto> listaProduto (){
		return produtoRepository.findAll();
				
	}
	
	@GetMapping("/produto/{id}")  
	@ApiOperation(value="Lista o Produto por Id")  //aponta no Swagger o que esse metodo faz
	public Produto produto(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);

	}

	@PostMapping("/produto")
	@ApiOperation(value="Salva um Produto")  //aponta no Swagger o que esse metodo faz
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um Produto")  //aponta no Swagger o que esse metodo faz
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
		
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um Produto") //aponta no Swagger o que esse metodo faz
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
		
	}

}
