package poofinal;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente 
{
    // para gerar codigo sequencial
	private static int codigoAtual = 0;
	
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private double limite;
	private double saldo;

    //referencia a pedidos
    private ArrayList<Pedido> pedidos = new ArrayList();
    
    //construtor
    public Cliente(String nome, String endereco){
        this.codigo = ++codigoAtual;
        this.nome = nome;
		this.endereco = endereco;
		this.telefone = "(vazio)";
		this.limite = 100000.0;  // limite padrao
		this.saldo = this.limite;
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
	
	public double getSaldo() {
		return saldo;
	}

	public void restaurarSaldo(double quantidade) {
		saldo += quantidade;
		if (saldo > limite)
			saldo = limite;
	}
	
	public boolean usarSaldo(double quantidade) {
		if (saldo >= quantidade)
		{
			saldo -= quantidade;
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Pedido> getPedidos()
	{
		return pedidos;
	}
	
	public boolean addPedido(Pedido pedido)
	{
		return pedidos.add(pedido);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 47 * hash + Objects.hashCode(this.nome);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Cliente other = (Cliente) obj;
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente #" + codigo + " >> " + nome + ", Limite: " + limite + ", Saldo: " + saldo;
	}
	
	
}
