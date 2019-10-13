package com.marcelino.apirest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.marcelino.apirest.models.Cliente;
import com.marcelino.apirest.models.Item_Venda;
import com.marcelino.apirest.models.Produto;
import com.marcelino.apirest.models.Venda;
import com.marcelino.apirest.repository.ClienteRepository;
import com.marcelino.apirest.repository.Item_VendaRepository;
import com.marcelino.apirest.repository.ProdutoRepository;
import com.marcelino.apirest.repository.VendaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApirestApplicationTests {

	@Autowired
	ProdutoRepository produtoRepository;
	ClienteRepository clienteRepository;
	VendaRepository vendaRepository;
	Item_VendaRepository item_vendaRepository;

	public void contextLoads() {
	}
	@Test
	public void Testar() {

		List<Item_Venda> itens = new ArrayList<>();

		Cliente c = new Cliente();
		Venda v = new Venda();
		Item_Venda item = new Item_Venda();
		Item_Venda item1 = new Item_Venda();
		Item_Venda item2 = new Item_Venda();
		Produto p = new Produto();
		Produto p1 = new Produto();
		Produto p2 = new Produto();

		v.setData(new Date());

		p = produtoRepository.findById(1342);
		p1 = produtoRepository.findById(2000);
		p2 = produtoRepository.findById(3489);

		c.setId(1);
		c.setNome("Diego");
		c.setTelefone("99999");

		item.setProduto(p);
		item1.setProduto(p1);
		item2.setProduto(p2);

		itens.add(item);
		itens.add(item1);
		itens.add(item2);

		v.setItens(itens);
		
		for (Item_Venda item_venda : itens) {
			item_venda.setVenda(v);
		}

		

		System.out.println(c);
		System.out.println(p);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(v);

		clienteRepository.save(c);
		vendaRepository.save(v);
	}



}
