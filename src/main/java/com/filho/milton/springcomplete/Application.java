package com.filho.milton.springcomplete;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.filho.milton.springcomplete.domain.Categoria;
import com.filho.milton.springcomplete.domain.Cidade;
import com.filho.milton.springcomplete.domain.Cliente;
import com.filho.milton.springcomplete.domain.Endereco;
import com.filho.milton.springcomplete.domain.Estado;
import com.filho.milton.springcomplete.domain.ItemPedido;
import com.filho.milton.springcomplete.domain.Pagamento;
import com.filho.milton.springcomplete.domain.PagamentoComBoleto;
import com.filho.milton.springcomplete.domain.PagamentoComCartao;
import com.filho.milton.springcomplete.domain.Pedido;
import com.filho.milton.springcomplete.domain.Produto;
import com.filho.milton.springcomplete.domain.enums.EstadoPagamento;
import com.filho.milton.springcomplete.domain.enums.TipoCliente;
import com.filho.milton.springcomplete.repositories.CategoriaRepository;
import com.filho.milton.springcomplete.repositories.CidadeRepository;
import com.filho.milton.springcomplete.repositories.ClienteRepository;
import com.filho.milton.springcomplete.repositories.EnderecoRepository;
import com.filho.milton.springcomplete.repositories.EstadoRepository;
import com.filho.milton.springcomplete.repositories.ItemPedidoRepository;
import com.filho.milton.springcomplete.repositories.PagamentoRepository;
import com.filho.milton.springcomplete.repositories.PedidoRepository;
import com.filho.milton.springcomplete.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll(Arrays.asList("123456789", "987654321"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "apto 303", "Jardim", "88845000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "105", "Sala 808", "Centro", "88840000", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("10/12/2020 10:32"),cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("15/12/1989 20:30"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("12/12/2020 21:30"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1,  p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
