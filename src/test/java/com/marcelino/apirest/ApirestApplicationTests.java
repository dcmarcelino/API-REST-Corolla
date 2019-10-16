package com.marcelino.apirest;


import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marcelino.apirest.models.Cidade;
import com.marcelino.apirest.models.Cliente;
import com.marcelino.apirest.models.Endereco;
import com.marcelino.apirest.models.Estado;
import com.marcelino.apirest.models.enums.TipoCliente;
import com.marcelino.apirest.repositories.CidadeRepository;
import com.marcelino.apirest.repositories.ClienteRepository;
import com.marcelino.apirest.repositories.EnderecoRepository;
import com.marcelino.apirest.repositories.EstadoRepository;
import com.marcelino.apirest.repositories.Item_VendaRepository;
import com.marcelino.apirest.repositories.ProdutoRepository;
import com.marcelino.apirest.repositories.VendaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApirestApplicationTests {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	VendaRepository vendaRepository;
	@Autowired
	Item_VendaRepository item_vendaRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	public void contextLoads() {
	}
	@Test
	public void Testar() {	
		
		
//	Estado er = new Estado(0, "Rio de Janeiro", "RJ");
//	Estado e1 = new Estado(0, "São Paulo", "SP");
//	Estado e3 = new Estado(0, "Minas Gerais", "MG");
//	
	Cidade cr = cidadeRepository.findById(8);
//	Cidade c1 = new Cidade(0, "Barra do Piraí", e);
//	Cidade c2 = new Cidade(0, "Uberlandia", e3);
	Cidade c3 = cidadeRepository.findById(11);
//	Cidade c4 = new Cidade(0, "Ubatuba", e1);
//	
//	e.getCidades().addAll(Arrays.asList(c1, c));
//	e1.getCidades().addAll(Arrays.asList(c3,c4));
//	e3.getCidades().addAll(Arrays.asList(c2));
//	
//	estadoRepository.saveAll(Arrays.asList(e,e1,e3));
//	cidadeRepository.saveAll(Arrays.asList(c,c1,c2,c3,c4));
//	
	
		Cliente c = new Cliente(0, "Rafaela Domingues", "rafadomingues@gmail.com", "11999944455", TipoCliente.PESSOAFISICA);
		c.getTelefones().addAll(Arrays.asList("219999999", "2158889995"));
		
		Cliente cli2 = new Cliente(0, "Diego Marcelino", "dcmarcelino@gmail.com", "12811109730", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("21982027812", "255555555"));
		
		Endereco e = new Endereco(0,"Rodovia Raposo Tavares", "3175", "Bloco B Apto 67", "Jardim Olympia", "05573900", c, c3);
		Endereco e2 = new Endereco(0,"Rua Conde de Azambuja", "170", "Apto 702", "Maria da Graça", "20740220", c, cr);
		
		c.getEnderecos().addAll(Arrays.asList(e, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e, e2));
		
		
		clienteRepository.saveAll(Arrays.asList(c,cli2));
		enderecoRepository.saveAll(Arrays.asList(e,e2));
		
	}



}
