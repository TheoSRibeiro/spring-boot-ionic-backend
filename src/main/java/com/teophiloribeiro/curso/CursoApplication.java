package com.teophiloribeiro.curso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teophiloribeiro.curso.domain.Categoria;
import com.teophiloribeiro.curso.domain.Cidade;
import com.teophiloribeiro.curso.domain.Cliente;
import com.teophiloribeiro.curso.domain.Endereco;
import com.teophiloribeiro.curso.domain.Estado;
import com.teophiloribeiro.curso.domain.ItemPedido;
import com.teophiloribeiro.curso.domain.Pagamento;
import com.teophiloribeiro.curso.domain.PagamentoComBoleto;
import com.teophiloribeiro.curso.domain.PagamentoComCartão;
import com.teophiloribeiro.curso.domain.Pedido;
import com.teophiloribeiro.curso.domain.Produto;
import com.teophiloribeiro.curso.domain.enums.EstadoPagamento;
import com.teophiloribeiro.curso.domain.enums.TipoCliente;
import com.teophiloribeiro.curso.repositories.CategoriaRepository;
import com.teophiloribeiro.curso.repositories.CidadeRepository;
import com.teophiloribeiro.curso.repositories.ClienteRepository;
import com.teophiloribeiro.curso.repositories.EnderecoRepository;
import com.teophiloribeiro.curso.repositories.EstadoRepository;
import com.teophiloribeiro.curso.repositories.ItemPedidoRepository;
import com.teophiloribeiro.curso.repositories.PagamentoRepository;
import com.teophiloribeiro.curso.repositories.PedidoRepository;
import com.teophiloribeiro.curso.repositories.ProdutoRepository;

//INSTANCIAR O BD ASSIM QUE A APLICAÇÃO INICIAR

@SpringBootApplication
public class CursoApplication implements CommandLineRunner{
	
	//-----REPOSITORIES------   -> salvar no BD
	
	//CATEGORIA E PRODUTO
	@Autowired // instanciado automaticamente
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//CIDADE E ESTADO
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	//CLIENTE E ENDERECO
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//PEDIDO E PAGAMENTO
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	//ITEMPEDIDO
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	//-----REPOSITORIES------
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}
	
	//Metodo para instanciar o BD com as categorias e produtos
	@Override
	public void run(String... args) throws Exception {
		
		//CATEGORIA E PRODUTO
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//ESTADO E CIDADE
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//CLIENTE E ENDERECO
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		//PEDIDO E PAGAMENTO
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartão(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		//ITEMPEDIDO
		ItemPedido ip1 = new ItemPedido(ped1, p1, 200.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		p1.getItens().addAll(Arrays.asList(ip1));
		p3.getItens().addAll(Arrays.asList(ip2));
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		ped2.getItens().addAll(Arrays.asList(ip3));
		p2.getItens().addAll(Arrays.asList(ip3));
		
		
		
		//Repository categoria
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2, cat3, cat4, cat5, cat6, cat7));
		
		//Criar repositorio dos produtos (produtoRepository) e salvar os produtos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//Repository das cidades e estados
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Cliente e Endereco
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		//Pedido e Pagamento
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		//ItemPedido
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		
		
	}
	

}
