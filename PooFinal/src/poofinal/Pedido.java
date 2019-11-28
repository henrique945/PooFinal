package poofinal;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private static long auxNum = 0;
    private long numero;
    private Date data;
    //referencia a itens pedidos
    private ArrayList<ItemPedido> listItemPedidos = new ArrayList();
    //referencia a cliente
    private Cliente cliente;
    
    //construtor
    public Pedido(Date data){
        this.numero = ++this.auxNum;
        this.data = data;
    }
    
    
    //getters and setters
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    //metódos
    public double totalPedidos(){
        double total = 0;
        
        for(ItemPedido ip : listItemPedidos){
            total += ip.totalItem();
        }
        
        return total;
    }
    
    public double totalImposto(){
        double total = 0;
        
        for(ItemPedido ip : listItemPedidos){
            total += ip.totalItemImposto();
        }
        
        return total;
    }
    
    
    
}
