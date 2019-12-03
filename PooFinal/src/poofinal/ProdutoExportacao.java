package poofinal;

public class ProdutoExportacao extends Produto 
{	
    private String destino;
    
    //construtor
    public ProdutoExportacao(String nome, double preco, double imposto, String destino){
        super(nome, preco, imposto);
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
