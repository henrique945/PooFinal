package poofinal;

public class ItemPedido {
    private static int numCodigo;
    private int codigo;
    private int quantidade;
    //referencia a produto
    private Produto produto;
    
    
    //construtores
    
    
    //getters and setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
