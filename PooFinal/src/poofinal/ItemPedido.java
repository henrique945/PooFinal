package poofinal;

public class ItemPedido 
{
    private int numero;
    private int quantidade;
    //referencia a produto
    private Produto produto;
    
    //construtores
    public ItemPedido(int numero, Produto produto, int quantidade){
        this.numero = numero;
		this.produto = produto;
        this.quantidade = quantidade;
    }
    
    //getters and setters
    public int getNumero() {
        return numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    //metódos
    public double totalItem(){
        return quantidade * produto.getPreco();
    }
	
    public double totalItemImposto(){
        return quantidade * produto.getPreco() * produto.getImposto();
    }
}
