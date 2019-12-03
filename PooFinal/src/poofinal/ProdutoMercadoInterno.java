package poofinal;

public class ProdutoMercadoInterno extends Produto 
{	
    private boolean incentivo;
    
    //construtor
    public ProdutoMercadoInterno(String nome, double preco, double imposto, boolean incentivo){
        super(nome, preco, imposto);
        this.incentivo = incentivo;
    }
    
    //getters and setters
    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
}
