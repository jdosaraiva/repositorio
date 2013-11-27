package br.com.caelum.matematicamaluca;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void testaComValorMaiorQueTrinta() {
		
		MatematicaMaluca mm = new MatematicaMaluca();
		
		int numero = 31;
		
		int retorno = mm.contaMaluca(numero);
		
		int valorEsperado = numero * 4;
		
		assertEquals(valorEsperado, retorno);
		
	}

	@Test
	public void testaComValorMenorQueTrintaEMaiorQueDez() {
		
		MatematicaMaluca mm = new MatematicaMaluca();
		
		int numero = 20;
		
		int retorno = mm.contaMaluca(numero);
		
		int valorEsperado = numero * 3;
		
		assertEquals(valorEsperado, retorno);
		
	}

	@Test
	public void testaComValorMenorQueDez() {
		
		MatematicaMaluca mm = new MatematicaMaluca();
		
		int numero = 5;
		
		int retorno = mm.contaMaluca(numero);
		
		int valorEsperado = numero * 2;
		
		assertEquals(valorEsperado, retorno);
		
	}
}
