package poofinal;

public class ProdutoExportacao extends Produto 
{	
    private String destino;
    
    //construtor
    public ProdutoExportacao(String nome, Categoria categoria, double preco, double imposto, String destino){
        super(nome, categoria, preco, imposto);
		if (destino != null)
			this.destino = destino;
		else
			this.destino = "(destino indefinido)";
    }
    
    //getters and setters
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + ", tipo: Exportacao, destino: " + destino;
	}
}
