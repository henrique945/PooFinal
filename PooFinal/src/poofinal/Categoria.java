package poofinal;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.descricao);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Categoria other = (Categoria) obj;
		if (!Objects.equals(this.descricao, other.descricao)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Categoria: " + descricao;
	}
    
        
}
