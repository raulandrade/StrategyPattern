package br.ufpb.dce.strategy;

public class PagamentoBoleto implements Pagamento {
	private String codigo;
	
	public PagamentoBoleto (String c){
		this.codigo = c;
	}

	@Override
	public double efetuaPagamento(double valorCompra, double codigoDeBarras) {
		valorCompra = (int)(valorCompra - (valorCompra*0.10));
		return valorCompra;
	}
}
