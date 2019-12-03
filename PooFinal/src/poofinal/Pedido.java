package poofinal;

import java.util.ArrayList;
import java.util.Date;

public class Pedido 
{
	// status de pedido
	public static final int STATUS_ABERTO = 0;
	public static final int STATUS_FINALIZADO = 1;
	public static final int STATUS_CANCELADO = 2;
	
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
		int numItem = itens.size() + 1;
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
}
