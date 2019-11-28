package poofinal;

public class ProdutoMercadoInterno extends Produto {
    private boolean incentivo;
    
    //construtor
    public ProdutoMercadoInterno(boolean incentivo, String nome, double preco, int moeda, double imposto){
        super(nome, preco, moeda, imposto);
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
