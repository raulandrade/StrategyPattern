package br.ufpb.dce.strategy;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaDeComprasTeste {

	private ListaDeCompras lista = new ListaDeCompras();

	@Before
	public void adicionaProdutosNaLista() {
		
		Produto p1 = new Produto("00001", 4.5);
		Produto p2 = new Produto("00002",2.0);
		Produto p3 = new Produto("00003", 3);
		Produto p4 = new Produto("00004", 10);
        
		lista.adicionar(p1);
        lista.adicionar(p2);
        lista.adicionar(p3);
        lista.adicionar(p4);
	}

	@Test
	public void Teste() {
                
		assertEquals(lista.buscaProduto("00001"), true);
		assertEquals(lista.buscaProduto("00002"), true);
		assertEquals(lista.buscaProduto("00003"), true);
		assertEquals(lista.buscaProduto("00004"), true);
		assertEquals(lista.buscaProduto("23253"), false);
		assertEquals(lista.buscaProduto("23234"), false);
		assertEquals(lista.buscaProduto("56878"), false);
		
		assertEquals((int) lista.realizarPagamento(new PagamentoDinheiro("João"), 30), 16);
		assertNotEquals((int) lista.realizarPagamento(new PagamentoDinheiro("João"), 30), 30);

		
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 14), -1);
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 15), 9);
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 13), -1);
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 18), 9);
		
		lista.removerProduto(new Produto("00001", 4.50));
		lista.removerProduto(new Produto("00003", 3));
		assertEquals(lista.buscaProduto("00001"), false);
		assertEquals(lista.buscaProduto("00003"), false);
		assertEquals(lista.buscaProduto("00002"), true);
		assertEquals(lista.buscaProduto("00004"), true);
		
		assertEquals((int) lista.realizarPagamento(new PagamentoDinheiro("João"), 30), 10);
		assertNotEquals((int) lista.realizarPagamento(new PagamentoDinheiro("João"), 30), 30);
		
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 14), -1);
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 15), 6);
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 13), -1);
		assertEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 18), 6);
		assertNotEquals((int) lista.realizarPagamento(new PagamentoCartao("09384", "João"), 18), 3);
		
		lista.adicionar(new Produto("00005", 12.5));
		lista.adicionar(new Produto("00006", 5));
		
		lista.removerProduto(new Produto("00004", 4.50));
		
		assertEquals(lista.buscaProduto("00001"), false);
		assertEquals(lista.buscaProduto("00002"), true);
		assertEquals(lista.buscaProduto("00003"), false);
		assertEquals(lista.buscaProduto("00004"), false);
		assertEquals(lista.buscaProduto("00005"), true);
		assertEquals(lista.buscaProduto("00006"), true);
		
		assertEquals((int) lista.realizarPagamento(new PagamentoBoleto("734097406"), 19.5), 17);
		assertNotEquals((int) lista.realizarPagamento(new PagamentoBoleto("734097406"), 19.5), 19.5);

	}
}
