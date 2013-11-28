package br.com.caelum.bissexto;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void retornaVerdadeiroParaUmAnoBissexto() {
		
		AnoBissexto ab = new AnoBissexto();
		
		assertTrue(ab.ehBissexto(2012));
	}

	@Test
	public void retornaFalsoParaUmAnoMultiploDeCem() {
		
		AnoBissexto ab = new AnoBissexto();
		
		assertFalse(ab.ehBissexto(1900));
	}


	@Test
	public void retornaVerdadeiroParaUmAnoMultiploDeQuatrocentos() {
		
		AnoBissexto ab = new AnoBissexto();
		
		assertTrue(ab.ehBissexto(2000));
	}
}
