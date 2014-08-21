package br.ufpb.dce.strategy;

public class PagamentoCartao implements Pagamento {
 
	private String numero;
	private String proprietario;
    private String vencimento;
     
    public PagamentoCartao(String num, String nomeDoProprietario){
        this.proprietario = num;
        this.numero = nomeDoProprietario;
    }
    
    // Se o vencimento for < 2015, retorna -1
    public double efetuaPagamento(double valor, double vencimento) {
    	if(vencimento >= 15){
	    	valor = (int)(valor - (valor*0.5));
	    	return valor;
    	} else {
    		return -1;
    	}
       	
    }
 
}