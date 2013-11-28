package br.com.caelum.leilao.servico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {
	
	Usuario joao;
	
	@Before
	public void setUp() {
		this.joao = new Usuario("Joao");
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarLanceComValorZero() {
		Lance lance = new Lance(joao, 0);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarLanceComValorNegativo() {
		Lance lance = new Lance(joao, -100.0);

	}

}
