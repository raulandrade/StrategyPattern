package br.ufpb.dce.strategy;

public class Produto {
 
    private String codigoDeBarra;
    private double valor;
     
    public Produto(String id, double valor){
        this.codigoDeBarra = id;
        this.valor = valor;
    }

	public String getCodigoDeBarra() {
        return this.codigoDeBarra;
    }
	
	public void setCodigoDeBarra (String codigo) {
        this.codigoDeBarra = codigo;
    }
 
    public double getValor() {
        return this.valor;
    }
    
    public double setValor (int valor) {
        return this.valor;
    }
     
}