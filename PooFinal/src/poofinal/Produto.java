package poofinal;

import java.util.Objects;

public class Produto 
{
	// moedas
	public static final int MOEDA_BRL = 0;
	public static final int MOEDA_USD = 1;
	public static final int MOEDA_EUR = 2;
	
	// impostos
	public static final double IMPOSTO_CATEGORIA_1 = 0.07;
	public static final double IMPOSTO_CATEGORIA_2 = 0.12;
	public static final double IMPOSTO_CATEGORIA_3 = 0.18;
	
    // para gerar codigo sequencial
	private static int codigoAtual = 0;
	
    private int codigo;
    private String nome;
    private double preco;
    private int moeda;
    private double imposto;
    //referencia a categoria
    private Categoria categoria;
    
    //construtor
    public Produto(String nome, Categoria categoria, double preco, double imposto){
        this.codigo = ++codigoAtual;
        this.nome = nome;
        this.preco = preco;
        this.moeda = MOEDA_BRL; // moeda padrao
        this.imposto = imposto;
		this.categoria = categoria;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.nome);
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
		final Produto other = (Produto) obj;
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Produto #" + codigo + " >> " + nome + ", Preco: " + preco + ", Categoria: " + categoria.getDescricao();
	}
	
	
}
