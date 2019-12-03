package poofinal;

public class ProdutoMercadoInterno extends Produto 
{	
    private boolean incentivo;
    
    //construtor
    public ProdutoMercadoInterno(String nome, Categoria categoria, double preco, double imposto, boolean incentivo){
        super(nome, categoria, preco, imposto);
        this.incentivo = incentivo;
    }
    
    //getters and setters
    public boolean hasIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
	
	@Override
	public String toString() {
		String ret = super.toString();
		return ret + ", tipo: Mercado Interno, incentivo: " + (incentivo ? "sim" : "nao");
	}
}
