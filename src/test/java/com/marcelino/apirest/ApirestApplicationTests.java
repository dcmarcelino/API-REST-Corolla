package com.marcelino.apirest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.marcelino.apirest.models.Item_Venda;
import com.marcelino.apirest.models.Pagamento;
import com.marcelino.apirest.models.PagamentoBoleto;
import com.marcelino.apirest.models.PagamentoCartao;
import com.marcelino.apirest.models.Produto;
import com.marcelino.apirest.models.Venda;
import com.marcelino.apirest.models.enums.EstadoPagamento;
import com.marcelino.apirest.models.enums.TipoCliente;
import com.marcelino.apirest.repositories.CidadeRepository;
import com.marcelino.apirest.repositories.ClienteRepository;
import com.marcelino.apirest.repositories.EnderecoRepository;
import com.marcelino.apirest.repositories.EstadoRepository;
import com.marcelino.apirest.repositories.Item_VendaRepository;
import com.marcelino.apirest.repositories.PagamentoRepository;
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
	@Autowired
	PagamentoRepository pagamentoRepository;

	public void contextLoads() {
	}

	//@Test
	public void Testar() throws ParseException {
		
	Produto p1 = new Produto(0, "TV 150 Polegadas", 7.500);
	Produto p2 = new Produto(0, "Samsung A+", 2.500);
	
	produtoRepository.saveAll(Arrays.asList(p1,p2));

	Estado er = new Estado(0, "Rio de Janeiro", "RJ");
	Estado e1 = new Estado(0, "São Paulo", "SP");
	Estado e3 = new Estado(0, "Minas Gerais", "MG");
	

	Cidade c1 = new Cidade(0, "Barra do Piraí", er);
	Cidade c2 = new Cidade(0, "Uberlandia", e3);
	Cidade c3 = new Cidade(0, "São Paulo", e1);
	Cidade c4 = new Cidade(0, "Ubatuba", e1);
	
	er.getCidades().addAll(Arrays.asList(c1));
	e1.getCidades().addAll(Arrays.asList(c3,c4));
	e3.getCidades().addAll(Arrays.asList(c2));
	
	estadoRepository.saveAll(Arrays.asList(er,e1,e3));
	cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
	
	
		Cliente cli1 = new Cliente(0, "Rafaela Domingues", "rafadomingues@gmail.com", "11999944455", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("219999999", "2158889995"));
		
		Cliente cli2 = new Cliente(0, "Diego Marcelino", "dcmarcelino@gmail.com", "12811109730", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("21982027812", "255555555"));
		
		Endereco e = new Endereco(0,"Rodovia Raposo Tavares", "3175", "Bloco B Apto 67", "Jardim Olympia", "05573900", cli1, c3);
		Endereco e2 = new Endereco(0,"Rua Conde de Azambuja", "170", "Apto 702", "Maria da Graça", "20740220", cli2, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e, e2));


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Venda venda1 = new Venda(0, sdf.parse("16/10/2019 09:30:00"), cli1, e);
		Venda venda2 = new Venda(0, sdf.parse("17/10/2019 10:55:08"), cli2, e2);
		
		Pagamento pagto1 = new PagamentoCartao(0 , EstadoPagamento.PAGO, venda1, 6L);
		venda1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoBoleto(0, EstadoPagamento.PENDENTE, venda2, sdf.parse("17/10/2019 10:55:08"), null);
		venda2.setPagamento(pagto2);
		
		cli1.getVendas().addAll(Arrays.asList(venda1));
		cli2.getVendas().addAll(Arrays.asList(venda2));
		
		vendaRepository.saveAll(Arrays.asList(venda1, venda2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	
		Item_Venda item1 = new Item_Venda(p1, venda1, 2, 15000, 0);
		Item_Venda item2 = new Item_Venda(p2, venda1, 2, 5000, 0);
		Item_Venda item3 = new Item_Venda(p2, venda2, 1, 2500, 0);
		
		venda1.getItens().addAll(Arrays.asList(item1, item2));
		venda2.getItens().addAll(Arrays.asList(item3));
		
		p1.getItens_venda().addAll(Arrays.asList(item1));
		p2.getItens_venda().addAll(Arrays.asList(item2, item3));
		
		item_vendaRepository.saveAll(Arrays.asList(item1, item2, item3));
	}

}
