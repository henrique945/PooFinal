/*
Facens - Faculdade de Engenharia de Sorocaba
Disciplina: Programação Orientada a Objetos I
Assunto: Trabalho Final POO

Alunos:
- Henrique Rodrigues Silva - 190898
- Rodolfo Ribeiro Antunes Filho - 120090
*/

package poofinal;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

// interface e classe auxiliares para criacao do menu
interface Callable {void call();}
class OpcaoMenu
{
	public Callable metodo;
	public String descricao;
	public OpcaoMenu(Callable metodo, String descricao) {
		this.metodo = metodo;
		this.descricao = descricao;
	}
}

// classe principal
public class PooFinal 
{
	// controle do menu
	private static TreeMap<Integer, OpcaoMenu> menu = new TreeMap();	
	private static boolean continuarExecucao = true;
	
	// scanner para uso geral
	static Scanner scan = new Scanner(System.in);
	
	// dados do programa
	private static TreeMap<String, Cliente> mapClientes = new TreeMap();
    private static TreeMap<String, Produto> mapProdutos = new TreeMap();
    private static TreeMap<String, Categoria> mapCategorias = new TreeMap();
    private static TreeMap<String, Pedido> mapPedidos = new TreeMap();
	
	
	
    public static void main(String[] args) 
	{
		// dados iniciais
		cadastrarDadosIniciais();
		
		// criacao do menu
		Integer contagem = 1;
		menu.put(contagem++, new OpcaoMenu(PooFinal::criarCliente, "Cadastrar Cliente"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::removerCliente, "Remover Cliente"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::alterarCliente, "Alterar Cliente"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::listarCliente, "Listar Cliente"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::criarProduto, "Cadastrar Produto"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::removerProduto, "Remover Produto"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::alterarProduto, "Alterar Produto"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::listarProduto, "Listar Produto"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::criarCategoria, "Cadastrar Categoria"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::removerCategoria, "Remover Categoria"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::alterarCategoria, "Alterar Categoria"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::listarCategoria, "Listar Categoria"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::criarPedido, "Criar Pedido"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::listarPedidos, "Listar Pedidos"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::listarPedidoPorCliente, "Listar Pedido por Cliente"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::baixarPedido, "Baixar Pedido"));
		menu.put(contagem++, new OpcaoMenu(PooFinal::encerrar, "Encerrar"));
		
		String strMenu = "";
		for (Map.Entry<Integer, OpcaoMenu> opcao : menu.entrySet())
				strMenu += opcao.getKey() + " - " + opcao.getValue().descricao + "\n";
		
		// loop de execucao principal
		while (continuarExecucao)
		{
			System.out.println("\n*** Menu ***");
			System.out.println(strMenu);
			System.out.print("Opcao: ");
			
			try
			{
				Integer input = Integer.parseInt(scan.nextLine());
				OpcaoMenu opcao = menu.get(input);
				
				if (opcao != null)
				{
					System.out.println("*** " + opcao.descricao + " ***");
					opcao.metodo.call();
				}
					
				else
					System.out.println(">> Opcao invalida.");
			}
			catch (Exception e)
			{
				System.out.println(">> Opcao invalida.");
			}			
		}
    }
	
	public static void cadastrarDadosIniciais()
	{
		Cliente c;
		c = new Cliente("Jose Silva", "Rua do Jose Silva, 123");
		mapClientes.put(c.getNome(), c);
		c = new Cliente("Joao Rosa", "Rua Pedrosa, 999");
		mapClientes.put(c.getNome(), c);
		c = new Cliente("Maria Santos", "Avenida da Salvacao, 666");
		mapClientes.put(c.getNome(), c);
		c = new Cliente("Paulo Castro", "Rua Itavuvu, 5600");
		mapClientes.put(c.getNome(), c);
		
		Categoria cat;
		cat = new Categoria("Eletronicos");
		mapCategorias.put(cat.getDescricao(), cat);
		cat = new Categoria("Moveis");
		mapCategorias.put(cat.getDescricao(), cat);
		cat = new Categoria("Eletrodomesticos");
		mapCategorias.put(cat.getDescricao(), cat);
		cat = new Categoria("Alimenticios");
		mapCategorias.put(cat.getDescricao(), cat);
		
		Produto p;
		p = new ProdutoMercadoInterno("Geladeira", mapCategorias.get("Eletrodomesticos"), 2000.0, Produto.IMPOSTO_CATEGORIA_1, false);
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoMercadoInterno("Fogao", mapCategorias.get("Eletrodomesticos"), 1000.0, Produto.IMPOSTO_CATEGORIA_1, false);
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoMercadoInterno("Cafeteira", mapCategorias.get("Eletrodomesticos"), 500.0, Produto.IMPOSTO_CATEGORIA_2, false);
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoMercadoInterno("Achocolatado", mapCategorias.get("Alimenticios"), 15.0, Produto.IMPOSTO_CATEGORIA_3, false);
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoExportacao("Televisor", mapCategorias.get("Eletronicos"), 2000.0, Produto.IMPOSTO_CATEGORIA_2, "Canada");
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoExportacao("Notebook", mapCategorias.get("Eletronicos"), 1000.0, Produto.IMPOSTO_CATEGORIA_2, "Canada");
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoExportacao("Soja", mapCategorias.get("Alimenticios"), 500.0, Produto.IMPOSTO_CATEGORIA_2, "Canada");
		mapProdutos.put(p.getNome(), p);
		p = new ProdutoExportacao("Carne", mapCategorias.get("Alimenticios"), 55.0, Produto.IMPOSTO_CATEGORIA_2, "Franca");
		mapProdutos.put(p.getNome(), p);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date data = null;
		Long numero;
		Cliente cli = null;
		
		Pedido ped = null;
		try	{ data = dateFormat.parse("12/12/2019"); }catch (Exception e) {}
		ped = new Pedido(data);
		cli = mapClientes.get("Jose Silva");
		ped.setCliente(cli);
		ped.addItem(mapProdutos.get("Televisor"), 4);
		ped.addItem(mapProdutos.get("Carne"), 40);
		ped.addItem(mapProdutos.get("Fogao"), 1);
		numero = ped.getNumero();
		mapPedidos.put(numero.toString(), ped);
		cli.addPedido(ped);
		cli.usarSaldo(ped.totalPedido());
		
		try	{ data = dateFormat.parse("12/09/2019"); }catch (Exception e) {}
		ped = new Pedido(data);
		cli = mapClientes.get("Maria Santos");
		ped.setCliente(cli);
		ped.addItem(mapProdutos.get("Soja"), 100);
		ped.addItem(mapProdutos.get("Geladeira"), 2);
		ped.addItem(mapProdutos.get("Fogao"), 2);
		numero = ped.getNumero();
		mapPedidos.put(numero.toString(), ped);
		cli.addPedido(ped);
		cli.usarSaldo(ped.totalPedido());
	}
	
	// metodos que implementam as funcionalidades do programa
	public static void criarCliente() 
	{
		System.out.print(">> Digite o nome do cliente: ");
		String nome = scan.nextLine();
		
		if (mapClientes.containsKey(nome))
		{
			System.out.println(">> Ja existe um cliente com esse nome.");
			return;
		}
		
		System.out.print(">> Digite o endereco do cliente: ");
		String endereco = scan.nextLine();
		
		Cliente cliente = new Cliente(nome, endereco);
		mapClientes.put(nome, cliente);
		System.out.println(">> Cliente cadastrado com sucesso.");
	}
	
	public static void removerCliente()
	{
		System.out.print(">> Digite o nome do cliente a ser removido: ");
		String nome = scan.nextLine();
		
		Cliente cliente = mapClientes.get(nome);
		
		if (cliente == null)
		{
			System.out.println(">> Nao existe um cliente com esse nome.");
			return;
		}
		
		if (cliente.getPedidos().size() > 0)
		{
			System.out.println(">> Este cliente possui pedidos. Exclua os pedidos primeiro.");
			return;
		}
		
		mapClientes.remove(nome);
		System.out.println(">> Cliente removido com sucesso.");
	}
	
	public static void alterarCliente()
	{
		System.out.print(">> Digite o nome do cliente a ser alterado: ");
		String nome = scan.nextLine();
		
		Cliente cliente = mapClientes.get(nome);
		
		if (cliente == null)
		{
			System.out.println(">> Nao existe um cliente com esse nome.");
			return;
		}
		
		System.out.print(">> Digite o novo nome do cliente: ");
		String novoNome = scan.nextLine();
		
		cliente.setNome(novoNome);
		mapClientes.remove(nome);
		mapClientes.put(novoNome, cliente); // troca a chave do cliente
		System.out.println(">> Cliente alterado com sucesso.");
	}
	
	public static void listarCliente()
	{
		System.out.print(">> Digite o nome do cliente a listar ou '*' para listar todos: ");
		String nome = scan.nextLine();
		
		if (nome.compareTo("*") == 0)
		{
			// lista todos os clientes
			if (mapClientes.size() > 0)
			{
				for (Map.Entry<String, Cliente> entry : mapClientes.entrySet())
					System.out.println(entry.getValue());
			}
			else
			{
				System.out.println(">> Nao ha clientes a listar.");
			}
		}
		else
		{
			Cliente cliente = mapClientes.get(nome);
		
			if (cliente != null)
			{
				System.out.println(cliente);
			}
			else
			{
				System.out.println(">> Nao existe um cliente com esse nome.");
			}
		}
	}
	
	public static void criarProduto()
	{
		System.out.print(">> Digite o nome do produto: ");
		String nome = scan.nextLine();
		
		if (mapProdutos.containsKey(nome))
		{
			System.out.println(">> Ja existe um produto com esse nome.");
			return;
		}
		
		System.out.print(">> Digite o preco do produto: ");
		double preco = 0.0;
		try
		{
			preco = Double.parseDouble(scan.nextLine());
		}
		catch (Exception e)
		{
			System.out.println(">> Valor invalido.");
			return;
		}
		
		System.out.print(">> Digite o nome da categoria do produto: ");
		String nomeCategoria = scan.nextLine();
		Categoria categoria = mapCategorias.get(nomeCategoria);
		if (categoria == null)
		{
			System.out.println(">> Nao existe uma categoria com esse nome.");
			return;
		}
		
		System.out.print(">> Digite a categoria do imposto (1 = 7.5% / 2 = 12% / 3 = 18%): ");
		String categoriaImposto = scan.nextLine();
		double imposto;
		if (categoriaImposto.compareTo("1") == 0)
		{
			imposto = Produto.IMPOSTO_CATEGORIA_1;
		}
		else if (categoriaImposto.compareTo("2") == 0)
		{				
			imposto = Produto.IMPOSTO_CATEGORIA_2;
		}
		else if (categoriaImposto.compareTo("3") == 0)
		{
			imposto = Produto.IMPOSTO_CATEGORIA_3;
		}
		else
		{
			System.out.println(">> Valor invalido.");
			return;
		}
		
		
		System.out.print(">> Digite o tipo de produto (1 - mercado interno / 2 - exportacao): ");
		String tipo = scan.nextLine();
		Produto produto = null;
		
		if (tipo.compareTo("1") == 0)
		{
			produto = new ProdutoMercadoInterno(nome, categoria, preco, imposto, false);
		}
		else if (tipo.compareTo("2") == 0)
		{
			produto = new ProdutoExportacao(nome, categoria, preco, imposto, null);
		}
		else
		{
			System.out.println(">> Tipo de produto invalido.");
			return;
		}
		
		mapProdutos.put(nome, produto);
		System.out.println(">> Produto cadastrado com sucesso.");
	}
	
	public static void removerProduto()
	{
		System.out.print(">> Digite o nome do produto a ser removido: ");
		String nome = scan.nextLine();
		
		Produto produto = mapProdutos.get(nome);
		
		if (produto == null)
		{
			System.out.println(">> Nao existe um produto com esse nome.");
			return;
		}
		
		for (Map.Entry<String, Pedido> entry : mapPedidos.entrySet())
		{
			if (entry.getValue().temProduto(produto))
			{
				System.out.println(">> Existem pedidos com esse produto. Exclua os pedidos primeiro.");
				return;
			}
		}					
		
		mapProdutos.remove(nome);
		System.out.println(">> Produto removido com sucesso.");
	}
	
	public static void alterarProduto()
	{
		System.out.print(">> Digite o nome do produto a ser alterado: ");
		String nome = scan.nextLine();
		
		Produto produto = mapProdutos.get(nome);
		
		if (produto == null)
		{
			System.out.println(">> Nao existe um produto com esse nome.");
			return;
		}
		
		System.out.print(">> Digite o novo preco do produto: ");
		double preco = 0.0;
		try
		{
			preco = Double.parseDouble(scan.nextLine());
		}
		catch (Exception e)
		{
			System.out.println(">> Valor invalido.");
			return;
		}
		
		produto.setPreco(preco);
		System.out.println(">> Produto alterado com sucesso.");
	}
	
	public static void listarProduto()
	{
		System.out.print(">> Digite o nome do produto ou '*' para listar todos: ");
		String input = scan.nextLine();
		
		if (input.compareTo("*") == 0)
		{
			// lista todos os produtos
			if (mapProdutos.size() > 0)
			{
				for (Map.Entry<String, Produto> entry : mapProdutos.entrySet())
					System.out.println(entry.getValue());
			}
			else
			{
				System.out.println(">> Nao ha produtos a listar.");
			}
		}
		else
		{			
			// procura por nome
			for (Map.Entry<String, Produto> entry : mapProdutos.entrySet())
			{
				if (entry.getValue().getNome().compareTo(input) == 0)
				{
					System.out.println(entry.getValue());
					return;
				}
			}
			
			// nao encontrou nada
			System.out.println(">> Nao existe um produto com esse codigo/nome.");
		}
	}
	
	public static void criarCategoria()
	{
		System.out.print(">> Digite o nome da categoria: ");
		String nome = scan.nextLine();
		
		if (mapCategorias.containsKey(nome))
		{
			System.out.println(">> Ja existe uma categoria com esse nome.");
			return;
		}
		
		Categoria categoria = new Categoria(nome);
		mapCategorias.put(nome, categoria);
		System.out.println(">> Categoria cadastrada com sucesso.");
	}
	
	public static void removerCategoria()
	{
		System.out.print(">> Digite o nome da categoria a ser removida: ");
		String nome = scan.nextLine();
		
		Categoria categoria = mapCategorias.get(nome);
		
		if (categoria == null)
		{
			System.out.println(">> Nao existe uma categoria com esse nome.");
			return;
		}
		
		for (Map.Entry<String, Produto> entry : mapProdutos.entrySet())
		{
			if (entry.getValue().getCategoria().equals(categoria))
			{
				System.out.println(">> Existem produtos com essa categoria. Exclua os produtos primeiro.");
				return;
			}
		}					
		
		mapCategorias.remove(nome);
		System.out.println(">> Categoria removida com sucesso.");
	}
	
	public static void alterarCategoria()
	{
		System.out.print(">> Digite o nome da categoria a ser alterada: ");
		String nome = scan.nextLine();
		
		Categoria categoria = mapCategorias.get(nome);
		
		if (categoria == null)
		{
			System.out.println(">> Nao existe uma categoria com esse nome.");
			return;
		}
		
		System.out.print(">> Digite o novo nome da categoria: ");
		String novoNome = scan.nextLine();
		
		categoria.setDescricao(novoNome);
		mapCategorias.remove(nome);
		mapCategorias.put(novoNome, categoria); // troca a chave da categoria
		System.out.println(">> Categoria alterada com sucesso.");
	}
	
	public static void listarCategoria()
	{
		// lista todas as categorias
		for (Map.Entry<String, Categoria> entry : mapCategorias.entrySet())
			System.out.println(entry.getValue());
	}
	
	public static void criarPedido()
	{
		// data
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print(">> Digite a data do pedido (dd/mm/aaaa): ");
		String strData = scan.nextLine();
		Date data;
		try
		{
			data = dateFormat.parse(strData);
		}
		catch (Exception e)
		{
			System.out.println(">> Data invalida.");
			return;
		}
		
		// cliente
		System.out.print(">> Digite o nome do cliente: ");
		String nomeCliente = scan.nextLine();
		
		Cliente cliente = mapClientes.get(nomeCliente);
		
		if (cliente == null)
		{
			System.out.println(">> Nao existe um cliente com esse nome.");
			return;
		}
		
		// cria o pedido
		Pedido pedido = new Pedido(data);
		pedido.setCliente(cliente);
		
		// adiciona itens
		System.out.println("*** Itens ***");
		while (true)
		{
			System.out.print(">> Digite o nome do produto ou '*' para terminar: ");
			String nomeProduto = scan.nextLine();

			if (nomeProduto.compareTo("*") == 0)
				break; // sai do while, acabou a entrada de produtos
				
			Produto produto = mapProdutos.get(nomeProduto);

			if (produto == null)
			{
				System.out.println(">> Nao existe um produto com esse nome.");
				continue; // tenta novamente
			}

			System.out.print(">> Digite a quantidade: ");
			int quantidade = 0;
			try
			{
				quantidade = Integer.parseInt(scan.nextLine());
				if (quantidade <= 0)
				{
					System.out.println(">> Quantidade invalida.");
					continue; // tenta de novo, volta para o nome
				}
			}
			catch (Exception e)
			{
				System.out.println(">> Quantidade invalida.");
				continue; // tenta de novo, volta para o nome
			}
			
			// chegou aqui, adiciona item ao pedido
			pedido.addItem(produto, quantidade);
		}
		
		// tudo certo ate aqui, checa se cliente tem saldo para realizar pedido
		if (!cliente.usarSaldo(pedido.totalPedido()))
		{
			System.out.println(">> Cliente nao tem saldo para realizar este pedido.");
			return;
		}
		
		// adiciona pedido no cliente e no mapa
		cliente.addPedido(pedido);
		Long numero = pedido.getNumero();
		mapPedidos.put(numero.toString(), pedido);
		System.out.println(">> Pedido " + pedido.getNumero() + " criado com sucesso.");
	}
	
	public static void listarPedidoPorCliente()
	{
		System.out.print(">> Digite o nome do cliente para listar pedidos: ");
		String nome = scan.nextLine();
		
		Cliente cliente = mapClientes.get(nome);

		if (cliente != null)
		{
			boolean achouAlgum = false;
			for (Pedido p : mapPedidos.values())
			{
				if (cliente == p.getCliente())
				{
					p.listarPedidoCompleto();
					achouAlgum = true;
				}
			}
			
			if (!achouAlgum)
				System.out.println("Nao ha pedidos para esse cliente.");
		}
		else
		{
			System.out.println(">> Nao existe um cliente com esse nome.");
		}
	}
	
	public static void listarPedidos()
	{
		System.out.print(">> Digite o codigo do pedido ou '*' para listar todos: ");
		String input = scan.nextLine();
		
		if (input.compareTo("*") == 0)
		{
			// lista todos os pedidos
			if (mapPedidos.size() > 0)
			{
				for (Map.Entry<String, Pedido> entry : mapPedidos.entrySet())
					entry.getValue().listarPedidoCompleto();
			}
			else
			{
				System.out.println(">> Nao ha pedidos a listar.");
			}
		}
		else
		{
			Pedido pedido = mapPedidos.get(input);
		
			if (pedido != null)
			{
				pedido.listarPedidoCompleto();
				System.out.println(">> Pedido baixado com sucesso.");
			}
			else
			{
				System.out.println(">> Nao existe um pedido com esse codigo.");
			}			
		}
	}
	
	public static void baixarPedido()
	{
		System.out.print(">> Digite o codigo do pedido para baixar: ");
		String input = scan.nextLine();
		
		Pedido pedido = mapPedidos.get(input);
		
		if (pedido != null)
		{
			pedido.setStatus(Pedido.STATUS_FINALIZADO);
			pedido.getCliente().restaurarSaldo(pedido.totalPedido());
			System.out.println(">> Pedido baixado com sucesso.");
		}
		else
		{
			System.out.println(">> Nao existe um pedido com esse codigo.");
		}	
	}
	
	
	public static void encerrar() 
	{ 
		System.out.println(">> Obrigado por utilizar nosso programa!");
		continuarExecucao = false;
	}
}
