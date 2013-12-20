package br.com.saraiva.combinacoes;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import static br.com.saraiva.combinacoes.Combinacao.*;


import org.junit.Test;

public class CombinacaoTest {

	@Test
	public void calculaFatorial() {
		
		assertThat(fat(0), equalTo(  1.0));
		assertThat(fat(1), equalTo(  1.0));
		assertThat(fat(2), equalTo(  2.0));
		assertThat(fat(3), equalTo(  6.0));
		assertThat(fat(4), equalTo( 24.0));
		assertThat(fat(5), equalTo(120.0));
		assertThat(fat(6), equalTo(720.0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExceptionSeNMenorQP() {
		
		combinacao(2, 4);
	}
	
	@Test
	public void calculaCombinacao() {
		
		assertThat(combinacao(1, 1), equalTo( 1.0));
		assertThat(combinacao(4, 2), equalTo( 6.0));
		assertThat(combinacao(5, 2), equalTo(10.0));
	}
	


}
