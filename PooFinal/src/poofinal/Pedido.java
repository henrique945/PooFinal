package poofinal;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private long numero;
    private Date data;
    //referencia a itens pedidos
    private ArrayList<ItemPedido> listItemPedidos = new ArrayList();
    //referencia a cliente
    private Cliente cliente;
    
    //construtor
    
    
    
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
    
    
    
    
}
