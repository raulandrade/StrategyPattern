package br.ufpb.dce.strategy;

import java.util.ArrayList;

public class ListaDeCompras {

	GerenciaListaDeCompras gCompras;
     
    public ListaDeCompras(){
    	this.gCompras = new GerenciaListaDeCompras();
    }
    
   public void adicionar(Produto prod){
    	this.gCompras.adicionarProduto(prod);
    }
     
    public void removerProduto(Produto prod){
    	this.gCompras.removerProduto(prod);
    }
     
    // Aqui!
    public double realizarPagamento(Pagamento formaDePagamento, double valor){
    	return this.gCompras.pagamento(formaDePagamento, valor);
    }
    
    public boolean buscaProduto(String codigo){
    	return this.gCompras.buscaCodigo(gCompras.getLista(), codigo);
    	
    }
}
