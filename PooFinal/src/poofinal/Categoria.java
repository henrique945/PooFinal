package poofinal;

public class Categoria {
    private String descricao;
    
    //construtores
	public Categoria()
	{
		this.descricao = "Sem descricao";
	}
	
    public Categoria(String descricao){
        this.descricao = descricao;
    }
    
    //getters and setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
