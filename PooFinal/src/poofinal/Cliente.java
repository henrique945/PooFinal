package poofinal;

import java.util.ArrayList;

public class Cliente 
{
    // para gerar codigo sequencial
	private static int codigoAtual = 0;
	
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private double limite;
    //referencia a pedidos
    private ArrayList<Pedido> pedidos = new ArrayList();
    
    //construtor
    public Cliente(String nome, String endereco){
        this.codigo = ++codigoAtual;
        this.nome = nome;
		this.endereco = endereco;
		this.telefone = "(vazio)";
		this.limite = 1000.0;  // limite padrao
    }
    
    //getters and setters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
	
	public ArrayList<Pedido> getPedidos()
	{
		return pedidos;
	}
	
	public boolean addPedido(Pedido pedido)
	{
		return pedidos.add(pedido);
	}
}
