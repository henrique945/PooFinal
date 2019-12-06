package poofinal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pedido 
{
	// status de pedido
	public static final int STATUS_ABERTO = 0;
	public static final int STATUS_FINALIZADO = 1;
	
	// para gerar codigo sequencial
    private static long numeroAtual = 0;
	
    private long numero;
    private Date data;
	private int status;
    //referencia a itens pedidos
    private ArrayList<ItemPedido> itens = new ArrayList();
    //referencia a cliente
    private Cliente cliente;
    
    //construtor
    public Pedido(Date data){
        this.numero = ++numeroAtual;
        this.data = data;
		this.status = STATUS_ABERTO; // status inicial
    }
    
    //getters and setters
    public long getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
	
	public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    //metódos
    public double totalPedido(){
        double total = 0.0;
        
        for(ItemPedido ip : itens){
            total += ip.totalItem();
        }
        
        return total;
    }
    
    public double totalImposto(){
        double total = 0.0;
        
        for(ItemPedido ip : itens){
            total += ip.totalItemImposto();
        }
        
        return total;
    }
    
	public boolean addItem(Produto produto, int quantidade)
	{
		int numItem;
		if (itens.size() == 0)
		{
			numItem = 1;
		}
		else 
		{
			// pega o ultimo elemento da lista e soma 1
			numItem = itens.get(itens.size() - 1).getNumero();
			++numItem;
		}
		return itens.add(new ItemPedido(numItem, produto, quantidade));
	}
	
	public boolean removeItem(int numItem)
	{
		for (ItemPedido ip : itens)
		{
			if (ip.getNumero() == numItem)
				return itens.remove(ip);
		}
		
		return false;
	}
	
	public boolean temProduto(Produto produto)
	{
		for (ItemPedido ip : itens)
		{
			if (ip.getProduto().equals(produto))
				return true;
		}
		
		return false;
	}
	
	public void listarPedidoCompleto()
	{
		System.out.println(this);
		System.out.println("Itens:");
		for (ItemPedido ip : itens)
			System.out.println(ip);
		System.out.print("\n");
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + (int) (this.numero ^ (this.numero >>> 32));
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
		final Pedido other = (Pedido) obj;
		if (this.numero != other.numero) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		return "Pedido #" + numero + " Data: " + dateFormat.format(data) + " Status: " 
				+ (status == Pedido.STATUS_ABERTO ? "aberto" : "finalizado") 
				+ "\nCliente: " + cliente.getNome() 
				+ "\nValor total: " + totalPedido() + ", Total de impostos: " + totalImposto();
	}
	
	
}
