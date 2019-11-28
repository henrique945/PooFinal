package poofinal;

public class Produto {
    private static int numCodigo;
    private int codigo;
    private String nome;
    private double preco;
    private int moeda;
    private double imposto;
    //referencia a categoria
    private Categoria categoria;
    
    
    //construtor
    public Produto(String nome, double preco, int moeda, double imposto){
        this.codigo = ++this.numCodigo;
        this.nome = nome;
        this.preco = preco;
        this.moeda = moeda;
        this.imposto = imposto;
    }
    
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

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    
    
    
}
