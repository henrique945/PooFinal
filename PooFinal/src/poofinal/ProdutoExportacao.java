package poofinal;

public class ProdutoExportacao extends Produto {
    private String destino;
    
    //construtor
    public ProdutoExportacao(String destino, String nome, double preco, int moeda, double imposto){
        super(nome, preco, moeda, imposto);
        this.destino = destino;
    }
    
    //getters and setters
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
    
}
