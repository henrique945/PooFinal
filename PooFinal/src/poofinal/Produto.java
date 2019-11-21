package poofinal;

public class Produto {
    private static int numCodigo;
    private int codigo;
    private String nome;
    private double preco;
    private int moeda;
    private double impost;
    //referencia a categoria
    private Categoria categoria;
    
    
    //construtor
    
    
    //getters and setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public double getImpost() {
        return impost;
    }

    public void setImpost(double impost) {
        this.impost = impost;
    }
    
    
    
}
