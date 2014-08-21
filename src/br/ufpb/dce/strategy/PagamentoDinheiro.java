package br.ufpb.dce.strategy;

public class PagamentoDinheiro implements Pagamento {
 
	private String comprador;
    
     
    public PagamentoDinheiro(String nomeDoComprador){
        this.comprador = nomeDoComprador;       
    }
     
    public double efetuaPagamento(double valorDaCompra, double dinheiro) {
    	valorDaCompra = (int)(valorDaCompra - (valorDaCompra*0.15));
    	if(valorDaCompra > dinheiro){
    		return -1;
    	}else {
    		return valorDaCompra;
       	}
    	
    }


 
}
