package poofinal;

import java.util.ArrayList;
import java.util.Scanner;

public class PooFinal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opt = 0, opt2 = 0;
        
        ArrayList <Cliente> listClientes = new ArrayList();
        ArrayList <Produto> listProdutos = new ArrayList();
        ArrayList <Categoria> listCategorias = new ArrayList();
        ArrayList <Pedido> listPedidos = new ArrayList();
        
        do{
            System.out.println("MENU");
            System.out.println("1-Manutenção Cliente");
            System.out.println("2-Manutenção Produto");
            System.out.println("3-Manutenção Categoria");
            System.out.println("4-Criar pedidos para cliente");
            System.out.println("5-Listar pedidos de um cliente");
            System.out.println("6-Dar baixa de um pedido");
            System.out.println("7-Sair");
            
            opt = Integer.parseInt(scan.next());
            
            switch(opt){
                case 1:
                    System.out.println("1-Criar");
                    System.out.println("2-Remover");
                    System.out.println("3-Alterar");
                    System.out.println("4-Pesquisar");
                    System.out.println("5-Listar");
                    
                    opt2 = Integer.parseInt(scan.next());
                    
                    switch(opt2){
                        case 1:
                            
                            break;
                            
                        case 2:
                            
                            break;
                            
                        case 3:
                            
                            break;
                            
                        case 4:
                            
                            break;
                            
                        case 5:
                            
                            break;
                    }
                    
                    break;
                    
                case 2:
                    System.out.println("6-Produto - Criar");
                    System.out.println("7-Produto - Remover");
                    System.out.println("8-Produto - Alterar");
                    System.out.println("9-Produto - Pesquisar");
                    System.out.println("10-Produto - Listar");
                    
                    break;
                    
                case 3:
                    System.out.println("11-Categoria - Criar");
                    System.out.println("12-Categoria - Remover");
                    System.out.println("13-Categoria - Alterar");
                    System.out.println("14-Categoria - Pesquisar");
                    System.out.println("15-Categoria - Listar");
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    
                    break;
                    
                case 6:
                    
                    break;
                    
                case 7:
                    
                    break;
            }
            
        }while(opt != 7);
        
        
        XML x = new XML();
        x.teste();
    }

}
