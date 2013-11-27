package br.com.caelum.palindromo.servico;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
	public void palindromoEstaCorreto() {
		
		Palindromo palindromo = new Palindromo();
		palindromo.ehPalindromo("Socorram-me subi no onibus em Marrocos");

		Assert.assertEquals(true, palindromo.ehPalindromo("Socorram-me subi no onibus em Marrocos"));
	}

}
