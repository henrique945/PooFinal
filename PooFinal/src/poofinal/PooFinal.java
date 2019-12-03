package poofinal;

import java.util.ArrayList;
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
    private static ArrayList<Produto> listProdutos = new ArrayList();
    private static ArrayList<Categoria> listCategorias = new ArrayList();
    private static ArrayList<Pedido> listPedidos = new ArrayList();
	
    public static void main(String[] args) 
	{
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
				System.out.println("Nao ha clientes a listar.");
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
	}
	
	public static void removerProduto()
	{
	}
	
	public static void alterarProduto()
	{
	}
	
	public static void listarProduto()
	{
		// opcao para digitar o codigo/nome do produto ou * para listar todos
	}
	
	public static void criarCategoria()
	{
	}
	
	public static void removerCategoria()
	{
	}
	
	public static void alterarCategoria()
	{
	}
	
	public static void listarCategoria()
	{
		// opcao para digitar o codigo/nome da categoria ou * para listar todas
	}
	
	public static void criarPedido()
	{
	}
	
	public static void listarPedidos()
	{
		// opcao para digitar o codigo do pedido ou * para listar todos
	}
	
	public static void baixarPedido()
	{
	}
	
	
	public static void encerrar() 
	{ 
		System.out.println(">> Obrigado por utilizar nosso programa!");
		continuarExecucao = false;
	}
}
