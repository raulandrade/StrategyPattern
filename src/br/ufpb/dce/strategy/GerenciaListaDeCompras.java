package br.ufpb.dce.strategy;

import java.util.*;

public class GerenciaListaDeCompras {

	private ArrayList<Produto> listaDeProdutos;
	
	public GerenciaListaDeCompras (){
		this.listaDeProdutos = new ArrayList<Produto>();
	}

	public void adicionarProduto(Produto p){
		if(buscaCodigo(listaDeProdutos, p.getCodigoDeBarra()) == true){
			System.out.println("O produto já foi adicionado anteriormente");
		}else{
	        this.listaDeProdutos.add(p);
		}
	}
	
	public void removerProduto(Produto p){
		for(int i = 0; i < this.listaDeProdutos.size(); i++){
			if(p.getCodigoDeBarra() == listaDeProdutos.get(i).getCodigoDeBarra()){
				this.listaDeProdutos.remove(listaDeProdutos.get(i));
			}
		}
	}
	
	public double somaValorDosProdutos(){
		double soma = 0;
		for(Produto p : listaDeProdutos){
			soma += p.getValor();
		}
		return soma;
	}
	
	public double pagamento(Pagamento formaDePagamento, double dinheiro){		
		double valorDaCompra = somaValorDosProdutos();
	    return formaDePagamento.efetuaPagamento(valorDaCompra, dinheiro);
	    }
	
	public boolean buscaCodigo(List<Produto> lp, String c) {  
	    for(Produto p : lp)  
	        if(p.getCodigoDeBarra().equals(c))  
	            return true;  
	    return false;  
	}  
	
	public ArrayList<Produto> getLista(){
		return this.listaDeProdutos;
	}
}

