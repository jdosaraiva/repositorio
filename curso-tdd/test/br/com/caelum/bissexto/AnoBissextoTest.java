package br.com.caelum.bissexto;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class AnoBissextoTest {
	
	private static AnoBissexto ab;
	
	@BeforeClass
	public static void init() {
		ab = new AnoBissexto();
	}
	
	@Test
	public void retornaVerdadeiroParaUmAnoBissexto() {
		
		assertTrue(ab.ehBissexto(2012));
	}

	@Test
	public void retornaFalsoParaUmAnoMultiploDeCem() {
		
		assertFalse(ab.ehBissexto(1900));
	}


	@Test
	public void retornaVerdadeiroParaUmAnoMultiploDeQuatrocentos() {
		
		assertTrue(ab.ehBissexto(2000));
	}
}
